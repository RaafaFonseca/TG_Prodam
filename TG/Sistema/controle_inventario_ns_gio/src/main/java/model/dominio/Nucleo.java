/**
 *
 * @author Tiago
 */


package model.dominio;

public class Nucleo extends GrupoGerencial {
    public Nucleo() {
        this.setDescricao(" ");
        this.setSigla(" ");
    }

    public Nucleo(String descricao, String sigla, Colaborador responsavel){
        this.setDescricao(descricao);
        this.setSigla(sigla);
        this.setResponsavel(responsavel);
    }
}