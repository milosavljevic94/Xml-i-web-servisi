package com.objava.naucnih.radova.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
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

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping(value = "/api")
public class KorisnikController {

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> login(@RequestParam String username, @RequestParam String password,
			HttpServletResponse response) throws IOException, JAXBException {
		String token = null;
		
		// create the client
		DatabaseClient client = DatabaseClientFactory.newClient(MarkLogicConfig.host,
			MarkLogicConfig.port, MarkLogicConfig.admin,
			MarkLogicConfig.password, MarkLogicConfig.authType);
				
		// create a manager for XML documents
		XMLDocumentManager docMgr = client.newXMLDocumentManager();

		// create a handle to receive the document content
		DOMHandle handle = new DOMHandle();

		Map<String, Object> tokenMap = new HashMap<String, Object>();
		
		// read the document content
		try{
			docMgr.read("http://localhost:8011/korisnici/" + username + ".xml", handle);
		}catch (ResourceNotFoundException e) {
			tokenMap.put("token", null);
			return new ResponseEntity<Map<String, Object>>(tokenMap, HttpStatus.UNAUTHORIZED);
		}
		client.release();
		
		JAXBContext jaxbContext = JAXBContext.newInstance(Korisnik.class);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		
		StringReader reader = new StringReader(handle.toString());
		Korisnik person = (Korisnik) jaxbUnmarshaller.unmarshal(reader);
		
		
		if (person != null && person.getPassword().equals(password)) {
			token = Jwts.builder().setSubject(username).claim("roles", person.getRoles()).setIssuedAt(new Date())
					.signWith(SignatureAlgorithm.HS256, "secretkey").compact();
			tokenMap.put("token", token);
			tokenMap.put("user", person);
			return new ResponseEntity<Map<String, Object>>(tokenMap, HttpStatus.OK);
		} else {
			tokenMap.put("token", null);
			return new ResponseEntity<Map<String, Object>>(tokenMap, HttpStatus.UNAUTHORIZED);
		}
	}
	
	@RequestMapping(value = "/add/korisnik", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<String> addKorisnik(@RequestParam String ime, @RequestParam String prezime, @RequestParam String username, @RequestParam String password, @RequestParam String orcid, @RequestParam String role) throws JAXBException, FileNotFoundException{
		
		Korisnik.Roles roles = new Korisnik.Roles();
		roles.setRole(role);
		Korisnik k = new Korisnik();
		k.setIme(ime);
		k.setPrezime(prezime);
		k.setUsername(username);
		k.setPassword(password);
		k.setOrcid(orcid);
		k.setRoles(roles);
		
		System.out.println(k.toString());
		
		// create JAXB context and instantiate marshaller
        JAXBContext context = JAXBContext.newInstance(Korisnik.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

//		
//		StringWriter sw = new StringWriter();
//        m.marshal(k, sw);
		File f = new File("src/main/resources/data/korisnici/" + k.getUsername() + ".xml");
        if(!f.exists()) { 
            m.marshal(k, new File("src/main/resources/data/korisnici/" + k.getUsername() + ".xml"));
        }

        
	    // create the client
		DatabaseClient client = DatabaseClientFactory.newClient(MarkLogicConfig.host,
			MarkLogicConfig.port, MarkLogicConfig.admin,
			MarkLogicConfig.password, MarkLogicConfig.authType);
     		
	    // create a manager for XML documents
		XMLDocumentManager docMgr = client.newXMLDocumentManager();
	
		// create a handle to receive the document content
		DOMHandle handle = new DOMHandle();
	
		// read the document content
		try{
			docMgr.read("http://localhost:8011/korisnici/" + username + ".xml", handle);
			client.release();
			return new ResponseEntity<String>("Username postoji", HttpStatus.FOUND);
		}catch (ResourceNotFoundException e) {
			// acquire the content
			InputStream docStream = ObjavaNaucnihRadovaApplication.class.getClassLoader().getResourceAsStream(
					"data/korisnici/" + k.getUsername() + ".xml");

			// create a manager for XML documents
			XMLDocumentManager docMgr1 = client.newXMLDocumentManager();

			// create a handle on the content
			InputStreamHandle handle1 = new InputStreamHandle(docStream);
			
			// write the document content
			docMgr.write("http://localhost:8011/korisnici/" + k.getUsername()+".xml", handle1);
			client.release();
			return new ResponseEntity<String>("Uspesno", HttpStatus.OK);
		}
	}
}
