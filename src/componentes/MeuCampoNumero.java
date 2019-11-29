
package componentes;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author RAPHAEL
 */
public class MeuCampoNumero extends JTextField implements MeuComponente {
    public boolean obrigatorio;
    private String dica;
    private boolean validacao;
    public boolean podeHabilitar;
    
    public MeuCampoNumero(int colunas, boolean obrigatorio, String dica, boolean podeHabilitar){
        super(colunas);
        this.obrigatorio = obrigatorio;
        this.dica = dica;
        this.podeHabilitar = podeHabilitar;
        
    }
    
    public void validaCampo(JTextField campo){
        int resultado;
        String codigo = campo.getText().trim();
        
        try{
            resultado = Integer.parseInt(codigo);
            this.validacao = true;
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Campo " + this.getDica() + " só aceita numeros" ,"Informação",JOptionPane.INFORMATION_MESSAGE);
            this.validacao = false;
        }
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
        validaCampo(this);
        return validacao;
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
