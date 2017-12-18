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
public class AtaqueCharge extends Ataque{

    public AtaqueCharge(int id, String nome, String tipo, String ppMax, String power, String accuracy) {
        super(id, nome, tipo, ppMax, power, accuracy);
    }

    public void efeito(Pokemon p) {
        System.out.println("Ataque Charge");
        this.setPpAtual(this.getPpAtual() - 1);
    }

}
