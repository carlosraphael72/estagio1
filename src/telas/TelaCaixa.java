
package telas;

import componentes.MeuCampoNumero;

/**
 *
 * @author RAPHAEL
 */
public class TelaCaixa extends TelaCadastro {
    private MeuCampoNumero campoSaldoInicial = new MeuCampoNumero(3, true, "Saldo Inicial", true);
    
    public TelaCaixa(){
        super("Caixa");
        adicionaCampo(1,1, campoSaldoInicial);
        
        pack();
    }
}
