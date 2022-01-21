/**
 *
 * @author Tiago
 */


package model.dominio;

public class Ocorrencia {
    private String os;
    private String descricao;
    private Equipamento equipamento;
    private Colaborador colaborador;

    public Ocorrencia() {
        this.os = " ";
        this.descricao = " ";
        this.equipamento = new Equipamento();
        this.colaborador = new Colaborador();
    }
    
    public Ocorrencia(String os, String descricao, Equipamento equipamento, Colaborador colaborador) {
        this.os = os;
        this.descricao = descricao;
        this.equipamento = equipamento;
        this.colaborador = colaborador;
    }

    public String getOs() {
        return os;
    }
    public void setOs(String os) {
        this.os = os;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Equipamento getEquipamento() {
        return equipamento;
    }
    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }
    public Colaborador getColaborador() {
        return colaborador;
    }
    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }
    
}
