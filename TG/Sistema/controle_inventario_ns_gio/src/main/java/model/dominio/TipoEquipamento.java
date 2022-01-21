package model.dominio;

/**
 * @author Tiago
 */
 
public class TipoEquipamento {
    private String descricao;
    private String marca;
    private String modelo;
    private String fornecedor;
    private String polegadas;

    public TipoEquipamento() {
        this.descricao = " ";
        this.marca = " ";
        this.modelo = " ";
        this.fornecedor = " ";
        this.polegadas = " ";
    }

    public TipoEquipamento(String descricao, String marca, String modelo, String fornecedor, String polegadas) {
        this.descricao = descricao;
        this.marca = marca;
        this.modelo = modelo;
        this.fornecedor = fornecedor;
        this.polegadas = polegadas;
    }

    public String getDescricao() {
        return descricao;
    }
    public String getPolegadas() {
        return polegadas;
    }
    public void setPolegadas(String polegadas) {
        this.polegadas = polegadas;
    }
    public String getFornecedor() {
        return fornecedor;
    }
    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
