
package telas;

import componentes.MeuCampoCEP;
import componentes.MeuCampoCNPJ;
import componentes.MeuCampoCPF;
import componentes.MeuCampoData;
import componentes.MeuCampoTelefone;
import componentes.MeuCampoTexto;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 *
 * @author RAPHAEL
 */
public class TelaGerenciarPessoa extends TelaCadastro {
    //Pessoa
    private MeuCampoTexto campoEndereco = new MeuCampoTexto(20, true, "Endereço");
    private MeuCampoTexto campoBairro = new MeuCampoTexto(5, true, "Bairro");
    private MeuCampoTexto campoComplemento = new MeuCampoTexto(10, true, "Complemento");
    private MeuCampoCEP campoCEP = new MeuCampoCEP(true, "CEP");
    private JComboBox comboCidade = new JComboBox();
    private MeuCampoTelefone campoTelefone1 = new MeuCampoTelefone(true, "Telefone 1");
    private MeuCampoTelefone campoTelefone2 = new MeuCampoTelefone(false, "Telefone 2");
    private MeuCampoTexto campoEmail = new MeuCampoTexto(20, true, "Email");
    private MeuCampoData campoDataInclusao = new MeuCampoData(true, "Data de inclusão");
    //JCheckBox Tipo de Pessoa
    private JCheckBox jcbPessoaFisica = new JCheckBox("Pessoa Fisica");
    private JCheckBox jcbPessoaJuridica = new JCheckBox("Pessoa Jurídica");
    //Pessoa Fisica
    private MeuCampoTexto campoNome = new MeuCampoTexto(20, true, "Nome");
    private MeuCampoData campoDataNascimento = new MeuCampoData(true, "Data de nascimento");
    private MeuCampoCPF campoCPF = new MeuCampoCPF(true, "CPF");
    private MeuCampoTexto campoMae = new MeuCampoTexto(20, true, "Nome da mãe");
    //Pessoa Juridica
    private MeuCampoTexto campoRazaoSocial = new MeuCampoTexto(20, true, "Razão Social");
    private MeuCampoTexto campoFantasia = new MeuCampoTexto(20, true, "Nome Fantasia");
    private MeuCampoCNPJ campoCNPJ = new MeuCampoCNPJ(true, "CNPJ");
    private MeuCampoTexto campoInscricaoEstadual = new MeuCampoTexto(10, true, "Inscrição Estadual");
    
    
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
        
        //Tipo de Pessoa
        gbc.gridx = 0;
        gbc.gridy = 3;
        jpComponentes.add(jcbPessoaFisica, gbc);
        jcbPessoaFisica.addActionListener(this);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        jpComponentes.add(jcbPessoaJuridica, gbc);
        jcbPessoaJuridica.addActionListener(this);
        
        //Pessoa Fisica
        JLabel jlNome = new JLabel(campoNome.getDica());
        gbc.gridx = 0;
        gbc.gridy = 4;
        jpComponentes.add(jlNome, gbc);
            
        gbc.gridx = 1;
        gbc.gridy = 4;
        jpComponentes.add(campoNome, gbc);
        campoNome.habilitar(false);
        
        JLabel jlDataNascimento = new JLabel(campoDataNascimento.getDica());
        gbc.gridx = 2;
        gbc.gridy = 4;
        jpComponentes.add(jlDataNascimento, gbc);
        
        gbc.gridx = 3;
        gbc.gridy = 4;
        jpComponentes.add(campoDataNascimento, gbc);
        campoDataNascimento.habilitar(false);
        
        JLabel jlCPF = new JLabel(campoCPF.getDica());
        gbc.gridx = 4;
        gbc.gridy = 4;
        jpComponentes.add(jlCPF, gbc);
        
        gbc.gridx = 5;
        gbc.gridy = 4;
        jpComponentes.add(campoCPF, gbc);
        campoCPF.habilitar(false);
        
        JLabel jlMae = new JLabel(campoMae.getDica());
        gbc.gridx = 6;
        gbc.gridy = 4;
        jpComponentes.add(jlMae, gbc);
        
        gbc.gridx = 7;
        gbc.gridy = 4;
        jpComponentes.add(campoMae, gbc);
        campoMae.habilitar(false);
        
        //Pessoa Juridica
        JLabel jlRazaoSocial = new JLabel(campoRazaoSocial.getDica());
        gbc.gridx = 0;
        gbc.gridy = 6;
        jpComponentes.add(jlRazaoSocial, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 6;
        jpComponentes.add(campoRazaoSocial, gbc);
        campoRazaoSocial.habilitar(false);
        
        JLabel jlFantasia = new JLabel(campoFantasia.getDica());
        gbc.gridx = 2;
        gbc.gridy = 6;
        jpComponentes.add(jlFantasia, gbc);
        
        gbc.gridx = 3;
        gbc.gridy = 6;
        jpComponentes.add(campoFantasia, gbc);
        campoFantasia.habilitar(false);
        
        JLabel jlCNPJ = new JLabel(campoCNPJ.getDica());
        gbc.gridx = 4;
        gbc.gridy = 6;
        jpComponentes.add(jlCNPJ, gbc);
        
        gbc.gridx = 5;
        gbc.gridy = 6;
        jpComponentes.add(campoCNPJ, gbc);
        campoCNPJ.habilitar(false);
        
        JLabel jlInscricaoEstadual = new JLabel(campoInscricaoEstadual.getDica());
        gbc.gridx = 6;
        gbc.gridy = 6;
        jpComponentes.add(jlInscricaoEstadual, gbc);
        
        gbc.gridx = 7;
        gbc.gridy = 6;
        jpComponentes.add(campoInscricaoEstadual, gbc);
        campoInscricaoEstadual.habilitar(false);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == jcbPessoaFisica){
            jcbPessoaJuridica.setSelected(false);
            camposPessoaFisica(true);
            camposPessoaJuridica(false);
            
        
            
        } else if(ae.getSource() == jcbPessoaJuridica){
            jcbPessoaFisica.setSelected(false);
            camposPessoaFisica(false);
            camposPessoaJuridica(true);
            
            
        }
    }
    
    public void camposPessoaFisica(boolean status){
        campoNome.habilitar(status);
            campoDataNascimento.habilitar(status);
            campoCPF.habilitar(status);
            campoMae.habilitar(status);
    }
    
    public void camposPessoaJuridica(boolean status){
        campoRazaoSocial.habilitar(status);
        campoFantasia.habilitar(status);
        campoCNPJ.habilitar(status);
        campoInscricaoEstadual.habilitar(status);
    }
}
