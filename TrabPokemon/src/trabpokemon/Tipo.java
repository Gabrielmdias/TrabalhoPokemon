/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabpokemon;

/**
 *
 * @author gabriel
 */
public enum Tipo {
    NONE("arquivo"),
    BUG("arq"),
    DRAGON("arq");
    
    // adicionar restante depois
    
    private final String tipo;
    
    Tipo(String tipo){
        this.tipo = tipo;
    }
    
}
