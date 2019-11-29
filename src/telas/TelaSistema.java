
package telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author RAPHAEL
 */
public class TelaSistema extends JFrame implements ActionListener {
    public static JDesktopPane jdp =  new JDesktopPane();
    
    private JMenuBar jmb =  new JMenuBar();
    
    private JMenu jmGerenciamento = new JMenu("Gerenciamento");
    private JMenuItem jmiPais = new JMenuItem("Gerenciar País");
    private JMenuItem jmiUF = new JMenuItem("Gerenciar Unidade Federação");
    private JMenuItem jmiCidade = new JMenuItem("Gerenciar Cidade");
    private JMenuItem jmiCategoria = new JMenuItem("Gerenciar Categorias");
    private JMenuItem jmiFabricante = new JMenuItem("Gerenciar Fabricantes");
    private JMenuItem jmiModelo = new JMenuItem("Gerenciar Modelos");
    private JMenuItem jmiProduto = new JMenuItem("Gerenciar Produtos");
    private JMenuItem jmiPessoa = new JMenuItem("Gerenciar Pessoas");
    private JMenuItem jmiCliente = new JMenuItem("Gerenciar Clientes");
    private JMenuItem jmiFornecedor = new JMenuItem("Gerenciar Fornecedores");
    private JMenuItem jmiUsuario = new JMenuItem("Gerenciar Usuários");
    
    private JMenu jmFinanceiro = new JMenu("Movimentações");

    private JMenuItem jmiCaixa = new JMenuItem("Caixa");  
    private JMenuItem jmiContasReceber = new JMenuItem("Contas a Receber");
    private JMenuItem jmiContasPagar = new JMenuItem("Contas a Pagar");
    
    
    public TelaSistema(){
        setTitle("Innove");
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().add(jdp);
        setJMenuBar(jmb);
        jmb.add(jmGerenciamento);
        jmb.add(jmFinanceiro);
        
        jmGerenciamento.add(jmiPais);
        jmGerenciamento.add(jmiUF);
        jmGerenciamento.add(jmiCidade);
        jmGerenciamento.add(jmiCategoria);
        jmGerenciamento.add(jmiFabricante);
        jmGerenciamento.add(jmiModelo);
        jmGerenciamento.add(jmiProduto);
        jmGerenciamento.add(jmiPessoa);
        jmGerenciamento.add(jmiCliente);
        jmGerenciamento.add(jmiFornecedor);
        jmGerenciamento.add(jmiUsuario);
        jmFinanceiro.add(jmiCaixa);
        jmFinanceiro.add(jmiContasReceber);
        jmFinanceiro.add(jmiContasPagar);
        
        jmiPais.addActionListener(this);
        jmiUF.addActionListener(this);
        jmiCidade.addActionListener(this);
        jmiCategoria.addActionListener(this);
        jmiFabricante.addActionListener(this);
        jmiModelo.addActionListener(this);
        jmiProduto.addActionListener(this);
        jmiPessoa.addActionListener(this);
        jmiCliente.addActionListener(this);
        jmiFornecedor.addActionListener(this);
        jmiUsuario.addActionListener(this);
        jmiCaixa.addActionListener(this);
        jmiContasReceber.addActionListener(this);
        jmiContasPagar.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == jmiPais){ 
            
            TelaGerenciarPais telaPais = new TelaGerenciarPais();
            
        } else if (ae.getSource() == jmiUF){
            
            TelaGerenciarUF telaUF = new TelaGerenciarUF();
            
        } else if (ae.getSource() == jmiCidade){
            
            TelaGerenciarCidade telaCidade = new TelaGerenciarCidade();
            
        } else if (ae.getSource() == jmiCategoria){
            
            TelaGerenciarCategoria telaCategoria = new TelaGerenciarCategoria();
            
        } else if (ae.getSource() == jmiFabricante){
            
            TelaGerenciarFabricante telaFabricante = new TelaGerenciarFabricante();
            
        } else if (ae.getSource() == jmiModelo){
            
            TelaGerenciarModelo telaModelo = new TelaGerenciarModelo();
        
        } else if (ae.getSource() == jmiProduto){
            
            TelaGerenciarProduto telaProduto = new TelaGerenciarProduto();
        
        } else if (ae.getSource() == jmiPessoa){
            
            TelaGerenciarPessoa telaPessoa = new TelaGerenciarPessoa();
        
        } else if (ae.getSource() == jmiCliente){
            
            TelaGerenciarCliente telaCliente = new TelaGerenciarCliente();
        
        } else if (ae.getSource() == jmiFornecedor){
            
            TelaGerenciarFornecedor telaFornecedor = new TelaGerenciarFornecedor();
        
        } else if (ae.getSource() == jmiUsuario){
            
            TelaGerenciarUsuario telaUsuario = new TelaGerenciarUsuario();
        
        } else if (ae.getSource() == jmiCaixa){
            TelaCaixa telaCaixa = new TelaCaixa();
        }
      
}
}
