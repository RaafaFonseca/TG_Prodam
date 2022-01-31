package control.viewhelper;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dominio.*;
import util.Resultado;

/**
 *
 * @author Tiago
 */
public class VhOcorrencias implements IViewHelper{

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        
        String operacao = request.getParameter("operacao");

        Ocorrencia ocorrencia = new Ocorrencia();

        if(operacao.equals("Salvar")){

           ocorrencia.setOs(request.getParameter("os"));
           ocorrencia.setDescricao(request.getParameter("descricao"));
           ocorrencia.getColaborador().setId(Integer.parseInt(request.getParameter("colaborador")));
           ocorrencia.getEquipamento().setId(Integer.parseInt(request.getParameter("equipamento")));

        }

        return ocorrencia;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse reponse)
            throws IOException, ServletException {

        RequestDispatcher rD = null;
        rD = request.getRequestDispatcher("index.jsp");
        rD.forward(request, reponse);
        
    }
    
}
