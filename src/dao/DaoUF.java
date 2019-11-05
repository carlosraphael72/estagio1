
package dao;

import bd.Conexao;
import static dao.DaoPais.SQLCONSULTAR;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import pojo.UF;

/**
 *
 * @author PC
 */
public class DaoUF {
    private UF uf;
    private final String SQLINCLUIR = "INSERT INTO UF (NOME, SIGLA, ATIVO) VALUES (?,?,?)";
    private final String SQLALTERAR = "UPDATE UF SET NOME = ?, SIGLA = ?, ATIVO = ? WHERE CODIGOUF = ?";
    private final String SQLEXCLUIR = "DELETE FROM PAIS WHERE CODIGOUF = ?";
    public static final String SQLCONSULTAR = "SELECT * FROM PAIS WHERE CODIGOUF = ?";
    public static final String SQLSELECT = "SELECT * FROM UF";
    public static final String SQLCOMBOBOX = "SELECT CODIGOUF, SIGLA FROM UF ORDER BY SIGLA";
    
    public DaoUF(UF uf){
        this.uf = uf;
    }
    
    public boolean incluir(){
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLINCLUIR);
            ps.setString(1, uf.getNome());
            ps.setString(2, uf.getSigla());
            ps.setString(3, uf.getAtivo());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel incluir a UF");
            return false;
        }
        
    }
    
   public boolean alterar(){
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLALTERAR);
            ps.setString(1, uf.getNome());
            ps.setString(2, uf.getSigla());
            ps.setString(3, uf.getAtivo());
            ps.setInt(4, uf.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel alterar a UF");
            return false;
        }
       
   }
   
   public boolean excluir(){
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLEXCLUIR);
            ps.setInt(1, uf.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel excluir a UF");
            return false;
        }
   }
   
   public boolean consultar(){
       try{
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLCONSULTAR);
            ps.setInt(1, uf.getCodigo());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                uf.setNome(rs.getString(2));
                uf.setSigla(rs.getString(3));
                uf.setAtivo(rs.getString(4));
            } else{
                JOptionPane.showMessageDialog(null, "UF não encontrado");
            }
            return true;
        } catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel consultar a UF");
            return false;
        }
   }
}
