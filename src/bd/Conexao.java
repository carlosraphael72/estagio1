
package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author RAPHAEL
 */
public class Conexao {
    private static Connection conexao;
    
    public static Connection getConexao(){
        try{
        if(conexao == null){
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/innove", "root", "root");
            System.out.println("Conectado com sucesso");
        }
        return conexao;
        } /*catch(ClassNotFoundException cnfe){
//            JOptionPane.showMessageDialog(null, "Erro no JDBC");
//            return null;
        }*/ catch(SQLException se){
            JOptionPane.showMessageDialog(null, "Erro na conexão com o banco de dados");
            se.printStackTrace();
            return null;
        }
        
    }
}
