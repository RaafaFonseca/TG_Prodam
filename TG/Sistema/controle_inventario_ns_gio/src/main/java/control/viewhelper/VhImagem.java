package control.viewhelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dominio.EntidadeDominio;
import model.dominio.Imagem;
import model.dominio.Programa;
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
        Programa programa = new Programa();
        List <Programa> programas = new ArrayList<Programa>();


        if(operacao.equals("Salvar")){
            imagem.setDescricao(request.getParameter("descricao"));
            
            programa.setDescricao(request.getParameter("programa1"));
            programa.setId(1);
            programas.add(programa);
            
            programa.setDescricao(request.getParameter("programa2"));
            programa.setId(2);
            programas.add(programa);

            programa.setDescricao(request.getParameter("programa3"));
            programa.setId(3);
            programas.add(programa);

            imagem.setProgramas(programas);
        }

        return imagem;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse reponse)
            throws IOException, ServletException {
        
    }
    
}
