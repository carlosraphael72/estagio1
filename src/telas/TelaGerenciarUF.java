
package telas;

import componentes.MeuCampoTexto;
import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 *
 * @author RAPHAEL
 */
public class TelaGerenciarUF extends TelaCadastro {
    private MeuCampoTexto campoNome = new MeuCampoTexto(20, true, "Unidade Federação");
    private MeuCampoTexto campoSigla = new MeuCampoTexto(2, true, "Sigla");
    private JComboBox comboPais = new JComboBox();
    
    
    public TelaGerenciarUF(){
        super("Gerenciar Unidade da Federação");
        adicionaComponente();
        
        pack();
    }
    
   public void adicionaComponente(){
       //Label Nome da UF
       JLabel jlNome = new JLabel(campoNome.getDica());
       gbc.gridx = 0;
       gbc.gridy = 1;
       jpComponentes.add(jlNome, gbc);
       
       //Campo nome da UF
       gbc.gridx = 1;
       gbc.gridy = 1;
       jpComponentes.add(campoNome, gbc);
       
       //Label sigla
       JLabel jlSigla = new JLabel(campoSigla.getDica());
       gbc.gridx = 2;
       gbc.gridy = 1;
       jpComponentes.add(jlSigla, gbc);
       
       // Campo Sigla
       gbc.gridx = 3;
       gbc.gridy = 1;
       jpComponentes.add(campoSigla, gbc);
       
       //Label Pais
       JLabel jlPais = new JLabel("Pais");
       gbc.gridx = 4;
       gbc.gridy = 1;
       jpComponentes.add(jlPais, gbc);
       
       //Combo Pais
       gbc.gridx = 5;
       gbc.gridy = 1;
       jpComponentes.add(comboPais, gbc);
   }
}
