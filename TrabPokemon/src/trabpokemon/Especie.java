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
    private Tipo tipo1 = Tipo.NONE, tipo2 = Tipo.NONE;
    private double baseHp, baseAtk, baseDef, baseSpe, baseSpd;

    public Especie(int id, String nome, String tipo1, String tipo2, double baseHp, double baseAtk, double baseDef, double baseSpe, double baseSpd) {
        this.id = id;
        this.nome = nome;
        if (!tipo1.isEmpty())
            this.tipo1 = Tipo.valueOf(tipo1.toUpperCase());
        if (!tipo2.isEmpty())
            this.tipo2 = Tipo.valueOf(tipo2.toUpperCase());
        this.baseHp = baseHp;
        this.baseAtk = baseAtk;
        this.baseDef = baseDef;
        this.baseSpe = baseSpe;
        this.baseSpd = baseSpd;
    }

    
    public double[] calcularAtributo(int l) {
        return new double[]{
            (2 * baseHp * l) / (100 + l + 10),
            2 * baseAtk * l / 100 + 5,
            2 * baseDef * l / 100 + 5,
            2 * baseSpe * l / 100 + 5,
            2 * baseSpd * l / 100 + 5};
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Tipo getTipo1() {
        return tipo1;
    }

    public Tipo getTipo2() {
        return tipo2;
    }

    public double getBaseHp() {
        return baseHp;
    }

    public double getBaseAtk() {
        return baseAtk;
    }

    public double getBaseDef() {
        return baseDef;
    }

    public double getBaseSpe() {
        return baseSpe;
    }

    public double getBaseSpd() {
        return baseSpd;
    }
    
    
}
