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
public abstract class Ataque {
    private int id;
    private String nome;
    private double ppMax, ppAtual, power, accuracy;
    
    public abstract void efeito();
    
    public boolean calculoCritico() {
        return true;
    }
    
    public boolean calculoAcerto() {
        return true;
    }
    
    public double calculoDano() {
        return 0;
    }
}
