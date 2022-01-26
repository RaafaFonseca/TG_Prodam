package model.dao;

import java.sql.*;
import java.util.List;
import util.Conectar;
import model.dominio.*;

/**
 *
 * @author Tiago
 */
public class ProgramaDAO extends AbstractDAO{

    public ProgramaDAO(){
        this.conn =  null;
    }
    public ProgramaDAO(Connection conn){
        this.conn =  conn;
    }

    @Override
    public void salvar(EntidadeDominio entidade) {
        Programa programa = (Programa) entidade;
        int id = 0;
    
        String nameEntidade = entidade.getClass().getName(); 

        String sql = "INSERT INTO programas (prg_id, prg_dt_cadastro, prg_descricao, prg_licenca, prg_observacao)"
        + "VALUES(prg_id, now(), ?, ?, ?);";

        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            if(conn == null || this.conn.isClosed()){
                this.conn = Conectar.getConnection();
                ctrlTransacao = true; 
            }else{
                ctrlTransacao = false;
            }

            conn.setAutoCommit(false);

            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            stmt.setString(1, programa.getDescricao());
            stmt.setString(2, programa.getLicenca());
            stmt.setString(3, programa.getObservacao());
            
            stmt.executeUpdate();

            rs = stmt.getGeneratedKeys();

            if(rs.next()) {id = rs.getInt(1);}
            
            programa.setId(id);

            if(ctrlTransacao) {conn.commit();}

        }catch(Exception ex){
            try {
                conn.rollback();
            } catch (SQLException e1) {
                System.out.println("Error: " + e1.getMessage());
            }
            System.out.println("Não foi possível salvar o(a) "+ nameEntidade +" no banco de dados \nErro:" + ex.getMessage());
        }finally{
            if(ctrlTransacao){Conectar.closeConnection(conn, stmt, rs);}
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
