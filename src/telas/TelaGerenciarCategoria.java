
package telas;

import componentes.MeuCampoTexto;
import javax.swing.JLabel;

/**
 *
 * @author RAPHAEL
 */
public class TelaGerenciarCategoria extends TelaCadastro {
    private MeuCampoTexto campoNome = new MeuCampoTexto(20, true, "Nome");
    
    public TelaGerenciarCategoria(){
        super("Gerenciar Categoria");
       adicionaCampo(1, 1, campoNome);
        
        pack();
    }
}
