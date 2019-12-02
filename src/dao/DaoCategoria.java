
package dao;

import bd.Conexao;
import static dao.DaoUF.SQLSELECT;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import pojo.Categoria;

/**
 *
 * @author PC
 */
public class DaoCategoria {
    private Categoria categoria;
    private final String SQLINCLUIR = "INSERT INTO CATEGORIA (NOME, ATIVO) VALUES (?,?)";
    private final String SQLALTERAR =  "UPDATE CATEGORIA SET NOME = ?, ATIVO = ? WHERE CODIGOCATEGORIA = ?";
    private final String SQLEXCLUIR = "DELETE FROM CATEGORIA WHERE CODIGOCATEGORIA = ?";
    public static final String SQLCONSULTAR = "SELECT CATEGORIA.CODIGOCATEGORIA, CATEGORIA.NOME, CATEGORIA.ATIVO FROM CATEGORIA";
    public static final String SQLSELECT = "SELECT NOME, ATIVO FROM CATEGORIA";
    
    public DaoCategoria(Categoria categoria){
        this.categoria = categoria;
    }
    
    public boolean incluir(){
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLINCLUIR);
            ps.setString(1, categoria.getNome());
            ps.setString(2, categoria.getAtivo());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel incluir a Categoria");
            return false;
        }
        
    }
    
    public boolean alterar(){
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLALTERAR);
            ps.setString(1, categoria.getNome());
            ps.setString(2, categoria.getAtivo());
            ps.setInt(3, categoria.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel alterar a Categoria");
            return false;
        }
       
   }
    
     public boolean excluir(){
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLEXCLUIR);
            ps.setInt(1, categoria.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel excluir a Categoria");
            return false;
        }
   }
     
     public boolean consultar(){
       try{
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLSELECT);
          //  ps.setInt(1, categoria.getCodigo());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                categoria.setNome(rs.getString(1));
                categoria.setAtivo(rs.getString(2));
            } else{
                JOptionPane.showMessageDialog(null, "Categoria não encontrado");
            }
            return true;
        } catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel consultar a Categoria");
            return false;
        }
   }
}
