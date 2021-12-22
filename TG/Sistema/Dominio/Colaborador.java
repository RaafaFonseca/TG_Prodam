import java.util.ArrayList;
import java.util.List;

public class Colaborador {
    private String rf;
    private String nome;
    private String observacao;
    private List <Ocorrencia> ocorrencias;
    private String tipoAcesso;
    private String tipoColaborador;
    private String regimeTrabalho;
    private GrupoGerencial grupoGerencial;
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
        this.grupoGerencial = null;
        this.equipamentosDisponibilizados = new ArrayList<Emprestimo>();
        this.contratosComodato = new ArrayList<ContratoComodato>();
    }

    public Colaborador(String rf, String nome, String observacao, List<Ocorrencia> ocorrencias, String tipoAcesso,
            String tipoColaborador, String regimeTrabalho, GrupoGerencial grupoGerencial,
            List<Emprestimo> equipamentosDisponibilizados,
            List<ContratoComodato> contratosComodato) {
        this.rf = rf;
        this.nome = nome;
        this.observacao = observacao;
        this.ocorrencias = ocorrencias;
        this.tipoAcesso = tipoAcesso;
        this.tipoColaborador = tipoColaborador;
        this.regimeTrabalho = regimeTrabalho;
        this.grupoGerencial = grupoGerencial;
        this.equipamentosDisponibilizados = equipamentosDisponibilizados;
        this.contratosComodato = contratosComodato;
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

    public GrupoGerencial getGrupoGerencial() {
        return grupoGerencial;
    }

    public void setGrupoGerencial(GrupoGerencial grupoGerencial) {
        this.grupoGerencial = grupoGerencial;
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
    
}
