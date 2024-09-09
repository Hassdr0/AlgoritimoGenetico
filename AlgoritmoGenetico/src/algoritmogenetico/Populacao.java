/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algoritmogenetico;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author UniCesumar
 */
public class Populacao{

    private Individuo populacao[];

    public Populacao(int tamanhoPopulacao, int tamanhoGenotipo) {
        this.populacao = this.inicializarPopulacao(tamanhoPopulacao, tamanhoGenotipo);
    }

    private Individuo[] inicializarPopulacao(int tamanhoPopulacao, int tamanhoGenotipo) {
        Individuo retorno[] = new Individuo[tamanhoPopulacao];

        for (int i = 0; i < tamanhoPopulacao; i++) {
            retorno[i] = new Individuo(tamanhoGenotipo);
        }
        return retorno;
    }
    
    public void imprimirPopulacao(){
        for(int i = 0; i < this.populacao.length; i++){
            System.out.print("Individuo numero " + i + " ");
            this.populacao[i].imprimirIndividuo();
        }
    
    }
    
     public void ordenarPorFitness() {
        Arrays.sort(this.populacao, Comparator.comparingInt(Individuo::getFitness));
    }

    public Individuo[] getPopulacao() {
        return populacao;
    }
    
    public void inserirIndividuo(int index, Individuo individuo){
        this.populacao[index] = individuo;
    }
    
    
}
