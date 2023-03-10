<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Logg inn</title>
    <link href="simple.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<p style="color:red"></p>
<p style="text-align: center; font-size: 32px">Logg Inn</p>

<form action="login" method="post">
    <fieldset style="border-left: none; border-right: none; margin: 0 auto; text-align: center">
        <input type="text" name="mobilnummer" placeholder="Mobilnummer..."
               style="border-top: none; border-bottom: none; text-align: center"/><br>
        <input type="password" name="passord" placeholder="Passord..."
               style="border-top: none; border-bottom: none; text-align: center"/><br>
        <input type="submit" value="Logg inn" style="border-radius: 10px"/><br>
    </fieldset>
</form>

<form action="registrer" method="get">
    <fieldset>
        <p>Har du ikkje brukar?</p>
        <input type="submit" value="Registrer"></input>
    </fieldset>
</form>


</body>
</html>