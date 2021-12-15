public abstract class GrupoGerencial {
    protected String descricao;
    protected String sigla;
    protected Colaborador responsavel;

    public String getDescricao() {
        return descricao;
    }
    public Colaborador getResponsavel() {
        return responsavel;
    }
    public void setResponsavel(Colaborador responsavel) {
        this.responsavel = responsavel;
    }
    public String getSigla() {
        return sigla;
    }
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    } 
}