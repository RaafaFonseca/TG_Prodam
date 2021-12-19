public class Localizacao {
    private String predio;
    private String andar;
    private String lado;
    private String referencia;

    public Localizacao(){
        this.predio = " ";
        this.andar = " ";
        this.lado = " ";
        this.referencia = " ";
    } 

    public Localizacao(String predio, String andar, String lado, String referencia){
        this.predio = predio;
        this.andar = andar;
        this.lado = lado;
        this.referencia = referencia;
    }

    public String getPredio() {
        return predio;
    }
    public String getReferencia() {
        return referencia;
    }
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
    public String getLado() {
        return lado;
    }
    public void setLado(String lado) {
        this.lado = lado;
    }
    public String getAndar() {
        return andar;
    }
    public void setAndar(String andar) {
        this.andar = andar;
    }
    public void setPredio(String predio) {
        this.predio = predio;
    }
       
}
