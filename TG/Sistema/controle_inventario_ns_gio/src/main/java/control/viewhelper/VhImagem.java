package control.viewhelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
        Programa programa1 = new Programa();
        Programa programa2 = new Programa();
        Programa programa3 = new Programa();
        List <Programa> programas = new ArrayList<Programa>();


        if(operacao.equals("Salvar")){
            imagem.setDescricao(request.getParameter("descricao"));
            
            programa1.setDescricao(request.getParameter("programa1"));
            programa1.setId(1);
            programas.add(programa1);
            
            programa2.setDescricao(request.getParameter("programa2"));
            programa2.setId(2);
            programas.add(programa2);

            programa3.setDescricao(request.getParameter("programa3"));
            programa3.setId(3);
            programas.add(programa3);

            imagem.setProgramas(programas);
        }

        return imagem;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse reponse)
            throws IOException, ServletException {

        RequestDispatcher rD = null;
        rD = request.getRequestDispatcher("index.jsp");
        rD.forward(request, reponse);
    }
    
}
