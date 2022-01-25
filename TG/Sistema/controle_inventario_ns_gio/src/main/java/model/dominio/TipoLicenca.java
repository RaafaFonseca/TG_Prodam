/**
 *
 * @author Tiago
 */


package model.dominio;

public class TipoLicenca extends EntidadeDominio{
    private String descricao;

    public TipoLicenca(){
        this.descricao = " ";
    }
    public TipoLicenca(String descricao){
        this.descricao = descricao;
    }

    public void setDescricao (String descricao){
        this.descricao = descricao;
    }
    public String getDescricao (){
        return this.descricao;
    }
}