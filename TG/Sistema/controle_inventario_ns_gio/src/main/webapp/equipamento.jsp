<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="model.strategy.ListarOpcoes"%>
<%@page import="java.util.List"%>
<%@page import="model.dominio.EntidadeDominio"%>
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
		<select name="tipoEquipamento">
			<option value="">Selecione...</option>
			<%
				StringBuilder sbRegistro = new StringBuilder();
				TipoEquipamento tpEquipamento = new TipoEquipamento();
				ListarOpcoes listarOpcoes = new ListarOpcoes();
                List<EntidadeDominio> entidades = listarOpcoes(tpEquipamento);

				for(int i = 0; i<entidades.size(); i++){
					TipoEquipamento tipoEquip = (TipoEquipamento)entidades.get(i);
					sbRegistro.setLength(0);

					sbRegistro.append("<option value='"
						+ tipoEquip.getId() + "' "
				}

			%>
		</select>
		
		<P> Tipo de equipamento:  <input type="text" name="tipoEquipamento"></p>
        <P> Nota Fiscal:          <input type="text" name="notaFiscal"></p>
        <P> Localização:          <input type="text" name="localizacao"></p>

        <input type="submit" name="operacao" value="Salvar">
        <input type="submit" name="operacao" value="Alterar">
        <input type="submit" name="operacao" value="Excluir">
		<a href="index.jsp">Home</a>
	</form>	
</body>
</html>
