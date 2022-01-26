package model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import model.dominio.EntidadeDominio;
import model.dominio.Imagem;
import model.dominio.Programa;
import util.Conectar;

/**
 *
 * @author Tiago
 */
public class ImagemDAO extends AbstractDAO{
    
    public ImagemDAO(){
        this.conn =  null;
    }
    public ImagemDAO(Connection conn){
        this.conn =  conn;
    }
    
    @Override
    public void salvar(EntidadeDominio entidade) {
        Imagem imagem = (Imagem) entidade;

        String sql = "INSERT INTO IMAGENS (img_id, img_dt_cadastro, img_descricao)"
        +" VALUES(img_id, now(), ?);";
        
        try{
            ctrlTransacao = FuncoesDAO.ctrlTransacao(conn);

            conn.setAutoCommit(false);
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            stmt.setString(1, imagem.getDescricao());
            
            FuncoesDAO.executarStmt(stmt, rs, imagem);

            for (Programa programa : imagem.getProgramas()){
               addPrograma(programa, imagem);
            }

            if(ctrlTransacao) {conn.commit();}

        }catch(Exception ex){
            try {
                conn.rollback();
            } catch (SQLException e1) {
                System.out.println("Error: " + e1.getMessage());
            }
            System.out.println("Não foi possível salvar o(a) "+ entidade.getClass().getName() +" no banco de dados \nErro:" + ex.getMessage());
            
        }finally{
            if(ctrlTransacao){Conectar.closeConnection(conn, stmt, rs);}
        } 
        
    }

    public void addPrograma(Programa programa, Imagem imagem){
        String sql = "INSERT INTO imagens_programas(ipr_id, ipr_prg_id, ipr_img_id)"
        + "VALUES (ipr_id, ?, ?);";
        
        try{
            stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, programa.getId());
            stmt.setInt(2, imagem.getId());
            
            stmt.executeUpdate();

        }catch(Exception ex){
            try {
                conn.rollback();
            } catch (SQLException e1) {
                System.out.println("Error: " + e1.getMessage());
            }
            System.out.println("Não foi possível associar o programa à imagem no banco de dados \nErro:" + ex.getMessage());   
        }
    }

    @Override
    public void alterar(EntidadeDominio entidade) {       
    }

    @Override
    public void excluir(EntidadeDominio entidade) {   
    }

    @Override
    public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
        return null;
    }

    @Override
    public EntidadeDominio consultar(int id) {
        return null;
    }
    
}
