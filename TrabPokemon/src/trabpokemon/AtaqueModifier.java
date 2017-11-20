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
public class AtaqueModifier extends Ataque {
    private int mod, n, chance;

    public AtaqueModifier(int id, String nome, String tipo, double ppMax, double power, double accuracy) {
        super(id, nome, tipo, ppMax, power, accuracy);
    }
    
    @Override
    public void efeito() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
