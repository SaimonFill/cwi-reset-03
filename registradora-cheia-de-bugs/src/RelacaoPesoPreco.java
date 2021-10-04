public class RelacaoPesoPreco {

    public static double retornaPrecoProduto(String item, int qtd) {
        double precoTotal = 0;

        if ("pao".equals(item)) {
            precoTotal = 12.75 * (qtd * 60 / 1000);
        }

        /*
        a fórmula para calcular o preço da fatia estava errada
        primeiro tem que divirir o valor total pela qtd de fatias retiradas
        e depois multiplicar pela qtd de fatias que o cliente solicitou.
         */
        if ("torta".equals(item)) {
            precoTotal = (96.00 / 16) * qtd;
            ItensPorQuantidade.torta -= qtd;
        }

        if ("leite".equals(item)) {
            precoTotal = 4.48 * qtd;
        }

        if ("café".equals(item)) {
            precoTotal = 9.56 * qtd;
        }

        /*
        o item estava descrito como 'sanduba'
        adicionado a subtração da quantidade de itens retirados.
         */
        if ("sanduiche".equals(item)) {
            precoTotal = 4.5 * qtd;
            ItensPorQuantidade.sanduiche -= qtd;
        }

        return precoTotal;
    }
}
