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
        scanner.nextLine();
        
        while(scanner.hasNext()){
            int id = Integer.parseInt(scanner.next());
            String nome = scanner.next(), 
                   type = scanner.next();
            double pp = Double.parseDouble(scanner.next()),
                   power = Double.parseDouble(scanner.next()),
                   accuracy = Double.parseDouble(scanner.next());
            String classe = scanner.next();
            String parametros = scanner.next();
            Ataque atk;
            Scanner scannerParametros = new Scanner(parametros).useDelimiter(",|\n");
            switch(classe){
                case "hp":
                    atk = new AtaqueHP( id, 
                                        nome, 
                                        type, 
                                        pp, power, 
                                        accuracy, 
                                        scannerParametros.next(), 
                                        Integer.parseInt(scannerParametros.next()));
                    
                    break;
                case "multihit":
                    atk = new AtaqueMultihit(   id, 
                                                nome, 
                                                type, 
                                                pp, 
                                                power, 
                                                accuracy, 
                                                Integer.parseInt(scannerParametros.next()), 
                                                Integer.parseInt(scannerParametros.next()));
                    break;
                case "modifier":
                    atk = new AtaqueModifier(   id,   
                                                nome, 
                                                type, 
                                                pp, 
                                                power, 
                                                accuracy,   
                                                Integer.parseInt(scannerParametros.next()), 
                                                Integer.parseInt(scannerParametros.next()), 
                                                Integer.parseInt(scannerParametros.next()));
                    break;
                case "fixo":
                    atk = new AtaqueFixo(   id, 
                                            nome, 
                                            type, 
                                            pp, 
                                            power, 
                                            accuracy, 
                                            Integer.parseInt(scannerParametros.next()));
                    break;
                case "status":
                    atk = new AtaqueStatus( id, 
                                            nome, 
                                            type, 
                                            pp, 
                                            power, 
                                            accuracy, 
                                            Integer.parseInt(scannerParametros.next()), 
                                            Integer.parseInt(scannerParametros.next()));
                    break;
                case "charge":
                    atk = new AtaqueCharge(id, nome, type, pp, power, accuracy);
                    break;
                default:
                    atk = new AtaqueComum(id, nome, type, pp, power, accuracy);
                    break;
            }
            ataques.add(atk);
        }
        System.out.println(ataques.size());
        for (int i = 0; i < 165; i++) {
            System.out.println(ataques.get(i).getNome());
        }
        
        
        
        
        scanner = new Scanner(new FileReader("tabelaDeEspecies.txt"))
                .useDelimiter("\t|\n");
        scanner.nextLine();
        while(scanner.hasNext()){
            especies.add(new Especie(Integer.parseInt(scanner.next()), 
                                     scanner.next(), 
                                     scanner.next(), 
                                     scanner.next(), 
                                     Double.parseDouble(scanner.next()), 
                                     Double.parseDouble(scanner.next()), 
                                     Double.parseDouble(scanner.next()),
                                     Double.parseDouble(scanner.next()),
                                     Double.parseDouble(scanner.next())));
        }
        System.out.println("especie1: " + especies.get(0).getNome());
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
