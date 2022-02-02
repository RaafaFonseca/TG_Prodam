/**
 *
 * @author Tiago
 */


package model.dominio;

public class Gerencia extends GrupoGerencial{
    public Gerencia() {
        this.setDescricao(" ");
        this.setSigla(" ");
    }

    public Gerencia(String descricao, String sigla, Colaborador responsavel){
        this.setDescricao(descricao);
        this.setSigla(sigla);
        this.setResponsavel(responsavel);
    }
}
