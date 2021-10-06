public class ItensPorQuantidade {

    static int pao = 3600;
    //estava com 4 tortas, o correto são 16 pedaços.
    static int torta = 16;
    static int sanduiche = 20;
    static int leite = 20;
    static int cafe = 20;

    /*
    método criado para retornar a quantidade restante de itens
     */
    public static int quantidadeRestanteItens(String item) {
        int restante = 0;

        if ("pao".equals(item)) {
            restante = pao;
        }

        if ("torta".equals(item)) {
            restante = torta;
        }
        if ("sanduiche".equals(item)) {
            restante = sanduiche;
        }

        if ("leite".equals(item)) {
            restante = leite;
        }

        if ("cafe".equals(item)) {
            restante = cafe;
        }
        return restante;
    }

    /*
    método criado para setar quantidade em 0 caso a quantidade fique negativa
    se estiver negativo é porque o estoque está zerado e a compra não pode ser concluida
     */
    public static void setQuantidadeZero(String item) {
        if (quantidadeRestanteItens(item) < 0) {
            if ("pao".equals(item)) {
                pao = 0;
            }
            if ("torta".equals(item)) {
                torta = 0;
            }
            if ("sanduiche".equals(item)) {
                sanduiche = 0;
            }
            if ("leite".equals(item)) {
                leite = 0;
            }
            if ("cafe".equals(item)) {
                cafe = 0;
            }
        }
    }
}
