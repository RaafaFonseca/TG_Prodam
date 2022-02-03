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
	<form action="Emprestimo" method="post">
		<p>Colaborador: <input type="text" name="colaborador"></p>
        <p>Equipamento: <input type="text" name="equipamento"></p>
        <p>Ativo: <input type="checkbox" name="ativo"></p>
        <p>Finalidade: <input type="text" name="finalidade"></p>
        <p>Responsável pela entrega: <input type="text" name="respEntrega"></p>
        <p>Data de devolução: <input type="date" name="dtDevolucao"></p>
        Indefinida: <input type="checkbox" name="devolucao" value="devolucao">
        <p>Data da disponilização: <input type="date" name="dtDisponibilizacao"></p>

		<input type="submit" name="operacao" value="Salvar">
        <input type="submit" name="operacao" value="Alterar">
        <input type="submit" name="operacao" value="Excluir">
		<a href="index.jsp">Home</a>
	</form>	
</body>
</html>
