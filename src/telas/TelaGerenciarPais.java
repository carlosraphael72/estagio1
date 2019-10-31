
package telas;

import componentes.MeuCampoNumero;
import componentes.MeuCampoTexto;

/**
 *
 * @author RAPHAEL
 */
public class TelaGerenciarPais extends TelaCadastro{
    
    private MeuCampoNumero campoCodigo = new MeuCampoNumero(2, false, "Codigo");
    private MeuCampoTexto campoPais =  new MeuCampoTexto(20, true, "País");
    private MeuCampoTexto campoSigla = new MeuCampoTexto(2, true, "Sigla");
    
    
    public TelaGerenciarPais(){
        super("Tela Gerenciamendo de Pais");
        adicionaCampo(1,1, campoCodigo);
        adicionaCampo(3,1, campoPais);
        adicionaCampo(5,1, campoSigla);
        
        pack();
    }
    
    

}
