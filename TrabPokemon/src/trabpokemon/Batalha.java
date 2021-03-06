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
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author gabriel
 */
public class Batalha {

    private final ArrayList<Jogador> jogador = new ArrayList<>();
    private final ArrayList<Especie> especies = new ArrayList<>();
    private final ArrayList<String[]> tabAtk = new ArrayList<>();

    public ArrayList<Jogador> getJogador() {
        return jogador;
    }

    public ArrayList<Especie> getEspecies() {
        return especies;
    }

    public ArrayList<String[]> getTabAtk() {
        return tabAtk;
    }

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

        while (scanner.hasNext()) {
            String[] campo = new String[8];
            for (int i = 0; i < 8; i++) {
                campo[i] = scanner.next().replaceAll(" ", "");
            }
            tabAtk.add(campo);
        }
    }

    public void inicializarJogadores() {
        Scanner scanner = new Scanner(System.in);

        for (int countJogador = 0; countJogador < 2; countJogador++) {
            Jogador j;
            if (scanner.nextInt() > 0) {
                j = new Humano();
            } else {
                j = new Maquina();
            }
            jogador.add(j);
            int qtde = scanner.nextInt();
            for (int countPokemon = 0; countPokemon < qtde; countPokemon++) {
                Especie especie = especies.get(scanner.nextInt() - 1);
                ArrayList<Ataque> atk = new ArrayList<>();
                int level = scanner.nextInt();
                for (int at = 0; at < 4; at++) {
                    int idAtk;
                    if ((idAtk = scanner.nextInt() - 1) > 0) {
                        switch (tabAtk.get(idAtk)[6]) { // [6] para pegar a classe  
                            case "comum":
                                atk.add(new Ataque(Integer.parseInt(tabAtk.get(idAtk)[0]),
                                        tabAtk.get(idAtk)[1],
                                        tabAtk.get(idAtk)[2],
                                        tabAtk.get(idAtk)[3],
                                        tabAtk.get(idAtk)[4],
                                        tabAtk.get(idAtk)[5]));
                                break;
                            case "hp":
                                int valor;
                                if (tabAtk.get(idAtk)[7].split(",")[0].trim().equals("max_hp")) {
                                    valor = (int) especie.getBaseHp();
                                } else {
                                    valor = (int) especie.getBaseAtk();
                                }
                                atk.add(new AtaqueHP(Integer.parseInt(tabAtk.get(idAtk)[0]),
                                        tabAtk.get(idAtk)[1],
                                        tabAtk.get(idAtk)[2],
                                        tabAtk.get(idAtk)[3],
                                        tabAtk.get(idAtk)[4],
                                        tabAtk.get(idAtk)[5],
                                        valor, 
                                        Double.parseDouble(tabAtk.get(idAtk)[7].split(",")[1])));
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
                }
                j.addPokemon(new Pokemon(especie, level, atk));
            }
        }
        imprimePokemonsJogadores();
    }

    public void executarTurno() {
        
        Collections.sort(jogador.get(0).getPokemons());
        Collections.sort(jogador.get(1).getPokemons());

        if (batalhaAcabou()) {
            
            ArrayList<int[]> comando = new ArrayList<>();
            for (Jogador j : jogador) {
                if(jogador.get(0).getPokemons().get(0).getHpAtual() >= 0 || jogador.get(1).getPokemons().get(0).getHpAtual() >= 0){
                System.out.println("Jogador "+ (jogador.indexOf(j) + 1));
                comando.add(j.escolherComando());
                }
                else {
                    System.out.println("Acabou");
                    System.exit(0);
                }
            }

            if (comando.get(0)[0] == 1) { // se comando do jogador 0 for trocar pokemon
                System.out.println("Jogador 1 realizou uma troca");
                jogador.get(0).trocarPokemon(comando.get(0)[1]);
            }
            if (comando.get(1)[0] == 1) { // se comando do jogador 1 for trocar pokemon
                System.out.println("Jogador 2 realizou uma troca");
                jogador.get(1).trocarPokemon(comando.get(1)[1]);
            }

            if (jogador.get(0).getPokemons().get(0).getSpd() >= jogador.get(1).getPokemons().get(0).getSpd()) { //Ataque
                // pokemon do jogador 0 mais rapido primeiro
                if (comando.get(0)[0] == 2 && (jogador.get(0).getPokemons().get(0).getHpAtual() >= 0)) {
                    jogador.get(0).usarAtaque(comando.get(0)[1], jogador.get(0).getPokemons().get(0), jogador.get(1).getPokemons().get(0));
                    if(jogador.get(1).getPokemons().get(0).getHpAtual() <= 0){
                        jogador.get(1).getPokemons().get(0).setHpAtual(0);
                        jogador.get(1).getPokemons().get(0).setStatus(Status.FAINTED);
                        //System.out.println("Vida pokemon jogador 1 :"+ jogador.get(0).getPokemons().get(0).getHpAtual());
                       // System.out.println("Vida pokemon jogador 2 :"+ jogador.get(1).getPokemons().get(0).getHpAtual());
                        System.out.println("Jogador 1 ganhou");
                    }
                }
                if (comando.get(1)[0] == 2 && (jogador.get(1).getPokemons().get(0).getHpAtual() >= 0)) {
                    jogador.get(1).usarAtaque(comando.get(1)[1], jogador.get(1).getPokemons().get(0), jogador.get(0).getPokemons().get(0));
                    if(jogador.get(0).getPokemons().get(0).getHpAtual() <= 0){
                        jogador.get(0).getPokemons().get(0).setHpAtual(0);
                        jogador.get(0).getPokemons().get(0).setStatus(Status.FAINTED);
                        //System.out.println("Vida pokemon jogador 1 :"+ jogador.get(0).getPokemons().get(0).getHpAtual());
                       // System.out.println("Vida pokemon jogador 2 :"+ jogador.get(1).getPokemons().get(0).getHpAtual());
                        System.out.println("Jogador 2 ganhou");
                    }
                }
            } else {
                //pokemon do jogador 1 mais rapido primeiro
                if (comando.get(1)[0] == 2 && (jogador.get(1).getPokemons().get(0).getHpAtual() >= 0)) {
                    jogador.get(1).usarAtaque(comando.get(1)[1], jogador.get(1).getPokemons().get(0), jogador.get(0).getPokemons().get(0));
                    if(jogador.get(0).getPokemons().get(0).getHpAtual() <= 0){
                        jogador.get(0).getPokemons().get(0).setHpAtual(0);
                        jogador.get(0).getPokemons().get(0).setStatus(Status.FAINTED);
                        //System.out.println("Vida pokemon jogador 1 :"+ jogador.get(0).getPokemons().get(0).getHpAtual());
                        //System.out.println("Vida pokemon jogador 2 :"+ jogador.get(1).getPokemons().get(0).getHpAtual());
                        System.out.println("Jogador 2 ganhou");
                    }
                }
                if (comando.get(0)[0] == 2 && (jogador.get(0).getPokemons().get(0).getHpAtual() >= 0)) {
                    jogador.get(0).usarAtaque(comando.get(0)[1], jogador.get(0).getPokemons().get(0), jogador.get(1).getPokemons().get(0));
                    if(jogador.get(1).getPokemons().get(0).getHpAtual() <= 0){
                        jogador.get(1).getPokemons().get(0).setHpAtual(0);
                        jogador.get(1).getPokemons().get(0).setStatus(Status.FAINTED);
                        //System.out.println("Vida pokemon jogador 1 :"+ jogador.get(0).getPokemons().get(0).getHpAtual());
                        //System.out.println("Vida pokemon jogador 2 :"+ jogador.get(1).getPokemons().get(0).getHpAtual());
                        System.out.println("Jogador 1 ganhou");
                    }
                }
            }
            System.out.println("Vida pokemon jogador 1 :"+ jogador.get(0).getPokemons().get(0).getHpAtual());
            System.out.println("Vida pokemon jogador 2 :"+ jogador.get(1).getPokemons().get(0).getHpAtual());
            imprimePokemonsJogadores();
        } else {
            System.out.println("Acabou");
            System.exit(0);
        }
        

    }

    public boolean batalhaAcabou() {
        Collections.sort(jogador.get(0).getPokemons());
        Collections.sort(jogador.get(1).getPokemons());
        if (!jogador.get(0).getPokemons().get(0).getStatus().equals(Status.FAINTED)
                || !jogador.get(1).getPokemons().get(0).getStatus().equals(Status.FAINTED)) {
            return true;
        } else {
            return false;
        }
    }
    
    public void imprimePokemonsJogadores(){
        for (int i = 0; i < 2; i++) {
            System.out.println("Jogador " + (i+1));
            System.out.println("Quantidade pokemon: " + verificaFainted(jogador.get(i).getPokemons()) + "/"+jogador.get(i).getPokemons().size());
            for (int j = 0; j < jogador.get(i).getPokemons().size(); j++) {
                System.out.println("Pokemon "+ (j+1) + " especie: "+ jogador.get(i).getPokemons().get(j).getEspecie().getNome());
                System.out.println("Level: "+ jogador.get(i).getPokemons().get(j).getLevel());
                for (int k = 0; k < jogador.get(i).getPokemons().get(j).getAtaque().size(); k++) {
                    System.out.println("Ataque pokemon: "+ jogador.get(i).getPokemons().get(j).getAtaque().get(k).getNome());
                }
            }
            System.out.println("");
        }
    }
    
    public int verificaFainted(List<Pokemon> time){
        int qtd = time.size();
        for(Pokemon pokemon : time){
            if(pokemon.getStatus().equals(Status.FAINTED)){
                qtd--;
            }
        }
        return qtd;
    }
}
