
package componentes;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;
import telas.TelaCadastro;

/**
 *
 * @author RAPHAEL
 */
public class MeuCampoTexto extends JTextField implements MeuComponente {
    public boolean obrigatorio;
    public String dica;
    public boolean podeHabilitar;
    
    public MeuCampoTexto(int colunas, boolean obrigatorio, String dica, boolean podeHabilitar){
        super(colunas);
        this.obrigatorio = obrigatorio;
        this.dica = dica;
        this.podeHabilitar = podeHabilitar;
        addFocusListener(new FocusListener(){
            public void focusLost(FocusEvent fe){
                setBackground(Color.white);
            }
            public void focusGained(FocusEvent fe){
                setBackground(Color.yellow);
            }
        });
    }

    @Override
    public void limpar() {
        setText("");
    }

    @Override
    public void habilitar(boolean status) {
        setEnabled(status && podeHabilitar);
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
        return getText().trim().isEmpty();
    }

    @Override
    public String getDica() {
        return dica;
    }
}
