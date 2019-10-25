
package componentes;

/**
 *
 * @author RAPHAEL
 */
public interface MeuComponente {
    public void limpar();
    public void habilitar(boolean status);
    public boolean eObrigatorio();
    public boolean eValido();
    public boolean eVazio();
    public String getDica();
}
