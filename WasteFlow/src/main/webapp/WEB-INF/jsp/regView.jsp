<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<head>
    <title>Påmelding</title>
    <link href="fancy.css" rel="stylesheet" type="text/css"/>
</head>

<body>
<h2>Påmelding</h2>

<form action="registrer" method="post" id="regskjema">
    <fieldset>
        <label for="mobil">Mobil (8 siffer):</label>
        <input type="text" name="mobil" id="mobil"
               placeholder="Fyll inn telefonnummer"
               title="Mobilnummer må bestå av nøyaktig 8 siffre"
               required pattern="\s*\+?\s*(\d\s*){8}\s*"
        />
        <span class="melding"></span>

        <label for="fornavn">Fornavn:</label>
        <input type="text" name="fornavn" id="fornavn"
               placeholder="Fyll inn fornavn"
               title="Fornavn må starte med stor forbokstav og innholde kun bokstaver, og antall tegn må være mellom 2 og 20"
               required pattern="\s*\p{Lu}\p{Ll}+(\s+\p{Lu}\p{Ll}+)*\s*"/>
        <span class="melding"></span>

        <label for="etternavn">Etternavn:</label>
        <input type="text" name="etternavn" id="etternavn"
               placeholder="Fyll inn etternavn"
               title="Etternavn må starte med stor forbokstav og innholde kun bokstaver, og antall tegn må være mellom 2 og 20"
               required pattern="\s*\p{Lu}\p{Ll}+\s*"
        />
        <span class="melding"></span>

        <label for="passord">Passord:</label>
        <input type="password" name="passord" id="passord"
               placeholder="Velg et passord"
               title="Passordet må bestå av minst 5 tegn, maks 25"
               required pattern=".{5,25}"
        />
        <span class="melding"></span>

        <label for="passordRepetert">Passord repetert:</label>
        <input type="password" name="passordRepetert" id="passordRepetert"
               placeholder="Gjenta passord"
               required pattern=".{5,25}"
        />
        <span class="melding"></span>

        <br/>
        <span class="columnfirst">Kjønn:</span>
        <span>
                <label>
                    <input type="radio" name="kjonn" value="M" checked="checked"/> mann</label>
                <label>
                    <input type="radio" name="kjonn" value="F"/>kvinne</label>
            </span>
        <span class="melding"></span>

        <button type="submit" onclick="checkPassword()">Meld meg på</button>
    </fieldset>
</form>


<script type="text/javascript">

    const pass1 = document.getElementById('passord');
    const pass2 = document.getElementById('passordRepetert')

    function checkPassword() {

        if (pass1.value == pass2.value) {
            console.log('THIS SHIT WORKS')
            pass1.setCustomValidity(''); /*set to valid*/
            pass2.style.borderColor = 'green';
        } else {
            console.log('THIS SHIT Dont WORKS')
            pass1.setCustomValidity('Passorda er ikkje like, prøv igjen'); /*set to invalid*/
            pass2.style.borderColor = 'red';
        }
    }

    pass1.addEventListener('keyup', () => {
        testPass(pass1);
        if (pass2.value.length != 0) checkPassword();
    })


    pass2.addEventListener('keyup', checkPassword);

    function testPass(pass) {
        const passLength = pass.value.length;
        
        if (passLength >= 5 && passLength < 12) {
            pass.style.borderColor = 'yellow';
        } else if (passLength >= 12) {
            pass.style.borderColor = 'green';
        } else {
            pass.style.borderColor = 'red';
        }
    }

</script>

</body>
</html>