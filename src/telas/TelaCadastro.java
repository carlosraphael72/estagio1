
package telas;

import componentes.MeuComponente;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
//import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
    private boolean temDadosNaTela = false;
    public JPanel jpComponentes = new JPanel();
    private JPanel jpBotoes = new JPanel();
    private JButton jbIncluir = new JButton("Incluir");
    private JButton jbAlterar = new JButton("Alterar");
    private JButton jbExcluir = new JButton("Excluir");
    private JButton jbConsultar = new JButton("Consultar");
    private JButton jbConfirmar = new JButton("Confirmar");
    private JButton jbCancelar = new JButton("Cancelar");
    private JCheckBox jcbAtivo = new JCheckBox("Ativo");
    private JCheckBox jcbInativo = new JCheckBox("Inativo");
    public GridBagConstraints gbc = new GridBagConstraints();
    
    private List<MeuComponente> campos = new ArrayList();
    
    
    public TelaCadastro(String titulo){
        // super(titulo, redimensionado, fechado, maximizado, iconeficado);
        super(titulo, false, true, false, false);
        getContentPane().add(jpComponentes);
        jpComponentes.setLayout(new GridBagLayout());
        getContentPane().add("South", jpBotoes);
        jpBotoes.setLayout(new GridLayout(1, 6));
        adicionaBotao(jbIncluir);
        adicionaBotao(jbAlterar);
        adicionaBotao(jbExcluir);
        adicionaBotao(jbConsultar);
        adicionaBotao(jbConfirmar);
        adicionaBotao(jbCancelar);
        
        adicionaCheckBox();
        
        pack();
        setVisible(true);
        TelaSistema.jdp.add(this);
        habilitaBotoes();
       // habilitaCampos(false);
    }
    
    public void adicionaBotao(JButton botao){
        jpBotoes.add(botao);
        botao.addActionListener(this);
    }
    
    public void adicionaCheckBox(){
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.WEST;
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        jpComponentes.add(jcbAtivo, gbc);
        jcbAtivo.addActionListener(this);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        jpComponentes.add(jcbInativo, gbc);
        jcbInativo.addActionListener(this);
        
    }
    
    public void habilitaBotoes(){
        jbIncluir.setEnabled(estadoTela == PADRAO);
        jbAlterar.setEnabled(estadoTela == PADRAO && temDadosNaTela);
        jbExcluir.setEnabled(estadoTela == PADRAO && temDadosNaTela);
        jbConsultar.setEnabled(estadoTela == PADRAO);
        jbConfirmar.setEnabled(estadoTela != PADRAO);
        jbCancelar.setEnabled(estadoTela != PADRAO);
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
            
        } else if(ae.getSource() == jcbInativo){
            jcbAtivo.setSelected(false);
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
        habilitaBotoes();
    }
    public void confirmar(){
        estadoTela = PADRAO;
        if(!verificaCampos()){
            return;
        }
        if(estadoTela == INCLUINDO){
            incluirBD();
            temDadosNaTela = true;
        }
        if(estadoTela == EXCLUINDO){
            JOptionPane.showConfirmDialog(this, "Deseja realmente excluir?", "Atenção", JOptionPane.YES_NO_OPTION
            );
            int opcao = 0;
            if(opcao == JOptionPane.YES_OPTION){
                limpaCampos();
                temDadosNaTela = false;
            }
        }
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
    public void preencherDados(int id){
        //Esse metodo será definido nas sub-classes
    }
}
