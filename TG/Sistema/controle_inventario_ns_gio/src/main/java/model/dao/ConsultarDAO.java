package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.dominio.*;
import util.Conectar;

/**
 *
 * @author Tiago
 */
public class ConsultarDAO extends AbstractDAO{
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    public ConsultarDAO(){
        this.conn =  null;
    }
    public ConsultarDAO (Connection conn){
        this.conn =  conn;
    }

    public List<EntidadeDominio> consultarAll(EntidadeDominio entidade) {
        String nameEntidade = entidade.getClass().getName(); 
        String sql = getScript(nameEntidade);
        
        List<EntidadeDominio> entidadesDominio = new ArrayList<EntidadeDominio>();

        try{
            if(conn == null || this.conn.isClosed()){
                this.conn = Conectar.getConnection();
                ctrlTransacao = true; 
            }else{
                ctrlTransacao = false;
            }

            this.stmt = conn.prepareStatement(sql);
            
            executeStmt(entidade, stmt);

            rs = stmt.executeQuery();

            construirEntidade(rs, entidadesDominio, entidade);

            return entidadesDominio;
        }catch(Exception ex){
            System.out.println("Não foi possível consultar o(a) "+ nameEntidade +" no banco de dados \nErro:" + ex.getMessage());
        }finally{
            if(ctrlTransacao){Conectar.closeConnection(conn, stmt, rs);}
        }
        return null;
    }

    public String getScript(String nameEntidade){
        String script = " ";

        switch (nameEntidade){
            case "model.dominio.Programa":
                script = "";
            break;

            case "model.dominio.Imagem":
                script = "SELECT * FROM imagens;";
            break;

            case "model.dao.relacoes.ImagemPrograma":
                script = "";
            break;
            
            case "model.dominio.TipoEquipamento":
                script = "SELECT * FROM tipos_equipamento;"; 
            break;

            case "model.dominio.Localizacao":
                script = "SELECT * FROM localizacoes;";
            break;

            case "model.dominio.NotaFiscal":
                script = "SELECT * FROM notas_fiscais;";
            break;

            case "model.dominio.ContratoEquipamentoTerceiro":
                script = "";
            break;

            case "model.dominio.Equipamento":
                script = "SELECT * FROM equipamentos;";
            break;

            case "model.dominio.Ocorrencia":
                script = "";
            break;

            case "model.dominio.TipoAcesso":
                script = "SELECT * FROM tipos_acesso;";
            break;
            
            case "model.dominio.RegimeTrabalho":
                script = "SELECT * FROM tipos_contratos;";
            break;

            case "model.dominio.TipoColaborador":
                script = "SELECT * FROM tipos_colaborador;";
            break;

            case "model.dominio.Colaborador":
                script = "";
            break;

            case "model.dominio.Presidencia":
                script = "SELECT * FROM presidencias;";
            break;

            case "model.dominio.Diretoria":
                script = "SELECT * FROM diretorias;";
            break;

            case "model.dominio.Gerencia":
                script = "SELECT * FROM gerencias;";
            break;

            case "model.dominio.Nucleo":
                script = "SELECT * FROM nucleos;";
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
                
                break;

                case "model.dominio.Imagem":
                    
                break;

                case "model.dao.relacoes.ImagemPrograma":
                    
                break;

                case "model.dominio.TipoEquipamento":
                    
                break;

                case "model.dominio.Localizacao":
                   
                break;

                case "model.dominio.NotaFiscal":
                    
                break;
                case "model.dominio.ContratoEquipamentoTerceiro":
                    
                break;

                case "model.dominio.Equipamento":
                    
                break;

                case "model.dominio.Ocorrencia":
                      
                break;

                case "model.dominio.TipoAcesso":
                    
                break;

                case "model.dominio.RegimeTrabalho":
                    
                break;

                case "model.dominio.TipoColaborador":
                    
                break;

                case "model.dominio.Colaborador":
                    
                break;

                case "model.dominio.Emprestimo":
    
                break;

                default:
                break;
            }
        }catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public void consultarDependencies(EntidadeDominio entidade){
       
    }

    public void construirEntidade(ResultSet rs, List<EntidadeDominio> entidades, EntidadeDominio entidade){
        try{
            switch (entidade.getClass().getName()){
                case "model.dominio.Programa":
                    
                break;

                case "model.dominio.Imagem":
                    while(rs.next()){
                        entidade = new Imagem();
                        
                        ((Imagem)entidade).setId(rs.getInt("img_id"));
                        ((Imagem)entidade).setDescricao(rs.getString("img_descricao"));
         
                        entidades.add(entidade);
                    }
                break;

                case "model.dao.relacoes.ImagemPrograma":
                    
                break;
                
                case "model.dominio.TipoEquipamento":
                    while(rs.next()){
                        entidade = new TipoEquipamento();
                        ((TipoEquipamento)entidade).setId(rs.getInt("teq_id"));
                        ((TipoEquipamento)entidade).setDescricao(rs.getString("teq_descricao"));
                        ((TipoEquipamento)entidade).setMarca(rs.getString("teq_marca"));
                        ((TipoEquipamento)entidade).setModelo(rs.getString("teq_modelo"));
                        ((TipoEquipamento)entidade).setFornecedor(rs.getString("teq_fornecedor"));
                        ((TipoEquipamento)entidade).setPolegadas(rs.getString("teq_polegadas"));
                        
                        entidades.add(entidade);
                    }
                break;

                case "model.dominio.Localizacao":
                    while(rs.next()){
                        entidade = new Localizacao();
                        ((Localizacao)entidade).setId(rs.getInt("loc_id"));
                        ((Localizacao)entidade).setPredio(rs.getString("loc_predio"));
                        ((Localizacao)entidade).setAndar(rs.getString("loc_andar"));
                        ((Localizacao)entidade).setLado(rs.getString("loc_lado"));
                        
                        entidades.add(entidade);
                    }
                break;

                case "model.dominio.NotaFiscal":
                    while(rs.next()){
                        entidade = new NotaFiscal();
                        ((NotaFiscal)entidade).setId(rs.getInt("nof_id"));
                        ((NotaFiscal)entidade).setNumero(rs.getString("nof_numero"));
                        ((NotaFiscal)entidade).setDate(rs.getDate("nof_dt"));
                        
                        entidades.add(entidade);
                    }
                break;

                case "model.dominio.ContratoEquipamentoTerceiro":
                    
                break;

                case "model.dominio.Equipamento":
                    while(rs.next()){
                        entidade = new Equipamento();
                        ((Equipamento)entidade).setId(rs.getInt("eqp_id"));
                        ((Equipamento)entidade).setSerial(rs.getString("eqp_serial"));
                        ((Equipamento)entidade).setNumPatrimonio(rs.getString("eqp_patrimonio"));
                        ((Equipamento)entidade).setObservacao(rs.getString("eqp_observacao"));
                        ((Equipamento)entidade).setLocPresencial(rs.getBoolean("eqp_loc_presencial"));
                        ((Equipamento)entidade).setCompartilhado(rs.getBoolean("eqp_compartilhado"));
                        ((Equipamento)entidade).getContratoEquipamentoTerceiro().setId((rs.getInt("eqp_cet_id")));
                        ((Equipamento)entidade).getTipoEquipamento().setId((rs.getInt("eqp_teq_id")));
                        ((Equipamento)entidade).getNotaFiscal().setId((rs.getInt("eqp_nof_id")));
                        ((Equipamento)entidade).getLocalizacao().setId((rs.getInt("eqp_loc_id")));

                        entidades.add(entidade);
                    }
                break;

                case "model.dominio.Ocorrencia":
                    
                break;

                case "model.dominio.TipoAcesso":
                    while(rs.next()){
                        entidade = new TipoAcesso();
                        
                        ((TipoAcesso)entidade).setId(rs.getInt("tac_id"));
                        ((TipoAcesso)entidade).setDescricao(rs.getString("tac_descricao"));
        
                        entidades.add(entidade);
                    }
                break;
                
                case "model.dominio.RegimeTrabalho":
                    while(rs.next()){
                        entidade = new RegimeTrabalho();
                        
                        ((RegimeTrabalho)entidade).setId(rs.getInt("tct_id"));
                        ((RegimeTrabalho)entidade).setDescricao(rs.getString("tct_descricao"));
        
                        entidades.add(entidade);
                }
                break;

                case "model.dominio.TipoColaborador":
                    while(rs.next()){
                        entidade = new TipoColaborador();
                        
                        ((TipoColaborador)entidade).setId(rs.getInt("tco_id"));
                        ((TipoColaborador)entidade).setDescricao(rs.getString("tco_descricao"));
        
                        entidades.add(entidade);
                    }
                break;

                case "model.dominio.Colaborador":
                    
                break;

                case "model.dominio.Emprestimo":
                
                break;

                case "model.dominio.Presidencia":
                    while(rs.next()){
                        entidade = new Presidencia();
                        
                        ((Presidencia)entidade).setId(rs.getInt("pre_id"));
                        ((Presidencia)entidade).setDescricao(rs.getString("pre_descricao"));
                        ((Presidencia)entidade).setSigla(rs.getString("pre_sigla"));
                        entidades.add(entidade);
                    }
                break;

                case "model.dominio.Diretoria":
                    while(rs.next()){
                        entidade = new Diretoria();
                        
                        ((Diretoria)entidade).setId(rs.getInt("dir_id"));
                        ((Diretoria)entidade).setDescricao(rs.getString("dir_descricao"));
                        ((Diretoria)entidade).setSigla(rs.getString("dir_sigla"));
                        entidades.add(entidade);
                    }
                break;

                case "model.dominio.Gerencia":
                    while(rs.next()){
                        entidade = new Gerencia();
                        
                        ((Gerencia)entidade).setId(rs.getInt("ger_id"));
                        ((Gerencia)entidade).setDescricao(rs.getString("ger_descricao"));
                        ((Gerencia)entidade).setSigla(rs.getString("ger_sigla"));
                        entidades.add(entidade);
                    } 
                break;

                case "model.dominio.Nucleo":
                    while(rs.next()){
                        entidade = new Nucleo();
                        
                        ((Nucleo)entidade).setId(rs.getInt("nuc_id"));
                        ((Nucleo)entidade).setDescricao(rs.getString("nuc_descricao"));
                        ((Nucleo)entidade).setSigla(rs.getString("nuc_sigla"));
                        entidades.add(entidade);
                    } 
                break;

                default:
                break;
            }  
        }catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
