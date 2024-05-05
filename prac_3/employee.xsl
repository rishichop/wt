<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
    <html>
        <body>
            <h2>EMPLOYEE DETAILS</h2>
            <table border="1">
                <thead>
                <tr>
                    <th style="text-align:left">SRno</th>
                    <th style="text-align:left">Name</th>
                    <th style="text-align:left">Designation</th>
                    <th style="text-align:left">Salary</th>
                </tr>
                </thead>
                <tbody>
                <xsl:for-each select="employee/entry">
                <tr>
                    <td><xsl:value-of select="srno"/></td>
                    <td><xsl:value-of select="name"/></td>
                    <td><xsl:value-of select="designation"/></td>
                    <td><xsl:value-of select="salary"/></td>
                </tr>
                </xsl:for-each>
                </tbody>
            </table>
        </body>
    </html>
</xsl:template>

</xsl:stylesheet>