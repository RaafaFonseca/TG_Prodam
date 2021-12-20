import java.util.Date;

public class ContratoEquipamentoTerceiros {
    private String fornecedor;
    private Date dataInicio;
    private Date dataFinal;
    
    public ContratoEquipamentoTerceiros() {
        this.fornecedor = " ";
        this.dataInicio = new Date();
        this.dataFinal = new Date();
    }

    public ContratoEquipamentoTerceiros(String fornecedor, Date dataInicio, Date dataFinal) {
        this.fornecedor = fornecedor;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
    }

    public String getFornecedor() {
        return fornecedor;
    }
    public Date getDataFinal() {
        return dataFinal;
    }
    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }
    public Date getDataInici() {
        return dataInicio;
    }
    public void setDataInici(Date dataInicio) {
        this.dataInicio = dataInicio;
    }
    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

}