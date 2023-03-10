<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>List</title>
    <link href="simple.css" rel="stylesheet" type="text/css"/>
</head>

<body>

<h1>LISTE OVER DELTAGERE:</h1> <br>

<p>Du er logget inn som bruker ${mobilnummer}</p> </br>

<table id="myList">
    <tr>

        <th>Deltakere</th>

    </tr>


    <tr>
    <th>Mobilnr</th>
    <th>Fornavn</th>
    <th>Etternavn</th>
    <th>Kjønn</th>
    </tr>

            <c:forEach items="${deltakerlist}" var="deltaker">
                <c:if test="${deltaker.mobilnummer == mobilnummer}">

                <tr id="delta" style="background-color: #0Db98D; color: #111111;">
                </c:if>
                <c:if test="${deltaker.mobilnummer != mobilnummer}">

                    <tr id="delta">
                </c:if>
            <td>${deltaker.mobilnummer}</td>
            <td>${deltaker.fornavn}</td>
            <td>${deltaker.etternavn}</td>
            <td>${deltaker.kjonn}</td>
        </tr>

    </c:forEach>
</table>
<form action="logout" method="post">
    <fieldset>
        <input type="submit" value="Logg ut"></input>
    </fieldset>
</form>

<script type="text/javascript">
</script>
</body>
</html>