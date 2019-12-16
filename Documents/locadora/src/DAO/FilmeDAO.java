/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Filme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eduarda
 */
public class FilmeDAO extends ExecuteSQL{
    

    public FilmeDAO(Connection con) {
        super(con);
        
        
        
   
        throw new UnsupportedOperationException("Not supported yet."); 
    }

  
  
   
    
    public String Inserir_Filme(Filme e){
        String sql = "insert into filme values (0,?,?,?,?,?,?)";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setInt(1, e.getCodigo());
            ps.setString(2, e.getTitulo());
            ps.setInt(3, e.getAno());
            ps.setString(4, e.getDuracao());
            ps.setInt(5, e.getCategoria);
            ps.setInt(6, e.getclassificacao());
            ps.setString(7, e.getcapa());
            
            
            
            
            if (ps.executeUpdate() > 0){
                return "Inserido com Sucesso.";
            
            }else{
                return "Erro ao Inserir";
            }
        } catch(SQLException o){
            return o.getMessage();
        }
    }
    
    
              public List<Filme> ListarFilme(){
                  
                  
                String sql = "select codigo,filme,ano,duracao,categoria,classificacao from filme";
                List<Filme> lista = new ArrayList<>();
                try{
                PreparedStatement ps = getCon().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                
                
                
                 if ( rs != null){
                    while (rs.next()) {
                        Filme e = new Filme();
                        e.setCodigo(rs.getInt(1));
                        e.setAno(rs.getInt(2));
                        e.setDuracao(rs.getString(3));
                        e.setCategoria(rs.getString(4));
       
                        lista.add(e);
                    }
                  return lista;
                } else{
                    return null;
                } 
                }catch (SQLException e){
                        return null;
                }
                        
              }
    
            public List<Filme> Pesquisar_Nome_Filme(String nome){
        String sql = "select codigo,ano,duracao,categoria,classificacao from filme where nome Like"+nome+"%'";
        return null;
    
    }
            
    
    public List<Filme> Pesquiisar_Cod_Cliente(int cod){
        String sql = "select codigo,filme,ano,duracao,categoria,classificacao from cliente where nome Like"+cod+"%'";
     return null;
    }
    
    
    
    
    public boolean Testar_Filme(int cod){
        boolean Resultado = false;
        try {
            
            String sql ="select * from filme where codigo = "+cod+"";
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs !=null){
                while(rs.next()){
                    Resultado = true;
                }
            }
            
        } catch (SQLException ex){
            ex.getMessage();
        }
        return Resultado;
        }
    
    
    public List<Filme> CapturarFilme(int cod){
        String sql = "select * from filme where codigo = "+ cod +" ";
        List<Filme> listar = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while(rs.next()){
                    Filme a = new Filme();
                    a.setCodigo(rs.getInt(1));
                    a.setTitulo(rs.getString(2));
                    a.setAno(rs.getInt(3));
                    a.setDuracao(rs.getString(4));
                    a.setCategoria(rs.getString(5));
                    a.setClassificacao(rs.getString(6));
                    a.setCapa(rs.getString(7));
                    listar.add(a);
                }
                return listar;
            } else{
                return null;
            }
        } catch(SQLException e){
            return null;
        } 
    }
    
    public String Alterar_Filme(Filme a) {
        String sql = "update filme set titulo = ? , ano = ?, duracao = ? "
                + ",categoria = ? ,classificacao = ? ,capa = ? ";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, a.getCodigo());
            ps.setString(2, a.getTitulo());
            ps.setInt(3, a.getAno());
            ps.setString(4, a.getDuracao());
            ps.setInt(5, a.getCategoria());
            ps.setInt(6, a.getClassificacao());
            ps.setString(7, a.getCapa());
            if(ps.executeUpdate() > 0) {
                return "Atualizado com sucesso.";
            } else {
                return "Erro ao Atualizar";
            }
                
       } catch (SQLException e) {
           return e.getMessage();
       }
     }
    
      public List<Filme> ListarComboFilme() {
            String sql = "Select nome Filme order by titulo ";
            List<Filme> listar = new ArrayList<>();
            try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if ( rs != null) {
                while(rs.next()){    
                Filme a = new Filme();
                a.setTitulo(rs.getString(2));
                listar.add(a);
                
                }
                return listar;        
            }else{
                return null;
            }            
            }catch (Exception e){
                return null;
            }
      }
      
        public List<Filme> ConsultaCodigoFilme(String titulo){
        
        String sql = "select idfuncionario from filme where nome = '"+ titulo +"'";
        List<Filme> listar = new ArrayList<>();
        try{ 
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
                  if ( rs != null) {
                while(rs.next()){    
                Filme a = new Filme();
                a.setCodigo(rs.getInt(1));
                listar.add(a);
                
                }
                return listar;        
            }else{
                return null;
            } 
            
        }catch (Exception e){
                return null;
        }
      
  }
}

