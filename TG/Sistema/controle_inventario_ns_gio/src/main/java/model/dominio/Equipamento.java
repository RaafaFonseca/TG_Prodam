/**
 *
 * @author Tiago
 */


package model.dominio;

import java.util.ArrayList;
import java.util.List;

public class Equipamento extends EntidadeDominio{
    private String serial;
    private String numPatrimonio;
    private String observacao;
    private Boolean locPresencial;
    private Boolean compartilhado;
    private TipoEquipamento tipoEquipamento; 
    private NotaFiscal notaFiscal;
    private Localizacao localizacao;
    private ContratoEquipamentoTerceiro contratoEquipamentoTerceiro;
    private List <Ocorrencia> ocorrencias;

    public Equipamento() {
        this.serial = " ";
        this.numPatrimonio = " ";
        this.observacao = " ";
        this.locPresencial = false;
        this.compartilhado = false;
        this.tipoEquipamento = new TipoEquipamento();
        this.notaFiscal = new NotaFiscal();
        this.localizacao = new Localizacao();
        this.contratoEquipamentoTerceiro = new ContratoEquipamentoTerceiro();
        this.ocorrencias = new ArrayList<Ocorrencia>();
    }

    public Equipamento(String serial, String numPatrimonio, String observacao, Boolean locPresencial,
            TipoEquipamento tipoEquipamento, NotaFiscal notaFiscal, Localizacao localizacao,
            ContratoEquipamentoTerceiro contratoEquipamentoTerceiro, List<Ocorrencia> ocorrencias, Boolean compartilhado) {
        this.serial = serial;
        this.numPatrimonio = numPatrimonio;
        this.observacao = observacao;
        this.locPresencial = locPresencial;
        this.tipoEquipamento = tipoEquipamento;
        this.notaFiscal = notaFiscal;
        this.localizacao = localizacao;
        this.contratoEquipamentoTerceiro = contratoEquipamentoTerceiro;
        this.ocorrencias = ocorrencias;
        this.compartilhado = compartilhado;
    }

    public Boolean getCompartilhado() {
        return compartilhado;
    }
    public void setCompartilhado(Boolean compartilhado) {
        this.compartilhado = compartilhado;
    }
    public String getSerial() {
        return serial;
    }
    public void setSerial(String serial) {
        this.serial = serial;
    }
    public String getNumPatrimonio() {
        return numPatrimonio;
    }
    public void setNumPatrimonio(String numPatrimonio) {
        this.numPatrimonio = numPatrimonio;
    }
    public String getObservacao() {
        return observacao;
    }
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    public Boolean getLocPresencial() {
        return locPresencial;
    }
    public void setLocPresencial(Boolean locPresencial) {
        this.locPresencial = locPresencial;
    }
    public TipoEquipamento getTipoEquipamento() {
        return tipoEquipamento;
    }
    public void setTipoEquipamento(TipoEquipamento tipoEquipamento) {
        this.tipoEquipamento = tipoEquipamento;
    }
    public NotaFiscal getNotaFiscal() {
        return notaFiscal;
    }
    public void setNotaFiscal(NotaFiscal notaFiscal) {
        this.notaFiscal = notaFiscal;
    }
    public Localizacao getLocalizacao() {
        return localizacao;
    }
    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }
    public ContratoEquipamentoTerceiro getContratoEquipamentoTerceiro() {
        return contratoEquipamentoTerceiro;
    }
    public void setContratoEquipamentoTerceiro(ContratoEquipamentoTerceiro contratoEquipamentoTerceiro) {
        this.contratoEquipamentoTerceiro = contratoEquipamentoTerceiro;
    }
    public List<Ocorrencia> getOcorrencias() {
        return ocorrencias;
    }
    public void setOcorrencias(List<Ocorrencia> ocorrencias) {
        this.ocorrencias = ocorrencias;
    }

    
}
