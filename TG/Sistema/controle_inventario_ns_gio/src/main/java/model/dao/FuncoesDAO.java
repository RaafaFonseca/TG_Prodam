package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dominio.EntidadeDominio;
import util.Conectar;

/**
 *
 * @author Tiago
 */
public class FuncoesDAO {
    private static boolean ctrlTransacao;

    public static boolean ctrlTransacao(Connection conn) throws SQLException{
        if(conn == null || conn.isClosed()){
            conn = Conectar.getConnection();
            ctrlTransacao = true; 
        }else{
            ctrlTransacao = false;
        }
        return ctrlTransacao;
    }

    public static void executarStmt(PreparedStatement stmt, ResultSet rs, EntidadeDominio entidade) throws SQLException{
        int id = 0;
        
        stmt.executeUpdate();

        rs = stmt.getGeneratedKeys();

        if(rs.next()) {id = rs.getInt(1);}
        
        entidade.setId(id);
    }
}
