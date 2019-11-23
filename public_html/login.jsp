<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page contentType="text/html;charset=windows-1252"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>
Hello World
</title>
</head>
<body>
<h2>
Torneo de Tens Grand Slam
</h2>
Inicio de Sesión
<html:errors />
<html:form action="/login">
<table border="0">
<tr>
    <td><bean:message key="username.prompt" /></td>
    <td><html:text property="username" /></td>
</tr>
<tr>
    <td><bean:message key="password.prompt" /></td>
    <td><html:password property="password" /></td>
</tr>
</table>

<html:submit value="Ingresar" />
</html:form>

<p>
<%= new java.util.Date() %></p>
</body>
</html>
