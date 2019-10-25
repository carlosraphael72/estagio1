
package telas;

import componentes.MeuCampoTexto;
import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 *
 * @author RAPHAEL
 */
public class TelaGerenciarCidade extends TelaCadastro {
    private MeuCampoTexto campoCidade = new MeuCampoTexto(20, true, "Nome");
    private JComboBox comboEstado = new JComboBox();
    
    public TelaGerenciarCidade(){
        super("Gerenciar Cidades");
        adicionaComponente();
        
        pack();
    }
    
    public void adicionaComponente(){
        JLabel jlCidade = new JLabel(campoCidade.getDica());
        gbc.gridx = 0;
        gbc.gridy = 1;
        jpComponentes.add(jlCidade, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        jpComponentes.add(campoCidade, gbc);
        
        JLabel jlEstado = new JLabel("Estado");
        gbc.gridx = 2;
        gbc.gridy = 1;
        jpComponentes.add(jlEstado, gbc);
        
        gbc.gridx = 3;
        gbc.gridy = 1;
        jpComponentes.add(comboEstado, gbc);
    }
}
