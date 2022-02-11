package control.viewhelper;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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


        if(operacao.equals("Salvar") || operacao.equals("Alterar")){

            if(operacao.equals("Alterar")){
                equipamento.setId(Integer.parseInt(request.getParameter("idEquipHidden")));
            }

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

        }else if (operacao.equals("Visualizar")){
            HttpSession session = request.getSession();
            Resultado resultado = (Resultado)session.getAttribute("resultado");
            String idEquipamento = request.getParameter("idEquipamento");
            int id = 0;
            
            if(Contem.contemDado(idEquipamento)){
                id = Integer.parseInt(idEquipamento);
            }
            
            for(EntidadeDominio ed : resultado.getEntidades()){
                if(ed.getId() == id){
                    equipamento = (Equipamento)ed;
                }
            }
        }
        return equipamento;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse reponse)
            throws IOException, ServletException {
        
        RequestDispatcher rD = null;
        
        String operacao = request.getParameter("operacao");
        
        if(operacao.equals("Salvar") || operacao.equals("Alterar")){
            rD = request.getRequestDispatcher("equipamento.jsp");
        }
        
        if(operacao.equals("Visualizar")){
            request.setAttribute("equipamento", resultado.getEntidades().get(0));
            rD = request.getRequestDispatcher("equipamento.jsp");
        }

        rD.forward(request, reponse);

    }
    
}
