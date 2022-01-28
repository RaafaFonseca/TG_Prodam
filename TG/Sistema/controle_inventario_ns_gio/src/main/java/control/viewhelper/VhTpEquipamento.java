package control.viewhelper;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dominio.EntidadeDominio;
import model.dominio.TipoEquipamento;
import util.Resultado;

/**
 *
 * @author Tiago
 */
public class VhTpEquipamento implements IViewHelper{

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        
        String operacao = request.getParameter("operacao");

        TipoEquipamento tpEquipamento = new TipoEquipamento();

        if(operacao.equals("Salvar")){
            tpEquipamento.setDescricao(request.getParameter("descricao"));
            tpEquipamento.setMarca(request.getParameter("marca"));
            tpEquipamento.setModelo(request.getParameter("modelo"));
            tpEquipamento.setFornecedor(request.getParameter("fornecedor"));
            tpEquipamento.setPolegadas(request.getParameter("polegadas"));
            
        }

        return tpEquipamento;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse reponse)
            throws IOException, ServletException {
        
    }
    
}
