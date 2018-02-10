package com.objava.naucnih.radova.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.StringWriter;
import java.math.BigInteger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;
import com.marklogic.client.document.XMLDocumentManager;
import com.marklogic.client.io.InputStreamHandle;
import com.objava.naucnih.radova.ObjavaNaucnihRadovaApplication;
import com.objava.naucnih.radova.configuration.MarkLogicConfig;
import com.objava.naucnih.radova.model.naucni_rad.CoverPage.Author;
import com.objava.naucnih.radova.model.naucni_rad.NrDef;

@RestController
@RequestMapping(value = "/api")
public class NaucniRadController {
	
	@RequestMapping(value = "/add/nr", method = RequestMethod.POST)
	public String addNaucniRad(@RequestBody NrDef nrDef) throws JAXBException, FileNotFoundException{
		
		System.out.println(nrDef.toString());
		
		// create JAXB context and instantiate marshaller
        JAXBContext context = JAXBContext.newInstance(NrDef.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		
		StringWriter sw = new StringWriter();
        m.marshal(nrDef, sw);
	        
	    // Write to File
	    m.marshal(nrDef, new File("src/main/resources/data/radovi/" + nrDef.getCoverPage().getTitle() + ".xml"));
		
		// get variables from our xml file, created before
//        System.out.println();
//        System.out.println("Output from our XML File: ");
//        Unmarshaller um = context.createUnmarshaller();
//		NrDef nrDef2 = (NrDef) um.unmarshal(new FileReader(coverPage.getTitle() + ".xml"));
//	    System.out.println(nrDef2.getCoverPage().getTitle() + "  " + nrDef2.getPaper().getPrimaryHeader().getPrimaryHeaderTitle());
        
	        
//	    // create the client
		DatabaseClient client = DatabaseClientFactory.newClient(MarkLogicConfig.host,
				MarkLogicConfig.port, MarkLogicConfig.admin,
				MarkLogicConfig.password, MarkLogicConfig.authType);
		
		// acquire the content
		InputStream docStream = ObjavaNaucnihRadovaApplication.class.getClassLoader().getResourceAsStream(
				"data/radovi/" + nrDef.getCoverPage().getTitle() + ".xml");

		// create a manager for XML documents
		XMLDocumentManager docMgr = client.newXMLDocumentManager();

		// create a handle on the content
		InputStreamHandle handle = new InputStreamHandle(docStream);

		Author a = new Author();
		// Get the author of the paper
		for (Author author : nrDef.getCoverPage().getAuthor()) {
			a = author;
		}
		
		String ORCID = "";
		// Get orcid
		for (BigInteger orcid : a.getORCID()) {
			ORCID += orcid;
		}
		
		// write the document content
		docMgr.write("http://localhost:8011/naucni_radovi/" + ORCID + "/" + nrDef.getCoverPage().getTitle() + ".xml", handle);
		
//		docMgr.delete("http://localhost:8011/naucni_radovi/afternoon-drink.xml");
		
		System.out.println("Wrote content");

//		// release the client
		client.release();
		return "Uspesno";
	}
}
