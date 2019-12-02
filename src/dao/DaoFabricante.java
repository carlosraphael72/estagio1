
package dao;

import bd.Conexao;
import static dao.DaoFabricante.SQLSELECT;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import pojo.Fabricante;

/**
 *
 * @author PC
 */
public class DaoFabricante {
    private Fabricante fabricante;
    private final String SQLINCLUIR = "INSERT INTO FABRICANTE (NOME, ATIVO) VALUES (?,?)";
    private final String SQLALTERAR =  "UPDATE FABRICANTE SET NOME = ?, ATIVO = ? WHERE CODIGOFABRICANTE = ?";
    private final String SQLEXCLUIR = "DELETE FROM FABRICANTE WHERE CODIGOFABRICANTE = ?";
    public static final String SQLCONSULTAR = "SELECT CODIGOFABRICANTE, NOME, ATIVO FROM FABRICANTE";
    public static final String SQLSELECT = "SELECT NOME, ATIVO FROM FABRICANTE";
    
    
    public DaoFabricante(Fabricante fabricante){
        this.fabricante = fabricante;
    }
    
    public boolean incluir(){
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLINCLUIR);
            ps.setString(1, fabricante.getNome());
            ps.setString(2, fabricante.getAtivo());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel incluir o Fabricante");
            return false;
        }
        
    }
    
    public boolean alterar(){
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLALTERAR);
            ps.setString(1, fabricante.getNome());
            ps.setString(2, fabricante.getAtivo());
            ps.setInt(3, fabricante.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel alterar o Fabricante");
            return false;
        }
       
   }
    
     public boolean excluir(){
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLEXCLUIR);
            ps.setInt(1, fabricante.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel excluir o Fabricante");
            return false;
        }
   }
     
     public boolean consultar(){
       try{
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLSELECT);
          //  ps.setInt(1, fabricante.getCodigo());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                fabricante.setNome(rs.getString(1));
                fabricante.setAtivo(rs.getString(2));
            } else{
                JOptionPane.showMessageDialog(null, "Fabricante não encontrado");
            }
            return true;
        } catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel consultar o Fabricante");
            return false;
        }
   }
}
