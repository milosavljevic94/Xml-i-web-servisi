//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.02.05 um 09:12:30 AM CET 
//


package com.objava.naucnih.radova.model.naucni_rad;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r anonymous complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/naucni_radovi/naslovna}cover_page"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/naucni_radovi/abstract}abstract_text"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/naucni_radovi/keywords}keywords"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/naucni_radovi/paper_text}paper"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "coverPage",
    "abstractText",
    "keywords",
    "paper"
})
@XmlRootElement(name = "nr_def", namespace = "http://www.ftn.uns.ac.rs/naucni_rad")
public class NrDef {

    @XmlElement(name = "cover_page", required = true)
    protected CoverPage coverPage;
    @XmlElement(name = "abstract_text", namespace = "http://www.ftn.uns.ac.rs/naucni_radovi/abstract", required = true)
    protected String abstractText;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/naucni_radovi/keywords", required = true)
    protected Keywords keywords;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/naucni_radovi/paper_text", required = true)
    protected Paper paper;

    /**
     * Ruft den Wert der coverPage-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CoverPage }
     *     
     */
    public CoverPage getCoverPage() {
        return coverPage;
    }

    /**
     * Legt den Wert der coverPage-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CoverPage }
     *     
     */
    public void setCoverPage(CoverPage value) {
        this.coverPage = value;
    }

    /**
     * Ruft den Wert der abstractText-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAbstractText() {
        return abstractText;
    }

    /**
     * Legt den Wert der abstractText-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAbstractText(String value) {
        this.abstractText = value;
    }

    /**
     * Ruft den Wert der keywords-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Keywords }
     *     
     */
    public Keywords getKeywords() {
        return keywords;
    }

    /**
     * Legt den Wert der keywords-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Keywords }
     *     
     */
    public void setKeywords(Keywords value) {
        this.keywords = value;
    }

    /**
     * Ruft den Wert der paper-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Paper }
     *     
     */
    public Paper getPaper() {
        return paper;
    }

    /**
     * Legt den Wert der paper-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Paper }
     *     
     */
    public void setPaper(Paper value) {
        this.paper = value;
    }

	@Override
	public String toString() {
		return "NrDef [coverPage=" + coverPage + ", abstractText=" + abstractText + ", keywords=" + keywords
				+ ", paper=" + paper + "]";
	}

    
}
