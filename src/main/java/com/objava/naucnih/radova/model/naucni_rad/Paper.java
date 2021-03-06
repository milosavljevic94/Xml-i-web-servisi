//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.02.05 um 09:12:30 AM CET 
//


package com.objava.naucnih.radova.model.naucni_rad;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="primary_header">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="primary_header_title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="primary_header_text" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="secondary_header" maxOccurs="9" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="secondary_header_title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="secondary_header_text" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="third_header" maxOccurs="9" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="third_header_title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="third_header_text" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
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
    "primaryHeader"
})
@XmlRootElement(name = "paper", namespace = "http://www.ftn.uns.ac.rs/naucni_radovi/paper_text")
public class Paper {

    @XmlElement(name = "primary_header", namespace = "http://www.ftn.uns.ac.rs/naucni_radovi/paper_text", required = true)
    protected Paper.PrimaryHeader primaryHeader;

    
    @Override
	public String toString() {
		return "Paper [primaryHeader=" + primaryHeader + "]";
	}

	/**
     * Ruft den Wert der primaryHeader-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Paper.PrimaryHeader }
     *     
     */
    public Paper.PrimaryHeader getPrimaryHeader() {
        return primaryHeader;
    }

    /**
     * Legt den Wert der primaryHeader-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Paper.PrimaryHeader }
     *     
     */
    public void setPrimaryHeader(Paper.PrimaryHeader value) {
        this.primaryHeader = value;
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
     *         &lt;element name="primary_header_title" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="primary_header_text" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="secondary_header" maxOccurs="9" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="secondary_header_title" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="secondary_header_text" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="third_header" maxOccurs="9" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="third_header_title" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="third_header_text" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
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
        "primaryHeaderTitle",
        "primaryHeaderText",
        "secondaryHeader"
    })
    public static class PrimaryHeader {

        @XmlElement(name = "primary_header_title", namespace = "http://www.ftn.uns.ac.rs/naucni_radovi/paper_text", required = true)
        protected String primaryHeaderTitle;
        @XmlElement(name = "primary_header_text", namespace = "http://www.ftn.uns.ac.rs/naucni_radovi/paper_text", required = true)
        protected String primaryHeaderText;
        @XmlElement(name = "secondary_header", namespace = "http://www.ftn.uns.ac.rs/naucni_radovi/paper_text")
        protected List<Paper.PrimaryHeader.SecondaryHeader> secondaryHeader;

        
        @Override
		public String toString() {
			return "PrimaryHeader [primaryHeaderTitle=" + primaryHeaderTitle + ", primaryHeaderText="
					+ primaryHeaderText + ", secondaryHeader=" + secondaryHeader + "]";
		}

		/**
         * Ruft den Wert der primaryHeaderTitle-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPrimaryHeaderTitle() {
            return primaryHeaderTitle;
        }

        /**
         * Legt den Wert der primaryHeaderTitle-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPrimaryHeaderTitle(String value) {
            this.primaryHeaderTitle = value;
        }

        /**
         * Ruft den Wert der primaryHeaderText-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPrimaryHeaderText() {
            return primaryHeaderText;
        }

        /**
         * Legt den Wert der primaryHeaderText-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPrimaryHeaderText(String value) {
            this.primaryHeaderText = value;
        }

        /**
         * Gets the value of the secondaryHeader property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the secondaryHeader property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSecondaryHeader().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Paper.PrimaryHeader.SecondaryHeader }
         * 
         * 
         */
        public List<Paper.PrimaryHeader.SecondaryHeader> getSecondaryHeader() {
            if (secondaryHeader == null) {
                secondaryHeader = new ArrayList<Paper.PrimaryHeader.SecondaryHeader>();
            }
            return this.secondaryHeader;
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
         *         &lt;element name="secondary_header_title" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="secondary_header_text" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="third_header" maxOccurs="9" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="third_header_title" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="third_header_text" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
            "secondaryHeaderTitle",
            "secondaryHeaderText",
            "thirdHeader"
        })
        public static class SecondaryHeader {

            @XmlElement(name = "secondary_header_title", namespace = "http://www.ftn.uns.ac.rs/naucni_radovi/paper_text", required = true)
            protected String secondaryHeaderTitle;
            @XmlElement(name = "secondary_header_text", namespace = "http://www.ftn.uns.ac.rs/naucni_radovi/paper_text", required = true)
            protected String secondaryHeaderText;
            @XmlElement(name = "third_header", namespace = "http://www.ftn.uns.ac.rs/naucni_radovi/paper_text")
            protected List<Paper.PrimaryHeader.SecondaryHeader.ThirdHeader> thirdHeader;

            /**
             * Ruft den Wert der secondaryHeaderTitle-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSecondaryHeaderTitle() {
                return secondaryHeaderTitle;
            }

            /**
             * Legt den Wert der secondaryHeaderTitle-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSecondaryHeaderTitle(String value) {
                this.secondaryHeaderTitle = value;
            }

            /**
             * Ruft den Wert der secondaryHeaderText-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSecondaryHeaderText() {
                return secondaryHeaderText;
            }

            /**
             * Legt den Wert der secondaryHeaderText-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSecondaryHeaderText(String value) {
                this.secondaryHeaderText = value;
            }

            /**
             * Gets the value of the thirdHeader property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the thirdHeader property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getThirdHeader().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Paper.PrimaryHeader.SecondaryHeader.ThirdHeader }
             * 
             * 
             */
            public List<Paper.PrimaryHeader.SecondaryHeader.ThirdHeader> getThirdHeader() {
                if (thirdHeader == null) {
                    thirdHeader = new ArrayList<Paper.PrimaryHeader.SecondaryHeader.ThirdHeader>();
                }
                return this.thirdHeader;
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
             *         &lt;element name="third_header_title" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="third_header_text" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
                "thirdHeaderTitle",
                "thirdHeaderText"
            })
            public static class ThirdHeader {

                @XmlElement(name = "third_header_title", namespace = "http://www.ftn.uns.ac.rs/naucni_radovi/paper_text", required = true)
                protected String thirdHeaderTitle;
                @XmlElement(name = "third_header_text", namespace = "http://www.ftn.uns.ac.rs/naucni_radovi/paper_text", required = true)
                protected String thirdHeaderText;

                /**
                 * Ruft den Wert der thirdHeaderTitle-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getThirdHeaderTitle() {
                    return thirdHeaderTitle;
                }

                /**
                 * Legt den Wert der thirdHeaderTitle-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setThirdHeaderTitle(String value) {
                    this.thirdHeaderTitle = value;
                }

                /**
                 * Ruft den Wert der thirdHeaderText-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getThirdHeaderText() {
                    return thirdHeaderText;
                }

                /**
                 * Legt den Wert der thirdHeaderText-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setThirdHeaderText(String value) {
                    this.thirdHeaderText = value;
                }

            }

        }

    }

}
