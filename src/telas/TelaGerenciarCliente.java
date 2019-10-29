
package telas;

import componentes.MeuCampoData;
import componentes.MeuCampoTexto;

/**
 *
 * @author RAPHAEL
 */
public class TelaGerenciarCliente extends TelaCadastro {
    private MeuCampoTexto campoPessoa =  new MeuCampoTexto(20, true, "Pessoa");
    private MeuCampoData campoDataInclusao = new MeuCampoData(true, "Data de inclusão");
    
    public TelaGerenciarCliente(){
        super("Gerenciar Cliente");
        adicionaCampo(1,1, campoPessoa);
        adicionaCampo(3,1, campoDataInclusao);
        
        pack();
    }
}
