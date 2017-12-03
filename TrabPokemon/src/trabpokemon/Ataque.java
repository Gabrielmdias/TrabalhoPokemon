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

    
    public String getNome() {
        return nome;
    }    
    
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
