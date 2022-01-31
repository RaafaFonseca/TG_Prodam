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
	<form action="Tipo" method="post">
		
        <select name="tipo">
			<option value="">Selecione...</option>
			<option value="regimeTrabalho"> Regime de Trabalho</option>
			<option value="tpColaborador"> Tipo de Colaborador</option>
			<option value="tpAcesso"> Tipo de Acesso</option>
		</select>

        Descrição: <input type="text" name="descricao">

		<input type="submit" name="operacao" value="Salvar">
        <input type="submit" name="operacao" value="Alterar">
        <input type="submit" name="operacao" value="Excluir">
		<a href="index.jsp">Home</a>
	</form>	
</body>
</html>
