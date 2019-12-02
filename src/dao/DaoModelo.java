/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bd.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import pojo.Modelo;
import pojo.Modelo;

/**
 *
 * @author PC
 */
public class DaoModelo {
    private Modelo modelo;
    private final String SQLINCLUIR = "INSERT INTO MODELO (DESCRICAO, ATIVO) VALUES (?,?)";
    private final String SQLALTERAR = "UPDATE MODELO SET DESCRICAO = ?, ATIVO = ? WHERE CODIGOMODELO = ?";
    private final String SQLEXCLUIR = "DELETE FROM MODELO WHERE CODIGOMODELO = ?";
    public static final String SQLCONSULTAR = "SELECT CODIGOMODELO, DESCRICAO, ATIVO FROM MODELO";
    public static final String SQLSELECT = "SELECT DESCRICAO, ATIVO FROM MODELO";
    
    
    public DaoModelo(Modelo modelo){
        this.modelo = modelo;
    }
    
    public boolean incluir(){
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLINCLUIR);
            ps.setString(1, modelo.getDescricao());
            ps.setString(2, modelo.getAtivo());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel incluir o Modelo");
            return false;
        }
        
    }
    
    public boolean alterar(){
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLALTERAR);
            ps.setString(1, modelo.getDescricao());
            ps.setString(2, modelo.getAtivo());
            ps.setInt(3, modelo.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel alterar o Modelo");
            return false;
        }
       
   }
    
     public boolean excluir(){
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLEXCLUIR);
            ps.setInt(1, modelo.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel excluir o Modelo");
            return false;
        }
   }
     
     public boolean consultar(){
       try{
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLSELECT);
          //  ps.setInt(1, modelo.getCodigo());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                modelo.setDescricao(rs.getString(1));
                modelo.setAtivo(rs.getString(2));
            } else{
                JOptionPane.showMessageDialog(null, "Modelo não encontrado");
            }
            return true;
        } catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel consultar o Modelo");
            return false;
        }
   }
    
}
