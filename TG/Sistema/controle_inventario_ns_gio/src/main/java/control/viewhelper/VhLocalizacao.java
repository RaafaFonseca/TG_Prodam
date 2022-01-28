package control.viewhelper;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dominio.*;
import util.Resultado;

/**
 *
 * @author Tiago
 */
public class VhLocalizacao implements IViewHelper{

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        
        String operacao = request.getParameter("operacao");

        Localizacao localizacao = new Localizacao();

        if(operacao.equals("Salvar")){

            localizacao.setPredio(request.getParameter("predio"));
            localizacao.setAndar(request.getParameter("andar"));
            localizacao.setLado(request.getParameter("lado"));
            localizacao.setReferencia(request.getParameter("referencia"));

        }

        return localizacao;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse reponse)
            throws IOException, ServletException {
        
    }
    
}
