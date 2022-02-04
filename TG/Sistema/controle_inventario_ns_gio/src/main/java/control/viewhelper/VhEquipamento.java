package control.viewhelper;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dominio.EntidadeDominio;
import model.dominio.Equipamento;
import util.*;

/**
 *
 * @author Tiago
 */
public class VhEquipamento implements IViewHelper{

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        
        String operacao = request.getParameter("operacao");

        Equipamento equipamento = new Equipamento();


        if(operacao.equals("Salvar")){
            equipamento.setSerial(request.getParameter("serial"));
            equipamento.setNumPatrimonio(request.getParameter("patrimonio"));
            equipamento.setObservacao(request.getParameter("observacao"));

            if(Contem.contemDado(request.getParameter("locPresencial"))){
                equipamento.setLocPresencial(true);
            }
            if(Contem.contemDado(request.getParameter("compartilhada"))){    
                equipamento.setCompartilhado(true);
            }

            equipamento.getContratoEquipamentoTerceiro().setId(Integer.parseInt(request.getParameter("contEquipTerceiro")));
            equipamento.getTipoEquipamento().setId(Integer.parseInt(request.getParameter("tipoEquipamento")));
            equipamento.getNotaFiscal().setId(Integer.parseInt(request.getParameter("notaFiscal")));;
            equipamento.getLocalizacao().setId(Integer.parseInt(request.getParameter("localizacao")));;

        }

        return equipamento;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse reponse)
            throws IOException, ServletException {
        
        RequestDispatcher rD = null;
        rD = request.getRequestDispatcher("index.jsp");
        rD.forward(request, reponse);

    }
    
}
