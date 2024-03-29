/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Categoria;
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
public class CategoriaDAO {
    
    public class CategoriaDAO extends ExecuteSQL{

            public CategoriaDAO(Connection con) {
            super(con);
         }
    public String Inserir_Categoria(Categoria a){
        String sql = "insert into value (0,?,?)";
        
                 try{
                     
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, a.getCodigo());
            ps.setString(2, a.getNome());
            
                     if (ps.executeUpdate() > 0){
                         return "Inserido com Sucesso.";
            
                        }else{
                         
                     return "Erro ao Inserir";
                }
                       } catch(SQLException e){
                        return e.getMessage();
                  }
                  }
    
                  public List<Categoria> ListarCategoria(){
                String sql = "select idcategoria, nome from categoria";
                    List<Categoria> lista = new ArrayList<>();
        try{
                  PreparedStatement ps = getCon().prepareStatement(sql);
                  ResultSet rs = ps.executeQuery();
            
           if ( rs != null){
                 while (rs.next()) {
                 Categoria a = new Categoria();
                  a.setCodigo(rs.getInt(1));
                  a.getNome(rs.getString(2));
                        
                              lista.add(a);
                        
                    }
                         return lista;
                         
                }      else  {
                    return null;
                } 
           
                        }catch (SQLException e){
                        return null;
                }
                
    }
                    public List<Categoria> Pesquisar_Nome_Categoria(String nome){
                    String sql = "select idcategoria, nome"
                     + "from categoria where nome Like '" + nome +"'";
                     List<Categoria> lista = new ArrayList<>();
        try{
                PreparedStatement ps = getCon().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
            
                              if ( rs != null){
                             while (rs.next()) {
                            Categoria a = new Categoria();
                            a.setCodigo(rs.getInt(1));
                            a.getNome(rs.getString(2));
                        
                                        lista.add(a);
                        
                    }
                                   return lista;
                        }  else{
                    return null;
                } 
                              
        }catch (SQLException e){
            return null;
        }
        
     }
                    
                      public List<Categoria> Pesquisar_Cod_Categoria(int cod){
                      String sql = "select idcategoria, nome"
                       + "from categoria where nome Like '"+ cod +"'";
                      
                        List<Categoria> lista = new ArrayList<>();
          try{
                PreparedStatement ps = getCon().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
            
                          if ( rs != null){
                           while (rs.next()) {
                        Categoria a = new Categoria();
                        a.setCodigo(rs.getInt(1));
                        a.getNome(rs.getString(2));
                        
                        lista.add(a);
                        
                    }
                           
                         return lista;
                }  else  {
                    return null;
                } 
                          
                }catch (SQLException e){
                        return null;
                }
                
     }    
                       public boolean Testar_Categoria(int cod){
                              boolean Resultado = false;
                      try {
            
            String sql ="select * from categoria where idcategoria = "+cod+"";
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
     
                public List<Categoria> CapturarCategoria(int cod){
                  String sql = "select * from categoria where idcategoria = "+ cod +" ";
                   List<Categoria> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
                           if (rs != null) {
                while(rs.next()){
                    Categoria a = new Categoria();
                    a.setCodigo(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    lista.add(a);
                }
                return lista;
            } else{
                return null;
            }
        } catch(SQLException e){
            return null;
        } 
     }
     
                   public String Alterar_Categoria(Categoria a) {
                   String sql = "update categoria where idcliente = ?";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(0, a.getCodigo());
            ps.setString(1, a.getNome());
            if(ps.executeUpdate() > 0) {
                return "Atualizado com sucesso.";
            } else {
                return "Erro ao Atualizar";
            }
                
       } catch (SQLException e) {
           return e.getMessage();
       }
     }  
                  public String Excluir_Categoria(Categoria a){
                  String sql = "delete from categoria where idcategoria = ? and nome = ? ";
        
                  try{
           PreparedStatement ps = getCon().prepareStatement(sql);
           ps.setInt(1, a.getCodigo());
           ps.setString(1, a.getNome());
           
                     if (ps.executeUpdate() > 0){
               return "Excluído com sucesso";
               
           }else{
               return "Erro ao excluir";
           }
        
        } catch (SQLException e){
            return e.getMessage();
        }
    }

    public List<Categoria> ListarFuncionario() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
}
