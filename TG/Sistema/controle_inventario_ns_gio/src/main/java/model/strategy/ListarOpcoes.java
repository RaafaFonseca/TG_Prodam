package model.strategy;

import model.dao.ConsultarDAO;
import model.dominio.EntidadeDominio;
import util.Resultado;

public class ListarOpcoes{

    public Resultado processar (EntidadeDominio entidade) {
        Resultado resultado = new Resultado();
        ConsultarDAO consultarDAO = new ConsultarDAO();
        resultado.setEntidades(consultarDAO.consultarAll(entidade));
        return resultado;
    }
    
}
