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
    
   
    public void carregarTabelas() {
        
    }
    
    public void inicializarJogadores() {
        Scanner scanner = new Scanner(System.in);
        int jogadorMaquina[], qtdePokemon[], especiePokemon[][], levelPokemon[][], atkPokemon1[][], atkPokemon2[][], atkPokemon3[][], atkPokemon4[][];
        jogadorMaquina = new int[2];
        qtdePokemon = new int[2];
        
        for (int k = 0; k < 2; k++) {
            jogadorMaquina[k] = scanner.nextInt();
            qtdePokemon[k] = scanner.nextInt();
            System.out.println("");
            System.out.println("Tipo jogador"+(k+1)+": "+jogadorMaquina[k]);
            System.out.println("Quantidade Pokemon: "+qtdePokemon[k]);
            for (int i = 0; i < qtdePokemon[k]; i++) {
                especiePokemon = new int [2][qtdePokemon[k]];
                levelPokemon = new int [2][qtdePokemon[k]];
                especiePokemon[k][i] = scanner.nextInt();
                levelPokemon[k][i] = scanner.nextInt();
                atkPokemon1 = new int[2][qtdePokemon[k]];
                atkPokemon2 = new int[2][qtdePokemon[k]];
                atkPokemon3 = new int[2][qtdePokemon[k]];
                atkPokemon4 = new int[2][qtdePokemon[k]];
                
                atkPokemon1[k][i] = scanner.nextInt();
                atkPokemon2[k][i] = scanner.nextInt();
                atkPokemon3[k][i] = scanner.nextInt();
                atkPokemon4[k][i] = scanner.nextInt();
                
                System.out.println("Especie: "+ especiePokemon[k][i]);
                System.out.println("Level: "+ levelPokemon[k][i]);
                System.out.println("Atk1: "+atkPokemon1[k][i]);
                System.out.println("Atk2: "+atkPokemon2[k][i]);
                System.out.println("Atk3: "+atkPokemon3[k][i]);
                System.out.println("Atk4: "+atkPokemon4[k][i]);
            }
        }
    }
    
    public void executarTurno() {
        
    }
}
