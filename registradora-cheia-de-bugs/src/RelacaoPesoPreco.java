public class RelacaoPesoPreco {

    public static double retornaPrecoProduto(String item, int qtd) {
        double precoTotal = 0;

        if ("pao".equals(item)) {
            precoTotal = 12.75 * (qtd * 60 / 1000);
        }

        if ("torta".equals(item)) {
            precoTotal = 96.00 * (qtd / 16);
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
