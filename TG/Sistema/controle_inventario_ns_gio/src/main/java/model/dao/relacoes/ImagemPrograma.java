package model.dao.relacoes;

import model.dominio.*;

/**
 * @author Tiago
 */
public class ImagemPrograma extends EntidadeDominio{
   
    private Imagem imagem;
    private Programa programa;
    
    public Programa getPrograma() {
        return programa;
    }
    public Imagem getImagem() {
        return imagem;
    }
    public void setImagem(Imagem imagem) {
        this.imagem = imagem;
    }
    public void setPrograma(Programa programa) {
        this.programa = programa;
    }


}
