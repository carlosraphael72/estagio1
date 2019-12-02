
package telas;

import bd.Conexao;
import componentes.MeuCampoTexto;
import dao.DaoCategoria;
import dao.DaoUF;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import pojo.Categoria;

/**
 *
 * @author RAPHAEL
 */
public class TelaGerenciarCategoria extends TelaCadastro {
    private MeuCampoTexto campoCodigo = new MeuCampoTexto(2, false, "Código", false);
    private MeuCampoTexto campoNome = new MeuCampoTexto(20, true, "Nome", true);
    
    private Categoria categoria = new Categoria();
    private DaoCategoria daoCategoria = new DaoCategoria(categoria);
    
    private DefaultTableModel dtm;
    private JTable tabela = getTabela();
    private String[] colunas = new String[]{"Código", "Nome", "Ativo"};
    
    public TelaGerenciarCategoria(){
        super("Gerenciar Categoria");
        criaTabela();
       adicionaCampo(1,1, campoCodigo);
       adicionaCampo(3,1, campoNome);
        
        pack();
        habilitaCampos(false);
    }
    
     public void criaTabela(){
        dtm = getDtm();
        dtm.setDataVector(dados, colunas);
        List<String[]> dados = Conexao.consultaBanco(daoCategoria.SQLCONSULTAR);
        for(int i = 0;i < dados.size();i++){
            dtm.addRow(dados.get(i));
        }      
        tabela.setModel(dtm);
        adicionaTabela(tabela);
    }
     @Override
     public void incluirBD(){
        categoria.setNome(campoNome.getText());
        categoria.setAtivo(status);
        daoCategoria.incluir();
        criaTabela();
    }
    
     @Override
    public void alterarBD(){
        categoria.setCodigo(Integer.parseInt(campoCodigo.getText()));
        categoria.setNome(campoNome.getText());
        categoria.setAtivo(status);
        daoCategoria.alterar();
        criaTabela();
    }
    
    @Override
    public void excluirBD(){
        categoria.setCodigo(Integer.parseInt(campoCodigo.getText()));
        daoCategoria.excluir();
        criaTabela();
    }
    
    @Override
    public void preencherDados(int codigo){
        categoria.setCodigo(codigo);
        daoCategoria.consultar();
        campoCodigo.setText("" + categoria.getCodigo());
        campoNome.setText(categoria.getNome());
        getStatus(categoria.getAtivo());
        temDadosNaTela = true;
        habilitaBotoes();
        criaTabela();
    }
}
