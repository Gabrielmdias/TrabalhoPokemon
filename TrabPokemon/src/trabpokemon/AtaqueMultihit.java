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

    public AtaqueMultihit(int id, String nome, String tipo, String ppMax, String power, String accuracy, int min, int max) {
        super(id, nome, tipo, ppMax, power, accuracy);
        this.min = min;
        this.max = max;
    }
   

    
    public void efeito(Pokemon usuario, Pokemon oponente) {
        /*O cálculo do dano do ataque é realizado diversas vezes aleatoriamente (a
        checagem de acerto e crítico é feita apenas uma vez no começo). O primeiro
        valor [min] define o número mínimo de vezes que o dano será dado ao oponente,
        enquanto o segundo valor [max] define o número máximo de vezes que o dano
        será aplicado. */
        calculoAcerto(usuario, oponente);
        calculoCritico(usuario);
    }
}
