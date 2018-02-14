package com.objava.naucnih.radova.controller;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;
import com.marklogic.client.document.XMLDocumentManager;
import com.marklogic.client.io.InputStreamHandle;
import com.objava.naucnih.radova.ObjavaNaucnihRadovaApplication;
import com.objava.naucnih.radova.configuration.MarkLogicConfig;
import com.objava.naucnih.radova.model.review.Review;
import com.objava.naucnih.radova.model.review.Review.Info;
import com.objava.naucnih.radova.model.review.Review.ReviewPart;
import com.objava.naucnih.radova.model.review.Review.Title;

@RestController
@RequestMapping(value = "/api")
public class RecenzijaController {
	
	List<Review> listaRecenzija = new ArrayList<Review>();
	
	@RequestMapping(value = "/addRecenziju", method = RequestMethod.POST)
	public String addRecenzija() throws JAXBException, FileNotFoundException {
		
		Review recenzija = new Review();
		List<ReviewPart> listaDelovaRecenzije = new ArrayList<ReviewPart>();
		listaDelovaRecenzije = recenzija.getReviewPart();
		
		Title naslov = new Title();
		naslov.setTypeOfReview("Recenzija naucnog rada");
		naslov.setManuscriptTitle("Rad broj 1");
		naslov.setRevisionRecommend("Accept");
		
		Info info = new Info();
		info.setReviewAutor("Recenzent Mirkovic");
		info.setManuscriptAutor("Autor Peric");
		info.setReviewScore("5.0");
		
		ReviewPart part1 = new ReviewPart();
		part1.setPartTitle("Introduction");
		part1.setPartText("Text of intro of some manuscript.");
		part1.setPartScore("4.9");
		
		listaDelovaRecenzije.add(part1);
		recenzija.setTitle(naslov);
		recenzija.setInfo(info);
		
		listaRecenzija.add(recenzija);
		
		// create JAXB context and instantiate marshaller
        JAXBContext context = JAXBContext.newInstance(com.objava.naucnih.radova.model.review.Review.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			// Write to System.out
	        m.marshal(recenzija, System.out);

	        // Write to File
	        m.marshal(recenzija, new File(recenzija.getTitle().getTypeOfReview() + ".xml"));
		
		// get variables from our xml file, created before
        System.out.println();
        System.out.println("Output from our XML File: ");
        Unmarshaller um = context.createUnmarshaller();
		Review recenzija2 = (Review) um.unmarshal(new FileReader(recenzija.getTitle().getTypeOfReview() + ".xml"));
	    System.out.println(recenzija2.getTitle().getTypeOfReview() + "  " + recenzija2.getInfo().getReviewScore());
        
	    // create the client
		@SuppressWarnings("deprecation")
		DatabaseClient client = DatabaseClientFactory.newClient(MarkLogicConfig.host,
				MarkLogicConfig.port, MarkLogicConfig.admin,
				MarkLogicConfig.password, MarkLogicConfig.authType);
		
		// acquire the content
		InputStream docStream = ObjavaNaucnihRadovaApplication.class.getClassLoader().getResourceAsStream(
				"data"+File.separator+"Recenzija broj 1.xml");

		// create a manager for XML documents
		XMLDocumentManager docMgr = client.newXMLDocumentManager();

		// create a handle on the content
		InputStreamHandle handle = new InputStreamHandle(docStream);

		// write the document content
		docMgr.write("http://localhost:8011/naucni_radovi/review-number1.xml", handle);
		
		docMgr.delete("http://localhost:8011/review-number1.xml");
		
		System.out.println("Wrote Recenzija broj 1.xml content");

		// release the client
		client.release();
		
		return "Recenzija"+recenzija.getTitle().getTypeOfReview()+"dodata";
	}
	
	    //stanica sa listom svih recenzija.
		@RequestMapping(value = "/recenzije")
		public String home(){
			
			for (Review lista : listaRecenzija) {
				return "Recenzije na:" +lista.getTitle().getManuscriptTitle();
			}
			return "Lista recenzija";
			
		}
}
