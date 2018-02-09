//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.02.05 um 09:12:30 AM CET 
//


package com.objava.naucnih.radova.model.naucni_rad;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *         &lt;element name="revisionVersion" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="author" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="first_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="last_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="affiliation" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                   &lt;element name="author_address">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="street" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="street_number" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *                             &lt;element name="city" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="country" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="phone_number" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="ORCID" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" maxOccurs="16"/>
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
    "title",
    "revisionVersion",
    "author"
})
@XmlRootElement(name = "cover_page")
public class CoverPage {

    @XmlElement(required = true)
    protected Object title;
    protected Object revisionVersion;
    @XmlElement(required = true)
    protected List<CoverPage.Author> author;

    /**
     * Ruft den Wert der title-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getTitle() {
        return title;
    }

    /**
     * Legt den Wert der title-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setTitle(Object value) {
        this.title = value;
    }

    /**
     * Ruft den Wert der revisionVersion-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getRevisionVersion() {
        return revisionVersion;
    }

    /**
     * Legt den Wert der revisionVersion-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setRevisionVersion(Object value) {
        this.revisionVersion = value;
    }

    /**
     * Gets the value of the author property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the author property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAuthor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CoverPage.Author }
     * 
     * 
     */
    public List<CoverPage.Author> getAuthor() {
        if (author == null) {
            author = new ArrayList<CoverPage.Author>();
        }
        return this.author;
    }
    
    


    @Override
	public String toString() {
		return "CoverPage [title=" + title + ", revisionVersion=" + revisionVersion + ", author=" + author + "]";
	}




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
     *         &lt;element name="first_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="last_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="affiliation" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
     *         &lt;element name="author_address">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="street" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="street_number" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
     *                   &lt;element name="city" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="country" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="phone_number" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="ORCID" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" maxOccurs="16"/>
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
        "firstName",
        "lastName",
        "affiliation",
        "authorAddress",
        "email",
        "phoneNumber",
        "orcid"
    })
    public static class Author {

        @XmlElement(name = "first_name", required = true)
        protected String firstName;
        @XmlElement(name = "last_name", required = true)
        protected String lastName;
        @XmlElement(required = true)
        protected Object affiliation;
        @XmlElement(name = "author_address", required = true)
        protected CoverPage.Author.AuthorAddress authorAddress;
        @XmlElement(required = true)
        protected String email;
        @XmlElement(name = "phone_number", required = true)
        protected String phoneNumber;
        @XmlElement(name = "ORCID", required = true, defaultValue = "1")
        @XmlSchemaType(name = "positiveInteger")
        protected List<BigInteger> orcid;

        /**
         * Ruft den Wert der firstName-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFirstName() {
            return firstName;
        }

        /**
         * Legt den Wert der firstName-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFirstName(String value) {
            this.firstName = value;
        }

        /**
         * Ruft den Wert der lastName-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLastName() {
            return lastName;
        }

        /**
         * Legt den Wert der lastName-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLastName(String value) {
            this.lastName = value;
        }

        /**
         * Ruft den Wert der affiliation-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link Object }
         *     
         */
        public Object getAffiliation() {
            return affiliation;
        }

        /**
         * Legt den Wert der affiliation-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link Object }
         *     
         */
        public void setAffiliation(Object value) {
            this.affiliation = value;
        }

        /**
         * Ruft den Wert der authorAddress-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link CoverPage.Author.AuthorAddress }
         *     
         */
        public CoverPage.Author.AuthorAddress getAuthorAddress() {
            return authorAddress;
        }

        /**
         * Legt den Wert der authorAddress-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link CoverPage.Author.AuthorAddress }
         *     
         */
        public void setAuthorAddress(CoverPage.Author.AuthorAddress value) {
            this.authorAddress = value;
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
         * Ruft den Wert der phoneNumber-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPhoneNumber() {
            return phoneNumber;
        }

        /**
         * Legt den Wert der phoneNumber-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPhoneNumber(String value) {
            this.phoneNumber = value;
        }

        /**
         * Gets the value of the orcid property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the orcid property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getORCID().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link BigInteger }
         * 
         * 
         */
        public List<BigInteger> getORCID() {
            if (orcid == null) {
                orcid = new ArrayList<BigInteger>();
            }
            return this.orcid;
        }

        
        @Override
		public String toString() {
			return "Author [firstName=" + firstName + ", lastName=" + lastName + ", affiliation=" + affiliation
					+ ", authorAddress=" + authorAddress + ", email=" + email + ", phoneNumber=" + phoneNumber
					+ ", orcid=" + orcid + "]";
		}


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
         *         &lt;element name="street" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="street_number" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
         *         &lt;element name="city" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="country" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
            "country"
        })
        public static class AuthorAddress {

            @XmlElement(required = true)
            protected String street;
            @XmlElement(name = "street_number", required = true, defaultValue = "1")
            @XmlSchemaType(name = "positiveInteger")
            protected BigInteger streetNumber;
            @XmlElement(required = true)
            protected String city;
            @XmlElement(required = true)
            protected String country;

            
            @Override
			public String toString() {
				return "AuthorAddress [street=" + street + ", streetNumber=" + streetNumber + ", city=" + city
						+ ", country=" + country + "]";
			}

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

        }

    }

}
