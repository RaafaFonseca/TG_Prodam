/**
 *
 * @author Tiago
 */


package model.dominio;

import java.util.Date;

public class Emprestimo extends EntidadeDominio{
    private Date dataDisponibilizacao;
    private Date dataDevolucao;
    private Colaborador colaborador;
    private Equipamento equipamento;
    private boolean isVigente;
    private String finalidade;
    private Colaborador respEntrega;

    public Emprestimo() {
        this.dataDisponibilizacao = new Date();
        this.dataDevolucao = new Date();
        this.colaborador = new Colaborador();
        this.equipamento = new Equipamento();
        this.isVigente = true;
        this.setFinalidade(" ");
        this.respEntrega = new Colaborador();
    }

    public Emprestimo(Date dataDisponibilizacao, Date dataDevolucao, Colaborador colaborador,
            Equipamento equipamento, boolean isVigente, String finalidade, Colaborador respEntrega) {
        this.dataDisponibilizacao = dataDisponibilizacao;
        this.dataDevolucao = dataDevolucao;
        this.colaborador = colaborador;
        this.equipamento = equipamento;
        this.isVigente = isVigente;
        this.setFinalidade(finalidade);
        this.respEntrega = respEntrega;
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

    public boolean isVigente() {
        return isVigente;
    }

    public void setVigente(boolean isVigente) {
        this.isVigente = isVigente;
    }

    public String getFinalidade() {
        return finalidade;
    }

    public void setFinalidade(String finalidade) {
        this.finalidade = finalidade;
    }

    public Colaborador getRespEntrega() {
        return respEntrega;
    }

    public void setRespEntrega(Colaborador respEntrega) {
        this.respEntrega = respEntrega;
    }
    
}