<!DOCTYPE HTML>
<html>
<head>
    
    <title>Il Mondo della Gomma - Gestionale</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="style.css">
    <link href="img/favicon.ico" rel="icon" type="image/x-icon" />
    
</head>
    
<body>

    <div id="navbar"><input class="bottone" type="submit" value="Logout"></div><br>
    <div id="gestionale">
        <h2>Inventario Pneumatici:</h2><a id="aggiungi" href="#" onclick="javascript:void(x=open('aggiungi.jsp','Privacy','top=10,left=10,toolbar=no,location=no,status=no,menubar=no,scrollbars=yes,resizable=no,width=700,height=330'));x.focus();">Aggiungi pneumatico</a>
        <div id="inventario">
        <div class="item">
            <img class="itempic" src="img/gomma.png" height="90">
            <span class="itemtitolo">BRIDGESTONE RAPID 82</span><br>
            <span class="itemdescr">145 / 80 / R13</span><br>
            <span class="mod-eli"><a href="#" onclick="javascript:void(x=open('modifica.jsp','Privacy','top=10,left=10,toolbar=no,location=no,status=no,menubar=no,scrollbars=yes,resizable=no,width=700,height=330'));x.focus();">modifica</a><b>|</b><a href="">elimina</a></span>
        </div>
        </div>
        <h2>Lista Ordini:</h2>
        <div id="ordini">
        <div class="item">
        <span class="ordernome">Mario Rossi</span><br>
        <span class="orderarticolo">BRIDGESTONE RAPID 82 x<span class="num">2</span></span><br>
        <span class="orderid">ID ordine: <span class="id"><b>1</b></span></span><br>
        <span class="orderdett"><a href="#" onclick="javascript:void(x=open('ordine.jsp','Privacy','top=10,left=10,toolbar=no,location=no,status=no,menubar=no,scrollbars=yes,resizable=no,width=1060,height=500'));x.focus();">dettaglio ordine</a></span>
        </div>
        </div>
    </div>

</body>
</html>