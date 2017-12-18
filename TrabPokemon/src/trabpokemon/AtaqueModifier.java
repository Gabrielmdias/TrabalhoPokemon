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
public class AtaqueModifier extends Ataque {
    private String mod;
    private int n, chance;

    public AtaqueModifier(int id, String nome, String tipo, String ppMax, String power, String accuracy, String mod, int n, int chance) {
        super(id, nome, tipo, ppMax, power, accuracy);
        this.mod = mod;
        this.n = n;
        this.chance = chance;
    }
    
    public void efeito(Pokemon usuario, Pokemon oponente) {
        /*Além do cálculo comum de dano, o ataque possui chance de alterar modifiers do
        oponente ou do atacante, sendo que o máximo que um modifier pode chegar é -
        6 até 6. O primeiro valor [mod] apresenta qual modifier será alterado (podendo
        ser Accuracy, Evasion, ATK, DEF, SPE ou SPD). O segundo valor [n] representa
        o quanto o modifier será alterado (valores positivos alteram o modifier do
        atacante e valores negativos alteram o modifier do oponente). O terceiro valor
        [chance] representa a probabilidade em % da mudança do status ocorrer. */
        /*if (this.chance > Math.random() * 100){
            switch(this.mod){
                case "Accuracy":

            }
        }*/
        System.out.println("Ataque modifier");
        this.setPpAtual(this.getPpAtual() - 1);
    }
}
