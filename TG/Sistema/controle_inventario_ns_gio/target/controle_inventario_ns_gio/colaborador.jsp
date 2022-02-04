<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page import="model.strategy.ListarOpcoes"%>
<%@page import="java.util.List"%>
<%@page import="model.dominio.*"%>
<%@page import="util.Resultado"%>
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
		<p>Imagem : <select name="imagem">
			<option value="">Selecione...</option>
			<%
				StringBuilder sbRegistro = new StringBuilder();
				Imagem image = new Imagem();
				ListarOpcoes listarOpcoes = new ListarOpcoes();
                Resultado resultado = listarOpcoes.processar(image);
				List <EntidadeDominio> entidades = resultado.getEntidades();

				for(int i = 0; i < entidades.size(); i++){	
					image = (Imagem)entidades.get(i);
					sbRegistro.setLength(0);
					sbRegistro.append("<option value='" + image.getId() + "'>"
						+ image.getDescricao() + "</option>");
					
					out.print(sbRegistro.toString());
				}

			%>
		</select></p>

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
