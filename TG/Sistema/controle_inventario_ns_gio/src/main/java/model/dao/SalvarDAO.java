package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.dao.relacoes.ImagemPrograma;
import model.dominio.*;
import util.Conectar;

/**
 *
 * @author Tiago
 */
public class SalvarDAO extends AbstractDAO{
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    public SalvarDAO(){
        this.conn =  null;
    }
    public SalvarDAO(Connection conn){
        this.conn =  conn;
    }

    public void salvar(EntidadeDominio entidade) {
        String nameEntidade = entidade.getClass().getName(); 
        String sql = getScript(nameEntidade);
 
        try{
            if(conn == null || this.conn.isClosed()){
                this.conn = Conectar.getConnection();
                ctrlTransacao = true; 
            }else{
                ctrlTransacao = false;
            }

            conn.setAutoCommit(false);

            this.stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            executeStmt(entidade, stmt);

            this.stmt.executeUpdate();

            this.rs = this.stmt.getGeneratedKeys();

            int id = 0;
            if(this.rs.next()) {id = rs.getInt(1);}
            
            entidade.setId(id);

            saveDependencies(entidade);

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
            
            case "model.dominio.TipoEquipamento":
                script = "INSERT INTO tipos_equipamento(teq_id, teq_dt_cadastro, teq_descricao, teq_marca, teq_modelo, teq_fornecedor, teq_polegadas)"
                + "VALUES(teq_id, now(), ?, ?, ?, ?, ?);"; 
            break;

            case "model.dominio.Localizacao":
                script="INSERT INTO localizacoes(loc_id, loc_dt_cadastro, loc_predio, loc_andar, loc_lado, loc_referencia)"
                + "VALUES(loc_id, now(), ?, ?, ?, ?);";
            break;

            case "model.dominio.NotaFiscal":
                script="INSERT INTO notas_fiscais (nof_id, nof_dt_cadastro, nof_numero, nof_dt)"
                + " VALUES(nof_id, now(), ?, ?);";
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

                case "model.dominio.TipoEquipamento":
                    stmt.setString(1, ((TipoEquipamento)entidade).getDescricao());
                    stmt.setString(2, ((TipoEquipamento)entidade).getMarca());
                    stmt.setString(3, ((TipoEquipamento)entidade).getModelo());
                    stmt.setString(4, ((TipoEquipamento)entidade).getFornecedor());
                    stmt.setString(5, ((TipoEquipamento)entidade).getPolegadas());
                break;

                case "model.dominio.Localizacao":
                    stmt.setString(1, ((Localizacao)entidade).getPredio());
                    stmt.setString(2, ((Localizacao)entidade).getAndar());
                    stmt.setString(3, ((Localizacao)entidade).getLado());
                    stmt.setString(4, ((Localizacao)entidade).getReferencia());
                break;

                case "model.dominio.NotaFiscal":
                    java.sql.Date dataSql = new java.sql.Date(((NotaFiscal)entidade).getDate().getTime());
                    stmt.setString(1, ((NotaFiscal)entidade).getNumero());
                    stmt.setDate(2, dataSql);
                break;

                default:
                break;
            }
        }catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public void relatingEntities(EntidadeDominio entidade1, EntidadeDominio entidade2){
        if(entidade1 instanceof Programa && entidade2 instanceof Imagem){     
            ImagemPrograma imgPrograma = new ImagemPrograma((Programa)entidade1, (Imagem)entidade2);

            SalvarDAO salvarDAO = new SalvarDAO(conn);
            salvarDAO.salvar(imgPrograma);
        }
    }

    public void saveDependencies(EntidadeDominio entidade){
        if(entidade instanceof Imagem){
            Imagem imagem = (Imagem) entidade;
            if(imagem.getProgramas().size() > 0){
                for (Programa programa : imagem.getProgramas()){
                    relatingEntities(programa, imagem);
                 }
            }
        }
    }
}
