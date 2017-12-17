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
    private boolean confusion = false, finch = false;
    Batalha b;

    public Pokemon(Especie especie, int level, ArrayList<Ataque> ataque) {
        this.level = level;
        this.especie = especie;
        this.ataque = ataque;
        this.modifierAccuracy = 0;
        this.modifierAtk = 0;
        this.modifierEvasion = 0;
        this.modifierSpd = 0;
        this.modifierSpe = 0;
        this.hpMax = especie.calcularAtributo(level)[0];
        this.hpAtual = this.hpMax;
        this.atk = especie.calcularAtributo(level)[1];
        this.def = especie.calcularAtributo(level)[2];
        this.spe = especie.calcularAtributo(level)[3];
        this.spd = especie.calcularAtributo(level)[4];
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
   
    public double valorAtributo(Pokemon p) {    
        int esp = p.getEspecie().getId();
        double baseAtk = b.getEspecies().get(esp).getBaseAtk();
        return 0;
    }

    @Override
    public int compareTo(Pokemon o) {
        if (this.status == Status.OK)
            return 1;
        if (this.status == Status.OK)
            return 2;
        if (this.status == Status.OK)
            return 1;    
                
        return -1;
    }
    
}
