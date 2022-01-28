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
	<form action="TipoEquipamento" method="post">
		<P> Descrição: <input type="text" name="descricao"></p>
		<P> Marca: <input type="text" name="marca"></p>
		<P> Modelo: <input type="text" name="modelo"></p>
		<P> Fornecedor: <input type="text" name="fornecedor"></p>
        <P> Polegadas: <input type="text" name="polegadas"></p>

		<input type="submit" name="operacao" value="Salvar">
        <input type="submit" name="operacao" value="Alterar">
        <input type="submit" name="operacao" value="Excluir">
	</form>	
</body>
</html>
