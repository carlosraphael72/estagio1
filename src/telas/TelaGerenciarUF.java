
package telas;

import componentes.MeuCampoTexto;
import componentes.MeuComboBox;

/**
 *
 * @author RAPHAEL
 */
public class TelaGerenciarUF extends TelaCadastro {
    private MeuCampoTexto campoNome = new MeuCampoTexto(20, true, "Unidade Federação");
    private MeuCampoTexto campoSigla = new MeuCampoTexto(2, true, "Sigla");
    private MeuComboBox comboPais = new MeuComboBox(true, "Pais");
    
    
    public TelaGerenciarUF(){
        super("Gerenciar Unidade da Federação");
        adicionaCampo(1,1, campoNome);
        adicionaCampo(3,1, campoSigla);
        adicionaCampo(5,1, comboPais);
       
        
        pack();
    }
    

}
