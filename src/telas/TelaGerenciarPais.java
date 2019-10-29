
package telas;

import componentes.MeuCampoTexto;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author RAPHAEL
 */
public class TelaGerenciarPais extends TelaCadastro{
    
    private MeuCampoTexto campoPais =  new MeuCampoTexto(20, true, "País");
    private MeuCampoTexto campoSigla = new MeuCampoTexto(2, true, "Sigla");
    
    
    public TelaGerenciarPais(){
        super("Tela Gerenciamendo de Pais");
        adicionaCampo(1,1, campoPais);
        adicionaCampo(3,1, campoSigla);
        
        pack();
    }
    
    

}
