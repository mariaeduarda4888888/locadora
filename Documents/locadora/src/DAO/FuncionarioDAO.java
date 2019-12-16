package DAO;

import java.sql.Connection;
import Modelo.Funcionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO extends ExecuteSQL {
    
    public FuncionarioDAO(Connection con) {
        super(con);
    }
    public boolean Logar (String login, String senha) {
        boolean finalResult = false;
        try {
             String consulta = "select login, senha from funcionario"
            + "where login = '" + login + "' and senha = '" + senha + "'";
              PreparedStatement ps = getCon().prepareStatement(consulta);
              ResultSet rs = ps.executeQuery();
                
                if (rs != null) {
                     while (rs.next())   {
                         Funcionario a = new Funcionario();
                         a.setLogin(rs.getString(1));
                         a.setSenha(rs.getString(2));
                         finalResult = true;
                     }
                }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return finalResult;
    }
    public String Inserir_Funcionario(Funcionario a) {
                
                
        String sql = "insert into funcionario value (0,?,?,?,?)";
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            

            ps.setString(1, (String) a.getCodigo());
            ps.setString(2, (String) a.getNome());
            ps.setString(3, a.getLogin());
            ps.setString(4, a.getSenha());
            
              if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso.";
            } else {
                  
                return "Erro ao inserir";
            }
              
        } catch (SQLException e) {
            return e.getMessage();

        }
    }
 
    /**
     *
     * @return
     */
           public List<Funcionario> ListarFuncionario() throws SQLException{
               
                String sql = "select idfuncionario, nome, from funcionario";
                List<Funcionario> lista = new ArrayList<>();
                
                try {
                PreparedStatement ps = getCon().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
            
                
                if ( rs != null){
                    while (rs.next()) {
                        Funcionario a = new Funcionario();
                        a.setCod(rs.getInt(1));
                        a.getNome(rs.getString(2));
                       
                        lista.add(a);    
                    }
                    
                     return lista;
                     
                } else{
                    
                    return null;
          } 
                }catch (SQLException e){
                        return null;
       }
    }
                    


           public List<Funcionario> Pesquisar_Nome_Funcionario(String nome) throws SQLException{
               
        String sql = "select idfuncionario, nome, from funcionario where nome Like"+nome+"%'";
        List<Funcionario> lista = new ArrayList<>();
        
        
        
         try{
                PreparedStatement ps = getCon().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
            
                if ( rs != null){
                    
                    while (rs.next()) {
                        Funcionario a = new Funcionario();
                        a.setCod(rs.getInt(1));
                        a.getNome(rs.getString(2));
                        lista.add(a);
                 
                    }
                    
                    return lista;
                    
                   
                    
                }else{
                    return null;
                    
                } 
                }catch (SQLException e){
                    
                    return null;
                }
        
    }
                
                           
                        
                   
    
             public List<Funcionario> Pesquiisar_Cod_Funcionario(int cod){
                 
                 
        String sql = "select idfuncionario, nome from funcionario where nome Like"+cod+"%'";
        List<Funcionario> lista = new ArrayList<>();
        
        
         try{
                PreparedStatement ps = getCon().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
            
                if ( rs != null){
                    
                    while (rs.next()) {
                        Funcionario a = new Funcionario();
                        a.setCod(rs.getInt(1));
                        
                        lista.add(a);
                        
                    }
                    return lista;
                } else{
                    return null;
                } 
                }catch (SQLException e){
                        return null;
                }
     }
             
             
        public boolean Testar_Funcionario(int cod){
            
            
        boolean Resultado = false;
        
        try {
            
            String sql ="select * from Funcionario where idfuncionario = "+cod+"";
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
 
        public List<Funcionario> CapturarFuncionario(int cod) throws SQLException{
            
        String sql = "select * from funcionario where idfuncionario = "+ cod +" ";
        List<Funcionario> lista = new ArrayList<>();
        
        
             try {
                 
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while(rs.next()){
                    Funcionario a = new Funcionario();
                    a.setCod(rs.getInt(1));
                    a.setNome(rs.getString(2));
                }
                
                return lista;
            } else{
                return null;
            }
        }catch(SQLException e){
            return null;
        } 
    }
        
        
             public String Alterar_Funcionario(Funcionario a) throws SQLException {
        String sql = "update funcionario set  nome = ? , login = ?, senha = ? ";
                
             try{
                 
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, (String) a.getNome());
            ps.setString(2, a.getLogin());
            ps.setString(3, a.getSenha());
            
            
           if(ps.executeUpdate() > 0) {
               
                return "Atualizado com sucesso.";
            } else {
                return "Erro ao Atualizar";
            } 
             }
             catch (SQLException e) {
           return e.getMessage();
       }
   } 
             public List<Funcionario> ListarComboFuncionario() {
                 
            String sql = "Select nome funcionario order by nome ";
            List<Funcionario> lista = new ArrayList<>();
            
            
            try{
                
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if ( rs != null) {
                while(rs.next()){    
                Funcionario a = new Funcionario();
                a.setNome(rs.getString(1));
                lista.add(a);
                
                }
                
                return lista;        
            }else{
                
                return null;
            }            
            }catch (Exception e){
                return null;
            }
    }

    public void Excluir_Categoria(Funcionario a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
   
 }  

