package control.viewhelper;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dominio.EntidadeDominio;
import model.dominio.TipoLicenca;
import util.Resultado;

/**
 *
 * @author Tiago
 */
public class VhTpLicenca implements IViewHelper{

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        
        String operacao = request.getParameter("operacao");

        TipoLicenca tpLicenca = new TipoLicenca();
        
        if(operacao.equals("Salvar")){
            tpLicenca.setDescricao(request.getParameter("descricao"));
        }

        return tpLicenca;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse reponse)
            throws IOException, ServletException {
        
    }
    
}
