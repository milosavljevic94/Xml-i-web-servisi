//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.02.05 um 09:15:02 AM CET 
//


package com.objava.naucnih.radova.model.revision;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.objava.naucnih.radova.model.revision package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AbstractText_QNAME = new QName("http://www.ftn.uns.ac.rs/naucni_radovi/abstract", "abstract_text");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.objava.naucnih.radova.model.revision
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CoverPage }
     * 
     */
    public CoverPage createCoverPage() {
        return new CoverPage();
    }

    /**
     * Create an instance of {@link Paper }
     * 
     */
    public Paper createPaper() {
        return new Paper();
    }

    /**
     * Create an instance of {@link Paper.PrimaryHeader }
     * 
     */
    public Paper.PrimaryHeader createPaperPrimaryHeader() {
        return new Paper.PrimaryHeader();
    }

    /**
     * Create an instance of {@link Paper.PrimaryHeader.SecondaryHeader }
     * 
     */
    public Paper.PrimaryHeader.SecondaryHeader createPaperPrimaryHeaderSecondaryHeader() {
        return new Paper.PrimaryHeader.SecondaryHeader();
    }

    /**
     * Create an instance of {@link CoverPage.Author }
     * 
     */
    public CoverPage.Author createCoverPageAuthor() {
        return new CoverPage.Author();
    }

    /**
     * Create an instance of {@link NrDef }
     * 
     */
    public NrDef createNrDef() {
        return new NrDef();
    }

    /**
     * Create an instance of {@link Keywords }
     * 
     */
    public Keywords createKeywords() {
        return new Keywords();
    }

    /**
     * Create an instance of {@link Paper.PrimaryHeader.SecondaryHeader.ThirdHeader }
     * 
     */
    public Paper.PrimaryHeader.SecondaryHeader.ThirdHeader createPaperPrimaryHeaderSecondaryHeaderThirdHeader() {
        return new Paper.PrimaryHeader.SecondaryHeader.ThirdHeader();
    }

    /**
     * Create an instance of {@link CoverPage.Author.AuthorAddress }
     * 
     */
    public CoverPage.Author.AuthorAddress createCoverPageAuthorAuthorAddress() {
        return new CoverPage.Author.AuthorAddress();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/naucni_radovi/abstract", name = "abstract_text")
    public JAXBElement<String> createAbstractText(String value) {
        return new JAXBElement<String>(_AbstractText_QNAME, String.class, null, value);
    }

}