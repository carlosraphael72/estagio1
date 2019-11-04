
package telas;

import componentes.MeuCampoTexto;
import componentes.MeuDBComboBox;

/**
 *
 * @author RAPHAEL
 */
public class TelaGerenciarUF extends TelaCadastro {
    private MeuCampoTexto campoNome = new MeuCampoTexto(20, true, "Unidade Federação");
    private MeuCampoTexto campoSigla = new MeuCampoTexto(2, true, "Sigla");
    private MeuDBComboBox comboPais = new MeuDBComboBox(true, "Pais");
    
    
    public TelaGerenciarUF(){
        super("Gerenciar Unidade da Federação");
        adicionaCampo(3,1, campoNome);
        adicionaCampo(5,1, campoSigla);
        adicionaCampo(7,1, comboPais);
       
        habilitaCampos(false);
        pack();
    }
    

}
