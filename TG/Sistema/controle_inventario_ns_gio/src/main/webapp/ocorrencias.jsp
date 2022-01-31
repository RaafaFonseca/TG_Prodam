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
	<form action="Ocorrencia" method="post">
		<p>OS: <input type="text" name="os"></p>
        <p>Descrição: <input type="text" name="descricao"></p>
        <p>Colaborador: <input type="text" name="colaborador"></p>
        <p>Equipamento: <input type="text" name="equipamento"></p>

		<input type="submit" name="operacao" value="Salvar">
        <input type="submit" name="operacao" value="Alterar">
        <input type="submit" name="operacao" value="Excluir">
		<a href="index.jsp">Home</a>
	</form>	
</body>
</html>
