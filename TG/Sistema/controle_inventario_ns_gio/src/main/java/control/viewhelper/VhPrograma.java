package control.viewhelper;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dominio.EntidadeDominio;
import model.dominio.Programa;
import util.Resultado;

/**
 *
 * @author Tiago
 */
public class VhPrograma implements IViewHelper{

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        
        String operacao = request.getParameter("operacao");

        Programa programa = new Programa();
        
        if(operacao.equals("Salvar")){
            programa.setDescricao(request.getParameter("descricao"));
            programa.setObservacao(request.getParameter("observacao"));
            programa.setLicenca(request.getParameter("licenca"));
        }
        return programa;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse reponse)
            throws IOException, ServletException {
        
    }
    
}
