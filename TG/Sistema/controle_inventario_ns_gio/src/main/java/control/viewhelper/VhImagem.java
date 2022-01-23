package control.viewhelper;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dominio.EntidadeDominio;
import model.dominio.Imagem;
import util.Resultado;

/**
 *
 * @author Tiago
 */
public class VhImagem implements IViewHelper{

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        
        String operacao = request.getParameter("operacao");

        Imagem imagem = new Imagem();
        
        if(operacao.equals("Salvar")){
            imagem.setDescricao(request.getParameter("nome"));
        }

        return imagem;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse reponse)
            throws IOException, ServletException {
        
    }
    
}
