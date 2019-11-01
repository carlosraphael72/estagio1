
package telas;

import bd.Conexao;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author RAPHAEL
 */
public class TelaConsulta extends JFrame {
    private TelaCadastro telaChamadora;
    private DefaultTableModel dtm = new DefaultTableModel();
    private String[][] dados = {};
    private JTable tabela = new JTable(dtm){
        @Override
        public boolean isCellEditable(int linha, int coluna){
            return false;
        }
    };
    private JScrollPane jsp = new JScrollPane(tabela);
    
    public TelaConsulta(String nomeTela, String[] colunas, String sql, TelaCadastro telaChamadora){
        this.telaChamadora = telaChamadora;
        setTitle(nomeTela);
        dtm.setDataVector(dados, colunas);
        getContentPane().add(jsp);
        setSize(600, 480);
        setVisible(true);
        List<String[]> dados = Conexao.consultaBanco(sql);
        for(int i = 0; i < dados.size(); i++){
            dtm.addRow(dados.get(i));
        }
        tabela.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                if(me.getClickCount() == 2){
                    telaChamadora.preencherDados(Integer.parseInt((String)tabela.getValueAt(tabela.getSelectedRow(), 0)));
                    dispose();
                }
                
            }
        });
    }
}
