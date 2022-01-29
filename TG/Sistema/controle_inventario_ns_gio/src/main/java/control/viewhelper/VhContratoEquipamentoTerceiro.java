package control.viewhelper;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dominio.*;
import util.Resultado;

/**
 *
 * @author Tiago
 */
public class VhContratoEquipamentoTerceiro implements IViewHelper{

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request){
        
        String operacao = request.getParameter("operacao");

        ContratoEquipamentoTerceiro contEquipTerceiro = new ContratoEquipamentoTerceiro();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

        if(operacao.equals("Salvar")){
            contEquipTerceiro.setFornecedor(request.getParameter("fornecedor"));
            try {
                contEquipTerceiro.setDataInicio(formatter.parse(request.getParameter("dataInicio")));
                contEquipTerceiro.setDataFinal(formatter.parse(request.getParameter("dataTermino")));
            } catch (ParseException e) {
                
                e.printStackTrace();
            }
        }

        return contEquipTerceiro;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse reponse)
            throws IOException, ServletException {
        
    }
    
}
