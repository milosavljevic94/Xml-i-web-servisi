//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.02.05 um 09:14:20 AM CET 
//


package com.objava.naucnih.radova.model.review;

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
 *         &lt;element name="title">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="typeOfReview" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="manuscript_title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="revision_recommend" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="info">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="reviewAutor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="manuscriptAutor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="review_score" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="reviewPart" maxOccurs="10" minOccurs="2">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="partTitle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="partText" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="recommendations" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="50" minOccurs="0"/>
 *                   &lt;element name="partScore" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "info",
    "reviewPart"
})
@XmlRootElement(name = "review")
public class Review {

    @XmlElement(required = true)
    protected Review.Title title;
    @XmlElement(required = true)
    protected Review.Info info;
    @XmlElement(required = true)
    protected List<Review.ReviewPart> reviewPart;

    /**
     * Ruft den Wert der title-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Review.Title }
     *     
     */
    public Review.Title getTitle() {
        return title;
    }

    /**
     * Legt den Wert der title-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Review.Title }
     *     
     */
    public void setTitle(Review.Title value) {
        this.title = value;
    }

    /**
     * Ruft den Wert der info-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Review.Info }
     *     
     */
    public Review.Info getInfo() {
        return info;
    }

    /**
     * Legt den Wert der info-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Review.Info }
     *     
     */
    public void setInfo(Review.Info value) {
        this.info = value;
    }

    /**
     * Gets the value of the reviewPart property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reviewPart property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReviewPart().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Review.ReviewPart }
     * 
     * 
     */
    public List<Review.ReviewPart> getReviewPart() {
        if (reviewPart == null) {
            reviewPart = new ArrayList<Review.ReviewPart>();
        }
        return this.reviewPart;
    }

    @Override
	public String toString() {
		return "Review [title=" + title + ", info=" + info + ", reviewPart=" + reviewPart + "]";
	}

    /**
=======
	/**
>>>>>>> Stashed changes
     * <p>Java-Klasse f�r anonymous complex type.
     * 
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="reviewAutor" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="manuscriptAutor" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="review_score" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "reviewAutor",
        "manuscriptAutor",
        "reviewScore"
    })
    public static class Info {

        @XmlElement(required = true)
        protected String reviewAutor;
        @XmlElement(required = true)
        protected String manuscriptAutor;
        @XmlElement(name = "review_score", required = true)
        protected String reviewScore;

        /**
         * Ruft den Wert der reviewAutor-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getReviewAutor() {
            return reviewAutor;
        }

        /**
         * Legt den Wert der reviewAutor-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setReviewAutor(String value) {
            this.reviewAutor = value;
        }

        /**
         * Ruft den Wert der manuscriptAutor-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getManuscriptAutor() {
            return manuscriptAutor;
        }

        /**
         * Legt den Wert der manuscriptAutor-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setManuscriptAutor(String value) {
            this.manuscriptAutor = value;
        }

        /**
         * Ruft den Wert der reviewScore-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getReviewScore() {
            return reviewScore;
        }

        /**
         * Legt den Wert der reviewScore-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setReviewScore(String value) {
            this.reviewScore = value;
        }

		@Override
		public String toString() {
			return "Info [reviewAutor=" + reviewAutor + ", manuscriptAutor=" + manuscriptAutor + ", reviewScore="
					+ reviewScore + "]";
		}
        
        

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
     *         &lt;element name="partTitle" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="partText" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="recommendations" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="50" minOccurs="0"/>
     *         &lt;element name="partScore" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "partTitle",
        "partText",
        "recommendations",
        "partScore"
    })
    public static class ReviewPart {

        @XmlElement(required = true)
        protected String partTitle;
        @XmlElement(required = true)
        protected String partText;
        protected List<String> recommendations;
        @XmlElement
        protected String partScore;

        /**
         * Ruft den Wert der partTitle-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPartTitle() {
            return partTitle;
        }

        /**
         * Legt den Wert der partTitle-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPartTitle(String value) {
            this.partTitle = value;
        }

        /**
         * Ruft den Wert der partText-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPartText() {
            return partText;
        }

        /**
         * Legt den Wert der partText-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPartText(String value) {
            this.partText = value;
        }

        /**
         * Gets the value of the recommendations property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the recommendations property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRecommendations().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getRecommendations() {
            if (recommendations == null) {
                recommendations = new ArrayList<String>();
            }
            return this.recommendations;
        }

        /**
         * Ruft den Wert der partScore-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPartScore() {
            return partScore;
        }

        /**
         * Legt den Wert der partScore-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPartScore(String value) {
            this.partScore = value;
        }

		@Override
		public String toString() {
			return "ReviewPart [partTitle=" + partTitle + ", partText=" + partText + ", recommendations="
					+ recommendations + ", partScore=" + partScore + "]";
		}
        
        

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
     *         &lt;element name="typeOfReview" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="manuscript_title" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="revision_recommend" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "typeOfReview",
        "manuscriptTitle",
        "revisionRecommend"
    })
    public static class Title {

        @XmlElement(required = true)
        protected String typeOfReview;
        @XmlElement(name = "manuscript_title", required = true)
        protected String manuscriptTitle;
        @XmlElement(name = "revision_recommend", required = true)
        protected String revisionRecommend;

        /**
         * Ruft den Wert der typeOfReview-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTypeOfReview() {
            return typeOfReview;
        }

        /**
         * Legt den Wert der typeOfReview-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTypeOfReview(String value) {
            this.typeOfReview = value;
        }

        /**
         * Ruft den Wert der manuscriptTitle-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getManuscriptTitle() {
            return manuscriptTitle;
        }

        /**
         * Legt den Wert der manuscriptTitle-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setManuscriptTitle(String value) {
            this.manuscriptTitle = value;
        }

        /**
         * Ruft den Wert der revisionRecommend-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRevisionRecommend() {
            return revisionRecommend;
        }

        /**
         * Legt den Wert der revisionRecommend-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRevisionRecommend(String value) {
            this.revisionRecommend = value;
        }

		@Override
		public String toString() {
			return "Title [typeOfReview=" + typeOfReview + ", manuscriptTitle=" + manuscriptTitle
					+ ", revisionRecommend=" + revisionRecommend + "]";
		}
        
        

    }

}
