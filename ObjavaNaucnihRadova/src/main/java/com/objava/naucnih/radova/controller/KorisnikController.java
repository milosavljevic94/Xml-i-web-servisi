package com.objava.naucnih.radova.controller;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.objava.naucnih.radova.model.korisnik.Adresa;
import com.objava.naucnih.radova.model.korisnik.Korisnik;

@RestController
@RequestMapping(value = "/users")
public class KorisnikController {

	ArrayList<Korisnik> sviKorisnici = new ArrayList<Korisnik>();
	
	@Context
	HttpServletRequest request;
	@Context
	ServletContext ctx;

/*    @GET
    @Path("/korisnici/{korisnickoIme}/")
    @Produces("application/xml")
    public Korisnik getKorisnik(@PathParam("korisnickoIme") String korisnickoIme) {
        System.out.println("Vrati korisnika sa korisnickim imenom: " + korisnickoIme);
        
        for(Korisnik k : sviKorisnici) {
        	if (k.getKorisnickoIme().equals(korisnickoIme)) {
        		return k;
        	}
        }
        return null;
    }*/
	
	/*@GET
	@Path("/getKorisnici")
	@Produces("application/xml")*/
	@RequestMapping(value = "/getKorisnici", method = RequestMethod.GET)
	public Collection<Korisnik> getKorisnici() {
		return getSviKorisnici();
	}
	
	/*@POST
	@Path("/checkValidity")
	@Produces("application/xml")
	@Consumes("application/xml")*/
	@RequestMapping(value="/checkValidity", method=RequestMethod.POST)
	public Response checkValidity(Korisnik k) {
		if(loginCheck(k)) {
			return Response.ok().build();
		}
		else {
			return Response.status(Status.NOT_FOUND).entity("{\"msg\":\"Korisnik not found\"}").build();
		}
	}

	void init() {
		Adresa a1 = new Adresa("ulica1","22","Novi Sad","Srbija");
		Korisnik k1 = new Korisnik("pera123","pera123","Pera","Peric",a1,"peroni@gmail.com","123/123-1231","autor");
		Korisnik k2 = new Korisnik("djura123","djura123","Djura","Djuric",a1,"djuroni@gmail.com","123/122-1231","recezent");
		
		sviKorisnici.add(k1);
		sviKorisnici.add(k2);
	}
	
	@SuppressWarnings("unchecked")
	private ArrayList<Korisnik> getSviKorisnici() {
		init();
		ArrayList<Korisnik> korisnici = (ArrayList<Korisnik>) ctx.getAttribute("korisnici");
		if (korisnici == null) {
			korisnici = this.sviKorisnici;
			ctx.setAttribute("korisnici", korisnici);
		} 
		return korisnici;
	}
	
	public boolean loginCheck(Korisnik k1) {
		for(Korisnik k : sviKorisnici) {
			if((k.getKorisnickoIme()).equalsIgnoreCase(k1.getKorisnickoIme())) {
				if(k.getLozinka().equalsIgnoreCase(k1.getLozinka())) {
					return true;
				}
			}
		}
		return false;
	}
}
