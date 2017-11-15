/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabpokemon;

import java.util.Scanner;

/**
 *
 * @author gabriel
 */
public class Batalha {
    
    private final Jogador[] jogador = new Humano[2];
    private final Jogador[] maquina = new Maquina[2];
    
   
    public void carregarTabelhas() {
        
    }
    
    public void inicializarJogadores() {
        Scanner scanner = new Scanner(System.in);
        int jogadorMaquina, qtdePokemon, especiePokemon, levelPokemon, atkPokemon[];
        jogadorMaquina = scanner.nextInt();
        qtdePokemon = scanner.nextInt();
        System.out.println("Jogador: "+jogadorMaquina);
        System.out.println("Quantidade: "+qtdePokemon);
        for (int i = 0; i < qtdePokemon; i++) {
            especiePokemon = scanner.nextInt();
            levelPokemon = scanner.nextInt();
            atkPokemon = new int[4];
            for (int j = 0; j < 4; j++) {
                atkPokemon[j] = scanner.nextInt();
            }
            System.out.println("Especie: "+ especiePokemon);
            System.out.println("Level: "+ levelPokemon);
            System.out.println("Atk: "+atkPokemon[0]);
            System.out.println("Atk: "+atkPokemon[1]);
            System.out.println("Atk: "+atkPokemon[2]);
            System.out.println("Atk: "+atkPokemon[3]);
        }
        
    }
    
    public void executarTurno() {
        
    }
}
