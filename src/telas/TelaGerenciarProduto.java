
package telas;

import componentes.MeuCampoData;
import componentes.MeuCampoNumero;
import componentes.MeuCampoTexto;
import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 *
 * @author RAPHAEL
 */
public class TelaGerenciarProduto extends TelaCadastro {
    private MeuCampoTexto campoDescricao = new MeuCampoTexto(20, true, "Descrição");
    private MeuCampoNumero campoUnidadeEstoque = new MeuCampoNumero(2, true, "Unidade de Estoque");
    private MeuCampoNumero campoUnidadeVenda = new MeuCampoNumero(2, true, "Unidade de Venda");   
    private JComboBox comboFabricante = new JComboBox();
    private JComboBox comboModelo = new JComboBox();
    private MeuCampoNumero campoValorUnitario = new MeuCampoNumero(2, true, "Valor Unitario");
    private MeuCampoData campoData = new MeuCampoData(true, "Data");
    
    
    public TelaGerenciarProduto(){
        super("Gerenciar Produto");
        adicionaComponente();
        
        pack();
    }
    
    public void adicionaComponente(){
        JLabel jlDescricao = new JLabel(campoDescricao.getDica());
        gbc.gridx = 0;
        gbc.gridy = 1;
        jpComponentes.add(jlDescricao, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        jpComponentes.add(campoDescricao, gbc);
        
        JLabel jlUnidadeEstoque = new JLabel(campoUnidadeEstoque.getDica());
        gbc.gridx = 2;
        gbc.gridy = 1;
        jpComponentes.add(jlUnidadeEstoque, gbc);
        
        gbc.gridx = 3;
        gbc.gridy = 1;
        jpComponentes.add(campoUnidadeEstoque, gbc);
        
        JLabel jlUnidadeVenda = new JLabel(campoUnidadeVenda.getDica());
        gbc.gridx = 4;
        gbc.gridy = 1;
        jpComponentes.add(jlUnidadeVenda, gbc);
        
        gbc.gridx = 5;
        gbc.gridy = 1;
        jpComponentes.add(campoUnidadeVenda, gbc);
        
        JLabel jlFabricante = new JLabel("Fabricante");
        gbc.gridx = 6;
        gbc.gridy = 1;
        jpComponentes.add(jlFabricante, gbc);
        
        gbc.gridx = 7;
        gbc.gridy = 1;
        jpComponentes.add(comboFabricante, gbc);
        
        JLabel jlModelo = new JLabel("Modelo");
        gbc.gridx = 8;
        gbc.gridy = 1;
        jpComponentes.add(jlModelo, gbc);
        
        gbc.gridx = 9;
        gbc.gridy = 1;
        jpComponentes.add(comboModelo, gbc);
        
        JLabel jlValorUnitario = new JLabel(campoValorUnitario.getDica());
        gbc.gridx = 0;
        gbc.gridy = 2;
        jpComponentes.add(jlValorUnitario, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        jpComponentes.add(campoValorUnitario, gbc);
        
        JLabel jlData = new JLabel(campoData.getDica());
        gbc.gridx = 2;
        gbc.gridy = 2;
        jpComponentes.add(jlData, gbc);
        
        gbc.gridx = 3;
        gbc.gridy = 2;
        jpComponentes.add(campoData, gbc);
    }
}
