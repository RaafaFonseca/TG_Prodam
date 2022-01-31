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
public class VhTipo implements IViewHelper{

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request){
        
        String operacao = request.getParameter("operacao");

        String cadastrarTipo = request.getParameter("tipo");

        Tipo tipo = new Tipo();

        if(operacao.equals("Salvar")){
            if(cadastrarTipo.equals("regimeTrabalho")){
                tipo = new RegimeTrabalho();

            }else if (cadastrarTipo.equals("tpColaborador")){
                tipo = new TipoColaborador();

            }else if (cadastrarTipo.equals("tpAcesso")){
                tipo = new TipoAcesso();

            }

            tipo.setDescricao(request.getParameter("descricao"));
        }

        return tipo;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse reponse)
            throws IOException, ServletException {

        RequestDispatcher rD = null;
        rD = request.getRequestDispatcher("index.jsp");
        rD.forward(request, reponse);     
        
    }
    
}
