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
public enum Status {
    OK("Ok"),
    BURN("Burn"),
    FROZEN("Frozen"),
    PARALYSIS("Paralysis"),
    POISON("Poison"),
    SLEEP("Sleep"),
    FAINTED("Fainted");
    
    private final String status;
    
    Status(String status){  
        this.status = status;
    }    
}
