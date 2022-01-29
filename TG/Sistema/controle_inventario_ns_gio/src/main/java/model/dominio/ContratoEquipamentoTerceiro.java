/**
 *
 * @author Tiago
 */


package model.dominio;

import java.util.Date;

public class ContratoEquipamentoTerceiro extends EntidadeDominio{
    private String fornecedor;
    private Date dataInicio;
    private Date dataFinal;
    
    public ContratoEquipamentoTerceiro() {
        this.fornecedor = " ";
        this.dataInicio = new Date();
        this.dataFinal = new Date();
    }

    public ContratoEquipamentoTerceiro(String fornecedor, Date dataInicio, Date dataFinal) {
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
    public Date getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }
    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

}