package control.viewhelper;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dominio.Colaborador;
import model.dominio.EntidadeDominio;
import util.Resultado;

/**
 *
 * @author Tiago
 */
public class VhColaborador implements IViewHelper{

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        
        String operacao = request.getParameter("operacao");

        Colaborador colaborador = new Colaborador();

        if(operacao.equals("Salvar")){

            colaborador.setRf(request.getParameter("rf"));
            colaborador.setNome(request.getParameter("nome"));
            colaborador.getImagem().setId(Integer.parseInt(request.getParameter("imagem")));
            colaborador.getTipoAcesso().setId(Integer.parseInt(request.getParameter("tpAcesso")));
            colaborador.getTipoColaborador().setId(Integer.parseInt(request.getParameter("tpColaborador")));
            colaborador.getRegimeTrabalho().setId(Integer.parseInt(request.getParameter("regimeTrabalho")));
            colaborador.getPresidencia().setId(Integer.parseInt(request.getParameter("pre")));
            colaborador.getGerencia().setId(Integer.parseInt(request.getParameter("ger")));
            colaborador.getDiretoria().setId(Integer.parseInt(request.getParameter("dir")));
            colaborador.getNucleo().setId(Integer.parseInt(request.getParameter("nuc")));
            
        }

        return colaborador;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse reponse)
            throws IOException, ServletException {
        
        RequestDispatcher rD = null;
        rD = request.getRequestDispatcher("index.jsp");
        rD.forward(request, reponse);
        
    }
    
}
