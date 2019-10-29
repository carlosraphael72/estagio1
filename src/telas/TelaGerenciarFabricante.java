
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
        adicionaCampo(1,1, campoNome);
       
        
        pack();
    }
    

}
