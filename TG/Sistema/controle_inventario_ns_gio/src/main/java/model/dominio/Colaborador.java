/**
 *
 * @author Tiago
 */


package model.dominio;

import java.util.ArrayList;
import java.util.List;

public class Colaborador extends EntidadeDominio{
    private String rf;
    private String nome;
    private String observacao;
    private List <Ocorrencia> ocorrencias;
    private String tipoAcesso;
    private String tipoColaborador;
    private String regimeTrabalho;
    private Presidencia presidencia;
    private Diretoria diretoria;
    private Gerencia gerencia;
    private Nucleo nucleo;
    private List<Emprestimo> equipamentosDisponibilizados;
    private List<ContratoComodato> contratosComodato;

    public Colaborador() {
        this.rf = " ";
        this.nome = " ";
        this.observacao = " ";
        this.ocorrencias = new ArrayList<Ocorrencia>();
        this.tipoAcesso = " ";
        this.tipoColaborador = " ";
        this.regimeTrabalho = " ";
        this.equipamentosDisponibilizados = new ArrayList<Emprestimo>();
        this.contratosComodato = new ArrayList<ContratoComodato>();
        this.presidencia = new Presidencia();
        this.diretoria = new Diretoria();
        this.gerencia = new Gerencia();
        this.nucleo = new Nucleo();
    }

    

    public Colaborador(String rf, String nome, String observacao, List<Ocorrencia> ocorrencias, String tipoAcesso,
            String tipoColaborador, String regimeTrabalho,
            List<Emprestimo> equipamentosDisponibilizados,
            List<ContratoComodato> contratosComodato,
            Presidencia presidencia, Diretoria diretoria,
            Gerencia gerencia, Nucleo nucleo) {
                
        this.rf = rf;
        this.nome = nome;
        this.observacao = observacao;
        this.ocorrencias = ocorrencias;
        this.tipoAcesso = tipoAcesso;
        this.tipoColaborador = tipoColaborador;
        this.regimeTrabalho = regimeTrabalho;
        this.equipamentosDisponibilizados = equipamentosDisponibilizados;
        this.contratosComodato = contratosComodato;
        this.presidencia =  presidencia;
        this.diretoria =  diretoria;
        this.gerencia =  gerencia;
        this.nucleo =  nucleo;
    }

    public String getRf() {
        return rf;
    }

    public void setRf(String rf) {
        this.rf = rf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public List<Ocorrencia> getOcorrencias() {
        return ocorrencias;
    }

    public void setOcorrencias(List<Ocorrencia> ocorrencias) {
        this.ocorrencias = ocorrencias;
    }

    public String getTipoAcesso() {
        return tipoAcesso;
    }

    public void setTipoAcesso(String tipoAcesso) {
        this.tipoAcesso = tipoAcesso;
    }

    public String getTipoColaborador() {
        return tipoColaborador;
    }

    public void setTipoColaborador(String tipoColaborador) {
        this.tipoColaborador = tipoColaborador;
    }

    public String getRegimeTrabalho() {
        return regimeTrabalho;
    }

    public void setRegimeTrabalho(String regimeTrabalho) {
        this.regimeTrabalho = regimeTrabalho;
    }

    public List<Emprestimo> getEquipamentosDisponibilizados() {
        return equipamentosDisponibilizados;
    }

    public void setEquipamentosDisponibilizados(List<Emprestimo> equipamentosDisponibilizados) {
        this.equipamentosDisponibilizados = equipamentosDisponibilizados;
    }

    public List<ContratoComodato> getContratosComodato() {
        return contratosComodato;
    }

    public void setContratosComodato(List<ContratoComodato> contratosComodato) {
        this.contratosComodato = contratosComodato;
    }
    public Nucleo getNucleo() {
        return nucleo;
    }

    public void setNucleo(Nucleo nucleo) {
        this.nucleo = nucleo;
    }

    public Gerencia getGerencia() {
        return gerencia;
    }

    public void setGerencia(Gerencia gerencia) {
        this.gerencia = gerencia;
    }

    public Diretoria getDiretoria() {
        return diretoria;
    }

    public void setDiretoria(Diretoria diretoria) {
        this.diretoria = diretoria;
    }

    public Presidencia getPresidencia() {
        return presidencia;
    }

    public void setPresidencia(Presidencia presidencia) {
        this.presidencia = presidencia;
    }
    
}
