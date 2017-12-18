/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabpokemon;

import java.util.Random;

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

    public void setPpAtual(double ppAtual) {
        this.ppAtual = ppAtual;
    }

    public double getPpAtual() {
        return ppAtual;
    }
    
    public String getNome() {
        return nome;
    }    
    
    public void efeito(Pokemon usuario, Pokemon oponente){
        this.ppAtual -= 1;
        if(calculoAcerto(usuario, oponente)){
            oponente.setHpAtual(oponente.getHpAtual() - calculoDano(usuario, oponente));
            System.out.println("Vida pokemon jogador 1 :"+ usuario.getHpAtual());
            System.out.println("Vida pokemon jogador 2 :"+ oponente.getHpAtual());
        }
    }
    
    public boolean calculoCritico(Pokemon p) {
        // speed do atacante / 512
        double chanceCritico;
        chanceCritico = p.getSpd()/512;
        if(Math.random() > chanceCritico)
            return false;
        else 
            return true;
    }
    
    public boolean calculoAcerto(Pokemon usuario, Pokemon oponente) {
            double prob = this.accuracy * (usuario.modifier(usuario.getModifierAccuracy())/oponente.modifier(oponente.getModifierEvasion()));
        return (Math.random() <= prob);
    }
    
    public double calculoDano(Pokemon usuario, Pokemon oponente) {
        int L = usuario.getLevel();
        double P = this.power;
        double A, D, dano;
        
        if(this.tipo.ordinal() < 8){
            A = usuario.getAtk();
            D = oponente.getDef();
        } else {
            A = usuario.getSpe();
            D = oponente.getSpe();
        }
        
        if(calculoAcerto(usuario, oponente))
            L *= 2;
        
        if(usuario.getStatus() == Status.BURN)
            A /= 2;
        
        if(A < 0) A = 0;
        if(A > 255) A = 255;
        if(D < 0) D = 0;
        if(D > 255) D = 255;
        
        dano = (L * A * P / D /50) + 2;
        if (this.tipo == usuario.getEspecie().getTipo1() ||
            this.tipo == usuario.getEspecie().getTipo2()){
            dano *= 1.5;
        }
        double[][] multTipos = {
            {1, 1, 1, 1, 1, 0.5, 1, 0, 1, 1, 1, 1, 1, 1, 1},
            {2, 1, 0.5, 0.5, 1, 2, 0.5, 1, 1, 1, 1, 1, .05, 2, 1},
            {1, 2, 1, 1, 1, 0.5, 2, 1, 1, 1, 2, 0.5, 1, 1, 1},
            {1, 1, 1, 0.5, 0.5, 0.5, 2, 0.5, 1, 1, 2, 1, 1, 1, 1},
            {1, 1, 0, 2, 1, 2, 0.5, 1, 2, 1, 0.5, 2, 1, 1, 1},
            {1, 0.5, 2, 1, 0.5, 1, 2, 1, 2, 1, 1, 1, 1, 2, 1},
            {1, 0.5, 0.5, 2, 1, 1, 1, 0.5, 0.5, 1, 2, 1, 2, 1, 1},
            {0, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 0, 1, 1},
            {1, 1, 1, 1, 1, 0.5, 2, 1, 0.5, 0.5, 2, 1, 1, 2, 0.5},
            {1, 1, 1, 1, 2, 2, 1, 1, 2, 0.5, 0.5, 1, 1, 1, 0.5},
            {1, 1, 0.5, 0.5, 2, 2, 0.5, 1, 0.5, 2, 0.5, 1, 1, 1, 0.5},
            {1, 1, 2, 1, 0, 1, 1, 1, 1, 2, 0.5, 0.5, 1, 1, 0.5},
            {1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 0.5, 1, 1 },
            {1, 1, 2, 1, 2, 1, 1, 1, 1, 0.5, 2, 1, 1, 0.5, 2},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2}
        };
        
        Tipo[] tipos = {Tipo.NORMAL, Tipo.FIGHTING, Tipo.FLYING, 
                        Tipo.POISON, Tipo.GROUND, Tipo.ROCK,
                        Tipo.BUG, Tipo.GHOST, Tipo.FIRE,
                        Tipo.WATER, Tipo.GRASS, Tipo.ELECTRIC,
                        Tipo.PSYCHIC, Tipo.ICE, Tipo.DRAGON};
        int i = 0, j = 0, k = 0;
        while(this.tipo != tipos[i]){
            i++;
        }
        while(oponente.getEspecie().getTipo1() != tipos[j]){
            j++;
        }
        dano *= multTipos[i][j];
        if(oponente.getEspecie().getTipo2() != Tipo.NONE){
            while(oponente.getEspecie().getTipo2() != tipos[j]){
                k++;
            }
            dano *= multTipos[i][k];
        }
        Random rand = new Random();
        int r = rand.nextInt(39)+217;
        dano = (dano * r)/255;
        return dano;
    }
}
