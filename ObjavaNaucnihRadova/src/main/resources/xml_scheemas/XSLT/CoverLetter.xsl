<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    xmlns:nr_cl="http://www.ftn.uns.ac.rs/naucni_radovi/cover_letter"
    exclude-result-prefixes="xs"
    version="1.0">
    <xsl:template match="/">
        <html>
            <body>
                <h1><xsl:value-of select="nr_cl:cover_letter/nr_cl:title_text" /> </h1>
                <h1><xsl:value-of select="nr_cl:cover_letter/nr_cl:name"/></h1>
                <p><xsl:value-of select="nr_cl:cover_letter/nr_cl:university_address"/></p>
            </body>
        </html>
    </xsl:template>
    
</xsl:stylesheet>