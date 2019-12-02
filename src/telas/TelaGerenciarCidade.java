
package telas;

import bd.Conexao;
import componentes.MeuCampoTexto;
import componentes.MeuDBComboBox;
import dao.DaoCidade;
import dao.DaoUF;
import java.util.List;
//import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import pojo.Cidade;

/**
 *
 * @author RAPHAEL
 */
public class TelaGerenciarCidade extends TelaCadastro {
    private MeuCampoTexto campoCodigo = new MeuCampoTexto(2, false, "Codigo", false);
    private MeuCampoTexto campoNome = new MeuCampoTexto(20, true, "Nome", true);
    private MeuDBComboBox comboEstado = new MeuDBComboBox(DaoUF.SQLCOMBOBOX, true, "Estado");
    
    private DefaultTableModel dtm;
    private JTable tabela = getTabela();
    private String[] colunas = new String[]{"Código", "Cidade", "UF", "Status"};
    
    private Cidade cidade =  new Cidade();
    private DaoCidade daoCidade = new DaoCidade(cidade);
    
    
    public TelaGerenciarCidade(){
        super("Gerenciar Cidades");
        criaTabela();
       adicionaCampo(1,1, campoCodigo);
       adicionaCampo(3,1, campoNome);
       adicionaCampo(5,1, comboEstado);
       habilitaCampos(false);
        pack();
    }
    
    public void criaTabela(){
        dtm = getDtm();
        dtm.setDataVector(dados, colunas);
        List<String[]> dados = Conexao.consultaBanco(daoCidade.SQLCONSULTAR);
        for(int i = 0;i < dados.size();i++){
            dtm.addRow(dados.get(i));
        }      
        tabela.setModel(dtm);
        adicionaTabela(tabela);
    }
    
    @Override
    public void incluirBD(){
        cidade.setNome(campoNome.getText());
        cidade.setUf(comboEstado.getValor());
        cidade.setAtivo(status);
        daoCidade.incluir();
        criaTabela();
    }
    
    @Override
    public void alterarBD(){
        cidade.setCodigo(Integer.parseInt(campoCodigo.getText()));
        cidade.setNome(campoNome.getText());
        cidade.setUf(comboEstado.getValor());
        cidade.setAtivo(status);
        daoCidade.alterar();
        criaTabela();
    }
    
    @Override
    public void excluirBD(){
        cidade.setCodigo(Integer.parseInt(campoCodigo.getText()));
        daoCidade.excluir();
        criaTabela();
    }
    
    @Override
    public void preencherDados(int codigo){
        cidade.setCodigo(codigo);
        daoCidade.consultar();
        campoCodigo.setText("" + cidade.getCodigo());
        campoNome.setText(cidade.getNome());
        comboEstado.setSelectedIndex(cidade.getUf());
        getStatus(cidade.getAtivo());
        temDadosNaTela = true;
        habilitaBotoes();
        criaTabela();
    }
}
