<!DOCTYPE HTML>
<html>
<head>
    
    <title>Il Mondo della Gomma - Acquisto Prodotto</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="style.css">
    <link href="img/favicon.ico" rel="icon" type="image/x-icon" />
    
</head>
    
<body>

    <div id="navbar"><h3> 089/1565482 </h3></div>
    <div id="acquisto">
        <h2>Stai per acquistare:</h2>
        
        <div class="risultato">
            <img src="img/gomma.png" height="200">
            <h2 class="nomepneumatico">BRIDGESTONE RAPID 82</h2>
            <h2 class="specifichetec">145 / 80 / R13</h2>
            <p class="prezzosing">Quantit&agrave;: <input style="width:35px;" size="2" value="1" type="number" name="quantita"></p>
            <p id="prezzo_t">Prezzo singolo: <b>&euro; <span id="p">80</span></b></p>
        </div>
      <fieldset id="acquirente">
          <legend style="font-size: 20px;font-weight: bold;">Informazioni acquirente</legend><br>
          <p><span>Nome</span><span style="position:relative;left:240px;">Cognome</span><br>
          <input style="width:255px;" type="text"><input style="margin-left:30px;width:255px;" type="text"><br><br>
          <span>Codice Fiscale</span><span style="position:relative;left:175px;">Email</span><br>
          <input style="width:255px;" type="text"><input size="21" style="margin-left:30px;width:255px;" type="email"><br><br>
          <span>Indirizzo</span><span style="position:relative;left:410px;">Civico</span><br>
          <input style="width:445px;" type="text"><input size="2" style="margin-left:30px;width:65px;" type="text"><br><br>
          <span>Citt&agrave;</span><span style="position:relative;left:178px;">Prov.</span><span style="position:relative;left:225px;">CAP</span><span style="position:relative;left:298px;">Paese</span><br>
          <input size="14" type="text"><input style="margin-left:30px;" size="1" type="text"><input style="margin-left:30px;" size="3" type="text"><input style="margin-left:30px;" size="9" type="text">
          </p>
        </fieldset>
      <fieldset id="metodo">
       <legend style="font-size: 20px;font-weight: bold;">Metodo di pagamento</legend>
        <p>
            <label>
              <input type="radio" name="pagamento" value="contrassegno" id="pagamento_0">
              Contrassegno</label>
            <br>
            <label>
              <input type="radio" name="pagamento" value="carta" id="pagamento_1">
              Carta di Credito</label>
            <br>
            <label>
              <input type="radio" name="pagamento" value="paypal" id="pagamento_2">
              PayPal</label>
            <br>
        </p>
        </fieldset>
        
            <button type="button" class="bottone" style="width:150px;">Acquista</button>
        
    </div>

</body>
</html>