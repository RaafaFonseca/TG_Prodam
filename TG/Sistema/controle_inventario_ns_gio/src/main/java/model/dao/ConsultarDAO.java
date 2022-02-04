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
                script = "";
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
}
