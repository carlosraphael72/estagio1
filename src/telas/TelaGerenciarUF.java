
package telas;

import componentes.MeuCampoTexto;
import componentes.MeuDBComboBox;
import dao.DaoPais;
import dao.DaoUF;
import pojo.UF;

/**
 *
 * @author RAPHAEL
 */
public class TelaGerenciarUF extends TelaCadastro {
    private MeuCampoTexto campoNome = new MeuCampoTexto(20, true, "Unidade Federação");
    private MeuCampoTexto campoSigla = new MeuCampoTexto(2, true, "Sigla");
    private MeuDBComboBox comboPais = new MeuDBComboBox(DaoPais.SQLCOMBOBOX, true, "Pais");
    
    private UF uf = new UF();
    private DaoUF daoUF = new DaoUF(uf);
    
    
    public TelaGerenciarUF(){
        super("Gerenciar Unidade da Federação");
        adicionaCampo(3,1, campoNome);
        adicionaCampo(5,1, campoSigla);
        adicionaCampo(7,1, comboPais);
       
        habilitaCampos(false);
        pack();
    }
    
    @Override
    public void incluirBD(){
        uf.setNome(campoNome.getText());
        uf.setSigla(campoSigla.getText());
        uf.setAtivo(status);
        daoUF.incluir();
    }
    @Override
    public void alterarBD(){
        uf.setCodigo(Integer.parseInt(campoCodigo.getText()));
        uf.setNome(campoNome.getText());
        uf.setSigla(campoSigla.getText());
        uf.setAtivo(status);
        daoUF.alterar();
    }
    @Override
    public void excluirBD(){
        uf.setCodigo(Integer.parseInt(campoCodigo.getText()));
        daoUF.excluir();
    }
    
     public void consultar(){
        super.consultar();
        new TelaConsulta("Consulta de UF", new String[] {"Codigo", "Nome", "Sigla", "Status"}, DaoUF.SQLSELECT, this);
    }
     @Override
    public void preencherDados(int codigo){
        uf.setCodigo(codigo);
        daoUF.consultar();
        campoCodigo.setText("" + uf.getCodigo());
        campoNome.setText(uf.getNome());
        campoSigla.setText(uf.getSigla());
        getStatus(uf.getAtivo());
        temDadosNaTela = true;
        habilitaBotoes();
    }

}
