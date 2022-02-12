package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.dao.relacoes.ImagemPrograma;
import model.dominio.*;
import util.Conectar;

/**
 *
 * @author Tiago
 */
public class ExcluirDAO extends AbstractDAO{
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    public ExcluirDAO(){
        this.conn =  null;
    }
    public ExcluirDAO(Connection conn){
        this.conn =  conn;
    }

    public void excluir(EntidadeDominio entidade) {
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

            this.stmt = conn.prepareStatement(sql);
            
            executeStmt(entidade, stmt);

            this.stmt.executeUpdate();

            if(ctrlTransacao) {conn.commit();}

        }catch(Exception ex){
            try {
                conn.rollback();
            } catch (SQLException e1) {
                System.out.println("Error: " + e1.getMessage());
            }
            System.out.println("Não foi possível excluir o(a) "+ nameEntidade +" no banco de dados \nErro:" + ex.getMessage());
        }finally{
            if(ctrlTransacao){Conectar.closeConnection(conn, stmt, rs);}
        }
    }

    public String getScript(String nameEntidade){
        String script = " ";

        switch (nameEntidade){
            case "model.dominio.Programa":
                script = "";
            break;

            case "model.dominio.Imagem":
                script = "";
            break;

            case "model.dao.relacoes.ImagemPrograma":
                script = "";
            break;
            
            case "model.dominio.TipoEquipamento":
                script = "";
            break;

            case "model.dominio.Localizacao":
                script = "";
            break;

            case "model.dominio.NotaFiscal":
                script = "";
            break;

            case "model.dominio.ContratoEquipamentoTerceiro":
                script = "";
            break;

            case "model.dominio.Equipamento":
                script = "DELETE FROM equipamentos WHERE eqp_id = ?;";
            break;

            case "model.dominio.Ocorrencia":
                script = "";
            break;

            case "model.dominio.TipoAcesso":
                script = "";
            break;
            
            case "model.dominio.RegimeTrabalho":
                script = "";
            break;

            case "model.dominio.TipoColaborador":
                script = "";
            break;

            case "model.dominio.Colaborador":
                script = "";
            break;

            case "model.dominio.Emprestimo":
                script = "";
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

                break;

                case "model.dominio.Imagem":
                    stmt.setString(1, ((Imagem)entidade).getDescricao());
                break;

                case "model.dao.relacoes.ImagemPrograma":
                    stmt.setInt(1, ((ImagemPrograma)entidade).getPrograma().getId());
                    
                break;

                case "model.dominio.TipoEquipamento":
                    stmt.setString(1, ((TipoEquipamento)entidade).getDescricao());
                   
                break;

                case "model.dominio.Localizacao":
                    stmt.setString(1, ((Localizacao)entidade).getPredio());
                   
                break;

                case "model.dominio.NotaFiscal":
                    stmt.setString(1, ((NotaFiscal)entidade).getNumero());
                break;

                case "model.dominio.ContratoEquipamentoTerceiro":     
                    stmt.setString(1, ((ContratoEquipamentoTerceiro)entidade).getFornecedor()); 
                break;

                case "model.dominio.Equipamento":
                    stmt.setInt(1, ((Equipamento)entidade).getId());
                break;

                case "model.dominio.Ocorrencia":
                    stmt.setString(1, ((Ocorrencia)entidade).getOs());    
                break;

                case "model.dominio.TipoAcesso":
                    stmt.setString(1, ((TipoAcesso)entidade).getDescricao());
                break;

                case "model.dominio.RegimeTrabalho":
                    stmt.setString(1, ((RegimeTrabalho)entidade).getDescricao());
                break;

                case "model.dominio.TipoColaborador":
                    stmt.setString(1, ((TipoColaborador)entidade).getDescricao());
                break;

                case "model.dominio.Colaborador":
                    stmt.setString(1, ((Colaborador)entidade).getRf());
                break;

                case "model.dominio.Emprestimo":
                    stmt.setInt(1, ((Emprestimo)entidade).getEquipamento().getId());
                break;

                default:
                break;
            }
        }catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }

}
