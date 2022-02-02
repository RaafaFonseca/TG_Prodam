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
	<form action="Colaborador" method="post">
		<p>Rf: <input type="text" name="rf"></p>
		<p>Nome: <input type="text" name="nome"></p>
		<p>Imagem: <input type="text" name="imagem"></p>
		<p>Tipo de acesso: <input type="text" name="tpAcesso"></p>
		<p>Tipo de colaborador: <input type="text" name="tpColaborador"></p>
		<p>Regime de trabalho: <input type="text" name="regimeTrabalho"></p>
		<p>Presidência: <input type="text" name="pre"></p>
		<p>Diretoria: <input type="text" name="dir"></p>
		<p>Gerência: <input type="text" name="ger"></p>
		<p>Núcleo: <input type="text" name="nuc"></p>

		<input type="submit" name="operacao" value="Salvar">
        <input type="submit" name="operacao" value="Alterar">
        <input type="submit" name="operacao" value="Excluir">
		<a href="index.jsp">Home</a>
	</form>	
</body>
</html>
