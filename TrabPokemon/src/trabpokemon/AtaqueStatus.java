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
public class AtaqueStatus extends Ataque{
    private int status, chance;


    public AtaqueStatus(int status, int chance, int id, String nome, String tipo, double ppMax, double power, double accuracy) {
        super(id, nome, tipo, ppMax, power, accuracy);
        this.status = status;
        this.chance = chance;
    }
    
    

    @Override
    public void efeito() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
