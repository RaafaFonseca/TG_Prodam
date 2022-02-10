package control.commando;

import model.dominio.EntidadeDominio;
import util.Resultado;

public class VisualizarCommand extends AbstractCommand{

    @Override
    public Resultado executar(EntidadeDominio entidade) {
        return fachada.visualizar(entidade); 
    }
    
}
