/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabpokemon;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabriel
 */
public abstract class Jogador {
    
    private final List<Pokemon> pokemons;

    public Jogador() {
        this.pokemons = new ArrayList<>(6);
    }
    
    
    public abstract void escolherComando();
    
    public void trocarPokemon() {
        
    }
    
    public void usarAtaque() {
        
    }
}
