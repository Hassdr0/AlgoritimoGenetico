/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algoritmogenetico;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author UniCesumar
 */
public class Agente {

    private Melhores melhor;
    private int tamanhoGenotipo;
    private int tamanhoPopulacao;
    private int numeroGeracoes;
    private int taxaMutacao;

    public Agente(int tamanhoGenotipo, int tamanhoPopulacao, int numeroGeracoes, int taxaMutacao) {
        this.tamanhoGenotipo = tamanhoGenotipo;
        this.tamanhoPopulacao = tamanhoPopulacao;
        this.numeroGeracoes = numeroGeracoes;
        this.taxaMutacao = taxaMutacao;
    }

    public Individuo run(int numeroParticipantes) {
        Populacao p = new Populacao(tamanhoPopulacao, tamanhoGenotipo);
        int i = 0;
        int[] torneio = new int[numeroParticipantes];
        Random r = new Random();
        boolean flag;

        this.melhor = new Melhores(p.getPopulacao()[tamanhoPopulacao -1], 0);
        while (i < numeroGeracoes) {
            p.ordenarPorFitness();
            for (int j = 0; j < numeroParticipantes; j++) {
                int k = 0;
                int sorteado = r.nextInt(tamanhoPopulacao);

                flag = true;
                while (k < j && flag) {

                    if (torneio[k] == sorteado) {
                        flag = false;
                    }
                    k++;
                }

                if (flag) {
                    torneio[k] = sorteado;
                } else {
                    j--;
                }

            }
            Arrays.sort(torneio);
            for(int k = 0; k <  numeroParticipantes / 2; k+=2){
                Individuo[] filhos = Individuo.cruzamento(p.getPopulacao()[torneio[k]], p.getPopulacao()[torneio[k+1]], taxaMutacao);
                p.inserirIndividuo(torneio[k], filhos[0]); //Inserindo filho
                p.inserirIndividuo(torneio[k+1], filhos[1]); //Inserindo a filha
            }
            
            if(p.getPopulacao()[0].getFitness() < this.melhor.getIndividuo().getFitness()){
                this.melhor.setIndividuo(p.getPopulacao()[0]);
                this.melhor.setGeracao(i);
            }
            i++;
        }
        
        System.out.println("O fitness da nossa melhor solução: " + this.melhor.getIndividuo().getFitness()
        + " A sua geração foi a " + this.melhor.getGeracao());
        return this.melhor.getIndividuo();
    }

}
