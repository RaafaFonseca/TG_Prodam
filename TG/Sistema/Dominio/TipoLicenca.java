public class TipoLicenca {
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