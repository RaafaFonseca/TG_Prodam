import java.util.ArrayList;
import java.util.List;

public class Equipamento {
    private String serial;
    private String numPatrimonio;
    private String observacao;
    private Boolean locPresenciBoolean;
    private TipoEquipamento tipoEquipamento; 
    private NotaFiscal notaFiscal;
    private Localizacao localizacao;
    private ContratoEquipamentoTerceiros contratoEquipamentoTerceiros;
    private List <Ocorrencia> ocorrencias;

    public Equipamento() {
        this.serial = " ";
        this.numPatrimonio = " ";
        this.observacao = " ";
        this.locPresenciBoolean = false;
        this.tipoEquipamento = new TipoEquipamento();
        this.notaFiscal = new NotaFiscal();
        this.localizacao = new Localizacao();
        this.contratoEquipamentoTerceiros = new ContratoEquipamentoTerceiros();
        this.ocorrencias = new ArrayList<Ocorrencia>();
    }

    
    public Equipamento(String serial, String numPatrimonio, String observacao, Boolean locPresenciBoolean,
            TipoEquipamento tipoEquipamento, NotaFiscal notaFiscal, Localizacao localizacao,
            ContratoEquipamentoTerceiros contratoEquipamentoTerceiros, List<Ocorrencia> ocorrencias) {
        this.serial = serial;
        this.numPatrimonio = numPatrimonio;
        this.observacao = observacao;
        this.locPresenciBoolean = locPresenciBoolean;
        this.tipoEquipamento = tipoEquipamento;
        this.notaFiscal = notaFiscal;
        this.localizacao = localizacao;
        this.contratoEquipamentoTerceiros = contratoEquipamentoTerceiros;
        this.ocorrencias = ocorrencias;
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
    public Boolean getLocPresenciBoolean() {
        return locPresenciBoolean;
    }
    public void setLocPresenciBoolean(Boolean locPresenciBoolean) {
        this.locPresenciBoolean = locPresenciBoolean;
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
    public ContratoEquipamentoTerceiros getContratoEquipamentoTerceiros() {
        return contratoEquipamentoTerceiros;
    }
    public void setContratoEquipamentoTerceiros(ContratoEquipamentoTerceiros contratoEquipamentoTerceiros) {
        this.contratoEquipamentoTerceiros = contratoEquipamentoTerceiros;
    }
    public List<Ocorrencia> getOcorrencias() {
        return ocorrencias;
    }
    public void setOcorrencias(List<Ocorrencia> ocorrencias) {
        this.ocorrencias = ocorrencias;
    }

    
}
