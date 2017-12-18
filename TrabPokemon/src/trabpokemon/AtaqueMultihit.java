/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabpokemon;

import java.util.Random;

/**
 *
 * @author gabriel
 */
public class AtaqueMultihit extends Ataque{
    private int min, max;

    public AtaqueMultihit(int id, String nome, String tipo, String ppMax, String power, String accuracy, int min, int max) {
        super(id, nome, tipo, ppMax, power, accuracy);
        this.min = min;
        this.max = max;
    }
   

    
    public void efeito(Pokemon usuario, Pokemon oponente) {
        this.setPpAtual(this.getPpAtual() - 1);
        calculoAcerto(usuario, oponente);
        calculoCritico(usuario);
   
        Random rand = new Random();
        int vezes = rand.nextInt(this.max+1)+this.min;
        
        oponente.setHpAtual(oponente.getHpAtual() - (vezes * calculoDano(usuario, oponente)));
        
    }
}
