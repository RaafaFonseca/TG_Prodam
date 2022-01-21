/**
 *
 * @author Tiago
 */


package model.dominio;

public class Presidencia extends GrupoGerencial{
    public Presidencia() {
        this.setDescricao(" ");
        this.setSigla(" ");
        this.setResponsavel( new Colaborador());
    }

    public Presidencia(String descricao, String sigla, Colaborador responsavel){
        this.setDescricao(descricao);
        this.setSigla(sigla);
        this.setResponsavel(responsavel);
    }   
}
