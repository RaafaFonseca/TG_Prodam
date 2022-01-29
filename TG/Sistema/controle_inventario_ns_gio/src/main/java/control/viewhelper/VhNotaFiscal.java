package control.viewhelper;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dominio.*;
import util.Resultado;

/**
 *
 * @author Tiago
 */
public class VhNotaFiscal implements IViewHelper{

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        
        String operacao = request.getParameter("operacao");

        NotaFiscal notaFiscal = new NotaFiscal();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        
        if(operacao.equals("Salvar")){
            notaFiscal.setNumero(request.getParameter("numero"));
            try {
                notaFiscal.setDate(formatter.parse(request.getParameter("data")));
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }

        return notaFiscal;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse reponse)
            throws IOException, ServletException {
        
    }
    
}
