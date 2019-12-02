
package telas;

import componentes.MeuCampoData;
import componentes.MeuCampoNumero;
import componentes.MeuCampoTexto;
import componentes.MeuComboBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 *
 * @author RAPHAEL
 */
public class TelaGerenciarProduto extends TelaCadastro {
    private MeuCampoTexto campoDescricao = new MeuCampoTexto(20, true, "Descrição", true);
    private MeuCampoNumero campoUnidadeEstoque = new MeuCampoNumero(2, true, "Unidade de Estoque", true);
    private MeuCampoNumero campoUnidadeVenda = new MeuCampoNumero(2, true, "Unidade de Venda", true);   
    private MeuComboBox comboFabricante = new MeuComboBox(true, "Fabricante");
    private MeuComboBox comboModelo = new MeuComboBox(true, "Modelo");
    private MeuCampoNumero campoValorUnitario = new MeuCampoNumero(2, true, "Valor Unitario", true);
    private MeuCampoData campoData = new MeuCampoData(true, "Data");
    
    
    public TelaGerenciarProduto(){
        super("Gerenciar Produto");
        adicionaCampo(1,1, campoDescricao);
        adicionaCampo(3,1, campoUnidadeEstoque);
        adicionaCampo(5,1, campoUnidadeVenda);
        adicionaCampo(7,1, comboFabricante);
        adicionaCampo(9,1, comboModelo);
        adicionaCampo(1,2, campoValorUnitario);
        adicionaCampo(3,2, campoData);
        
        pack();
        habilitaCampos(false);
    }
    

}
