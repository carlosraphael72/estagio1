
package telas;

import bd.Conexao;
import componentes.MeuCampoData;
import componentes.MeuCampoNumero;
import componentes.MeuCampoTexto;
import componentes.MeuDBComboBox;
import dao.DaoCategoria;
import dao.DaoFabricante;
import dao.DaoModelo;
import dao.DaoProduto;
import java.sql.Date;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import pojo.Produto;

/**
 *
 * @author RAPHAEL
 */
public class TelaGerenciarProduto extends TelaCadastro {
    private MeuCampoTexto campoCodigo = new MeuCampoTexto(2, false, "Código", false);
    private MeuCampoTexto campoDescricao = new MeuCampoTexto(20, true, "Descrição", true);
    private MeuCampoNumero campoUnidadeEstoque = new MeuCampoNumero(2, true, "Unidade de Estoque", true);
    private MeuCampoNumero campoUnidadeVenda = new MeuCampoNumero(2, true, "Unidade de Venda", true);
    private MeuDBComboBox comboCategoria = new MeuDBComboBox(DaoCategoria.SQLCOMBOBOX, true, "Categoria");
    private MeuDBComboBox comboFabricante = new MeuDBComboBox(DaoFabricante.SQLCOMBOBOX , true, "Fabricante");
    private MeuDBComboBox comboModelo = new MeuDBComboBox(DaoModelo.SQLCOMBOBOX ,true, "Modelo");
    private MeuCampoNumero campoValorUnitario = new MeuCampoNumero(2, true, "Valor Unitario", true);
    private MeuCampoData campoData = new MeuCampoData(true, "Data");
    
    private String[] colunas = new String[]{"Código","Produto", "Categoria", "Fabricante", "Modelo", "Valor Unitário","Ativo"};
     private DefaultTableModel dtm;
    private JTable tabela = getTabela();
    
    private Produto produto = new Produto();
    private DaoProduto daoProduto = new DaoProduto(produto);
    
    public TelaGerenciarProduto(){
        super("Gerenciar Produto");
        criaTabela();
        adicionaCampo(1,1, campoCodigo);
        adicionaCampo(3,1, campoDescricao);
       // adicionaCampo(5,1, campoUnidadeEstoque);
       // adicionaCampo(7,1, campoUnidadeVenda);
        adicionaCampo(5,1, comboCategoria);
        adicionaCampo(7,1, comboFabricante);
        adicionaCampo(1,2, comboModelo);
        adicionaCampo(3,2, campoValorUnitario);
       // adicionaCampo(7,2, campoData);
        
        pack();
        habilitaCampos(false);
    }
    
    public void criaTabela(){
        dtm = getDtm();
        dtm.setDataVector(dados, colunas);
        List<String[]> dados = Conexao.consultaBanco(daoProduto.SQLCONSULTAR);
        for(int i = 0;i < dados.size();i++){
            dtm.addRow(dados.get(i));
        }      
        tabela.setModel(dtm);
        adicionaTabela(tabela);
    }
     @Override
     public void incluirBD(){
        produto.setDescricao(campoDescricao.getText());
        produto.setCategoria(comboCategoria.getValor());
        produto.setFabricante(comboFabricante.getValor());
        produto.setModelo(comboModelo.getValor());
        produto.setValorUnitario(Double.parseDouble(campoValorUnitario.getText()));
        //produto.setDataInclusao(campoData.getText());
        produto.setAtivo(status);
        daoProduto.incluir();
        criaTabela();
    }
    
     @Override
    public void alterarBD(){
        produto.setCodigo(Integer.parseInt(campoCodigo.getText()));
        produto.setDescricao(campoDescricao.getText());
        produto.setCategoria(comboCategoria.getValor());
        produto.setFabricante(comboFabricante.getValor());
        produto.setModelo(comboModelo.getValor());
        produto.setValorUnitario(Double.parseDouble(campoValorUnitario.getText()));
        produto.setAtivo(status);
        daoProduto.alterar();
        criaTabela();
    }
    
    @Override
    public void excluirBD(){
        produto.setCodigo(Integer.parseInt(campoCodigo.getText()));
        daoProduto.excluir();
        criaTabela();
    }
    
    @Override
    public void preencherDados(int codigo){
        produto.setCodigo(codigo);
        daoProduto.consultar();
        campoCodigo.setText("" + produto.getCodigo());
        campoDescricao.setText(produto.getDescricao());
        comboCategoria.setSelectedIndex(produto.getCategoria());
        comboFabricante.setSelectedIndex(produto.getFabricante());
        comboModelo.setSelectedIndex(produto.getModelo());
        campoValorUnitario.setText(String.valueOf(produto.getValorUnitario()));
        getStatus(produto.getAtivo());
        temDadosNaTela = true;
        habilitaBotoes();
        criaTabela();
    }

}
