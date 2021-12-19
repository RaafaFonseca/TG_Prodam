
import java.util.Date;

public class ContratoComodato{
    private Date date; 
    private String caminhoArquivo;
    private String status;

    public ContratoComodato(){
        this.date = new Date();
        this.caminhoArquivo = " ";;
        this.status = Status.ATIVO.toString();
    }
    public ContratoComodato(Date date, String caminhoArquivo, String status){
        this.date = new Date();
        this.caminhoArquivo = " ";;
        this.status = Status.ATIVO.toString();
    }

    public Date getDate() {
        return date;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getCaminhoArquivo() {
        return caminhoArquivo;
    }
    public void setCaminhoArquivo(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }
    public void setDate(Date date) {
        this.date = date;
    } 

    
}