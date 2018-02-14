package com.objava.naucnih.radova.controller;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;
import com.marklogic.client.document.DocumentPage;
import com.marklogic.client.document.DocumentRecord;
import com.marklogic.client.document.XMLDocumentManager;
import com.marklogic.client.io.DOMHandle;
import com.marklogic.client.io.InputStreamHandle;
import com.marklogic.client.query.QueryManager;
import com.marklogic.client.query.StringQueryDefinition;
import com.objava.naucnih.radova.ObjavaNaucnihRadovaApplication;
import com.objava.naucnih.radova.configuration.MarkLogicConfig;
import com.objava.naucnih.radova.model.naucni_rad.NrDef;
import com.objava.naucnih.radova.model.review.Review;

@RestController
@RequestMapping(value = "/api")
public class RecenzijaController {
	
	@RequestMapping(value = "/recenzije/{title}", method = RequestMethod.GET)
	public List<Review> getNaucniRadovi(@PathVariable String title) throws JAXBException{
		
		DatabaseClient client = DatabaseClientFactory.newClient(MarkLogicConfig.host,
				MarkLogicConfig.port, MarkLogicConfig.admin,
				MarkLogicConfig.password, MarkLogicConfig.authType);
		
		// create a manager for XML documents
		XMLDocumentManager docMgr = client.newXMLDocumentManager();			
		
		QueryManager qm = client.newQueryManager();

        // Build query
		StringQueryDefinition query = 
		        qm.newStringDefinition().withCriteria(title);
        
        // Perform the multi-document read and process results
        DocumentPage documents = docMgr.search(query, 1);
        System.out.println("Total matching documents: "
            + documents.getTotalSize());      
        DOMHandle handle1 = new DOMHandle();
        List<Review> recenzije = new ArrayList<>();
        
        JAXBContext jaxbContext = JAXBContext.newInstance(Review.class);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		
        for (DocumentRecord document: documents) {
            System.out.println(document.getUri());
         // ne zelimo da procitamo korisnika vec samo njegove radove
            if(document.getUri().contains("http://localhost:8011/review/" 
            										+ title)){
            	
	            docMgr.read(document.getUri(), handle1);
	    		
	    		StringReader reader = new StringReader(handle1.toString());
	    		Review review = (Review) jaxbUnmarshaller.unmarshal(reader);
	    		
	    		recenzije.add(review);
            }
        }
        
		// release the client
		client.release();
		
		return recenzije;
	}
	
	@RequestMapping(value = "/addRecenziju/{orcid}")
	public List<Review> addRecenzija(@RequestBody Review review, @PathVariable String orcid)
			throws JAXBException, FileNotFoundException {
		
		System.out.println(review.toString());
		
		// create JAXB context and instantiate marshaller
        JAXBContext context = JAXBContext.newInstance(com.objava.naucnih.radova.model.review.Review.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

	        // Write to File
	        m.marshal(review, new File("src/main/resources/data/recenzije/" + review.getTitle().getTypeOfReview() + ".xml"));
		
		
	    // create the client
		@SuppressWarnings("deprecation")
		DatabaseClient client = DatabaseClientFactory.newClient(MarkLogicConfig.host,
				MarkLogicConfig.port, MarkLogicConfig.admin,
				MarkLogicConfig.password, MarkLogicConfig.authType);
		
		// acquire the content
		InputStream docStream = ObjavaNaucnihRadovaApplication.class.getClassLoader().getResourceAsStream(
				"data/recenzije/" + review.getTitle().getTypeOfReview() + ".xml");

		// create a manager for XML documents
		XMLDocumentManager docMgr = client.newXMLDocumentManager();

		// create a handle on the content
		InputStreamHandle handle = new InputStreamHandle(docStream);

		// write the document content
		docMgr.write("http://localhost:8011/review/" 
				+ review.getTitle().getManuscriptTitle()
				+ "/" + review.getTitle().getTypeOfReview() + ".xml", handle);
		
		QueryManager qm = client.newQueryManager();

        // Build query
		StringQueryDefinition query = 
		        qm.newStringDefinition().withCriteria(review.getTitle().getManuscriptTitle());
        
        // Perform the multi-document read and process results
        DocumentPage documents = docMgr.search(query, 1);
        System.out.println("Total matching documents: "
            + documents.getTotalSize());      
        DOMHandle handle1 = new DOMHandle();
        List<Review> recenzije = new ArrayList<>();
        
        JAXBContext jaxbContext = JAXBContext.newInstance(Review.class);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		
        for (DocumentRecord document: documents) {
            System.out.println(document.getUri());
         // ne zelimo da procitamo korisnika vec samo njegove radove
            if(document.getUri().contains("http://localhost:8011/review/" 
            										+ review.getTitle().getManuscriptTitle())){
            	
	            docMgr.read(document.getUri(), handle1);
	    		
	    		StringReader reader = new StringReader(handle1.toString());
	    		Review reiew = (Review) jaxbUnmarshaller.unmarshal(reader);
	    		
	    		recenzije.add(review);
            }
        }
        
		// release the client
		client.release();
		
		return recenzije;
	}
}
