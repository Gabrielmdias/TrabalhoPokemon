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

    public void setConfusion(boolean confusion) {
        this.confusion = confusion;
    }

    public void setFinch(boolean finch) {
        this.finch = finch;
    }

    public void setModifierAtk(int modifierAtk) {
        this.modifierAtk = modifierAtk;
    }

    public void setModifierDef(int modifierDef) {
        this.modifierDef = modifierDef;
    }

    public void setModifierSpe(int modifierSpe) {
        this.modifierSpe = modifierSpe;
    }

    public void setModifierSpd(int modifierSpd) {
        this.modifierSpd = modifierSpd;
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
    
    public void setStatus(String status) {
        this.status = Status.valueOf(status);
    }
    
    public int modifier(int modifier){
        if(modifier == -6) return 33;
        if(modifier == -5) return 37;
        if(modifier == -4) return 43;
        if(modifier == -3) return 50;
        if(modifier == -2) return 60;
        if(modifier == -1) return 75;
        if(modifier == -0) return 100;
        if(modifier == 1) return 133;
        if(modifier == 2) return 166;
        if(modifier == 3) return 200;
        if(modifier == 4) return 233;
        if(modifier == 5) return 266;
        if(modifier == 6) return 300;
        return 0;
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
        if(this.status == Status.OK) return 1;
        if(this.status == Status.BURN) return 2;
        if(this.status == Status.FROZEN) return 3;
        if(this.status == Status.PARALYSIS) return 4;
        if(this.status == Status.POISON) return 5;
        if(this.status == Status.SLEEP) return 6;
        if(this.status == Status.FAINTED) return 7;
        return 0;
    }
    
}
