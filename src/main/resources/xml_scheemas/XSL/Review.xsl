<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    xmlns:nr_review="http://www.ftn.uns.ac.rs/naucni_radovi/reviews"
    exclude-result-prefixes="xs"
    version="1.0">
    <xsl:template match="/">
        <html>
            <body>
                <h1 align="center"><xsl:value-of select="nr_review:review/nr_review:title/nr_review:typeOfReview" /></h1>
                <h1 align="center"><xsl:value-of select="nr_review:review/nr_review:title/nr_review:manuscript_title" /></h1>
                <h1 align="center"><xsl:value-of select="nr_review:review/nr_review:title/nr_review:revision_recommend" /></h1>
                <p align="center"><xsl:value-of select="nr_review:review/nr_review:info/nr_review:reviewAutor" /></p>
                <p align="center"><xsl:value-of select="nr_review:review/nr_review:info/nr_review:manuscriptAutor" /></p>
                <p align="center"><xsl:value-of select="nr_review:review/nr_review:info/nr_review:review_score" /></p>
                <br/>
                
                <xsl:for-each select="nr_review:review/nr_review:reviewPart">
                    <h4><xsl:value-of select="nr_review:partTitle"/></h4>
                    <p><xsl:value-of select="nr_review:partText"/></p>
                    <h3><xsl:value-of select="nr_review:partScore"/></h3>
                 </xsl:for-each>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>