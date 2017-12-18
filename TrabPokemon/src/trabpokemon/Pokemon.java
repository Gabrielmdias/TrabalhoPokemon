/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabpokemon;

import static java.lang.Double.max;
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
                modifierDef,
                modifierSpe, 
                modifierSpd;
    private boolean confusion = false, finch = false;

    public Pokemon(Especie especie, int level, ArrayList<Ataque> ataque) {
        this.level = level;
        this.especie = especie;
        this.ataque = ataque;
        this.modifierAccuracy = 0;
        this.modifierAtk = 0;
        this.modifierEvasion = 0;
        this.modifierDef = 0;
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

    public int getLevel() {
        return level;
    }

    public double getHpAtual() {
        return hpAtual;
    }

    public void setHpAtual(double hpAtual) {
        this.hpAtual = hpAtual;
    }

    public void setModifierAccuracy(int modifierAccuracy) {
        this.modifierAccuracy = modifierAccuracy;
    }

    public void setModifierEvasion(int modifierEvasion) {
        this.modifierEvasion = modifierEvasion;
    }
    
    

    public double getAtk() {
        return atk;
    }

    public double getDef() {
        return def;
    }

    public double getSpe() {
        return spe;
    }

    public int getModifierAccuracy() {
        return modifierAccuracy;
    }

    public int getModifierEvasion() {
        return modifierEvasion;
    }

    public int getModifierAtk() {
        return modifierAtk;
    }

    public int getModifierDef() {
        return modifierDef;
    }

    public int getModifierSpe() {
        return modifierSpe;
    }

    public int getModifierSpd() {
        return modifierSpd;
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
   
    public double[] valorAtributo(Pokemon p) {    
        //int esp = p.getEspecie().getId();
        //double baseAtk = b.getEspecies().get(esp).getBaseAtk();
        // retorno = Atributo * ( max(2, 2 + modifier) / max(2, 2 - modifier) ) 
        return new double[]{
            (atk * (max (2, 2 + modifierAtk) / max (2, 2 - modifierAtk))),
            (def * (max (2, 2 + modifierDef) / max (2, 2 - modifierDef))),
            (spe * (max (2, 2 + modifierSpe) / max (2, 2 - modifierSpe))),
            (spd * (max (2, 2 + modifierSpd) / max (2, 2 - modifierSpd)))};
    }

    @Override
    public int compareTo(Pokemon o) {
        return this.status.ordinal();
    }
    
}
