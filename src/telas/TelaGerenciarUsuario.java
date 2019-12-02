
package telas;

import componentes.MeuCampoTexto;

/**
 *
 * @author RAPHAEL
 */
public class TelaGerenciarUsuario extends TelaCadastro {
    MeuCampoTexto campoPessoa = new MeuCampoTexto(20, true, "Pessoa", true);
    MeuCampoTexto campoUsuario = new MeuCampoTexto(10, true, "Usuario", true);
    MeuCampoTexto campoSenha = new MeuCampoTexto(10, true, "Senha", true);
    MeuCampoTexto campoNivelDeAcesso = new MeuCampoTexto(10, true, "Nivel de Acesso", true);
    
    public TelaGerenciarUsuario(){
        super("Gerenciar Usuario");
        adicionaCampo(1,1, campoPessoa);
        adicionaCampo(3,1, campoUsuario);
        adicionaCampo(5,1, campoSenha);
        adicionaCampo(7,1, campoNivelDeAcesso);
        
        pack();
    }
}
