
package telas;

import bd.Conexao;
import componentes.MeuCampoTexto;
import dao.DaoModelo;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import pojo.Modelo;

/**
 *
 * @author RAPHAEL
 */
public class TelaGerenciarModelo extends TelaCadastro {
    private MeuCampoTexto campoCodigo = new MeuCampoTexto(2, false, "Código", false);
    private MeuCampoTexto campoDescricao = new MeuCampoTexto(50, true, "Descrição", true);
    
     private DefaultTableModel dtm;
    private JTable tabela = getTabela();
    private String[] colunas = new String[]{"Código","Descrição","Ativo"};
    
    private Modelo modelo = new Modelo();
    private DaoModelo daoModelo = new DaoModelo(modelo);
    
    public TelaGerenciarModelo(){
        super("Gerenciar Modelo");
        criaTabela();
        adicionaCampo(1,1, campoCodigo);
        adicionaCampo(3,1, campoDescricao);
        
        pack();
        habilitaCampos(false);
    }
    
    public void criaTabela(){
        dtm = getDtm();
        dtm.setDataVector(dados, colunas);
        List<String[]> dados = Conexao.consultaBanco(daoModelo.SQLCONSULTAR);
        for(int i = 0;i < dados.size();i++){
            dtm.addRow(dados.get(i));
        }      
        tabela.setModel(dtm);
        adicionaTabela(tabela);
    }
     @Override
     public void incluirBD(){
        modelo.setDescricao(campoDescricao.getText());
        modelo.setAtivo(status);
        daoModelo.incluir();
        criaTabela();
    }
    
     @Override
    public void alterarBD(){
        modelo.setCodigo(Integer.parseInt(campoCodigo.getText()));
        modelo.setDescricao(campoDescricao.getText());
        modelo.setAtivo(status);
        daoModelo.alterar();
        criaTabela();
    }
    
    @Override
    public void excluirBD(){
        modelo.setCodigo(Integer.parseInt(campoCodigo.getText()));
        daoModelo.excluir();
        criaTabela();
    }
    
    @Override
    public void preencherDados(int codigo){
        modelo.setCodigo(codigo);
        daoModelo.consultar();
        campoCodigo.setText("" + modelo.getCodigo());
        campoDescricao.setText(modelo.getDescricao());
        getStatus(modelo.getAtivo());
        temDadosNaTela = true;
        habilitaBotoes();
        criaTabela();
    }

}
