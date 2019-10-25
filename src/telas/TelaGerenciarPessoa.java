
package telas;

import componentes.MeuCampoCEP;
import componentes.MeuCampoData;
import componentes.MeuCampoTelefone;
import componentes.MeuCampoTexto;
import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 *
 * @author RAPHAEL
 */
public class TelaGerenciarPessoa extends TelaCadastro {
    private MeuCampoTexto campoEndereco = new MeuCampoTexto(20, true, "Endereço");
    private MeuCampoTexto campoBairro = new MeuCampoTexto(5, true, "Bairro");
    private MeuCampoTexto campoComplemento = new MeuCampoTexto(10, true, "Complemento");
    private MeuCampoCEP campoCEP = new MeuCampoCEP(true, "CEP");
    private JComboBox comboCidade = new JComboBox();
    private MeuCampoTelefone campoTelefone1 = new MeuCampoTelefone(true, "Telefone 1");
    private MeuCampoTelefone campoTelefone2 = new MeuCampoTelefone(false, "Telefone 2");
    private MeuCampoTexto campoEmail = new MeuCampoTexto(20, true, "Email");
    private MeuCampoData campoDataInclusao = new MeuCampoData(true, "Data de inclusão");
    
    
    public TelaGerenciarPessoa(){
        super("Gerenciar Pessoa");
        adicionaComponente();
        
        habilitaCampos(false);
        pack();
    }
    
    public void adicionaComponente(){
        JLabel jlEndereco = new JLabel(campoEndereco.getDica());
        gbc.gridx = 0;
        gbc.gridy = 1;
        jpComponentes.add(jlEndereco, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        jpComponentes.add(campoEndereco, gbc);
        
        JLabel jlBairro = new JLabel(campoBairro.getDica());
        gbc.gridx = 2;
        gbc.gridy = 1;
        jpComponentes.add(jlBairro, gbc);
        
        gbc.gridx = 3;
        gbc.gridy = 1;
        jpComponentes.add(campoBairro, gbc);
        
        JLabel jlComplemento = new JLabel(campoComplemento.getDica());
        gbc.gridx = 4;
        gbc.gridy = 1;
        jpComponentes.add(jlComplemento, gbc);
        
        gbc.gridx = 5;
        gbc.gridy = 1;
        jpComponentes.add(campoComplemento, gbc);
        
        JLabel jlCEP = new JLabel(campoCEP.getDica());
        gbc.gridx = 6;
        gbc.gridy = 1;
        jpComponentes.add(jlCEP, gbc);
        
        gbc.gridx = 7;
        gbc.gridy = 1;
        jpComponentes.add(campoCEP, gbc);
        
        JLabel jlCidade = new JLabel("Cidade");
        gbc.gridx = 8;
        gbc.gridy = 1;
        jpComponentes.add(jlCidade, gbc);
        
        gbc.gridx = 9;
        gbc.gridy = 1;
        jpComponentes.add(comboCidade, gbc);
        
        JLabel jlTelefone1 = new JLabel(campoTelefone1.getDica());
        gbc.gridx = 0;
        gbc.gridy = 2;
        jpComponentes.add(jlTelefone1, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        jpComponentes.add(campoTelefone1, gbc);
        
        JLabel jlTelefone2 = new JLabel(campoTelefone2.getDica());
        gbc.gridx = 2;
        gbc.gridy = 2;
        jpComponentes.add(jlTelefone2, gbc);
        
        gbc.gridx = 3;
        gbc.gridy = 2;
        jpComponentes.add(campoTelefone2, gbc);
        
        JLabel jlEmail = new JLabel(campoEmail.getDica());
        gbc.gridx = 4;
        gbc.gridy = 2;
        jpComponentes.add(jlEmail, gbc);
        
        gbc.gridx = 5;
        gbc.gridy = 2;
        jpComponentes.add(campoEmail, gbc);
        
        JLabel jlDataInclusao = new JLabel(campoDataInclusao.getDica());
        gbc.gridx = 6;
        gbc.gridy = 2;
        jpComponentes.add(jlDataInclusao, gbc);
        
        gbc.gridx = 7;
        gbc.gridy = 2;
        jpComponentes.add(campoDataInclusao, gbc);
    }
}
