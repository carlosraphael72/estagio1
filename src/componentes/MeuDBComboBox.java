
package componentes;

import bd.Conexao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author PC
 */
public class MeuDBComboBox extends JComboBox implements MeuComponente {
    private String sql;
    private boolean obrigatorio;
    private String dica;
    private List<Integer> pks = new ArrayList();
    
    public MeuDBComboBox(String sql, boolean obrigatorio, String dica){
        this.sql = sql;
        this.obrigatorio = obrigatorio;
        this.dica = dica;
        preencher();
    }
    
    public void preencher(){
        addItem("Selecione");
        pks.add(-1);
        List<String[]> dados = Conexao.consultaBanco(sql);
        for (int i = 0; i < dados.size(); i++){
            String[] dado = dados.get(i);
            pks.add(Integer.parseInt(dado[0]));
            addItem(dado[1]);
        }
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
        return getSelectedIndex() <= 0;
    }

    @Override
    public String getDica() {
        return dica;
    }
    
    public int getValor(){
        return pks.get(getSelectedIndex());
    }
    
    public void setValor(int valor){
        for (int i = 0; i < pks.size(); i++){
            if (pks.get(i) == valor){
                setSelectedIndex(i);
                return;
            }
        }
    }
    
}
