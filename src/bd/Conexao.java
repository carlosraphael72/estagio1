
package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author RAPHAEL
 */
public class Conexao {
   // private static Connection conexao;
    
    public static Connection getConexao(){
        try{
            Class.forName("org.firebirdsql.jdbc.FBDriver");
          Connection  conexao =  DriverManager.getConnection("jdbc:firebirdsql://127.0.0.1/D:/innove/INNOVE1.FDB", "SYSDBA", "masterkey");
            return conexao;
           // System.out.println("Conexão realizada com sucesso");
           // JOptionPane.showMessageDialog(null, "Conexão realizada com sucesso");
       
        
        }  catch(SQLException se){
            System.out.println("Erro na conexão com o banco de dados");
           // throw new RuntimeException("Erro na conexão com o banco de dados", se);
            //JOptionPane.showMessageDialog(null, "Erro na conexão com o banco de dados");
            //se.printStackTrace();
            return null;
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro no JDBC");
          //  throw new RuntimeException("Erro no JDBC", ex);
           // JOptionPane.showMessageDialog(null, "Erro no JDBC");
            return null;
        }
        
    }
    
//    public static void closeConexao(Connection conexao){
//        if(conexao != null){
//            try {
//                conexao.close();
//            } catch (SQLException ex) {
//                System.err.println("Erro:" + ex);
//            }
//        }
//    }
//    public static void closeConexao(Connection conexao, PreparedStatement ps){
//        if(ps != null){
//            try {
//                ps.close();
//            } catch (SQLException ex) {
//                System.err.println("Erro:" + ex);
//            }
//        }
//        closeConexao(conexao);
//    }
//    public static void closeConexao(Connection conexao, PreparedStatement ps, ResultSet rs){
//        if(rs != null){
//            try {
//                rs.close();
//            } catch (SQLException ex) {
//                System.err.println("Erro:" + ex);
//            }
//        }
//        closeConexao(conexao, ps);
//    }
    
    public static List<String[]> consultaBanco(String sql) {
        List<String[]> retorno = new ArrayList();
        try {
            Statement st = getConexao().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String[] linha = new String[rs.getMetaData().getColumnCount()];
                for (int coluna = 1;
                        coluna <= rs.getMetaData().getColumnCount();
                        coluna++) {
                    linha[coluna - 1] = rs.getString(coluna);
                }
                retorno.add(linha);
            }
            return retorno;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao consultar o Banco de Dados");
            e.printStackTrace();
            return null;
        }
    }
}
