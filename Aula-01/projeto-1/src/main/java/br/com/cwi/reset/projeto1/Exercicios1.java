package br.com.cwi.reset.projeto1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercicios1 {

    public Integer somarLista(List<Integer> numeros) {
        int soma = 0;
        for (int i = 0; i < numeros.size(); i++) {
            soma += numeros.get(i);
        }
        return soma;
    }

    public Double calcularMedia(List<Integer> numeros) {
        double media = 0.0;
        media = somarLista(numeros) / numeros.size();
        return media;
    }

    public Integer obterMaiorNumero(List<Integer> numeros) {
        int maiorNumero = 0;
        for (int i = 0; i < numeros.size(); i++) {
            int numero1 = numeros.get(i);
            if (numero1 > maiorNumero) {
                maiorNumero = numero1;
            }
        }
        return maiorNumero;
    }

    public String obterPalavraInvertida(String palavra) {
        String palavraInvertida = "";
        for (int i = palavra.length() - 1; i >= 0; i--) {
            palavraInvertida += palavra.charAt(i);
        }
        return palavraInvertida;
    }

    public List<Integer> ordenarLista(List<Integer> numeros) {
        Integer[] vetorNumeros = new Integer[6];
        vetorNumeros = numeros.toArray(new Integer[numeros.size()]);
        int temporario = 0;
        for (int i = 0; i < numeros.size() - 1; i++) {
            for (int j = i + 1; j < numeros.size(); j++) {
                if (vetorNumeros[j] < vetorNumeros[i]) {
                    temporario = vetorNumeros[j];
                    vetorNumeros[j] = vetorNumeros[i];
                    vetorNumeros[i] = temporario;
                }
            }
        }
        return Arrays.asList(vetorNumeros);
    }
}

