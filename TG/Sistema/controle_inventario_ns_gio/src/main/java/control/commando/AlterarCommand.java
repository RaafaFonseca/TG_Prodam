/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.commando;

import model.dominio.EntidadeDominio;
import util.Resultado;

/**
 *
 * @author Tiago
 */
public class AlterarCommand extends AbstractCommand{

    @Override
    public Resultado executar(EntidadeDominio entidade) {
         return fachada.alterar(entidade);
    }
    
}
 