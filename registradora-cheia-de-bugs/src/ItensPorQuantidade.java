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

        if ("paes".equals(item)) {
            restante = pao;
        }

        if ("torta".equals(item)) {
            restante = torta;
        }
        if ("sanduiche".equals(item)) {
            restante = sanduiche;
        }

        if ("cafe".equals(item)) {
            restante = leite;
        }

        if ("leite".equals(item)) {
            restante = cafe;
        }

        return restante;
    }


}
