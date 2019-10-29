
package componentes;

import javax.swing.JComboBox;

/**
 *
 * @author RAPHAEL
 */
public class MeuComboBox extends JComboBox implements MeuComponente {
    private boolean obrigatorio;
    private String dica;
    
    public MeuComboBox(boolean obrigatorio, String dica){
    this.obrigatorio = obrigatorio;
    this.dica = dica;
}

    @Override
    public void limpar() {
        setSelectedIndex(0);
    }

    @Override
    public void habilitar(boolean status) {
        setEnabled(status);
    }

    @Override
    public boolean eObrigatorio() {
        return obrigatorio;
    }

    @Override
    public boolean eValido() {
        return true;
    }

    @Override
    public boolean eVazio() {
        return (getSelectedIndex() <=0);
    }

    @Override
    public String getDica() {
        return dica;
    }
}
