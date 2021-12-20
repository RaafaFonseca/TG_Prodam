import java.util.Date;

public class DisponibilizacaoEquipamento {
    private Date dataDisponibilizacao;
    private Date dataDevolucao;
    private Colaborador colaborador;
    private Equipamento equipamento;
    
    public DisponibilizacaoEquipamento() {
        this.dataDisponibilizacao = new Date();
        this.dataDevolucao = new Date();
        this.colaborador = new Colaborador();
        this.equipamento = new Equipamento();
    }

    public DisponibilizacaoEquipamento(Date dataDisponibilizacao, Date dataDevolucao, Colaborador colaborador,
            Equipamento equipamento) {
        this.dataDisponibilizacao = dataDisponibilizacao;
        this.dataDevolucao = dataDevolucao;
        this.colaborador = colaborador;
        this.equipamento = equipamento;
    }

    public Date getDataDisponibilizacao() {
        return dataDisponibilizacao;
    }

    public void setDataDisponibilizacao(Date dataDisponibilizacao) {
        this.dataDisponibilizacao = dataDisponibilizacao;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    


    
}