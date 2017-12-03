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
public class Humano extends Jogador{

    public Humano() {
    }
    

    @Override
    public void escolherComando() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Qual é a ação desejada?");
        System.out.println("\t1 - Trocar Pokémon;");
        System.out.println("\t2 - Escolher ataque;");
        switch(scanner.nextInt()){
            case 1:
                System.out.println("Selecione um Pokemón para troca:");
                scanner.nextInt();
                break;
                
            case 2: 
                System.out.println("Selecione um ataque:");
                scanner.nextInt();
                break;
                
            default:
                break;
        }
    }
    
}