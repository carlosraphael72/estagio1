
package telas;

import componentes.MeuCampoTexto;
import componentes.MeuComboBox;
import javax.swing.JLabel;

/**
 *
 * @author RAPHAEL
 */
public class TelaGerenciarCidade extends TelaCadastro {
    private MeuCampoTexto campoCidade = new MeuCampoTexto(20, true, "Nome");
    private MeuComboBox comboEstado = new MeuComboBox(true, "Estado");
    
    public TelaGerenciarCidade(){
        super("Gerenciar Cidades");
       adicionaCampo(1,1, campoCidade);
       adicionaCampo(3,1, comboEstado);
        
        pack();
    }
}
