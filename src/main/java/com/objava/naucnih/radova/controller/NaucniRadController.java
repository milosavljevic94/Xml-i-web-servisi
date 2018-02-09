package com.objava.naucnih.radova.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;
import com.marklogic.client.ResourceNotFoundException;
import com.marklogic.client.document.XMLDocumentManager;
import com.marklogic.client.io.DOMHandle;
import com.marklogic.client.io.InputStreamHandle;
import com.objava.naucnih.radova.ObjavaNaucnihRadovaApplication;
import com.objava.naucnih.radova.configuration.MarkLogicConfig;
import com.objava.naucnih.radova.model.korisnik.Korisnik;
import com.objava.naucnih.radova.model.naucni_rad.CoverPage;
import com.objava.naucnih.radova.model.naucni_rad.CoverPage.Author;
import com.objava.naucnih.radova.model.naucni_rad.CoverPage.Author.AuthorAddress;
import com.objava.naucnih.radova.model.naucni_rad.Keywords;
import com.objava.naucnih.radova.model.naucni_rad.NrDef;
import com.objava.naucnih.radova.model.naucni_rad.Paper;
import com.objava.naucnih.radova.model.naucni_rad.Paper.PrimaryHeader;
import com.objava.naucnih.radova.model.naucni_rad.Paper.PrimaryHeader.SecondaryHeader;
import com.objava.naucnih.radova.model.naucni_rad.Paper.PrimaryHeader.SecondaryHeader.ThirdHeader;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping(value = "/api")
public class NaucniRadController {
	
	@RequestMapping(value = "/add/nr", method = RequestMethod.POST)
	public String addNaucniRad(@RequestBody NrDef nrDef) throws JAXBException, FileNotFoundException{
		
		System.out.println(nrDef.toString());
		
		// create JAXB context and instantiate marshaller
//        JAXBContext context = JAXBContext.newInstance(NrDef.class);
//			Marshaller m = context.createMarshaller();
//			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//			// Write to System.out
//	        m.marshal(nrDef, System.out);
//
//	        // Write to File
//	        m.marshal(nrDef, new File(coverPage.getTitle() + ".xml"));
//		
//		// get variables from our xml file, created before
//        System.out.println();
//        System.out.println("Output from our XML File: ");
//        Unmarshaller um = context.createUnmarshaller();
//		NrDef nrDef2 = (NrDef) um.unmarshal(new FileReader(coverPage.getTitle() + ".xml"));
//	    System.out.println(nrDef2.getCoverPage().getTitle() + "  " + nrDef2.getPaper().getPrimaryHeader().getPrimaryHeaderTitle());
//        
//	        
////	    // create the client
//		DatabaseClient client = DatabaseClientFactory.newClient(MarkLogicConfig.host,
//				MarkLogicConfig.port, MarkLogicConfig.admin,
//				MarkLogicConfig.password, MarkLogicConfig.authType);
//		
//		// acquire the content
//		InputStream docStream = ObjavaNaucnihRadovaApplication.class.getClassLoader().getResourceAsStream(
//				"data"+File.separator+"Rad 1.xml");
//
//		// create a manager for XML documents
//		XMLDocumentManager docMgr = client.newXMLDocumentManager();
//
//		// create a handle on the content
//		InputStreamHandle handle = new InputStreamHandle(docStream);
//
//		// write the document content
//		docMgr.write("http://localhost:8011/naucni_radovi/afternoon-drink.xml", handle);
//		
//		docMgr.delete("http://localhost:8011/afternoon-drink.xml");
//		
//		System.out.println("Wrote Rad 1.xml content");
//
////		// release the client
//		client.release();
		return "Uspesno";
	}
}