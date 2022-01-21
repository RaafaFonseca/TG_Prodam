/**
 *
 * @author Tiago
 */


package model.dominio;

import java.util.Date;

public class NotaFiscal {
    private String numero;
    private Date date;

    public NotaFiscal(){
        this.numero = " ";
        this.date = new Date(); 
    }
    public NotaFiscal(String numero, Date date){
        this.numero = numero;
        this.date = date; 
    }

    public Date getDate() {
        return date;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    

}
