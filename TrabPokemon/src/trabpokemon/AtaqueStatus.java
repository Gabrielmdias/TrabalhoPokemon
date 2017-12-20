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
        this.setPpAtual(this.getPpAtual() - 1);
        oponente.setHpAtual(oponente.getHpAtual() - calculoDano(usuario, oponente));
        
        if (this.chance > (int)Math.random() * 100) {
             switch (this.status) {
                case "Confusion":
                    oponente.setConfusion(true);
                    break;
                case "Flinch":
                    oponente.setFinch(true);
                    break;
                default:
                    oponente.setStatus(this.status);
                    break;
            }
        }
    }
}
