
package dao;

import bd.Conexao;
//import static dao.DaoPRODUTO.SQLSELECT;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import pojo.Produto;
//import pojo.PRODUTO;

/**
 *
 * @author RAPHAEL
 */
public class DaoProduto {
    private Produto produto;
    private final String SQLINCLUIR = "INSERT INTO PRODUTO (DESCRICAO, CODIGOCATEGORIA, CODIGOFABRICANTE, CODIGOMODELO, VALORUNITARIO, ATIVO) VALUES (?,?,?,?,?,?)";
    private final String SQLALTERAR = "UPDATE PRODUTO SET DESCRICAO = ?, CODIGOCATEGORIA = ?, CODIGOFABRICANTE = ?, CODIGOMODELO = ?, VALORUNITARIO = ?,  ATIVO = ? WHERE CODIGOPRODUTO = ?";
    private final String SQLEXCLUIR = "DELETE FROM PRODUTO WHERE CODIGOPRODUTO = ?";
    public static final String SQLCONSULTAR = "SELECT PRODUTO.CODIGOPRODUTO, PRODUTO.DESCRICAO, CATEGORIA.NOME, FABRICANTE.NOME, MODELO.DESCRICAO, PRODUTO.VALORUNITARIO, PRODUTO.ATIVO FROM PRODUTO INNER JOIN CATEGORIA ON PRODUTO.CODIGOCATEGORIA = CATEGORIA.CODIGOCATEGORIA INNER JOIN FABRICANTE ON PRODUTO.CODIGOFABRICANTE = FABRICANTE.CODIGOFABRICANTE INNER JOIN MODELO ON PRODUTO.CODIGOMODELO = MODELO.CODIGOMODELO";
    public static final String SQLSELECT = "SELECT PRODUTO.CODIGOPRODUTO, PRODUTO.DESCRICAO, CATEGORIA.CODIGOCATEGORIA, FABRICANTE.CODIGOFABRICANTE, MODELO.CODIGOMODELO, PRODUTO.VALORUNITARIO, PRODUTO.ATIVO FROM PRODUTO INNER JOIN CATEGORIA ON PRODUTO.CODIGOCATEGORIA = CATEGORIA.CODIGOCATEGORIA INNER JOIN FABRICANTE ON PRODUTO.CODIGOFABRICANTE = FABRICANTE.CODIGOFABRICANTE INNER JOIN MODELO ON PRODUTO.CODIGOMODELO = MODELO.CODIGOMODELO";
    public static final String SQLCOMBOBOX = "";
    
    public DaoProduto(Produto produto){
        this.produto = produto;
    }
    
    public boolean incluir(){
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLINCLUIR);
            ps.setString(1, produto.getDescricao());
            ps.setInt(2, produto.getCategoria());
            ps.setInt(3, produto.getFabricante());
            ps.setInt(4, produto.getModelo());
            ps.setDouble(5, produto.getValorUnitario());
           // ps.setDate(6, produto.getDataInclusao());
            ps.setString(6, produto.getAtivo());

            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel incluir o PRODUTO");
            return false;
        }
        
    }
    
   public boolean alterar(){
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLALTERAR);
            ps.setString(1, produto.getDescricao());
            ps.setInt(2, produto.getCategoria());
            ps.setInt(3, produto.getFabricante());
            ps.setInt(4, produto.getModelo());
            ps.setDouble(5, produto.getValorUnitario());
           // ps.setDate(6, produto.getDataInclusao());
            ps.setString(6, produto.getAtivo());
            ps.setInt(7, produto.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel alterar o PRODUTO");
            return false;
        }
       
   }
   
   public boolean excluir(){
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLEXCLUIR);
            ps.setInt(1, produto.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel excluir o PRODUTO");
            return false;
        }
   }
   
   public boolean consultar(){
       try{
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLSELECT);
          //  ps.setInt(1, produto.getCodigo());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                produto.setCodigo(rs.getInt(1));
                produto.setDescricao(rs.getString(2));
                produto.setCategoria(rs.getInt(3));
                produto.setFabricante(rs.getInt(4));
                produto.setModelo(rs.getInt(5));
                produto.setValorUnitario(rs.getDouble(6));
              //  ps.setDate(6, produto.getDataInclusao());
                produto.setAtivo(rs.getString(7));
                
            } else{
                JOptionPane.showMessageDialog(null, "PRODUTO não encontrado");
            }
            return true;
        } catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel consultar o PRODUTO");
            return false;
        }
   }
}
