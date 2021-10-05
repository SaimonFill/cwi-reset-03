public class QuantidadeMinimaItem {

    public static boolean precisaReposicao(String item) {
        if ("pao".equals(item)) {
            return ItensPorQuantidade.pao < 600;
        }

        if ("torta".equals(item)) {
            return ItensPorQuantidade.torta < 10;
        }

        /*
        o item estava descrito como 'sanduba'
        alterado condição para a cozinha repor item se tem 1 ou 0 sanduiches
         */
        if ("sanduiche".equals(item)) {
            return ItensPorQuantidade.sanduiche <= 1;
        }

        /*
        item estava trocado por 'cafe'
         */
        if ("leite".equals(item)) {
            return ItensPorQuantidade.leite < 12;
        }

        /*
        item estava trocado por 'leite'
         */
        if ("cafe".equals(item)) {
            return ItensPorQuantidade.cafe < 12;
        }

        return false;
    }
}
