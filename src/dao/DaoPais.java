
package dao;

import bd.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import pojo.Pais;

/**
 *
 * @author RAPHAEL
 */
public class DaoPais {
    private Pais pais;
    private final String SQLINCLUIR = "INSERT INTO PAIS VALUES (?,?,?,?)";
    private final String SQLALTERAR = "UPDATE PAIS SET NOME = ?, SIGLA = ?, ATIVO = ? WHERE CODIGOPAIS = ?";
    private final String SQLEXCLUIR = "DELETE FROM PAIS WHERE CODIGOPAIS = ?";
    
    public DaoPais(Pais pais){
        this.pais = pais;
    }
    
    public boolean incluir(){
        try{
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLINCLUIR);
            ps.setInt(1, pais.getCodigo());
            ps.setString(2, pais.getNome());
            ps.setString(3, pais.getSigla());
            ps.setString(4, pais.getAtivo());
            ps.executeUpdate();
            return true;
            
        } catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel incluir o País");
            return false;
        }
    }
    
    public boolean alterar(){
        try{
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLALTERAR);
            ps.setString(1, pais.getNome());
            ps.setString(2, pais.getSigla());
            ps.setString(3, pais.getAtivo());
            ps.setInt(4, pais.getCodigo());
            ps.executeUpdate();
            return true;
        } catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel alterar o País");
            return false;
        }
    }
    
    public boolean excluir(){
        try{
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLEXCLUIR);
            ps.setInt(1, pais.getCodigo());
            ps.executeUpdate();
            return true;
            
        } catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel excluir o País");
            return false;
        }
    }
    
    public boolean consultar(){
        try{
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLEXCLUIR);
            ps.setInt(1, pais.getCodigo());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                pais.setNome(rs.getString(2));
                pais.setSigla(rs.getString(3));
                pais.setAtivo(rs.getString(4));
            } else{
                JOptionPane.showMessageDialog(null, "País não encontrado");
            }
            return true;
        } catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel consultar o País");
            return false;
        }
    }
}