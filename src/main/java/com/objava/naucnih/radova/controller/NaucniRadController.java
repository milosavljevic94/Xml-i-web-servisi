package com.objava.naucnih.radova.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.http.ResponseEntity;
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
import com.objava.naucnih.radova.model.naucni_rad.CoverPage.Author;
import com.objava.naucnih.radova.model.naucni_rad.NrDef;

@RestController
@RequestMapping(value = "/api")
public class NaucniRadController {
	
	@RequestMapping(value = "/nr/{orcid}", method = RequestMethod.GET)
	public List<NrDef> getNaucniRadovi(@PathVariable String orcid) throws JAXBException{
		
		DatabaseClient client = DatabaseClientFactory.newClient(MarkLogicConfig.host,
				MarkLogicConfig.port, MarkLogicConfig.admin,
				MarkLogicConfig.password, MarkLogicConfig.authType);
		
		// create a manager for XML documents
		XMLDocumentManager docMgr = client.newXMLDocumentManager();			
		
		QueryManager qm = client.newQueryManager();

        // Build query
		StringQueryDefinition query = 
		        qm.newStringDefinition().withCriteria(orcid);
        
        // Perform the multi-document read and process results
        DocumentPage documents = docMgr.search(query, 1);
        System.out.println("Total matching documents: "
            + documents.getTotalSize());      
        DOMHandle handle = new DOMHandle();
        List<NrDef> naucniRadovi = new ArrayList<>();
        
        JAXBContext jaxbContext = JAXBContext.newInstance(NrDef.class);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		
        for (DocumentRecord document: documents) {
            System.out.println(document.getUri());
            // ne zelimo da procitamo korisnika vec samo njegove radove
            if(document.getUri().contains("http://localhost:8011/korisnici/autor/")){
            	break;
            }
            docMgr.read(document.getUri(), handle);
    		
    		StringReader reader = new StringReader(handle.toString());
    		NrDef papre = (NrDef) jaxbUnmarshaller.unmarshal(reader);
    		
    		naucniRadovi.add(papre);
            // Do something with the content using document.getContent()
        }

//		release the client
		client.release();
		
		return naucniRadovi;
	}
	
	@RequestMapping(value = "/nr/{orcid}/{title}", method = RequestMethod.DELETE)
	public List<NrDef> deleteRad(@PathVariable String orcid, @PathVariable String title) throws JAXBException {
		DatabaseClient client = DatabaseClientFactory.newClient(MarkLogicConfig.host,
				MarkLogicConfig.port, MarkLogicConfig.admin,
				MarkLogicConfig.password, MarkLogicConfig.authType);
		
		// create a manager for XML documents
		XMLDocumentManager docMgr = client.newXMLDocumentManager();
		
		docMgr.delete("http://localhost:8011/naucni_radovi/" + orcid + "/" + title + ".xml");
		
		QueryManager qm = client.newQueryManager();

        // Build query
		StringQueryDefinition query = 
		        qm.newStringDefinition().withCriteria(orcid);
        
        // Perform the multi-document read and process results
        DocumentPage documents = docMgr.search(query, 1);
        System.out.println("Total matching documents: "
            + documents.getTotalSize());      
        DOMHandle handle = new DOMHandle();
        List<NrDef> naucniRadovi = new ArrayList<>();
        
        JAXBContext jaxbContext = JAXBContext.newInstance(NrDef.class);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		
        for (DocumentRecord document: documents) {
            System.out.println(document.getUri());
         // ne zelimo da procitamo korisnika vec samo njegove radove
            if(document.getUri().contains("http://localhost:8011/korisnici/autor/")){
            	break;
            }
            docMgr.read(document.getUri(), handle);
    		
    		StringReader reader = new StringReader(handle.toString());
    		NrDef papre = (NrDef) jaxbUnmarshaller.unmarshal(reader);
    		
    		naucniRadovi.add(papre);
            // Do something with the content using document.getContent()
        }
        
//        release the client
		client.release();
		
		return naucniRadovi;
	}
	
	@RequestMapping(value = "/add/nr/{orcid}", method = RequestMethod.POST)
	public List<NrDef> addNaucniRad(@RequestBody NrDef nrDef, @PathVariable String orcid) throws JAXBException, FileNotFoundException{
		
		System.out.println(nrDef.toString());
		
		// create JAXB context and instantiate marshaller
        JAXBContext context = JAXBContext.newInstance(NrDef.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		
		StringWriter sw = new StringWriter();
        m.marshal(nrDef, sw);
	        
	    // Write to File
	    m.marshal(nrDef, new File("src/main/resources/data/radovi/" + nrDef.getCoverPage().getTitle() + ".xml"));
	        
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
		
		// write the document content
		docMgr.write("http://localhost:8011/naucni_radovi/" + orcid + "/" + nrDef.getCoverPage().getTitle() + ".xml", handle);
		
		QueryManager qm = client.newQueryManager();

        // Build query
		StringQueryDefinition query = 
		        qm.newStringDefinition().withCriteria(orcid);
        
        // Perform the multi-document read and process results
        DocumentPage documents = docMgr.search(query, 1);
        System.out.println("Total matching documents: "
            + documents.getTotalSize());      
        DOMHandle handle1 = new DOMHandle();
        List<NrDef> naucniRadovi = new ArrayList<>();
        
        JAXBContext jaxbContext = JAXBContext.newInstance(NrDef.class);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		
        for (DocumentRecord document: documents) {
            System.out.println(document.getUri());
         // ne zelimo da procitamo korisnika vec samo njegove radove
            if(document.getUri().contains("http://localhost:8011/korisnici/autor/")){
            	break;
            }
            docMgr.read(document.getUri(), handle1);
    		
    		StringReader reader = new StringReader(handle1.toString());
    		NrDef papre = (NrDef) jaxbUnmarshaller.unmarshal(reader);
    		
    		naucniRadovi.add(papre);
        }
        
//        release the client
		client.release();
		
		return naucniRadovi;
	}
	
	@RequestMapping(value = "/nr/{orcid}/{title}", method = RequestMethod.PUT)
	public List<NrDef> updateRad(@RequestBody NrDef nrDef, @PathVariable String orcid, @PathVariable String title) throws JAXBException {
		System.out.println("Menjaj====" + nrDef.toString());
		
		// create JAXB context and instantiate marshaller
        JAXBContext context = JAXBContext.newInstance(NrDef.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		
		StringWriter sw = new StringWriter();
        m.marshal(nrDef, sw);
	        
	    // Write to File
	    m.marshal(nrDef, new File("src/main/resources/data/radovi/" + title + ".xml"));
	        
//	    // create the client
		DatabaseClient client = DatabaseClientFactory.newClient(MarkLogicConfig.host,
				MarkLogicConfig.port, MarkLogicConfig.admin,
				MarkLogicConfig.password, MarkLogicConfig.authType);
		
		// acquire the content
		InputStream docStream = ObjavaNaucnihRadovaApplication.class.getClassLoader().getResourceAsStream(
				"data/radovi/" + title + ".xml");

		// create a manager for XML documents
		XMLDocumentManager docMgr = client.newXMLDocumentManager();

		// create a handle on the content
		InputStreamHandle handle = new InputStreamHandle(docStream);

		Author a = new Author();
		// Get the author of the paper
		for (Author author : nrDef.getCoverPage().getAuthor()) {
			a = author;
		}
		
		// write the document content
		docMgr.write("http://localhost:8011/naucni_radovi/" + orcid + "/" + title + ".xml", handle);
		
		QueryManager qm = client.newQueryManager();

        // Build query
		StringQueryDefinition query = 
		        qm.newStringDefinition().withCriteria(orcid);
        
        // Perform the multi-document read and process results
        DocumentPage documents = docMgr.search(query, 1);
        System.out.println("Total matching documents: "
            + documents.getTotalSize());      
        DOMHandle handle1 = new DOMHandle();
        List<NrDef> naucniRadovi = new ArrayList<>();
        
        JAXBContext jaxbContext = JAXBContext.newInstance(NrDef.class);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		
        for (DocumentRecord document: documents) {
            System.out.println(document.getUri());
         // ne zelimo da procitamo korisnika vec samo njegove radove
            if(document.getUri().contains("http://localhost:8011/korisnici/autor/")){
            	break;
            }
            docMgr.read(document.getUri(), handle1);
    		
    		StringReader reader = new StringReader(handle1.toString());
    		NrDef papre = (NrDef) jaxbUnmarshaller.unmarshal(reader);
    		
    		naucniRadovi.add(papre);
        }
        
//        release the client
		client.release();
		
		return naucniRadovi;
	}
}
