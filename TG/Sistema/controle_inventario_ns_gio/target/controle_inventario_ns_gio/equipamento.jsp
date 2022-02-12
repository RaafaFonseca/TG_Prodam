<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
	<%
		Equipamento equipa = (Equipamento) request.getAttribute("equipamento");
		StringBuilder componente = new StringBuilder();
	%>

	<form action="Equipamento" method="post">
		<%
			componente.setLength(0);
			componente.append("<input type='hidden' name='idEquipHidden' value='");
			if(equipa != null) {componente.append(equipa.getId());}
			componente.append("'/>");
			out.print(componente.toString());
			
		%>

		<%
			componente.setLength(0);
			componente.append("<P> Serial: ");
			componente.append("<input type='text' name='serial' value='");
			if(equipa != null) {componente.append(equipa.getSerial());}
			componente.append("'/></P>");
			out.print(componente.toString());
			
		%>
		<%
			componente.setLength(0);
			componente.append("<P> Número de patrimônio: ");
			componente.append("<input type='text' name='patrimonio' value='"); 
			if(equipa != null) {componente.append(equipa.getNumPatrimonio());}
			componente.append("'/></P>");
			out.print(componente.toString());
		%>
		<%
			componente.setLength(0);
			componente.append("<P> Observação: ");
			componente.append("<input type='text' name='observacao' value ='"); 
			if(equipa != null) {componente.append(equipa.getObservacao());}
			componente.append("'/></P>");
			out.print(componente.toString());
		%>
		
		<%
			componente.setLength(0);
			componente.append("<P> Presencial: ");
			componente.append("<input type='checkbox' name='locPresencial' value='presencial'"); 
			if(equipa != null && equipa.getLocPresencial()){componente.append("checked");}
			componente.append("/></P>");
			out.print(componente.toString());
		%>

		<%
			componente.setLength(0);
			componente.append("<P> Compartilhado: ");
			componente.append("<input type='checkbox' name='compartilhada' value='compartilhada'"); 
			if(equipa != null && equipa.getCompartilhado()){componente.append("checked");}
			componente.append("/></P>");
			out.print(componente.toString());
		%>

		<%
			componente.setLength(0);
			componente.append("<P> Contrato de equipamento de terceiro: ");
			componente.append("<input type='text' name='contEquipTerceiro' value='"); 
			if(equipa != null) {componente.append(equipa.getContratoEquipamentoTerceiro().getId());}
			componente.append("'/></P>");
			out.print(componente.toString());
		%>

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

					sbRegistro.append("<option value='" + tipoEquip.getId() + "' ");

					if(equipa != null && equipa.getTipoEquipamento().getId() == tipoEquip.getId()){
						sbRegistro.append("selected");
					}

					sbRegistro.append(">");
					sbRegistro.append(tipoEquip.getDescricao() + " " + tipoEquip.getMarca() + "</option>");
					out.print(sbRegistro.toString());
				}

			%>
		</select>
		
		<p>Nota fiscal : <select name="notaFiscal">
			<option value="">Selecione...</option>
			<%
				sbRegistro = new StringBuilder();
				NotaFiscal ntFiscal = new NotaFiscal();
                resultado = listarOpcoes.processar(ntFiscal);
				entidades = resultado.getEntidades();

				for(int i = 0; i < entidades.size(); i++){	
					ntFiscal = (NotaFiscal)entidades.get(i);
					sbRegistro.setLength(0);

					sbRegistro.append("<option value='" + ntFiscal.getId() + "' ");
					
					if(equipa != null && equipa.getNotaFiscal().getId() == ntFiscal.getId()){
						sbRegistro.append("selected");
					}

					sbRegistro.append(">");
					sbRegistro.append(ntFiscal.getNumero() + "</option>");
					out.print(sbRegistro.toString());
				}

			%>
		</select></p>

		<p>Localização : <select name="localizacao">
			<option value="">Selecione...</option>
			<%
				sbRegistro = new StringBuilder();
				Localizacao local = new Localizacao();
                resultado = listarOpcoes.processar(local);
				entidades = resultado.getEntidades();

				for(int i = 0; i < entidades.size(); i++){	
					local = (Localizacao)entidades.get(i);
					sbRegistro.setLength(0);

					sbRegistro.append("<option value='" + local.getId() + "' ");

					if(equipa != null && equipa.getLocalizacao().getId() == local.getId()){
						sbRegistro.append("selected");
					}

					sbRegistro.append(">");	
					sbRegistro.append(local.getAndar() + "º andar - "
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

		<br>
		<br>
		<TABLE BORDER="5"    WIDTH="50%"   CELLPADDING="4" CELLSPACING="3">
			<TR>
				<TH></TH>
				<TH>ID:</TH>
				<TH>Serial:</TH>
				<TH>Número de patrimônio:</TH>
				<TH>Observação:</TH>
				<TH>Presencial:</TH>
				<TH>Compartilhado:</TH>
				<TH>Contrato de equipamento de terceiro:</TH>
				<TH>Tipo de equipamento:</TH>
				<TH>Nota fiscal:</TH>
				<TH>Localização:</TH>
			</TR>

			<%
				Equipamento equipamentos = new Equipamento();
				resultado = listarOpcoes.processar(equipamentos);
				entidades = resultado.getEntidades();
				sbRegistro = new StringBuilder();
				StringBuilder sbLink = new StringBuilder();
				StringBuilder sbExcluir = new StringBuilder();
				request.getSession().setAttribute("resultado",resultado);

				if(entidades != null){
					for(int i = 0; i < entidades.size(); i++){
						equipamentos = (Equipamento)entidades.get(i);
						sbRegistro.setLength(0);
						sbLink.setLength(0);
						sbExcluir.setLength(0);

						sbRegistro.append("<TR ALIGN='CENTER'>");
						
						sbLink.append("<a href=Equipamento?");
						sbLink.append("idEquipamento=");
						sbLink.append(equipamentos.getId());						
						sbLink.append("&");
						sbLink.append("operacao=");
						sbLink.append("Visualizar");												
						sbLink.append(">");

						sbExcluir.append("<a href=Equipamento?");
						sbExcluir.append("idEquipamento=");
						sbExcluir.append(equipamentos.getId());						
						sbExcluir.append("&");
						sbExcluir.append("operacao=");
						sbExcluir.append("Excluir");												
						sbExcluir.append(">");
						
						sbRegistro.append("<TD>");
						sbRegistro.append(sbExcluir.toString());	
						sbRegistro.append("Excluir");
						sbRegistro.append("</a>");				
						sbRegistro.append("</TD>");

						sbRegistro.append("<TD>");
						sbRegistro.append(sbLink.toString());	
						sbRegistro.append(equipamentos.getId());
						sbRegistro.append("</a>");				
						sbRegistro.append("</TD>");
						
						sbRegistro.append("<TD>");
						sbRegistro.append(sbLink.toString());				
						sbRegistro.append(equipamentos.getSerial());
						sbRegistro.append("</a>");				
						sbRegistro.append("</TD>");
						
						sbRegistro.append("<TD>");
						sbRegistro.append(sbLink.toString());				
						sbRegistro.append(equipamentos.getNumPatrimonio());
						sbRegistro.append("</a>");				
						sbRegistro.append("</TD>");
						
						sbRegistro.append("<TD>");
						sbRegistro.append(sbLink.toString());				
						sbRegistro.append(equipamentos.getObservacao());
						sbRegistro.append("</a>");				
						sbRegistro.append("</TD>");
						
						sbRegistro.append("<TD>");
						sbRegistro.append(sbLink.toString());				
						sbRegistro.append(equipamentos.getLocPresencial());
						sbRegistro.append("</a>");				
						sbRegistro.append("</TD>");

						sbRegistro.append("<TD>");
						sbRegistro.append(sbLink.toString());				
						sbRegistro.append(equipamentos.getCompartilhado());
						sbRegistro.append("</a>");				
						sbRegistro.append("</TD>");

						sbRegistro.append("<TD>");
						sbRegistro.append(sbLink.toString());				
						sbRegistro.append(equipamentos.getContratoEquipamentoTerceiro().getId());
						sbRegistro.append("</a>");				
						sbRegistro.append("</TD>");

						sbRegistro.append("<TD>");
						sbRegistro.append(sbLink.toString());				
						sbRegistro.append(equipamentos.getTipoEquipamento().getId());
						sbRegistro.append("</a>");				
						sbRegistro.append("</TD>");

						sbRegistro.append("<TD>");
						sbRegistro.append(sbLink.toString());				
						sbRegistro.append(equipamentos.getNotaFiscal().getId());
						sbRegistro.append("</a>");				
						sbRegistro.append("</TD>");

						sbRegistro.append("<TD>");
						sbRegistro.append(sbLink.toString());				
						sbRegistro.append(equipamentos.getLocalizacao().getId());
						sbRegistro.append("</a>");				
						sbRegistro.append("</TD>");
						
						sbRegistro.append("</TR>");
										
						out.print(sbRegistro.toString());

					} 

				}	
			%>
		</table>	
	</form>	
</body>
</html>
