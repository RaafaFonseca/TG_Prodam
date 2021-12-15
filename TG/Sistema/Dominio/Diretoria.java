public class Diretoria extends GrupoGerencial{
    public Diretoria() {
        this.setDescricao(" ");
        this.setSigla(" ");
        this.setResponsavel( new Colaborador());
    }

    public Diretoria(String descricao, String sigla, Colaborador responsavel){
        this.setDescricao(descricao);
        this.setSigla(sigla);
        this.setResponsavel(responsavel);
    }
}
