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
        List<Integer> numerosOrdenados = new ArrayList<>();
        int temporario = 0;
        for (int i = 0; i < numeros.size() - 1; i++) {
            if (numeros.get(i) < numeros.get(i + 1)) {
                temporario = numeros.get(i);
                numerosOrdenados.add(temporario);
            }
        }
        return numerosOrdenados;
    }
}

