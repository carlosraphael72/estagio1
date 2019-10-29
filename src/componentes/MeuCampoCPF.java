
package componentes;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author RAPHAEL
 */
public class MeuCampoCPF extends JFormattedTextField implements MeuComponente {
    public boolean obrigatorio;
    public String dica;
    
    public MeuCampoCPF(boolean obrigatorio, String dica){
        try{
            setColumns(10);
           this.obrigatorio = obrigatorio;
           this.dica = dica;
           MaskFormatter mf = new MaskFormatter("###.###.###-##");
           mf.install(this);
           
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void limpar() {
        setText("   .   .   -  ");
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
        return getText().equals("   .   .   -  ");
    }

    @Override
    public String getDica() {
        return dica;
    }
    
}
