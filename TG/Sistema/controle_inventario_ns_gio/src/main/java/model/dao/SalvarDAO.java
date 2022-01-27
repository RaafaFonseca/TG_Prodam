package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.dao.relacoes.ImagemPrograma;
import model.dominio.EntidadeDominio;
import model.dominio.Imagem;
import model.dominio.Programa;
import util.Conectar;

/**
 *
 * @author Tiago
 */
public class SalvarDAO extends AbstractDAO{

    public SalvarDAO(){
        this.conn =  null;
    }
    public SalvarDAO(Connection conn){
        this.conn =  conn;
    }

    public void salvar(EntidadeDominio entidade) {
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
            
            executeStmt(entidade, stmt);

            stmt.executeUpdate();

            rs = stmt.getGeneratedKeys();

            int id = 0;
            if(rs.next()) {id = rs.getInt(1);}
            
            entidade.setId(id);

            if(nameEntidade.equals(Imagem.class.getName())){
                Imagem imagem = (Imagem) entidade;
                if(imagem.getProgramas().size() > 0){
                    for (Programa programa : imagem.getProgramas()){
                        
                        relatingEntities(programa, imagem);
                     }
                }
            }

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

    public String getScript(String nameEntidade){
        String script = " ";

        switch (nameEntidade){
            case "model.dominio.Programa":
                script = "INSERT INTO programas (prg_id, prg_dt_cadastro, prg_descricao, prg_licenca, prg_observacao)"
                + "VALUES(prg_id, now(), ?, ?, ?);";
            break;

            case "model.dominio.Imagem":
                script = "INSERT INTO IMAGENS (img_id, img_dt_cadastro, img_descricao)"
                +" VALUES(img_id, now(), ?);";
            break;

            case "model.dao.relacoes.ImagemPrograma":
                script = "INSERT INTO imagens_programas(ipr_id, ipr_prg_id, ipr_img_id)"
                + "VALUES (ipr_id, ?, ?);";
            break;
            
            default:
            break;
        }
        return script;
    }

    public void executeStmt(EntidadeDominio entidade, PreparedStatement stmt){
        try{
            switch (entidade.getClass().getName()){
                case "model.dominio.Programa":
                    stmt.setString(1, ((Programa)entidade).getDescricao());
                    stmt.setString(2, ((Programa)entidade).getLicenca());
                    stmt.setString(3, ((Programa)entidade).getObservacao());
                break;

                case "model.dominio.Imagem":
                    stmt.setString(1, ((Imagem)entidade).getDescricao());
                break;

                case "model.dao.relacoes.ImagemPrograma":
                    stmt.setInt(1, ((ImagemPrograma)entidade).getPrograma().getId());
                    stmt.setInt(2, ((ImagemPrograma)entidade).getImagem().getId());
                break;

                default:
                break;
            }
        }catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public void relatingEntities(EntidadeDominio entidade1, EntidadeDominio entidade2){
        String nameEntity1 = entidade1.getClass().getName();
        String nameEntity2 = entidade2.getClass().getName();

        if(nameEntity1.equals(Imagem.class.getName()) && nameEntity2.equals(Programa.class.getName())){
            ImagemPrograma imgPrograma = new ImagemPrograma();
            imgPrograma.setImagem((Imagem)entidade1);
            imgPrograma.setPrograma((Programa)entidade2);
            
            salvar(imgPrograma);
        }
    }
}
