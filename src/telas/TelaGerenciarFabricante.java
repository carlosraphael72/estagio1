
package telas;

import bd.Conexao;
import componentes.MeuCampoTexto;
import dao.DaoFabricante;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import pojo.Fabricante;

/**
 *
 * @author RAPHAEL
 */
public class TelaGerenciarFabricante extends TelaCadastro {
    private MeuCampoTexto campoCodigo = new MeuCampoTexto(2, false, "Código", false);
    private MeuCampoTexto campoNome = new MeuCampoTexto(20, true, "Nome", true);
    
    private DefaultTableModel dtm;
    private JTable tabela = getTabela();
    private String[] colunas = new String[]{"Código", "Nome", "Ativo"};
    
    private Fabricante fabricante = new Fabricante();
    private DaoFabricante daoFabricante = new DaoFabricante(fabricante);
    
    public TelaGerenciarFabricante(){
        super("Gerenciar Fabricante");
        criaTabela();
        adicionaCampo(1,1, campoCodigo);
        adicionaCampo(3,1, campoNome);
       
        
        pack();
        habilitaCampos(false);
    }
    
public void criaTabela(){
        dtm = getDtm();
        dtm.setDataVector(dados, colunas);
        List<String[]> dados = Conexao.consultaBanco(daoFabricante.SQLCONSULTAR);
        for(int i = 0;i < dados.size();i++){
            dtm.addRow(dados.get(i));
        }      
        tabela.setModel(dtm);
        adicionaTabela(tabela);
    }
     @Override
     public void incluirBD(){
        fabricante.setNome(campoNome.getText());
        fabricante.setAtivo(status);
        daoFabricante.incluir();
        criaTabela();
    }
    
     @Override
    public void alterarBD(){
        fabricante.setCodigo(Integer.parseInt(campoCodigo.getText()));
        fabricante.setNome(campoNome.getText());
        fabricante.setAtivo(status);
        daoFabricante.alterar();
        criaTabela();
    }
    
    @Override
    public void excluirBD(){
        fabricante.setCodigo(Integer.parseInt(campoCodigo.getText()));
        daoFabricante.excluir();
        criaTabela();
    }
    
    @Override
    public void preencherDados(int codigo){
        fabricante.setCodigo(codigo);
        daoFabricante.consultar();
        campoCodigo.setText("" + fabricante.getCodigo());
        campoNome.setText(fabricante.getNome());
        getStatus(fabricante.getAtivo());
        temDadosNaTela = true;
        habilitaBotoes();
        criaTabela();
    }
}
