/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabpokemon;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author gabriel
 */
public class Batalha {
    
    private final Jogador[] jogador = new Jogador[2];
    private List<Especie> especies = new ArrayList<>();
    private List<Ataque> ataques = new ArrayList<>();
    
   
    public void carregarTabelas() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("tabelaDeAtaques.txt"))
                .useDelimiter("\t|\n");
        String classe, parametros;
        while(scanner.hasNext()){
            /*int id = scanner.nextInt();
            String nome = scanner.next();
            if(String tipo == scanner.next()){
            
        }*/
            
            ataques.add(new Ataque(scanner.nextInt(), 
                                   scanner.next(), 
                                   scanner.next(), 
                                   scanner.nextDouble(), 
                                   scanner.nextDouble(), 
                                   scanner.nextDouble()) {
                @Override
                public void efeito() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });
            classe = scanner.next();
            parametros = scanner.next();
        }
        
        scanner = new Scanner(new FileReader("tabelaDeEspecies.txt"))
                .useDelimiter("\t|\n");
        while(scanner.hasNext()){
            especies.add(new Especie(scanner.nextInt(), 
                                     scanner.next(), 
                                     scanner.next(), 
                                     scanner.next(), 
                                     scanner.nextDouble(), 
                                     scanner.nextDouble(), 
                                     scanner.nextDouble(),
                                     scanner.nextDouble(),
                                     scanner.nextDouble()));
        }
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
            if(jogadorMaquina[k] == 0){
                jogador[k] = new Maquina();
            }
            for (int i = 0; i < qtdePokemon[k]; i++) {
                Pokemon pokemon = new Pokemon();
               //Especie especie = new Especie(i, nome, i, k, i, i, i, Tipo.FIRE, Tipo.FIRE);
                
                
                
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
