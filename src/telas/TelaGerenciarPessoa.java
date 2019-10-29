
package telas;

import componentes.MeuCampoCEP;
import componentes.MeuCampoCNPJ;
import componentes.MeuCampoCPF;
import componentes.MeuCampoData;
import componentes.MeuCampoTelefone;
import componentes.MeuCampoTexto;
import componentes.MeuComboBox;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

/**
 *
 * @author RAPHAEL
 */
public class TelaGerenciarPessoa extends TelaCadastro {
    //Pessoa
    private MeuCampoTexto campoEndereco = new MeuCampoTexto(20, true, "Endereço");
    private MeuCampoTexto campoBairro = new MeuCampoTexto(10, true, "Bairro");
    private MeuCampoTexto campoComplemento = new MeuCampoTexto(10, true, "Complemento");
    private MeuCampoCEP campoCEP = new MeuCampoCEP(true, "CEP");
    private MeuComboBox comboCidade = new MeuComboBox(true, "Cidade");
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
        //Pessoa Fisica
        adicionaCampo(1,2, campoNome);
        adicionaCampo(3,2, campoDataNascimento);
        adicionaCampo(5,2, campoCPF);
        adicionaCampo(7,2, campoMae);
        
        //Pessoa Juridica
        adicionaCampo(1,3, campoRazaoSocial);
        adicionaCampo(3,3, campoFantasia);
        adicionaCampo(5,3, campoCNPJ);
        adicionaCampo(7,3, campoInscricaoEstadual);
        
        //Pessoa
        adicionaCampo(1,4, campoEndereco);
        adicionaCampo(3,4, campoBairro);
        adicionaCampo(5,4, campoComplemento);
        adicionaCampo(7,4, campoCEP);
        adicionaCampo(1,5, comboCidade);
        adicionaCampo(3,5, campoTelefone1);
        adicionaCampo(5,5, campoTelefone2);
        adicionaCampo(7,5, campoEmail);
        adicionaCampo(1,6, campoDataInclusao);
        
        adicionaComponente();
        
        habilitaCampos(false);
        pack();
    }
    
    public void adicionaComponente(){
        //Tipo de Pessoa
        gbc.gridx = 0;
        gbc.gridy = 1;
        jpComponentes.add(jcbPessoaFisica, gbc);
        jcbPessoaFisica.addActionListener(this);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        jpComponentes.add(jcbPessoaJuridica, gbc);
        jcbPessoaJuridica.addActionListener(this);
        
        //Pessoa Fisica

        campoNome.habilitar(false);
        campoDataNascimento.habilitar(false);
        campoCPF.habilitar(false);
        campoMae.habilitar(false);
        
        //Pessoa Juridica
    
        campoRazaoSocial.habilitar(false);
        campoFantasia.habilitar(false);
        campoCNPJ.habilitar(false);
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
