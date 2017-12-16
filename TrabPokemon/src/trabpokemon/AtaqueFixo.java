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
public class AtaqueFixo extends Ataque{
    private int val;    

    public AtaqueFixo(int id, String nome, String tipo, String ppMax, String power, String accuracy, int val) {
        super(id, nome, tipo, ppMax, power, accuracy);
        this.val = val;
    }

    @Override
    public void efeito(Pokemon p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
