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
	<form action="Imagem" method="post">
		<P> Nome: <input type="text" name="descricao"></p>
		<P> Programa 1<input type="text" name="programa1"></p>
		<P> Programa 2<input type="text" name="programa2"></p>
		<P> Programa 3<input type="text" name="programa3"></p>

		<input type="submit" name="operacao" value="Salvar">
        <input type="submit" name="operacao" value="Alterar">
        <input type="submit" name="operacao" value="Excluir">
	</form>	
</body>
</html>
