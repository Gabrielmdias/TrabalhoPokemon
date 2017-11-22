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
    NONE("None"),
    BUG("Bug"),
    DRAGON("Dragon"),
    ELECTRIC("Electric"),
    FIGHTING("Fighting"),
    FIRE("Fire"),
    FLYING("Flying"),
    ICE("Ice"),
    GHOST("Ghost"),
    GRASS("Grass"),
    GROUND("Ground"),
    NORMAL("Normal"),
    POISON("Poison"),
    PSYCHIC("Psychic"),
    ROCK("Rock"),
    WATER("Water");
    
    private final String tipo;
    
    Tipo(String tipo){
        this.tipo = tipo;
    }

    
    
}
