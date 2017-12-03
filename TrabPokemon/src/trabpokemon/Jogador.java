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
    
    private List<Pokemon> pokemons = new ArrayList<>();

    public Jogador() {
    }
    
    
    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
    
    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }
    
    public void escolherComando() {
        
    }
    
    public void trocarPokemon() {
        
    }
    
    public void usarAtaque() {
        
    }
}
