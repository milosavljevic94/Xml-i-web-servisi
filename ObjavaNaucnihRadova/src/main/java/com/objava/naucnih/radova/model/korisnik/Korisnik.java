package com.objava.naucnih.radova.model.korisnik;

public class Korisnik {

	private String korisnickoIme;
	private String lozinka;
	private String ime;
	private String prezime;
	private Adresa adresa;
	private String email;
	private String telefon;
	private String tipKorisnika;
	public Korisnik() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Korisnik(String korisnickoIme, String lozinka, String ime, String prezime, Adresa adresa, String email,
			String telefon, String tipKorisnika) {
		super();
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.ime = ime;
		this.prezime = prezime;
		this.adresa = adresa;
		this.email = email;
		this.telefon = telefon;
		this.tipKorisnika = tipKorisnika;
	}
	public String getKorisnickoIme() {
		return korisnickoIme;
	}
	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}
	public String getLozinka() {
		return lozinka;
	}
	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public Adresa getAdresa() {
		return adresa;
	}
	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getTipKorisnika() {
		return tipKorisnika;
	}
	public void setTipKorisnika(String tipKorisnika) {
		this.tipKorisnika = tipKorisnika;
	}
	
}
