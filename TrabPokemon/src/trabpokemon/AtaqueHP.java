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
public class AtaqueHP extends Ataque{
    private int valor;
    private int porcentagem;

    public AtaqueHP(int id, String nome, String tipo, String ppMax, String power, String accuracy, int valor, int porcentagem) {
        super(id, nome, tipo, ppMax, power, accuracy);
        this.valor = valor;
        this.porcentagem = porcentagem;
    } 

    public void efeito(Pokemon usuario, Pokemon oponente) {
        this.setPpAtual(this.getPpAtual() - 1);
        oponente.setHpAtual(oponente.getHpAtual() - calculoDano(usuario, oponente));
        
        usuario.setHpAtual(usuario.getHpAtual() + (this.valor * this.porcentagem));
        
    }
}
