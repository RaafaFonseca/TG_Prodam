package control.viewhelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dominio.Emprestimo;
import model.dominio.EntidadeDominio;
import util.*;

/**
 *
 * @author Tiago
 */
public class VhEmprestimo implements IViewHelper{

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        
        String operacao = request.getParameter("operacao");

        Emprestimo emprestimo = new Emprestimo();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd"); 

        if(operacao.equals("Salvar")){
           
            emprestimo.getColaborador().setId(Integer.parseInt(request.getParameter("colaborador")));

            emprestimo.getEquipamento().setId(Integer.parseInt(request.getParameter("equipamento")));
            
            emprestimo.setFinalidade(request.getParameter("finalidade"));

            emprestimo.getRespEntrega().setId(Integer.parseInt(request.getParameter("respEntrega")));

            if(Contem.contemDado(request.getParameter("ativo"))){
                emprestimo.setVigente(true);
            }
            if(Contem.contemDado(request.getParameter("devolucao"))){    
                emprestimo.setDataDevolucao(null);
            }else{
                try {
                    emprestimo.setDataDevolucao(formatter.parse(request.getParameter("dtDevolucao")));
                } catch (ParseException e) {
                    
                    e.printStackTrace();
                }
            }

            try {
                emprestimo.setDataDisponibilizacao(formatter.parse(request.getParameter("dtDisponibilizacao")));
            } catch (ParseException e) {
                
                e.printStackTrace();
            }

        }

        return emprestimo;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse reponse)
            throws IOException, ServletException {
        
        RequestDispatcher rD = null;
        rD = request.getRequestDispatcher("index.jsp");
        rD.forward(request, reponse);

    }
    
}
