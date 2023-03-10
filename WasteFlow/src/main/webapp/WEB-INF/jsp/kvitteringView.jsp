<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Velkommen</title>
    <link href="fancy.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<h4>Du er nå hjertelig velkommen til festen ${fornavn} ${etternavn}!</h4>

<p>bruk ${mobilnr} og ditt personlige passord neste gang du skal logge på</p>


<form action="login" method="get">
    <fieldset>
        <p>logg inn for å få en oversikt over alle deltakere</p>
        <input type="submit" value="Gå til logg inn siden"></input>

    </fieldset>
</form>

</body>
</html>