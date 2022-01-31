/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.fachada;

import java.util.*;
import model.dominio.*;
import model.dao.*;
import model.strategy.*;
import util.Resultado;

/**
 *
 * @author Tiago
 */
public class Fachada implements IFachada{
    
    private Map<String, Map<String, List<IStrategy>>> rns;
    private Resultado resultado;

    public Fachada(){
       
        rns = new HashMap<String, Map<String, List<IStrategy>>> ();

        
        ArrayList<IStrategy> rnsSalvarImagem = new ArrayList<IStrategy>();
        ArrayList<IStrategy> rnsAlterarImagem = new ArrayList<IStrategy>();
        ArrayList<IStrategy> rnsExcluirImagem = new ArrayList<IStrategy>();
        ArrayList<IStrategy> rnsConsultarImagem = new ArrayList<IStrategy>();
   
        Map<String, List<IStrategy>> rnsImagem = new HashMap<String, List<IStrategy>>();     
        rnsImagem.put("SALVAR", rnsSalvarImagem);
        rnsImagem.put("ALTERAR", rnsAlterarImagem);
        rnsImagem.put("EXCLUIR", rnsExcluirImagem);
        rnsImagem.put("CONSULTAR", rnsConsultarImagem);
        
        rns.put(Imagem.class.getName(), rnsImagem);   
        
    }
    
    @Override
    public Resultado salvar(EntidadeDominio entidade) { 
        resultado = new Resultado();
        String nmClass = entidade.getClass().getName();
       
        String msg = aplicarRegras(entidade, "SALVAR");
        
        if(msg == null){
            SalvarDAO salvarDAO = new SalvarDAO();
            try{
                salvarDAO.salvar(entidade); 
                List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
                entidades.add(entidade);
                resultado.setEntidades(entidades);
            }catch(Exception ex){
                ex.printStackTrace();
                resultado.setMsg("Não foi possível salvar o(a)" + nmClass);
            }   
        }     
        return resultado;
    }

    @Override
    public Resultado alterar(EntidadeDominio entidade) {
        resultado = new Resultado();
        String nmClass = entidade.getClass().getName();
           
        String msg = aplicarRegras(entidade, "ALTERAR");

        if(msg == null){
            AlterarDAO alterarDAO = new AlterarDAO();
            try{
                alterarDAO.alterar(entidade);
                List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
                entidades.add(entidade);
                resultado.setEntidades(entidades);
                
            }catch(Exception ex){
                ex.printStackTrace();
                resultado.setMsg("Não foi possível alterar o(a)" + nmClass);
            }   
        }     
        return resultado;
    }

    @Override
    public Resultado excluir(EntidadeDominio entidade) {
        resultado = new Resultado();
        String nmClass = entidade.getClass().getName();
           
        String msg = aplicarRegras(entidade, "EXCLUIR");

        if(msg == null){
            ExcluirDAO excluirDAO = new ExcluirDAO();
            try{
                excluirDAO.excluir(entidade);
                List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
                entidades.add(entidade);
                resultado.setEntidades(entidades);
                
            }catch(Exception ex){
                ex.printStackTrace();
                resultado.setMsg("Não foi possível excluir o(a)" + nmClass);
            }   
        }     
        return resultado;
    }

    @Override
    public Resultado consultar(EntidadeDominio entidade) {
        resultado = new Resultado();
        /*
        String nmClass = entidade.getClass().getName();
           
        String msg = aplicarRegras(entidade, "CONSULTAR");

        if(msg == null){
            IDAO dao = daos.get(nmClass);
            try{
                resultado.setEntidades(dao.consultar(entidade));
                
            }catch(Exception ex){
                ex.printStackTrace();
                resultado.setMsg("Não foi possível consultar o(a)" + nmClass);
            }   
        }  
        */
        return resultado;
        
    }
    
    @Override
    public Resultado visualizar(EntidadeDominio entidade){
        resultado = new Resultado();
        resultado.setEntidades(new ArrayList<EntidadeDominio>(1));
        resultado.getEntidades().add(entidade);
        return resultado;
    }
   
    private String aplicarRegras(EntidadeDominio entidade, String operacao){
        StringBuilder msg = new StringBuilder();
        
        Map <String, List<IStrategy>> regrasNegocio = rns.get(entidade.getClass().getName());
        
        if(regrasNegocio != null){
            List<IStrategy> regrasOperacao = regrasNegocio.get(operacao);
            if(regrasOperacao != null){
                for(IStrategy regras : regrasOperacao){
                    String mensagem = regras.processar(entidade);
                    if(mensagem != null){
                        msg.append(mensagem);
                        msg.append("\n");
                    }
                }
            }
        }
        if(msg.length() > 0){
            return msg.toString();
        }else{
            return null;
        }
    }

    @Override
    public Resultado acessar(EntidadeDominio entidade) {
        
        return null;
    }
    
}
