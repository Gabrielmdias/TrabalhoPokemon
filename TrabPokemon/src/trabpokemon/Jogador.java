/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabpokemon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author gabriel
 */
public abstract class Jogador {
    
    private List<Pokemon> pokemons = new ArrayList<>();

    public Jogador() {
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }
    
    
    
    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
    
    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }
    
    public abstract int[] escolherComando();
    
    public void trocarPokemon(int pokemonPrincipal) {
        Collections.swap(this.getPokemons(), 0, pokemonPrincipal);
    }
    
    public void usarAtaque(int ataque) {
        this.getPokemons().get(0).getAtaque().get(ataque).efeito(this.pokemons.get(0));
    }
}
