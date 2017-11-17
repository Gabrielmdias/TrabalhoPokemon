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
        int opcao, pokemon, ataque;
        System.out.println("Qual a ação deseja tomar?");
        System.out.println("\t1 - Trocar pokemon.");
        System.out.println("\t2 - Escolher ataque.");
        opcao = scanner.nextInt();
        switch(opcao){
            case 1:
                System.out.println("Qual pokemon deseja escolher para trocar?");
                pokemon = scanner.nextInt();
                
                break;
            case 2: 
                System.out.println("Qual ateque deseja utilizar:");
                ataque = scanner.nextInt();
                if(ataque == 1){
                    
                }
                break;
        }
        
    }
    
    
}
