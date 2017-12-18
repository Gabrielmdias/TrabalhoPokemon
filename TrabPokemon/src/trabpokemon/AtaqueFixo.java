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
    
    
    public void efeito(Pokemon usuario, Pokemon oponente) {
        if(this.val == usuario.getLevel())
            oponente.setHpAtual(oponente.getHpAtual() - usuario.getLevel());
        else 
            oponente.setHpAtual(oponente.getHpAtual() - this.val);
        this.setPpAtual(this.getPpAtual() - 1);
    }
}
