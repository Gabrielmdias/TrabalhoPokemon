/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabpokemon;

/**
 *
 * @author gabriel
 */
public class AtaqueHP extends Ataque{
    private int valor;
    private int porcentagem;

    public AtaqueHP(int id, String nome, String tipo, String ppMax, String power, String accuracy, int valor, int porcentagem) {
        super(id, nome, tipo, ppMax, power, accuracy);
        this.valor = valor;
        this.porcentagem = porcentagem;
    }
    
    

    @Override
    public void efeito(Pokemon p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
