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
public class Maquina extends Jogador{

    public Maquina() {
    }
    
    
    @Override
    public int[] escolherComando() {
        Random r = new Random();
        int tamanho = getPokemons().get(0).getAtaque().size();        
        int[] retorno = {2, r.nextInt(tamanho)};
        return retorno;
    }
    
}
