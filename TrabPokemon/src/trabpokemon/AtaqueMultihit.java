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
public class AtaqueMultihit extends Ataque{
    private int min, max;

    public AtaqueMultihit(int id, String nome, String tipo, double ppMax, double power, double accuracy, int min, int max) {
        super(id, nome, tipo, ppMax, power, accuracy);
        this.min = min;
        this.max = max;
    }

    

    @Override
    public void efeito() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
