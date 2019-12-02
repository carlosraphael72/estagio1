
package dao;

import bd.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import pojo.Cidade;

/**
 *
 * @author PC
 */
public class DaoCidade {
    private Cidade cidade;
    private final String SQLINCLUIR = "INSERT INTO CIDADE (NOME, CODIGOUF, ATIVO) VALUES (?,?,?)";
    private final String SQLALTERAR =  "UPDATE CIDADE SET NOME = ?, CODIGOUF = ?, ATIVO = ? WHERE CODIGOCIDADE = ?";
    private final String SQLEXCLUIR = "DELETE FROM CIDADE WHERE CODIGOCIDADE = ?";
    public static final String SQLCONSULTAR = "SELECT CIDADE.CODIGOCIDADE, CIDADE.NOME, UF.SIGLA, CIDADE.ATIVO FROM CIDADE INNER JOIN UF ON CIDADE.CODIGOUF = UF.CODIGOUF";
    public static final String SQLSELECT = "SELECT CIDADE.NOME, CIDADE.ATIVO, UF.CODIGOUF FROM CIDADE INNER JOIN UF ON CIDADE.CODIGOUF = UF.CODIGOUF";
  //  public static final String SQLCOMBOBOX = ""
    
    public DaoCidade(Cidade cidade){
        this.cidade = cidade;
    }
    
    public boolean incluir(){   
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLINCLUIR);
            ps.setString(1, cidade.getNome());
            ps.setInt(2, cidade.getUf());
            ps.setString(3, cidade.getAtivo());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel incluir a Cidade");
            return false;
        }
    }
    
   public boolean alterar(){
       try{
           PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLALTERAR);
           ps.setString(1, cidade.getNome());
           ps.setInt(2, cidade.getUf());
           ps.setString(3, cidade.getAtivo());
           ps.setInt(4, cidade.getCodigo());
           ps.executeUpdate();
           return true;    
       } catch(SQLException ex){
           ex.printStackTrace();
           JOptionPane.showMessageDialog(null, "Não foi possivel alterar a Cidade");
           return false;
       }
   }
   
   public boolean excluir(){
       try{
           PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLEXCLUIR);
           ps.setInt(1, cidade.getCodigo());
           return true;
       } catch(SQLException ex){
           ex.printStackTrace();
           JOptionPane.showMessageDialog(null, "Não foi possivel excluir a Cidade");
           return false;
       }
   }
   
   public boolean consultar(){
       try{
       PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLSELECT);
       ResultSet rs = ps.executeQuery();
       if(rs.next()){
           cidade.setNome(rs.getString(1));
           cidade.setAtivo(rs.getString(2));
           cidade.setUf(rs.getInt(3));
       } else{
           JOptionPane.showMessageDialog(null, "Cidade não encontrada");
       }
       return true;
       } catch(SQLException ex){
           ex.printStackTrace();
           JOptionPane.showMessageDialog(null, "Não foi possivel consultar a Cidade");
           return false;
       }
   }
}
