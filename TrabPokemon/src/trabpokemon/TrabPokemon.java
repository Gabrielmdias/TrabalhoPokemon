/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabpokemon;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriel
 */
public class TrabPokemon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Batalha batalha = new Batalha();
        
        try {
            batalha.carregarTabelas();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TrabPokemon.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        batalha.inicializarJogadores();
        batalha.executarTurno();

    }    
}
