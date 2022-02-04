<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page import="javax.swing.JOptionPane"%>
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
	<form action="Equipamento" method="post">

		<P> Serial:               <input type="text" name="serial"></p>
		<P> Número de patrimônio: <input type="text" name="patrimonio"></p>
		<P> Observação:           <input type="text" name="observacao"></p>
		<P> Presencial:           <input type="checkbox" name="locPresencial" value="presencial"></p>
        <P> Compartilhado:        <input type="checkbox" name="compartilhada" value="compartilhada"></p>
        <P> Contrato de equipamento de terceiro: <input type="text" name="contEquipTerceiro"></p>
		Tipo de equipmento : <select name="tipoEquipamento">
			<option value="">Selecione...</option>
			<%
				StringBuilder sbRegistro = new StringBuilder();
				TipoEquipamento tpEquipamento = new TipoEquipamento();
				ListarOpcoes listarOpcoes = new ListarOpcoes();
                Resultado resultado = listarOpcoes.processar(tpEquipamento);
				List <EntidadeDominio> entidades = resultado.getEntidades();

				for(int i = 0; i < entidades.size(); i++){	
					TipoEquipamento tipoEquip = (TipoEquipamento)entidades.get(i);
					sbRegistro.setLength(0);
					sbRegistro.append("<option value='" + tipoEquip.getId() + "'>"
						+ tipoEquip.getDescricao() + " " + tipoEquip.getMarca() + "</option>");
					
					out.print(sbRegistro.toString());
				}

			%>
		</select>
		
		<p>Nota fiscal : <select name="notaFiscal">
			<option value="">Selecione...</option>
			<%
				sbRegistro = new StringBuilder();
				NotaFiscal ntFiscal = new NotaFiscal();
				listarOpcoes = new ListarOpcoes();
                resultado = listarOpcoes.processar(ntFiscal);
				entidades = resultado.getEntidades();

				for(int i = 0; i < entidades.size(); i++){	
					ntFiscal = (NotaFiscal)entidades.get(i);
					sbRegistro.setLength(0);
					sbRegistro.append("<option value='" + ntFiscal.getId() + "'>"
						+ ntFiscal.getNumero() + "</option>");
					
					out.print(sbRegistro.toString());
				}

			%>
		</select></p>

		<p>Localização : <select name="localizacao">
			<option value="">Selecione...</option>
			<%
				sbRegistro = new StringBuilder();
				Localizacao local = new Localizacao();
				listarOpcoes = new ListarOpcoes();
                resultado = listarOpcoes.processar(local);
				entidades = resultado.getEntidades();

				for(int i = 0; i < entidades.size(); i++){	
					local = (Localizacao)entidades.get(i);
					sbRegistro.setLength(0);
					sbRegistro.append("<option value='" + local.getId() + "'>"
						+ local.getAndar() + "º andar - "
						+ local.getPredio() + " - " 
						+ local.getLado() + "</option>");
					
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
