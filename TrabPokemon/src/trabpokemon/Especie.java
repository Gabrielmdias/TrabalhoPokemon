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
public class Especie {
    private int id;
    private String nome;
    private double baseHp, baseAtk, baseDef, baseSpe, baseSpd;
    private Tipo tipo1, tipo2;

    public Especie(int id, String nome, double baseHp, double baseAtk, double baseDef, double baseSpe, double baseSpd, Tipo tipo1, Tipo tipo2) {
        this.id = id;
        this.nome = nome;
        this.baseHp = baseHp;
        this.baseAtk = baseAtk;
        this.baseDef = baseDef;
        this.baseSpe = baseSpe;
        this.baseSpd = baseSpd;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
    }
    
    public double[] calcularAtributo(int L) {
        double atributos[] = new double[5];
        atributos[0] = (2 * baseHp * L) / (100 + L + 10);
        atributos[1] = 2 * baseAtk * L / 100 + 5;
        atributos[2] = 2 * baseDef * L / 100 + 5;
        atributos[3] = 2 * baseSpe * L / 100 + 5;
        atributos[4] = 2 * baseSpd * L / 100 + 5;
        return atributos;
    }
}
