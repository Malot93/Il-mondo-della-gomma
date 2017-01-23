<!DOCTYPE HTML>
<html>
<head>
    
    <title>Il Mondo della Gomma</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="style.css">
    <link href="favicon.ico" rel="icon" type="image/x-icon" />
    
</head>
    
<body>

    <div id="navbar"><h3> 089/1565482 </h3></div>
    <div id="centrale">
        <h2 align="center" style="position:relative;top:-40px;">Ricerca Pneumatico</h2>
        <form action="RispostaIndex" method="get">
        <select style="position:relative;top:-20px;" class="ricerca" name="larghezza" id="larghezza">
        <option value="0">Larghezza</option>
        <option disabled value="0"> </option>
        <option value="125" name="125">125</option>
        <option value="130" name="130">130</option>
        <option value="140" name="140">140</option>
        <option value="145" name="145">145</option>
        <option value="160" name="160">160</option>
        <option value="170" name="170">170</option>
        <option value="180" name="180">180</option>
        <option value="190" name="190">190</option>
        <option value="200" name="200">200</option>
        </select>
        <select style="position:relative;left:35px;top:-20px;" class="ricerca" name="altezza" id="altezza">
        <option value="0">Altezza</option>
        <option disabled value="0"> </option>
        <option value="60" name="60">60</option>
        <option value="65" name="65">65</option>
        <option value="70" name="70">70</option>
        <option value="80" name="80">80</option>
        </select>
        <select style="position:relative;left:70px;top:-20px;" class="ricerca" name="diametro" id="diametro">
        <option value="0">Diametro</option>
        <option disabled value="0"> </option>
        <option value="R12" name="R12">R12</option>
        <option value="R13" name="R13">R13</option>
        <option value="R14" name="R14">R14</option>
        <option value="R15" name="R15">R15</option>
        <option value="R16" name="R16">R16</option>
        <option value="R17" name="R17">R17</option>
        <option value="R18" name="R18">R18</option>
        <option value="R19" name="R19">R19</option>
        <option value="R20" name="R20">R20</option>
        <option value="R21" name="R21">R21</option>
        <option value="R22" name="R22">R22</option>
        </select><br><br><br>
        <select style="position:relative;width:175px;top:-20px;left:115px;" class="ricerca" name="stagionalita" id="stagionalita">
        <option value="0">Stagionalit&agrave;</option>
        <option disabled value="0"> </option>
        <option value="estivi" name="estivi">Estivi</option>
        <option value="invernali" name="invernali">Invernali</option>
        <option value="allseason" name="allseason">All Season</option>
        </select><br><br><br>
        <select style="position:relative;top:-20px;width:175px;left:115px;" class="ricerca" name="marca" id="marca">
        <option value="0">Marca Produttore</option>
        <option disabled value="0"> </option>
        <option value="bridgestone" name="bridgestone">Bridgestone</option>
        <option value="continental" name="continental">Continental</option>
        <option value="firestone" name="firestone">Firestone</option>
        <option value="goodyear" name="goodyear">GoodYear</option>
        <option value="michelin" name="michelin">Michelin</option>
        </select><br>
        <input class="bottone" type="submit" value="Cerca Pneumatico">
        </form>
    </div><br>
    <p style="text-align: center; position: relative; top: 125px;">Non sai qual &egrave; lo pneumatico adatto a te? Visualizza la <span style="cursor:pointer; font-weight: 700;" onclick="javascript:void(x=open('guida.jsp','Privacy','top=10,left=10,toolbar=no,location=no,status=no,menubar=no,scrollbars=yes,resizable=no,width=666,height=746'));x.focus();"><u>Guida</u></span></p>


</body>
</html>