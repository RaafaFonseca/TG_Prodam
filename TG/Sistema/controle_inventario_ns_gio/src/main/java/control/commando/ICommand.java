package control.commando;

import model.dominio.EntidadeDominio;
import util.Resultado;

/**
 *
 * @author Tiago
 */
public interface ICommand {
    public Resultado executar(EntidadeDominio entidade);
}
