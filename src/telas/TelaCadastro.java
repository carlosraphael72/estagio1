
package telas;

import componentes.MeuCampoCodigo;
import componentes.MeuComponente;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
//import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author RAPHAEL
 */
public class TelaCadastro extends JInternalFrame implements ActionListener {
    private final int PADRAO = 0;
    private final int INCLUINDO = 1;
    private final int ALTERANDO = 2;
    private final int EXCLUINDO = 3;
    private final int CONSULTANDO = 4;
    
    private int estadoTela = PADRAO;
    public boolean temDadosNaTela = false;
    public String status;
    public JPanel jpComponentes = new JPanel();
    private JPanel jpBotoes = new JPanel();
    private JPanel jpTabela = new JPanel();
    private JButton jbIncluir = new JButton("Incluir");
    private JButton jbAlterar = new JButton("Alterar");
    private JButton jbExcluir = new JButton("Excluir");
    private JButton jbConsultar = new JButton("Consultar");
    private JButton jbConfirmar = new JButton("Confirmar");
    private JButton jbCancelar = new JButton("Cancelar");
    public JCheckBox jcbAtivo = new JCheckBox("Ativo");
    public JCheckBox jcbInativo = new JCheckBox("Inativo");
    public GridBagConstraints gbc = new GridBagConstraints();
    
    public List<MeuComponente> campos = new ArrayList();
    
    private JScrollPane scroll = new JScrollPane();
    
    private DefaultTableModel dtm;
    private JTable tabela;
    public String[][] dados = {};
    

    
    public TelaCadastro(String titulo){
        // super(titulo, redimensionado, fechado, maximizado, iconeficado);
        super(titulo, false, true, false, false);
        getContentPane().add("North", jpComponentes);
        jpComponentes.setLayout(new GridBagLayout());
        getContentPane().add("Center", jpBotoes);
        jpBotoes.setLayout(new GridLayout(1, 6));
        getContentPane().add("South", jpTabela);
        adicionaBotao(jbIncluir);
        adicionaBotao(jbAlterar);
        adicionaBotao(jbExcluir);
       // adicionaBotao(jbConsultar);
        adicionaBotao(jbConfirmar);
        adicionaBotao(jbCancelar);
        
       // adicionaCheckBox();
        
        pack();
        setVisible(true);
        TelaSistema.jdp.add(this);
        habilitaBotoes();
//        jcbAtivo.setEnabled(false);
//        jcbInativo.setEnabled(false);
       // habilitaCampos(false);
    }
    
    public void adicionaTabela(JTable jt){
        scroll.setViewportView(jt);
        this.getContentPane().add("South", scroll);
    }
    
    public void adicionaBotao(JButton botao){
        jpBotoes.add(botao);
        botao.addActionListener(this);
    }
    
    public void adicionaCampo(int x, int y, /*int largura, int altura*/ MeuComponente componente){

        // gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.WEST;
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        jpComponentes.add(jcbAtivo, gbc);
        jcbAtivo.addActionListener(this);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        jpComponentes.add(jcbInativo, gbc);
        jcbInativo.addActionListener(this);
        
//        JLabel jlCodigo = new JLabel("Codigo");
//        gbc.gridx = 0;
//        gbc.gridy = 1;
//        jpComponentes.add(jlCodigo, gbc);
//        
//        gbc.gridx = 1;
//        gbc.gridy = 1;
//        jpComponentes.add(campoCodigo, gbc);
        
       String texto = componente.getDica();
       if (componente.eObrigatorio()){
        texto = "<html><body>" + texto + "<font color=\"red\">*</font>: ";
    }else{
    texto = texto + ": ";
    }
       JLabel jlTexto =  new JLabel(texto);
      
       
       gbc.gridx = x-1;
       gbc.gridy = y;
       jpComponentes.add(jlTexto, gbc);
       
       gbc.gridx = x;
       gbc.gridy = y;
      // gbc.gridwidth = largura;
       //gbc.gridheight = altura;
       jpComponentes.add((JComponent) componente, gbc);
       campos.add(componente);
       
       
    }
    
    public void getStatus(String ativo){
        if(ativo == "ATIVO"){
            jcbAtivo.setSelected(true);
            jcbInativo.setSelected(false);
        } else if(ativo == "INATIVO") {
            jcbInativo.setSelected(true);
            jcbAtivo.setSelected(false);
        } else{
            System.out.println("Bug no ATIVO/INATIVO");
        }
    }
    
    public void habilitaBotoes(){
        jbIncluir.setEnabled(estadoTela == PADRAO || estadoTela == CONSULTANDO);
        jbAlterar.setEnabled(estadoTela == PADRAO && temDadosNaTela || estadoTela == CONSULTANDO && temDadosNaTela);
        jbExcluir.setEnabled(estadoTela == PADRAO && temDadosNaTela || estadoTela == CONSULTANDO);
        jbConsultar.setEnabled(estadoTela == PADRAO || estadoTela == CONSULTANDO);
        jbConfirmar.setEnabled(estadoTela != PADRAO && estadoTela != CONSULTANDO);
        jbCancelar.setEnabled(estadoTela != PADRAO && estadoTela != CONSULTANDO);
        jcbAtivo.setEnabled(estadoTela != PADRAO);
        jcbInativo.setEnabled(estadoTela != PADRAO);
    }
    
    public void habilitaCampos(boolean status){
        for(int i=0; i < campos.size(); i++){
            campos.get(i).habilitar(status);
        }
    }
    
    public void limpaCampos(){
        for(int i=0; i < campos.size(); i++){
            campos.get(i).limpar();
        }
        jcbAtivo.setSelected(false);
        jcbInativo.setSelected(false);
    }
    
    public boolean verificaCampos(){
        String errosObrigatorios = "";
        String errosValidacao = "";
        for(int i=0; i < campos.size(); i++){
            if(campos.get(i).eObrigatorio() && campos.get(i).eVazio()){
                errosObrigatorios = errosObrigatorios + campos.get(i).getDica() + "\n";
            }
            if(!campos.get(i).eValido()){
                errosValidacao = errosValidacao + campos.get(i).getDica() + "\n";
            }
        }
        if(!errosObrigatorios.isEmpty()){
            JOptionPane.showMessageDialog(null, "Campos obrigatorios não preenchidos: \n\n" + errosObrigatorios);
        }
        if(!errosValidacao.isEmpty()){
            JOptionPane.showMessageDialog(null, "Campos invalidos: \n\n" +errosValidacao);
        }
        return errosObrigatorios.isEmpty() && errosValidacao.isEmpty();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == jbIncluir){
            incluir();
        } else if(ae.getSource() == jbAlterar){
            alterar();
        } else if(ae.getSource() == jbExcluir){
            excluir();
        }else if(ae.getSource() == jbConsultar){
            consultar();
        }else if(ae.getSource() == jbConfirmar){
            confirmar();
        } else if(ae.getSource() == jbCancelar){
            cancelar();
        } else if(ae.getSource() == jcbAtivo){
            jcbInativo.setSelected(false);
            this.status = "ATIVO";
            
        } else if(ae.getSource() == jcbInativo){
            jcbAtivo.setSelected(false);
            this.status = "INATIVO";
        }
        else{
            System.out.println("Fonte do ActionListener não reconhecida");
        }
    }
    
    public void incluir(){
        estadoTela = INCLUINDO;
        limpaCampos();
        habilitaCampos(true);
        habilitaBotoes();
    }
    public void alterar(){
        estadoTela = ALTERANDO;
        habilitaCampos(true);
        habilitaBotoes();
    }
    public void excluir(){
        estadoTela = EXCLUINDO;
        habilitaBotoes();
    }
    public void consultar(){
        estadoTela = CONSULTANDO;
        
    }
    public void confirmar(){
        
        if(!verificaCampos()){
            return;
        }
        if(estadoTela == INCLUINDO){
           int opcao =  JOptionPane.showConfirmDialog(this, "Deseja realmente salvar?", "Atenção", JOptionPane.YES_NO_OPTION);
            if(opcao == JOptionPane.YES_OPTION){
            incluirBD();
            limpaCampos();
            temDadosNaTela = false;
            }
        } else if(estadoTela == EXCLUINDO){
           int opcao = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir?", "Atenção", JOptionPane.YES_NO_OPTION);
            if(opcao == JOptionPane.YES_OPTION){
                excluirBD();
                limpaCampos();
                temDadosNaTela = false;
            }
        } else if(estadoTela == ALTERANDO){
          int opcao = JOptionPane.showConfirmDialog(this, "Deseja realmente salvar a alteração?", "Atenção", JOptionPane.YES_NO_OPTION);
            if(opcao == JOptionPane.YES_OPTION){
              alterarBD();
              limpaCampos();
              temDadosNaTela = false;  
            }
        } else {
                JOptionPane.showMessageDialog(this, "Erro ao confirmar");
            }
        
        estadoTela = PADRAO;
        habilitaCampos(false);
        habilitaBotoes();
    }
    public void cancelar(){
        estadoTela = PADRAO;
        limpaCampos();
        habilitaCampos(false);
        habilitaBotoes();
    }
    
    public void incluirBD(){
        //Esse metodo será definido nas sub-classes
    }
    public void alterarBD(){
        //Esse metodo será definido nas sub-classes
    }
    public void excluirBD(){
        //Esse metodo será definido nas sub-classes
    }
    public void preencherDados(int id){
        //Esse metodo será definido nas sub-classes
    }
    public void criarTabela(){
        
    }
    
    
    public JTable getTabela(){
        tabela = new JTable(){
            @Override
            public boolean isCellEditable(int linha, int coluna){
                return false;
            }
        };
        tabela.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                if(me.getClickCount() == 2){
                    if(estadoTela == PADRAO){
                        preencherDados(Integer.parseInt((String)tabela.getValueAt(tabela.getSelectedRow(), 0)));
                        temDadosNaTela = true;
                        habilitaBotoes();
                    }
                } else {
                    tabela.setFocusable(false);
                }
            }
        });
        return tabela;
    }
    
    public DefaultTableModel getDtm(){
        dtm = new DefaultTableModel();
        return dtm;
    }
}
