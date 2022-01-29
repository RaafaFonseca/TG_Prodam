<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>
	<form action="Equipamento" method="post">

		<P> Serial:               <input type="text" name="serial"></p>
		<P> Número de patrimônio: <input type="text" name="patrimonio"></p>
		<P> Observação:           <input type="text" name="observacao"></p>
		<P>                       <input type="checkbox" name="locPresencial" value="presencial"></p>
        <P>                       <input type="checkbox" name="compartilhada" value="compartilhada"></p>
        <P> Contrato de equipamento de terceiro: <input type="text" name="contEquipTerceiro"></p>
		<P> Tipo de equipamento:  <input type="text" name="tipoEquipamento"></p>
        <P> Nota Fiscal:          <input type="text" name="notaFiscal"></p>
        <P> Localização:          <input type="text" name="localizacao"></p>

        <input type="submit" name="operacao" value="Salvar">
        <input type="submit" name="operacao" value="Alterar">
        <input type="submit" name="operacao" value="Excluir">
	</form>	
</body>
</html>
