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
public class AlterarDAO extends AbstractDAO{
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    public AlterarDAO(){
        this.conn =  null;
    }
    public AlterarDAO(Connection conn){
        this.conn =  conn;
    }

    public void alterar(EntidadeDominio entidade) {
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
            System.out.println("Não foi possível alterar o(a) "+ nameEntidade +" no banco de dados \nErro:" + ex.getMessage());
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
                script = "UPDATE equipamentos SET eqp_patrimonio =?, eqp_serial =?, " 
                + "eqp_observacao =?, "
                + "eqp_loc_presencial =?, eqp_compartilhado =?, eqp_loc_id =?, eqp_nof_id =?, " 
                + "eqp_teq_id =?, eqp_cet_id =? WHERE eqp_id =?";
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
                case "model.dominio.ContratoEquipamentoTerceiro":
                    java.sql.Date dataInicio = new java.sql.Date(((ContratoEquipamentoTerceiro)entidade).getDataInicio().getTime());
                    java.sql.Date dataTermino = new java.sql.Date(((ContratoEquipamentoTerceiro)entidade).getDataFinal().getTime());
                    stmt.setString(1, ((ContratoEquipamentoTerceiro)entidade).getFornecedor());
                    stmt.setDate(2, dataInicio);
                    stmt.setDate(3, dataTermino);
                break;

                case "model.dominio.Equipamento":
                    stmt.setString(1, ((Equipamento)entidade).getNumPatrimonio());
                    stmt.setString(2, ((Equipamento)entidade).getSerial());
                    stmt.setString(3, ((Equipamento)entidade).getObservacao());
                    stmt.setBoolean(4, ((Equipamento)entidade).getLocPresencial());
                    stmt.setBoolean(5, ((Equipamento)entidade).getCompartilhado());
                    stmt.setInt(6, ((Equipamento)entidade).getLocalizacao().getId());
                    stmt.setInt(7, ((Equipamento)entidade).getNotaFiscal().getId());
                    stmt.setInt(8, ((Equipamento)entidade).getTipoEquipamento().getId());
                    stmt.setInt(9, ((Equipamento)entidade).getContratoEquipamentoTerceiro().getId());
                    stmt.setInt(10, ((Equipamento)entidade).getId());
                break;

                case "model.dominio.Ocorrencia":
                    stmt.setString(1, ((Ocorrencia)entidade).getOs());
                    stmt.setString(2, ((Ocorrencia)entidade).getDescricao());
                    stmt.setInt(3, ((Ocorrencia)entidade).getEquipamento().getId());
                    stmt.setInt(4, ((Ocorrencia)entidade).getColaborador().getId());    
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
                    stmt.setString(2, ((Colaborador)entidade).getNome());
                    stmt.setInt(3, ((Colaborador)entidade).getImagem().getId());
                    stmt.setInt(4, ((Colaborador)entidade).getTipoAcesso().getId());
                    stmt.setInt(5, ((Colaborador)entidade).getTipoColaborador().getId());
                    stmt.setInt(6, ((Colaborador)entidade).getRegimeTrabalho().getId());
                    stmt.setInt(7, ((Colaborador)entidade).getPresidencia().getId());
                    stmt.setInt(8, ((Colaborador)entidade).getGerencia().getId());
                    stmt.setInt(9, ((Colaborador)entidade).getDiretoria().getId());
                    stmt.setInt(10, ((Colaborador)entidade).getNucleo().getId());
                break;

                case "model.dominio.Emprestimo":
                    java.sql.Date dataDisponibilizacao = new java.sql.Date(((Emprestimo)entidade).getDataDisponibilizacao().getTime());
                    java.sql.Date dataDevolucao = null;
                   
                    if(((Emprestimo)entidade).getDataDevolucao() != null){
                        dataDevolucao = new java.sql.Date(((Emprestimo)entidade).getDataDevolucao().getTime());
                    }

                    stmt.setInt(1, ((Emprestimo)entidade).getEquipamento().getId());
                    stmt.setDate(2, dataDisponibilizacao);
                    stmt.setDate(3, dataDevolucao);
                    stmt.setInt(4, ((Emprestimo)entidade).getColaborador().getId());
                    stmt.setBoolean(5, ((Emprestimo)entidade).isVigente());
                    stmt.setString(6, ((Emprestimo)entidade).getFinalidade());
                    stmt.setInt(7, ((Emprestimo)entidade).getRespEntrega().getId());
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
