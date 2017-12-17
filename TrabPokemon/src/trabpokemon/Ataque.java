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
    private Tipo tipo;
    private double ppMax, ppAtual, power, accuracy;

    public Ataque(int id, String nome, String tipo, String ppMax, String power, String accuracy) {
        this.id = id;
        this.nome = nome;
        this.tipo = Tipo.valueOf(tipo.toUpperCase());
        this.ppMax = Double.valueOf(ppMax);
        this.ppAtual = Double.valueOf(ppMax);
        this.power = Double.valueOf(power);
        this.accuracy = Double.valueOf(accuracy);
    }

    public int getId() {
        return id;
    }    
    
    public String getNome() {
        return nome;
    }    
    
    public abstract void efeito(Pokemon p);
    
    public boolean calculoCritico(Pokemon p) {
        // sspeed do atacante / 512
        double chanceCritico;
        chanceCritico = p.getSpd()/512;
        if(Math.random() > chanceCritico)
            return false;
        else return true;
    }
    
    public boolean calculoAcerto() {
        //this.accuracy * (modifier accuracy do oponente / modifier evasion do oponente)
        
        return true;
    }
    
    public double calculoDano() {
        return 0;
    }
}
