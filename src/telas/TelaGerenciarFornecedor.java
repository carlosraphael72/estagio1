
package telas;

import componentes.MeuCampoData;
import componentes.MeuCampoTexto;

/**
 *
 * @author RAPHAEL
 */
public class TelaGerenciarFornecedor extends TelaCadastro {
    private MeuCampoTexto campoPessoa = new MeuCampoTexto(20, true, "Pessoa", true);
    private MeuCampoData campoDataInclusao = new MeuCampoData(true, "Data de Inclusão");
    
    public TelaGerenciarFornecedor(){
        super("Gerenciar Fornecedor");
        adicionaCampo(1,1, campoPessoa);
        adicionaCampo(3,1, campoDataInclusao);
        
        pack();
    }
}
