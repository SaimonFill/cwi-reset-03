public class ReposicaoCozinha {

    static void reporItem(String item) {
        if ("paes".equals(item)) {
            ItensPorQuantidade.pao = 3600;
        }

        /*
        a quantidade de torta preparada deve ser de 64
        porque nos requisitos pede reposição de 4 tortas com 16 fatias.
         */
        if ("torta".equals(item)) {
            ItensPorQuantidade.torta = 64;
        }
        if ("sanduiche".equals(item)) {
            ItensPorQuantidade.sanduiche = 20;
        }
    }
}
