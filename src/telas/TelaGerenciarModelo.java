
package telas;

import componentes.MeuCampoTexto;
import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 *
 * @author RAPHAEL
 */
public class TelaGerenciarModelo extends TelaCadastro {
    private MeuCampoTexto campoDescricao = new MeuCampoTexto(50, true, "Descrição");
    private JComboBox comboCategoria = new JComboBox();
    
    public TelaGerenciarModelo(){
        super("Gerenciar Modelo");
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
        
        JLabel jlCategoria = new JLabel("Categoria");
        gbc.gridx = 2;
        gbc.gridy = 1;
        jpComponentes.add(jlCategoria, gbc);
        
        gbc.gridx = 3;
        gbc.gridy = 1;
        jpComponentes.add(comboCategoria, gbc);
    }
}
