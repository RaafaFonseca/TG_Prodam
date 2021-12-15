public class Programa {
    private String descricao;
    private String licenca;
    private String observacao;
    private TipoLicenca tpLicenca;

    public Programa (){
        this.setDescricao(" ");
        this.setLicenca(" ");
        this.setObservacao(" ");
        this.setTpLicenca(new TipoLicenca());
    }
    public Programa (String descricao, String licenca, String observacao, TipoLicenca tpLicenca){
        this.setDescricao(descricao);
        this.setLicenca(licenca);
        this.setObservacao(observacao);
        this.setTpLicenca(tpLicenca);       
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public TipoLicenca getTpLicenca() {
        return tpLicenca;
    }
    public void setTpLicenca(TipoLicenca tpLicenca) {
        this.tpLicenca = tpLicenca;
    }
    public String getObservacao() {
        return observacao;
    }
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    public String getLicenca() {
        return licenca;
    }
    public void setLicenca(String licenca) {
        this.licenca = licenca;
    }
    
}
