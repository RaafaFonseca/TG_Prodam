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
		Rf: <input type="text" name="rf">
		Nome: <input type="text" name="nome">
		Observação: <input type="text" name="observacao">
		Tipo de acesso: <input type="text" name="tpAcesso">
		Tipo de colaborador: <input type="text" name="tpColaborador">
		Regime de trabalho: <input type="text" name="regimeTrabalho">
		Presidência: <input type="text" name="pre">
		Diretoria: <input type="text" name="dir">
		Gerência: <input type="text" name="ger">
		Núcleo: <input type="text" name="nuc">

		<input type="submit" name="operacao" value="Salvar">
        <input type="submit" name="operacao" value="Alterar">
        <input type="submit" name="operacao" value="Excluir">
		<a href="index.jsp">Home</a>
	</form>	
</body>
</html>
