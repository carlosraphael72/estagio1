
package telas;

import componentes.MeuCampoTexto;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author RAPHAEL
 */
public class TelaGerenciarPais extends TelaCadastro{
    
    private MeuCampoTexto campoPais =  new MeuCampoTexto(20, true, "País");
    private MeuCampoTexto campoSigla = new MeuCampoTexto(2, true, "Sigla");
    
    
    public TelaGerenciarPais(){
        super("Tela Gerenciamendo de Pais");
        adicionaComponente();
        
        pack();
    }
    
    public void adicionaComponente(){
        
        //Label do campo pais
        JLabel jlPais = new JLabel(campoPais.getDica());
        gbc.gridx = 0;
        gbc.gridy = 1;
        jpComponentes.add(jlPais, gbc);
        
        //Campo pais
        gbc.gridx = 1;
        gbc.gridy = 1;
        jpComponentes.add(campoPais, gbc);
        
        //Label sigla
        JLabel jlSigla = new JLabel(campoSigla.getDica());
        gbc.gridx = 2;
        gbc.gridy = 1;
        jpComponentes.add(jlSigla, gbc);
        
        //Campo Sigla
        gbc.gridx = 3;
        gbc.gridy = 1;
        jpComponentes.add(campoSigla, gbc);
        

    }
    

}
