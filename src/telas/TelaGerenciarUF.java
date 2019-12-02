
package telas;

import bd.Conexao;
import componentes.MeuCampoTexto;
import componentes.MeuDBComboBox;
import dao.DaoPais;
import dao.DaoUF;
import java.util.List;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import pojo.Pais;
import pojo.UF;

/**
 *
 * @author RAPHAEL
 */
public class TelaGerenciarUF extends TelaCadastro {
    private MeuCampoTexto campoCodigo = new MeuCampoTexto(2, false, "Codigo", false);
    private MeuCampoTexto campoNome = new MeuCampoTexto(20, true, "Unidade Federação", true);
    private MeuCampoTexto campoSigla = new MeuCampoTexto(2, true, "Sigla", true);
    private MeuDBComboBox comboPais = new MeuDBComboBox(DaoPais.SQLCOMBOBOX, true, "Pais");
    
    private UF uf = new UF();
    private DaoUF daoUF = new DaoUF(uf);
    private Pais pais = new Pais();
   // private DaoPais daoPais = new DaoPais(pais);
    private String[] colunas = new String[]{"Código", "Estado", "Sigla", "País", "Status"};

    private DefaultTableModel dtm;
    private JTable tabela = getTabela();
    
    
    public TelaGerenciarUF(){
        super("Gerenciar Unidade da Federação");
        criaTabela();
        adicionaCampo(1,1, campoCodigo);
        adicionaCampo(3,1, campoNome);
        adicionaCampo(5,1, campoSigla);
        adicionaCampo(7,1, comboPais);
       
        habilitaCampos(false);
        pack();
    }
    
    public void criaTabela(){
        dtm = getDtm();
        dtm.setDataVector(dados, colunas);
        List<String[]> dados = Conexao.consultaBanco(DaoUF.SQLCONSULTAR);
        for(int i = 0;i < dados.size();i++){
            dtm.addRow(dados.get(i));
        }      
        tabela.setModel(dtm);
        adicionaTabela(tabela);
    }
    
    @Override
    public void incluirBD(){
        uf.setNome(campoNome.getText());
        uf.setSigla(campoSigla.getText());
        uf.setPais(comboPais.getValor());
        uf.setAtivo(status);
        daoUF.incluir();
        criaTabela();
    }
    @Override
    public void alterarBD(){
        uf.setCodigo(Integer.parseInt(campoCodigo.getText()));
        uf.setNome(campoNome.getText());
        uf.setSigla(campoSigla.getText());
        uf.setAtivo(status);
        uf.setPais(comboPais.getValor());
        daoUF.alterar();
        criaTabela();
    }
    @Override
    public void excluirBD(){
        uf.setCodigo(Integer.parseInt(campoCodigo.getText()));
        daoUF.excluir();
        criaTabela();
    }
    
//     public void consultar(){
//        super.consultar();
//        new TelaConsulta("Consulta de UF", new String[] {"Codigo", "Nome", "Sigla","País", "Status"}, DaoUF.SQLCONSULTAR, this);
//    }
     @Override
    public void preencherDados(int codigo){
        uf.setCodigo(codigo);
        daoUF.consultar();
        campoCodigo.setText("" + uf.getCodigo());
        campoNome.setText(uf.getNome());
        campoSigla.setText(uf.getSigla());
        comboPais.setSelectedIndex(uf.getPais());
        getStatus(uf.getAtivo());
        temDadosNaTela = true;
        habilitaBotoes();
        criaTabela();
    }

}
