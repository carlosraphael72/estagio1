
package telas;

import componentes.MeuCampoTexto;
import componentes.MeuComboBox;

/**
 *
 * @author RAPHAEL
 */
public class TelaGerenciarModelo extends TelaCadastro {
    private MeuCampoTexto campoDescricao = new MeuCampoTexto(50, true, "Descrição");
    private MeuComboBox comboCategoria = new MeuComboBox(true, "Categoria");
    
    public TelaGerenciarModelo(){
        super("Gerenciar Modelo");
        adicionaCampo(1,1, campoDescricao);
        adicionaCampo(3,1, comboCategoria);
        
        pack();
    }
    

}
