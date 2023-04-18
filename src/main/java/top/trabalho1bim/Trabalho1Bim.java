package top.trabalho1bim;

import java.util.Arrays;
import javax.swing.JOptionPane;

public class Trabalho1Bim {

    public static void main(String[] args) {
        int tamanho = 0;
        int aux = 0;
        long tempoExecucaoI = 0;
        long tempoExecucaoS = 0;
        long tempoExecucaoB = 0;
        
        do {
            tamanho = Integer.parseInt(JOptionPane.showInputDialog("Qual sera o tamanho do vetor?"));
            
            if(tamanho < 0) {
                JOptionPane.showMessageDialog(null, "Valor invalido");
                continue;
                
            } else {
                break;
            }
            
        } while(tamanho != 0);
        
        int[] vetorOriginal = new int[tamanho];
        int[] vetorOrdenadoI = new int[tamanho];
        int[] vetorOrdenadoS = new int[tamanho];
        int[] vetorOrdenadoB = new int[tamanho];
        
        for(int i = 0; i < tamanho; i++) {
            aux = Integer.parseInt(JOptionPane.showInputDialog("Informe o " + (i + 1) + " numero:"));
            
            if(aux >= 0){
                vetorOriginal[i] = aux;
                vetorOrdenadoI[i] = aux;
                vetorOrdenadoS[i] = aux;
                vetorOrdenadoB[i] = aux;
            } else {
                JOptionPane.showMessageDialog(null, "Valor invalido!");
                i--;
            }
            
        }
        
        
        insertionSort(vetorOrdenadoI, tempoExecucaoI, vetorOriginal);
        //msg += "\nInsercao: " + Arrays.toString(vetorOrdenadoI) + " " + tempoExecucaoI + "ms";
        selectionSort(vetorOrdenadoS, tempoExecucaoS, vetorOriginal);
        //msg += "\nSelecao: " + Arrays.toString(vetorOrdenadoS) + " " + tempoExecucaoS + "ms";
        bubbleSort(vetorOrdenadoB, tempoExecucaoB, vetorOriginal);
        //msg += "\nBolha: " + Arrays.toString(vetorOrdenadoB) + " " + tempoExecucaoB + "ms";
        
        
    }
    
    public static void insertionSort(int[] vetorOrdenado, long tempoExecucao, int[] vetorOriginal) {
        int chave, j;
        long inicio = System.nanoTime();
        
        
        for(int i = 0; i < vetorOrdenado.length; i++){
            chave = vetorOrdenado[i];
            
            for(j = i - 1;  j >= 0 && vetorOrdenado[j] > chave ; j-- ){
                vetorOrdenado[j + 1] = vetorOrdenado[j];
                
            }
            vetorOrdenado[j + 1] = chave;
            
        }
        
        long fim = System.nanoTime();
        
        tempoExecucao = fim - inicio;
        
        JOptionPane.showMessageDialog(null, "Insercao" 
                + "\nVetor Original: " + Arrays.toString(vetorOriginal)
                + "\nVetor Ordenado: " + Arrays.toString(vetorOrdenado) 
                + "\nTempo de execucao: " + tempoExecucao + "ns");
    }
    
    public static void selectionSort(int[] vetorOrdenado, long tempoExecucao, int[] vetorOriginal) {
        long inicio = System.nanoTime();
        for (int i = 0; i < vetorOrdenado.length - 1; i++) {
            int posMenor = i;
            
            for(int j = i+1; j < vetorOrdenado.length; j++){
                if(vetorOrdenado[j] < vetorOrdenado[posMenor]){
                    posMenor = j;
                }
            }
            
            if(posMenor != i){
                int aux = vetorOrdenado[i];
                vetorOrdenado[i] = vetorOrdenado[posMenor];
                vetorOrdenado[posMenor] = aux;
            }
            
        }
        
        long fim = System.nanoTime();
        tempoExecucao = fim - inicio;
        
        JOptionPane.showMessageDialog(null, "Selecao" 
                + "\nVetor Original: " + Arrays.toString(vetorOriginal)
                + "\nVetor Ordenado: " + Arrays.toString(vetorOrdenado) 
                + "\nTempo de execucao: " + tempoExecucao + "ns");
    }
    
    public static void bubbleSort(int[] vetorOrdenado, long tempoExecucao, int[] vetorOriginal) {
        boolean troca;
        long inicio = System.nanoTime();
        
        do {
            troca = false;
            
            for(int i = 0; i < vetorOrdenado.length - 1; i++) {
                if(vetorOrdenado[i] > vetorOrdenado[i + 1]) {
                    int aux = vetorOrdenado[i];
                    vetorOrdenado[i] = vetorOrdenado[i + 1];
                    vetorOrdenado[i + 1] = aux;
                    troca = true;
                    
                }
                
            }
            
        }while(troca);
        
        long fim = System.nanoTime();
        tempoExecucao = fim - inicio;
        
        JOptionPane.showMessageDialog(null, "Bolha" 
                + "\nVetor Original: " + Arrays.toString(vetorOriginal)
                + "\nVetor Ordenado: " + Arrays.toString(vetorOrdenado) 
                + "\nTempo de execucao: " + tempoExecucao + "ns");
    }
}
