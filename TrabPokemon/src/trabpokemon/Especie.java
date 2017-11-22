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
        if (!tipo1.isEmpty()){
            System.out.println(tipo1);
            this.tipo1 = Tipo.valueOf(tipo1.toUpperCase());
        }
        if (!tipo2.isEmpty()){
            System.out.println(tipo2);
            this.tipo2 = Tipo.valueOf(tipo2.toUpperCase());
        }
        this.baseHp = baseHp;
        this.baseAtk = baseAtk;
        this.baseDef = baseDef;
        this.baseSpe = baseSpe;
        this.baseSpd = baseSpd;
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
