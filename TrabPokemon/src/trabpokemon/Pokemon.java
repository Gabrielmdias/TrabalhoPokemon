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
public class Pokemon implements Comparable<Pokemon>{
    private int level;
    private Especie especie;
    private Status status = Status.OK;
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

    public ArrayList<Ataque> getAtaque() {
        return ataque;
    }

    public double getSpd() {
        return spd;
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

    @Override
    public int compareTo(Pokemon o) {
        if (this.status == Status.FAINTED)
            return 2;
        return 1;
    }
    
}
