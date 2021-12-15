import java.util.ArrayList;
import java.util.List;

public class Imagem {
    private String  descricao;
    private List<Programa> programas;

    public Imagem () {
        this.setDescricao(" ");
        this.setProgramas(new ArrayList<Programa>());
    }
    public Imagem (String descricao, List<Programa> programas){
        this.setDescricao(descricao);
        this.setProgramas(programas);
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
