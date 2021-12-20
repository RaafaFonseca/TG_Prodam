import java.util.ArrayList;
import java.util.List;

public class Imagem {
    private String  descricao;
    private List<Programa> programas;

    public Imagem(String descricao, List<Programa> programas) {
        this.descricao = descricao;
        this.programas = programas;
    }

    public Imagem() {
        this.descricao = " ";
        this.programas = new ArrayList<Programa>();
    }

    public List<Programa> getProgramas() {
        return programas;
    }
    public void setProgramas(List<Programa> programas) {
        this.programas = programas;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    } 
}
