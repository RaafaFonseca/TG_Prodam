/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.commando;

import control.fachada.*;

/**
 *
 * @author Tiago
 */
public abstract class AbstractCommand implements ICommand{
    protected IFachada fachada = new Fachada();
}
