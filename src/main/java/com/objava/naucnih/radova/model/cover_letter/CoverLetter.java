//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.02.05 um 09:13:44 AM CET 
//


package com.objava.naucnih.radova.model.cover_letter;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java-Klasse für anonymous complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="title_text" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *         &lt;element name="name_of_university" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *         &lt;element name="university_address">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="street" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="street_number" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *                   &lt;element name="city" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="country" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="postal_number" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="recipient">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="recipient_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="recipient_role" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="journal_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="letter_text">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="700"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="signature">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="academic_degree" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="department" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="university" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "titleText",
    "name",
    "nameOfUniversity",
    "universityAddress",
    "email",
    "recipient",
    "date",
    "letterText",
    "signature"
})
@XmlRootElement(name = "cover_letter")
public class CoverLetter {

    @XmlElement(name = "title_text", required = true)
    protected Object titleText;
    @XmlElement(required = true)
    protected Object name;
    @XmlElement(name = "name_of_university", required = true)
    protected Object nameOfUniversity;
    @XmlElement(name = "university_address", required = true)
    protected CoverLetter.UniversityAddress universityAddress;
    @XmlElement(required = true)
    protected String email;
    @XmlElement(required = true)
    protected CoverLetter.Recipient recipient;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar date;
    @XmlElement(name = "letter_text", required = true)
    protected String letterText;
    @XmlElement(required = true)
    protected CoverLetter.Signature signature;

    /**
     * Ruft den Wert der titleText-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getTitleText() {
        return titleText;
    }

    /**
     * Legt den Wert der titleText-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setTitleText(Object value) {
        this.titleText = value;
    }

    /**
     * Ruft den Wert der name-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getName() {
        return name;
    }

    /**
     * Legt den Wert der name-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setName(Object value) {
        this.name = value;
    }

    /**
     * Ruft den Wert der nameOfUniversity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getNameOfUniversity() {
        return nameOfUniversity;
    }

    /**
     * Legt den Wert der nameOfUniversity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setNameOfUniversity(Object value) {
        this.nameOfUniversity = value;
    }

    /**
     * Ruft den Wert der universityAddress-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CoverLetter.UniversityAddress }
     *     
     */
    public CoverLetter.UniversityAddress getUniversityAddress() {
        return universityAddress;
    }

    /**
     * Legt den Wert der universityAddress-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CoverLetter.UniversityAddress }
     *     
     */
    public void setUniversityAddress(CoverLetter.UniversityAddress value) {
        this.universityAddress = value;
    }

    /**
     * Ruft den Wert der email-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Legt den Wert der email-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Ruft den Wert der recipient-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CoverLetter.Recipient }
     *     
     */
    public CoverLetter.Recipient getRecipient() {
        return recipient;
    }

    /**
     * Legt den Wert der recipient-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CoverLetter.Recipient }
     *     
     */
    public void setRecipient(CoverLetter.Recipient value) {
        this.recipient = value;
    }

    /**
     * Ruft den Wert der date-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Legt den Wert der date-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

    /**
     * Ruft den Wert der letterText-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLetterText() {
        return letterText;
    }

    /**
     * Legt den Wert der letterText-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLetterText(String value) {
        this.letterText = value;
    }

    /**
     * Ruft den Wert der signature-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CoverLetter.Signature }
     *     
     */
    public CoverLetter.Signature getSignature() {
        return signature;
    }

    /**
     * Legt den Wert der signature-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CoverLetter.Signature }
     *     
     */
    public void setSignature(CoverLetter.Signature value) {
        this.signature = value;
    }


    /**
     * <p>Java-Klasse für anonymous complex type.
     * 
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="recipient_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="recipient_role" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="journal_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "recipientName",
        "recipientRole",
        "journalName"
    })
    public static class Recipient {

        @XmlElement(name = "recipient_name", required = true)
        protected String recipientName;
        @XmlElement(name = "recipient_role", required = true)
        protected String recipientRole;
        @XmlElement(name = "journal_name", required = true)
        protected String journalName;

        /**
         * Ruft den Wert der recipientName-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRecipientName() {
            return recipientName;
        }

        /**
         * Legt den Wert der recipientName-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRecipientName(String value) {
            this.recipientName = value;
        }

        /**
         * Ruft den Wert der recipientRole-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRecipientRole() {
            return recipientRole;
        }

        /**
         * Legt den Wert der recipientRole-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRecipientRole(String value) {
            this.recipientRole = value;
        }

        /**
         * Ruft den Wert der journalName-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJournalName() {
            return journalName;
        }

        /**
         * Legt den Wert der journalName-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJournalName(String value) {
            this.journalName = value;
        }

    }


    /**
     * <p>Java-Klasse für anonymous complex type.
     * 
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="academic_degree" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="department" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="university" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "name",
        "academicDegree",
        "department",
        "university"
    })
    public static class Signature {

        @XmlElement(required = true)
        protected String name;
        @XmlElement(name = "academic_degree", required = true)
        protected String academicDegree;
        @XmlElement(required = true)
        protected String department;
        @XmlElement(required = true)
        protected String university;

        /**
         * Ruft den Wert der name-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * Legt den Wert der name-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }

        /**
         * Ruft den Wert der academicDegree-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAcademicDegree() {
            return academicDegree;
        }

        /**
         * Legt den Wert der academicDegree-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAcademicDegree(String value) {
            this.academicDegree = value;
        }

        /**
         * Ruft den Wert der department-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDepartment() {
            return department;
        }

        /**
         * Legt den Wert der department-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDepartment(String value) {
            this.department = value;
        }

        /**
         * Ruft den Wert der university-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUniversity() {
            return university;
        }

        /**
         * Legt den Wert der university-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUniversity(String value) {
            this.university = value;
        }

    }


    /**
     * <p>Java-Klasse für anonymous complex type.
     * 
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="street" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="street_number" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
     *         &lt;element name="city" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="country" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="postal_number" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "street",
        "streetNumber",
        "city",
        "country",
        "postalNumber"
    })
    public static class UniversityAddress {

        @XmlElement(required = true)
        protected String street;
        @XmlElement(name = "street_number", required = true, defaultValue = "1")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger streetNumber;
        @XmlElement(required = true)
        protected String city;
        @XmlElement(required = true)
        protected String country;
        @XmlElement(name = "postal_number", required = true)
        protected String postalNumber;

        /**
         * Ruft den Wert der street-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStreet() {
            return street;
        }

        /**
         * Legt den Wert der street-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStreet(String value) {
            this.street = value;
        }

        /**
         * Ruft den Wert der streetNumber-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getStreetNumber() {
            return streetNumber;
        }

        /**
         * Legt den Wert der streetNumber-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setStreetNumber(BigInteger value) {
            this.streetNumber = value;
        }

        /**
         * Ruft den Wert der city-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCity() {
            return city;
        }

        /**
         * Legt den Wert der city-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCity(String value) {
            this.city = value;
        }

        /**
         * Ruft den Wert der country-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCountry() {
            return country;
        }

        /**
         * Legt den Wert der country-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCountry(String value) {
            this.country = value;
        }

        /**
         * Ruft den Wert der postalNumber-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPostalNumber() {
            return postalNumber;
        }

        /**
         * Legt den Wert der postalNumber-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPostalNumber(String value) {
            this.postalNumber = value;
        }

    }

}
