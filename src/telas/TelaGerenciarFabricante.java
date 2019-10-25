
package telas;

import componentes.MeuCampoTexto;
import javax.swing.JLabel;

/**
 *
 * @author RAPHAEL
 */
public class TelaGerenciarFabricante extends TelaCadastro {
    private MeuCampoTexto campoNome = new MeuCampoTexto(20, true, "Nome");
    
    public TelaGerenciarFabricante(){
        super("Gerenciar Fabricante");
        adicionaComponente();
        
        pack();
    }
    
    public void adicionaComponente(){
        JLabel jlNome = new JLabel(campoNome.getDica());
        gbc.gridx = 0;
        gbc.gridy = 1;
        jpComponentes.add(jlNome, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        jpComponentes.add(campoNome, gbc);
    }
}
