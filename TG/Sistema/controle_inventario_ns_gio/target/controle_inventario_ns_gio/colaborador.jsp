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

		<p>Tipo de acesso: <select name="tpAcesso">
			<option value="">Selecione...</option>
			<%
				sbRegistro = new StringBuilder();
				TipoAcesso tpAcesso = new TipoAcesso();
				listarOpcoes = new ListarOpcoes();
                resultado = listarOpcoes.processar(tpAcesso);
				entidades = resultado.getEntidades();

				for(int i = 0; i < entidades.size(); i++){	
					tpAcesso = (TipoAcesso)entidades.get(i);
					sbRegistro.setLength(0);
					sbRegistro.append("<option value='" + tpAcesso.getId() + "'>"
						+ tpAcesso.getDescricao() + "</option>");
					
					out.print(sbRegistro.toString());
				}

			%>
		</select></p>

		<p>Tipo de colaborador: <select name="tpColaborador">
			<option value="">Selecione...</option>
			<%
				sbRegistro = new StringBuilder();
				TipoColaborador tpColaborador = new TipoColaborador();
				listarOpcoes = new ListarOpcoes();
                resultado = listarOpcoes.processar(tpColaborador);
				entidades = resultado.getEntidades();

				for(int i = 0; i < entidades.size(); i++){	
					tpColaborador = (TipoColaborador)entidades.get(i);
					sbRegistro.setLength(0);
					sbRegistro.append("<option value='" + tpColaborador.getId() + "'>"
						+ tpColaborador.getDescricao() + "</option>");
					
					out.print(sbRegistro.toString());
				}

			%>
		</select></p>
				
		<p>Regime de trabalho: <select name="regimeTrabalho">
			<option value="">Selecione...</option>
			<%
				sbRegistro = new StringBuilder();
				RegimeTrabalho rmTrabalho = new RegimeTrabalho();
				listarOpcoes = new ListarOpcoes();
                resultado = listarOpcoes.processar(rmTrabalho);
				entidades = resultado.getEntidades();

				for(int i = 0; i < entidades.size(); i++){	
					rmTrabalho = (RegimeTrabalho)entidades.get(i);
					sbRegistro.setLength(0);
					sbRegistro.append("<option value='" + rmTrabalho.getId() + "'>"
						+ rmTrabalho.getDescricao() + "</option>");
					
					out.print(sbRegistro.toString());
				}

			%>
		</select></p>

		<p>Presidência: <select name="pre">
			<option value="">Selecione...</option>
			<%
				sbRegistro = new StringBuilder();
				Presidencia pre = new Presidencia();
				listarOpcoes = new ListarOpcoes();
                resultado = listarOpcoes.processar(pre);
				entidades = resultado.getEntidades();

				for(int i = 0; i < entidades.size(); i++){	
					pre = (Presidencia)entidades.get(i);
					sbRegistro.setLength(0);
					sbRegistro.append("<option value='" + pre.getId() + "'>"
						+ pre.getSigla() + " - "
						+ pre.getDescricao() + "</option>");
					
					out.print(sbRegistro.toString());
				}

			%>
		</select></p>

		<p>Diretoria: <select name="dir">
			<option value="">Selecione...</option>
			<%
				sbRegistro = new StringBuilder();
				Diretoria dir = new Diretoria();
				listarOpcoes = new ListarOpcoes();
                resultado = listarOpcoes.processar(dir);
				entidades = resultado.getEntidades();

				for(int i = 0; i < entidades.size(); i++){	
					dir = (Diretoria)entidades.get(i);
					sbRegistro.setLength(0);
					sbRegistro.append("<option value='" + dir.getId() + "'>"
						+ dir.getSigla() + " - "
						+ dir.getDescricao() + "</option>");
					
					out.print(sbRegistro.toString());
				}

			%>
		</select></p>

		<p>Gerencia: <select name="ger">
			<option value="">Selecione...</option>
			<%
				sbRegistro = new StringBuilder();
				Gerencia ger = new Gerencia();
				listarOpcoes = new ListarOpcoes();
                resultado = listarOpcoes.processar(ger);
				entidades = resultado.getEntidades();

				for(int i = 0; i < entidades.size(); i++){	
					ger = (Gerencia)entidades.get(i);
					sbRegistro.setLength(0);
					sbRegistro.append("<option value='" + ger.getId() + "'>"
						+ ger.getSigla() + " - "
						+ ger.getDescricao() + "</option>");
					
					out.print(sbRegistro.toString());
				}

			%>
		</select></p>

		<p>Núcleo: <select name="nuc">
			<option value="">Selecione...</option>
			<%
				sbRegistro = new StringBuilder();
				Nucleo nuc = new Nucleo();
				listarOpcoes = new ListarOpcoes();
                resultado = listarOpcoes.processar(nuc);
				entidades = resultado.getEntidades();

				for(int i = 0; i < entidades.size(); i++){	
					nuc = (Nucleo)entidades.get(i);
					sbRegistro.setLength(0);
					sbRegistro.append("<option value='" + nuc.getId() + "'>"
						+ nuc.getSigla() + " - "
						+ nuc.getDescricao() + "</option>");
					
					out.print(sbRegistro.toString());
				}

			%>
		</select></p>
		
		<input type="submit" name="operacao" value="Salvar">
        <input type="submit" name="operacao" value="Alterar">
        <input type="submit" name="operacao" value="Excluir">
		<a href="index.jsp">Home</a>
	</form>	
</body>
</html>
