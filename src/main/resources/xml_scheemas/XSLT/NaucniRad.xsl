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
                <h1><xsl:value-of select="nr:nr_def/nr_cp:cover_page/nr_cp:title" /> </h1>
                <h2><xsl:value-of select="nr:nr_def/nr_cp:cover_page/nr_cp:author/nr_cp:first_name" />
                    <xsl:text disable-output-escaping="yes"> </xsl:text>
                    <xsl:value-of select="nr:nr_def/nr_cp:cover_page/nr_cp:author/nr_cp:last_name"/>
                </h2>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>