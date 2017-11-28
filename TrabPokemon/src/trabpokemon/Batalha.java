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
    private List<String[]> tabAtk = new ArrayList<>();

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
        //System.out.println("especie1: " + especies.get(0).getNome());

        scanner = new Scanner(new FileReader("tabelaDeAtaques.txt"))
                .useDelimiter("\t|\n");
        scanner.nextLine();
        String[] campo = new String[8];
        while (scanner.hasNext()) {
            for (int i = 0; i < 8; i++) {
                campo[i] = scanner.next();
            }
            tabAtk.add(campo);
        }
    }

    public void inicializarJogadores() {
        Scanner scanner = new Scanner(System.in);
        int jogadorMaquina[], qtdePokemon[];
        jogadorMaquina = new int[2];
        qtdePokemon = new int[2];

        for (int k = 0; k < 2; k++) {
            jogadorMaquina[k] = scanner.nextInt();
            qtdePokemon[k] = scanner.nextInt();
            System.out.println("");
            System.out.println("Tipo jogador" + (k + 1) + ": " + jogadorMaquina[k]);
            System.out.println("Quantidade Pokemon: " + qtdePokemon[k]);
            if (jogadorMaquina[k] == 0) {
                jogador[k] = new Maquina();
            } else {
                jogador[k] = new Humano();
            }
            for (int i = 0; i < qtdePokemon[k]; i++) {
                Especie especie = especies.get(scanner.nextInt() - 1);
                int lvl = scanner.nextInt();
                ArrayList<Ataque> atk = new ArrayList<>();
                for (int j = 0; j < 4; j++) {
                    int idAtk = scanner.nextInt() - 1;
                    if (idAtk > 0) {
                        tabAtk.get(idAtk);
                        switch (tabAtk.get(idAtk)[6]) {
                            case "hp":
                                int valor;
                                int porcentagem;
                                if (tabAtk.get(idAtk)[7].split(",")[0].equals("max_hp")) {
                                    valor = (int) especie.getBaseHp();
                                } else {
                                    valor = (int) especie.getBaseAtk();
                                }
                                porcentagem = Integer.parseInt(tabAtk.get(idAtk)[7].split(",")[1]);
                                atk.add(new AtaqueHP(Integer.parseInt(tabAtk.get(idAtk)[0]),
                                        tabAtk.get(idAtk)[1],
                                        tabAtk.get(idAtk)[2],
                                        Double.parseDouble(tabAtk.get(idAtk)[3]),
                                        Double.parseDouble(tabAtk.get(idAtk)[4]),
                                        Double.parseDouble(tabAtk.get(idAtk)[5]),
                                        valor,
                                        porcentagem));
                                break;
                            case "multihit":
                                atk.add(new AtaqueMultihit(Integer.parseInt(tabAtk.get(idAtk)[0]), 
                                        tabAtk.get(idAtk)[1], 
                                        tabAtk.get(idAtk)[2], 
                                        Double.parseDouble(tabAtk.get(idAtk)[3]),
                                        Double.parseDouble(tabAtk.get(idAtk)[4]),
                                        Double.parseDouble(tabAtk.get(idAtk)[5]),
                                        Integer.parseInt(tabAtk.get(idAtk)[7].split(",")[0]), 
                                        Integer.parseInt(tabAtk.get(idAtk)[7].split(",")[1])));
                                break;
                            case "modifier":
                                atk.add(new AtaqueModifier(Integer.parseInt(tabAtk.get(idAtk)[0]),
                                        tabAtk.get(idAtk)[1], 
                                        tabAtk.get(idAtk)[2], 
                                        Double.parseDouble(tabAtk.get(idAtk)[3]),
                                        Double.parseDouble(tabAtk.get(idAtk)[4]),
                                        Double.parseDouble(tabAtk.get(idAtk)[5]),
                                        tabAtk.get(idAtk)[7].split(",")[0], 
                                        Integer.parseInt(tabAtk.get(idAtk)[7].split(",")[1]), 
                                        Integer.parseInt(tabAtk.get(idAtk)[7].split(",")[2])));
                                break;
                            case "fixo":

                                break;
                            case "status":

                                break;
                            case "charge":

                                break;
                            default:

                                break;
                        }
                    }
                    Pokemon pokemon = new Pokemon(especie, lvl, atk);
                }

            }

            /* O primeiro parâmetro é um número de 1 a 151 e representa a espécie do
                pokémon descrito;
                 O segundo parâmetro é um número de 1 a 100 e representa o Lvl (Nível)
                do pokémon descrito;
                 Os próximos quatro parâmetros são números de 0 a 165 e representam
                os quatro ataques do pokémon descrito;
                    Note que, mesmo que um pokémon possa ter menos de 4
                ataques, sempre são passados 4 ids por parâmetro;
                    Sendo assim, quando o pokémon não possuir todos os 4 ataques,
                os espaços vazios são representados pelo número 0; */
        }
    }
    
    public void executarTurno() {

    }

}


