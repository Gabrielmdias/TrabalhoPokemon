/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabpokemon;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author gabriel
 */
public class Batalha {

    private final ArrayList<Jogador> jogador = new ArrayList<>();
    private final ArrayList<Especie> especies = new ArrayList<>();
    private final ArrayList<String[]> tabAtk = new ArrayList<>();

    public void carregarTabelas() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("tabelaDeEspecies.txt"))
                .useDelimiter("\t|\n");
        scanner.nextLine();
        while (scanner.hasNext()) {
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

        scanner = new Scanner(new FileReader("tabelaDeAtaques.txt"))
                .useDelimiter("\t|\n");
        scanner.nextLine();
        
        String[] campo = new String[8];
        while (scanner.hasNext()){
            for (int i = 0; i < 8; i++)
                campo[i] = scanner.next().replaceAll(" ", "");
            tabAtk.add(campo);
        }
    }

    public void inicializarJogadores() {
        Scanner scanner = new Scanner(System.in);

        for (int countJogador = 0; countJogador < 2; countJogador++) {
            Jogador j;
            if (scanner.nextInt() > 0)
                j = new Humano();
            else
                j = new Maquina();
            jogador.add(j);
            int qtde = scanner.nextInt();
            for (int countPokemon = 0; countPokemon < qtde; countPokemon++) {    
                Especie especie = especies.get(scanner.nextInt());
                ArrayList<Ataque> atk = new ArrayList<>();
                int level = scanner.nextInt();                
                for (int at = 0; at < 4; at++) {
                    int idAtk;
                    if ((idAtk = scanner.nextInt()) > 0);
                        switch (tabAtk.get(idAtk)[6]) { // [6] para pegar a classe  
                            
                            case "hp":
                                int valor;
                                if (tabAtk.get(idAtk)[7].split(",")[0].trim().equals("max_hp"))
                                    valor = (int) especie.getBaseHp();
                                else
                                    valor = (int) especie.getBaseAtk();
                                atk.add(new AtaqueHP(Integer.parseInt(tabAtk.get(idAtk)[0]),
                                        tabAtk.get(idAtk)[1],
                                        tabAtk.get(idAtk)[2],
                                        tabAtk.get(idAtk)[3],
                                        tabAtk.get(idAtk)[4],
                                        tabAtk.get(idAtk)[5],
                                        valor,
                                        Integer.parseInt(tabAtk.get(idAtk)[7].split(",")[1])));
                                break;
                                
                            case "multihit":
                                atk.add(new AtaqueMultihit(Integer.parseInt(tabAtk.get(idAtk)[0]),
                                        tabAtk.get(idAtk)[1],
                                        tabAtk.get(idAtk)[2],
                                        tabAtk.get(idAtk)[3],
                                        tabAtk.get(idAtk)[4],
                                        tabAtk.get(idAtk)[5],
                                        Integer.parseInt(tabAtk.get(idAtk)[7].split(",")[0]),
                                        Integer.parseInt(tabAtk.get(idAtk)[7].split(",")[1])));
                                break;
                                
                            case "modifier":
                                atk.add(new AtaqueModifier(Integer.parseInt(tabAtk.get(idAtk)[0]),
                                        tabAtk.get(idAtk)[1],
                                        tabAtk.get(idAtk)[2],
                                        tabAtk.get(idAtk)[3],
                                        tabAtk.get(idAtk)[4],
                                        tabAtk.get(idAtk)[5],
                                        tabAtk.get(idAtk)[7].split(",")[0].trim(),
                                        Integer.parseInt(tabAtk.get(idAtk)[7].split(",")[1]),
                                        Integer.parseInt(tabAtk.get(idAtk)[7].split(",")[2])));
                                break;
                                
                            case "fixo":
                                atk.add(new AtaqueFixo(Integer.parseInt(tabAtk.get(idAtk)[0]),
                                        tabAtk.get(idAtk)[1],
                                        tabAtk.get(idAtk)[2],
                                        tabAtk.get(idAtk)[3],
                                        tabAtk.get(idAtk)[4],
                                        tabAtk.get(idAtk)[5],
                                        Integer.parseInt(tabAtk.get(idAtk)[7])));
                                break;
                                
                            case "status":
                                atk.add(new AtaqueStatus(Integer.parseInt(tabAtk.get(idAtk)[0]),
                                        tabAtk.get(idAtk)[1],
                                        tabAtk.get(idAtk)[2],
                                        tabAtk.get(idAtk)[3],
                                        tabAtk.get(idAtk)[4],
                                        tabAtk.get(idAtk)[5],
                                        tabAtk.get(idAtk)[7].split(",")[0].trim(),
                                        Integer.parseInt(tabAtk.get(idAtk)[7].split(",")[1])));
                                break;
                                
                            case "charge":
                                atk.add(new AtaqueCharge(Integer.parseInt(tabAtk.get(idAtk)[0]),
                                        tabAtk.get(idAtk)[1],
                                        tabAtk.get(idAtk)[2],
                                        tabAtk.get(idAtk)[3],
                                        tabAtk.get(idAtk)[4],
                                        tabAtk.get(idAtk)[5]));
                                break;
                                
                            default:
                                break;
                        }
                    }                    
                    j.addPokemon(new Pokemon(especie, level, atk));
                }
            }
        }
    
    public void executarTurno(){
        Collections.sort(jogador.get(0).getPokemons());
        Collections.sort(jogador.get(1).getPokemons());
        
        while(jogador.get(0).getPokemons().get(0).getStatus() != Status.FAINTED && 
                jogador.get(1).getPokemons().get(0).getStatus() != Status.FAINTED ){
            
            int c = 0;
            ArrayList<int[]> comando = new ArrayList<>();
            for (Jogador j : jogador) {
                comando.set(c++, j.escolherComando());
            }
            
            if(comando.get(0)[0] == comando.get(1)[0]){
                if(jogador.get(0).getPokemons().get(0).getSpd() < jogador.get(1).getPokemons().get(0).getSpd()){
                    Collections.swap(jogador, 0, 1);
                    Collections.swap(comando, 0, 1);
                }
            } else if (comando.get(1)[0] == 1){
                Collections.swap(jogador, 0, 1);
                Collections.swap(comando, 0, 1);
            }
        
            for(int i = 0; i < 0; i++){
                switch(comando.get(i)[0]){
                    case 1:
                        jogador.get(i).trocarPokemon(comando.get(i)[1]);
                        break;
                    case 2:
                        jogador.get(i).usarAtaque(comando.get(i)[1]);
                }
            }
        
            //comportamneto dos status
        }
        
    }

}
