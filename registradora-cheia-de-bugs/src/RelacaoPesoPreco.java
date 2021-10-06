public class RelacaoPesoPreco {

    public static double retornaPrecoProduto(String item, int qtd) {
        double precoTotal = 0;

        /*
        a fórmula para calcular o preço da fatia estava errada
        primeiro a quantidade tem que ser transformada em Kg para depois multiplicar pelo valor.
         */
        if ("pao".equals(item)) {
            precoTotal = (qtd * 60 * 0.001) * 12.75;
            ItensPorQuantidade.pao -= (qtd * 60);
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
            ItensPorQuantidade.leite -= qtd;
        }

        /*
        o item estava descrito como 'café' (com acento)
        adicionado a subtração da quantidade de itens retirados.
         */
        if ("cafe".equals(item)) {
            precoTotal = 9.56 * qtd;
            ItensPorQuantidade.cafe -= qtd;
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
