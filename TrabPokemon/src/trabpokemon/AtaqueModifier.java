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
    private String mod;
    private int n, chance;

    public AtaqueModifier(int id, String nome, String tipo, String ppMax, String power, String accuracy, String mod, int n, int chance) {
        super(id, nome, tipo, ppMax, power, accuracy);
        this.mod = mod;
        this.n = n;
        this.chance = chance;
    }
    
    @Override
    public void efeito(Pokemon p) {
        
    }
}
