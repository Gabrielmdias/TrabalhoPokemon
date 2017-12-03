/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabpokemon;

import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class Pokemon {
    private int level;
    private Especie especie;
    private Status status;
    private final ArrayList<Ataque> ataque;
    private double hpAtual, hpMax, atk, def, spe, spd;
    private int modifierAccuracy, 
                modifierEvasion, 
                modifierAtk, 
                modifierSpe, 
                modifierSpd;
    private boolean confusion, finch;

    public Pokemon(Especie especie, int level, ArrayList<Ataque> ataque) {
        this.level = level;
        this.especie = especie;
        this.ataque = ataque;
    }
    

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
   
    public double valorAtributo() {    
        return 0;
    }
    
}
