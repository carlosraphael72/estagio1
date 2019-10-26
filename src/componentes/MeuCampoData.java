
package componentes;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author RAPHAEL
 */
public class MeuCampoData extends JFormattedTextField implements MeuComponente {
    private boolean obrigatorio;
    private String dica;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
   // private boolean validacao;
    
    public MeuCampoData(boolean obrigatorio, String dica){
        try{
            setColumns(8);
            this.obrigatorio = obrigatorio;
            this.dica = dica;
            //SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
            MaskFormatter mf = new MaskFormatter("##/##/####");
            mf.install(this);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
//        public void validaCampo(JFormattedTextField campo){
//        int resultado;
//        String codigo = campo.getText().trim();
//        
//        try{
//            resultado = Integer.parseInt(codigo);
//            this.validacao = true;
//        } catch(Exception ex){
//            JOptionPane.showMessageDialog(null, "Campo " + this.getDica() + "só aceita numeros" ,"Informação",JOptionPane.INFORMATION_MESSAGE);
//            this.validacao = false;
//        }
//    }

    @Override
    public void limpar() {
        setText("  /  /    ");
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
        try{
            sdf.setLenient(false);
            sdf.parse(getText());
            return true;
        } catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean eVazio() {
        return getText().equals("  /  /    ");
    }

    @Override
    public String getDica() {
        return dica;
    }
    
    public void setValor(Date data){
        setText(sdf.format(data));
    }
    
    public Date getValor(){
        try{
            return sdf.parse(getText());
        } catch(Exception e){
            System.out.println("Não foi possibel obter o valor do MeuCampoData");
            return null;
        }
    }
}
