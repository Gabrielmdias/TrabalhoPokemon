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
public enum Tipo {
    NORMAL("Normal"),
    FIGHTING("Fighting"),
    FLYING("Flying"),
    POISON("Poison"),
    GROUND("Ground"),
    ROCK("Rock"),
    BUG("Bug"),
    GHOST("Ghost"),
    FIRE("Fire"),
    WATER("Water"),
    ELECTRIC("Electric"),
    GRASS("Grass"),
    ICE("Ice"),
    PSYCHIC("Psychic"),
    DRAGON("Dragon"),
    NONE("None");
    
    private final String tipo;
    
    Tipo(String tipo){
        this.tipo = tipo;
    }

    
    
}
