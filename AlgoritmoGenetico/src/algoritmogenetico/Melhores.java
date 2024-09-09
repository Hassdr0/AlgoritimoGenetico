/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algoritmogenetico;

/**
 *
 * @author UniCesumar
 */
public class Melhores {
    private Individuo individuo;
    private int geracao;

    public Melhores(Individuo individuo, int geracao) {
        this.individuo = individuo;
        this.geracao = geracao;
    }

    public Individuo getIndividuo() {
        return individuo;
    }

    public void setIndividuo(Individuo individuo) {
        this.individuo = individuo;
    }

    public int getGeracao() {
        return geracao;
    }

    public void setGeracao(int geracao) {
        this.geracao = geracao;
    }
    
    
    
}
