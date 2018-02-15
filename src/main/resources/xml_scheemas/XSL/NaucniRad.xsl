<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:nr="http://www.ftn.uns.ac.rs/naucni_rad"
    xmlns:nr_cp="http://www.ftn.uns.ac.rs/naucni_radovi/naslovna"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:nr_abs="http://www.ftn.uns.ac.rs/naucni_radovi/abstract"
    xmlns:nr_keyw="http://www.ftn.uns.ac.rs/naucni_radovi/keywords"
    xmlns:nr_pt="http://www.ftn.uns.ac.rs/naucni_radovi/paper_text"
    version="1.0">
    <xsl:template match="/">
        <html>
            <body>
                <div class="row">
                    <div class="row">
                        <h1><xsl:value-of select="nr:nr_def/nr_cp:cover_page/nr_cp:title" /> </h1>
                    </div>
                    <div class="row">
                        <h2><xsl:value-of select="nr:nr_def/nr_cp:cover_page/nr_cp:author/nr_cp:first_name" />
                            <xsl:text disable-output-escaping="yes"> </xsl:text>
                            <xsl:value-of select="nr:nr_def/nr_cp:cover_page/nr_cp:author/nr_cp:last_name"/>
                        </h2>
                        <h3><xsl:value-of select="nr:nr_def/nr_cp:cover_page/nr_cp:author/nr_cp:affiliation"/></h3>
                    </div>
                    <div class="row">
                        <h4><xsl:value-of select="nr:nr_def/nr_cp:cover_page/nr_cp:author/nr_cp:author_address/nr_cp:street"/></h4>
                        <h4><xsl:value-of select="nr:nr_def/nr_cp:cover_page/nr_cp:author/nr_cp:author_address/nr_cp:street_number"/></h4>
                        <h4><xsl:value-of select="nr:nr_def/nr_cp:cover_page/nr_cp:author/nr_cp:author_address/nr_cp:city"/></h4>
                        <h4><xsl:value-of select="nr:nr_def/nr_cp:cover_page/nr_cp:author/nr_cp:author_address/nr_cp:country"/></h4>
                    </div>
                    <div class="row">
                        <h4><xsl:value-of select="nr:nr_def/nr_cp:cover_page/nr_cp:author/nr_cp:email"/></h4>
                        <h4><xsl:value-of select="nr:nr_def/nr_cp:cover_page/nr_cp:author/nr_cp:phone_number"/></h4>
                        <h4><xsl:value-of select="nr:nr_def/nr_cp:cover_page/nr_cp:author/nr_cp:ORCID"/></h4>
                    </div>
                </div>
                <div class="row">
                    <p><xsl:value-of select="nr:nr_def/nr_cp:abstract_text"/></p>
                </div>
                <div class="row">
                    <xsl:variable name="all-keywords" select="nr:nr_def/nr_cp:keywords" />
                    <xsl:for-each select="$all-keywords">
                        <p><xsl:value-of select="keyword"/></p>
                    </xsl:for-each>
                </div>
                <div class="row">
                    <h1><xsl:value-of select="nr:nr_def/nr_cp:paper/nr_cp:primary_header/nr_cp:primary_header_title"/></h1>
                    <p><xsl:value-of select="nr:nr_def/nr_cp:paper/nr_cp:primary_header/nr_cp:primary_header_text"/></p>
                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>