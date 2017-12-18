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
    public int[] escolherComando() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Quer 1-trocar de pokemon ou 2-atacar ?");
        int op1 = scanner.nextInt(),
            op2 = 0,
            i = 0;
        
        if(op1 == 1){
            while(i < this.getPokemons().size()){
                System.out.println(i +": "+ this.getPokemons().get(i).getEspecie().getNome());
                i++;
            }
            System.out.println("Selecione um Pokemón para troca:");
           
        } else {
            while(i < this.getPokemons().get(0).getAtaque().size()){
                System.out.println(i +": "+ this.getPokemons().get(0).getAtaque().get(i).getNome());
                i++;
            }
            System.out.println("Qual ataque utilizar:");
           
        }
        int[] r = {op1, scanner.nextInt()};
        return r;
    }
    
}