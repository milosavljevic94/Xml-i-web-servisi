package com.objava.naucnih.radova.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.http.HttpStatus;
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
import com.objava.naucnih.radova.model.naucni_rad.NrDef;
import com.objava.naucnih.radova.model.cover_letter.CoverLetter;
import com.objava.naucnih.radova.model.naucni_rad.CoverPage.Author;

@RestController
@RequestMapping(value = "/api")
public class CoverLetterController {

	@RequestMapping(value = "/add/coverLetter/{nazivNaucnogRadaZaCoverLetter}/{orcidZaCoverLetter}", method = RequestMethod.POST)
	public ResponseEntity<String> addCoverLetter(@RequestBody CoverLetter coverLetter, @PathVariable String nazivNaucnogRadaZaCoverLetter, @PathVariable String orcidZaCoverLetter) throws JAXBException, FileNotFoundException{
		
		System.out.println(coverLetter.toString());
		
		// create JAXB context and instantiate marshaller
        JAXBContext context = JAXBContext.newInstance(CoverLetter.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		
		StringWriter sw = new StringWriter();
        m.marshal(coverLetter, sw);
	        
	    // Write to File
	    m.marshal(coverLetter, new File("src/main/resources/data/propratnaPisma/" + coverLetter.getTitleText() + ".xml"));
	        
//	    // create the client
		DatabaseClient client = DatabaseClientFactory.newClient(MarkLogicConfig.host,
				MarkLogicConfig.port, MarkLogicConfig.admin,
				MarkLogicConfig.password, MarkLogicConfig.authType);
		
		// acquire the content
		InputStream docStream = ObjavaNaucnihRadovaApplication.class.getClassLoader().getResourceAsStream(
				"data/propratnaPisma/" + coverLetter.getTitleText() + ".xml");

		// create a manager for XML documents
		XMLDocumentManager docMgr = client.newXMLDocumentManager();

		// create a handle on the content
		InputStreamHandle handle = new InputStreamHandle(docStream);
		
		// write the document content
		docMgr.write("http://localhost:8011/naucni_radovi/" + orcidZaCoverLetter + "/" + nazivNaucnogRadaZaCoverLetter + "/" + coverLetter.getTitleText() + ".xml", handle);
		
		QueryManager qm = client.newQueryManager();

        // Build query
		/*StringQueryDefinition query = 
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
            if(!document.getUri().contains("http://localhost:8011/korisnici/")){
            	
	            docMgr.read(document.getUri(), handle1);
	    		
	    		StringReader reader = new StringReader(handle1.toString());
	    		NrDef papre = (NrDef) jaxbUnmarshaller.unmarshal(reader);
	    		
	    		naucniRadovi.add(papre);
            }
        }
        
//        release the client
		client.release();
		
		return naucniRadovi;*/
		return new ResponseEntity<String>("Uspesno", HttpStatus.OK);
	}
	
}
