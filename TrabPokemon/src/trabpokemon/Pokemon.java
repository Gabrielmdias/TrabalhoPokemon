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
public class Pokemon {
    private int level;
    private double hpAtual, hpMax, atk, def, spe, spd;
    private int modifierAccuracy = 0, 
                modifierEvasion = 0, 
                modifierAtk = 0, 
                modifierSpe = 0, 
                modifierSpd = 0;
    private boolean confusion, finch;
    private Especie especie;
    private Ataque ataque;
    private Status status;
    
    

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public Ataque getAtaque() {
        return ataque;
    }

    public void setAtaque(Ataque ataque) {
        this.ataque = ataque;
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
