/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Classificacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Eduarda
 */
public class ClassificacaoDAO extends ExecuteSQL {
     public ClassificacaoDAO(Connection con) {
            super(con);
    }
                public String Inserir_Classificacao(Classificacao a) {
                String sql = "insert into value (0,?,?)";
                   try {
                      PreparedStatement ps = getCon().prepareStatement(sql);
            

            ps.setString(1, a.getNome());
            ps.setInt(2, (int) a.getPreco());

            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso.";
            } else {
                return "Erro ao inserir";
            }
        } catch (SQLException e) {
            return e.getMessage();

        }
     }

                 public void Inserir_Categoria(Classificacao a) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public List<Classificacao> ListarClassificacao() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public void Excluir_Classificacao(Classificacao a) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}

