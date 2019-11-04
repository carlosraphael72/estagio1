
package telas;

import componentes.MeuCampoNumero;
import componentes.MeuCampoTexto;
import dao.DaoPais;
import pojo.Pais;

/**
 *
 * @author RAPHAEL
 */
public class TelaGerenciarPais extends TelaCadastro{
    
    //private MeuCampoNumero campoCodigo = new MeuCampoNumero(2, false, "Codigo");
    private MeuCampoTexto campoNome =  new MeuCampoTexto(20, true, "Nome do País");
    private MeuCampoTexto campoSigla = new MeuCampoTexto(2, true, "Sigla");
    
    private Pais pais = new Pais();
    private DaoPais daoPais = new DaoPais(pais);
    
    
    public TelaGerenciarPais(){
        super("Gerenciamento de Pais");
       // adicionaCampo(1,1, campoCodigo);
        adicionaCampo(3,1, campoNome);
        adicionaCampo(5,1, campoSigla);
        
        habilitaCampos(false);
        pack();
    }
    
    
    
    @Override
    public void incluirBD(){
       // pais.setCodigo(Integer.parseInt(campoCodigo.getText()));
        pais.setNome(campoNome.getText());
        pais.setSigla(campoSigla.getText());
        pais.setAtivo(status);
        daoPais.incluir();
    }
    @Override
    public void alterarBD(){
        pais.setCodigo(Integer.parseInt(campoCodigo.getText()));
        pais.setNome(campoNome.getText());
        pais.setSigla(campoSigla.getText());
        pais.setAtivo(status);
        daoPais.alterar();
    }
    @Override
    public void excluirBD(){
        pais.setCodigo(Integer.parseInt(campoCodigo.getText()));
        daoPais.excluir();
    }
    
    public void consultar(){
        super.consultar();
        new TelaConsulta("Consulta de País", new String[] {"Codigo", "Nome", "Sigla", "Status"}, DaoPais.SQLSELECT, this);
    }
    
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
    }

}
