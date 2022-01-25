package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.dominio.EntidadeDominio;
import util.Conectar;
import model.dominio.*;

/**
 *
 * @author Tiago
 */
public class SalvarDAO{
    private Connection conn;
    private boolean ctrlTransacao;
    
    public SalvarDAO(){
        this.conn =  null;
    }

    public SalvarDAO(Connection conn){
        this.conn =  conn;
    }
    
    public void salvar(EntidadeDominio entidade) {
        int id = 0;
    
        String nameEntidade = entidade.getClass().getName(); 

        String sql = getScript(nameEntidade);

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

            executarStmt(stmt, entidade);

            stmt.executeUpdate();

            rs = stmt.getGeneratedKeys();

            if(rs.next()) {id = rs.getInt(1);}
            
            entidade.setId(id);

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

    public String getScript (String nameEntidade){
        String script = null;
        
        switch (nameEntidade) {
            case "model.dominio.Imagem":
                script = "INSERT INTO IMAGENS (img_id, img_dt_cadastro, img_descricao)"
                +" VALUES(img_id, now(), ?);";
            break;

            case "model.dominio.TipoLicenca":
                script = "INSERT INTO tipos_licenca (tlc_id, tlc_dt_cadastro, tlc_descricao)"
                + "VALUES(tlc_id, now(), ?);";
            break;

            case "model.dominio.Programa":
                script = "INSERT INTO programas (prg_id, prg_dt_cadastro, prg_descricao, prg_observacao, prg_tlc_id)"
                + "VALUES(prg_id, now(), ?, ?, ?);";
            break;

            default:
            break;
        }

        return script;
    }

    public void executarStmt (PreparedStatement stmt, EntidadeDominio entidade) throws SQLException{
        String nameEntidade = entidade.getClass().getName(); 

        switch (nameEntidade) {
            
            case "model.dominio.Imagem":
                stmt.setString(1, ((Imagem)entidade).getDescricao());
            break;

            case "model.dominio.TipoLicenca":
                stmt.setString(1, ((TipoLicenca)entidade).getDescricao());
            break;

            case "model.dominio.Programa":
                stmt.setString(1, ((Programa)entidade).getDescricao());
                stmt.setString(2, ((Programa)entidade).getObservacao());
                stmt.setInt(3, ((Programa)entidade).getTpLicenca().getId());
            break;

            default:
            break;
        }  
    }
}
