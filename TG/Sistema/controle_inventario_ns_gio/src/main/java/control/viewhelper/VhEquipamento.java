package control.viewhelper;

import java.io.IOException;
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
            equipamento.getTipoEquipamento().setId(1);
            equipamento.getNotaFiscal().setId(1);
            equipamento.getLocalizacao().setId(1);

        }

        return equipamento;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse reponse)
            throws IOException, ServletException {
        
    }
    
}
