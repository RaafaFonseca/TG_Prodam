package model.dominio;

public class Tipo extends EntidadeDominio{
    private String descricao;

    public Tipo() {
        super();
        this.descricao = " ";
    }

    public Tipo(String descricao){
        super(0);
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


}
