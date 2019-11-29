
package telas;

import bd.Conexao;
import componentes.MeuCampoNumero;
import componentes.MeuCampoTexto;
import dao.DaoPais;
import java.util.List;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import pojo.Pais;

/**
 *
 * @author RAPHAEL
 */
public class TelaGerenciarPais extends TelaCadastro{
    
    private MeuCampoTexto campoCodigo = new MeuCampoTexto(2, false, "Codigo", false);
    private MeuCampoTexto campoNome =  new MeuCampoTexto(20, true, "Nome do País", true);
    private MeuCampoTexto campoSigla = new MeuCampoTexto(2, true, "Sigla", true);
    
    private Pais pais = new Pais();
    private DaoPais daoPais = new DaoPais(pais);
    
    private String[] colunas = new String[]{"Código", "País", "Sigla", "Ativo"};
    
    //private Vector colunasVec = new  Vector();
    private DefaultTableModel dtm;
    private JTable tabela = getTabela();
    
    public TelaGerenciarPais() /*throws PropertyVetoException*/{
        super("Gerenciamento de Pais");
        criaTabela();
        adicionaCampo(1,1, campoCodigo);
        adicionaCampo(3,1, campoNome);
        adicionaCampo(5,1, campoSigla);
        
        habilitaCampos(false);
        pack();
    }
    
    public void criaTabela(){
        dtm = getDtm();
        dtm.setDataVector(dados, colunas);
        List<String[]> dados = Conexao.consultaBanco(DaoPais.SQLSELECT);
        for(int i = 0;i < dados.size();i++){
            dtm.addRow(dados.get(i));
        }      
        tabela.setModel(dtm);
        adicionaTabela(tabela);
    }
    
    @Override
    public void incluirBD(){
       // pais.setCodigo(Integer.parseInt(campoCodigo.getText()));
        pais.setNome(campoNome.getText());
        pais.setSigla(campoSigla.getText());
        pais.setAtivo(status);
        daoPais.incluir();
        criaTabela();
    }
    @Override
    public void alterarBD(){
        pais.setCodigo(Integer.parseInt(campoCodigo.getText()));
        pais.setNome(campoNome.getText());
        pais.setSigla(campoSigla.getText());
        pais.setAtivo(status);
        daoPais.alterar();
        criaTabela();
    }
    @Override
    public void excluirBD(){
        pais.setCodigo(Integer.parseInt(campoCodigo.getText()));
        daoPais.excluir();
        criaTabela();
    }
    
//    public void consultar(){
//        super.consultar();
//        new TelaConsulta("Consulta de País", new String[] {"Codigo", "Nome", "Sigla", "Status"}, DaoPais.SQLSELECT, this);
//    }
    
    @Override
    public void preencherDados(int codigo){
        pais.setCodigo(codigo);
        daoPais.consultar();
        campoCodigo.setText("" + pais.getCodigo());
        campoNome.setText(pais.getNome());
        campoSigla.setText(pais.getSigla());
        getStatus(pais.getAtivo());
        temDadosNaTela = true;
        habilitaBotoes();
        criaTabela();
    }

}
