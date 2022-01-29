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
	<form action="Programa" method="post">
		Descrição: <input type="text" name="descricao">
        Observação: <input type="text" name="observacao">
        
		<select name="licenca">
			<option value="">Selecione...</option>
			<option value="gnu"> GNU General Public License (GNU GPL)</option>
			<option value="freeware"> Freeware</option>
			<option value="openSource"> Open Source</option>
			<option value="softProprietario"> Software Proprietário</option>
			<option value="flutuante"> Flutuante</option>
			<option value="licenciado"> Licenciado</option>
		</select>

		<input type="submit" name="operacao" value="Salvar">
        <input type="submit" name="operacao" value="Alterar">
        <input type="submit" name="operacao" value="Excluir">
		<a href="index.jsp">Home</a>
	</form>	
</body>
</html>
