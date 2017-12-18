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
public class AtaqueStatus extends Ataque {

    private int chance;
    private String status;

    public AtaqueStatus(int id, String nome, String tipo, String ppMax, String power, String accuracy, String status, int chance) {
        super(id, nome, tipo, ppMax, power, accuracy);
        this.status = status;
        this.chance = chance;
    }

    public void efeito(Pokemon usuario, Pokemon oponente) {

        oponente.setHpAtual(oponente.getHpAtual() - calculoDano(usuario, oponente));

        if (this.chance > Math.random() * 100) {
            if ("Confusion".equals(this.status)) {
                oponente.setConfusion(true);
            } else if ("Flinch".equals(this.status)) {
                oponente.setFinch(true);
            } else {
                oponente.setStatus(this.status);
            }
        }
        
        this.setPpAtual(this.getPpAtual() - 1);
    }
}
