package com.objava.naucnih.radova.controller;

import java.io.IOException;
import java.io.StringReader;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
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
			docMgr.read("http://localhost:8011/korisnici/autor/" + username + ".xml", handle);
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
}
