
public class Registradora {

    public static void main(String[] args) {
        System.out.println("primeiroBug()");
        primeiroBug();

        System.out.println("\nsegundoBug()");
        segundoBug();

        System.out.println("\nterceiroBug()");
        terceiroBug();

        System.out.println("\nquartoBug()");
        quartoBug();

        System.out.println("\nquintoBug()");
        quintoBug();

//        sextoBug();
    }

    private static double registrarItem(String item, int quantidade) {
        double precoItem = RelacaoPesoPreco.retornaPrecoProduto(item, quantidade);

        /*
        as ordens das condições estavam erradas,
        foram ajustadas para atender os requisitos
         */
        if (QuantidadeMinimaItem.precisaReposicao(item)) {
            if ("leite".equals(item) || "cafe".equals(item)) {
                ReposicaoFornecedor.reporItem(item);
                System.out.println("Fornecedor repor item!");
            }
            if (!DataProjeto.cozinhaEmFuncionamento()) {
                System.out.println("Cozinha fechada!");
                if (ItensPorQuantidade.quantidadeRestanteItens(item) < 0) {
                    System.out.println("Estoque indisponível!");
                    precoItem = 0.0;
                }
                else {
                    System.out.println("Restam "
                            + ItensPorQuantidade.quantidadeRestanteItens(item)
                            + " unidades de " + item);
                }
            }
            else if ("pao".equals(item) || "sanduiche".equals(item) || "torta".equals(item)) {
                ReposicaoCozinha.reporItem(item);
                System.out.println("Cozinha repor item!");
            }
        }

        return precoItem;
    }

    /*
     o item no método RelacaoPesoPreco.retornaPrecoProduto(item, quantidade)
     estava descrito como 'sanduba'
     */
    private static void primeiroBug() {
        DataProjeto.criarDataComCozinhaFuncionando();
        String item = "sanduiche";
        int quantidade = 4;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: R$ %.2f", precoTotal));
    }

    /*
    a qtd na classe ItensPorQuantidade estava errada, tinha 4 ao invés de 16.
    a formula na RelacaoPesoPreco estava incorreta e foi corrigita.
     */
    private static void segundoBug() {
        DataProjeto.criarDataComCozinhaEncerradaMasComDiaUtil();
        String item = "torta";
        int quantidade = 10;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: R$ %.2f", precoTotal));
    }

    /*
    na classe RelacaoPesoPreco o item estava descrito como 'café' (com acento)
    nas classes QuantidadeMinimaItem e ItemPorQuantidade a descrição estava invertida com a do leite.
     */
    private static void terceiroBug() {
        DataProjeto.criarDataComCozinhaFuncionando();
        String item = "cafe";
        int quantidade = 40;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: R$ %.2f", precoTotal));
    }

    /*
    como já tinha resolvido os bugs do item sanduiche e reposição,
    o quartoBug() rodou normal.
     */
    private static void quartoBug() {
        DataProjeto.criarDataComCozinhaFuncionando();
        // Cliente 1
        String item = "sanduiche";
        int quantidade = 20;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: R$ %.2f", precoTotal));

        // Cliente 2
        String item2 = "sanduiche";
        int quantidade2 = 5;

        double precoTotal2 = registrarItem(item2, quantidade2);

        System.out.println(String.format("Valor total: R$ %.2f", precoTotal2));
    }

    /*
    na classe RelacaoPesoPreco foi corrigida a fórmula para calcular o valor do pao
    e adicionado remoção da quantidade.
     */
    private static void quintoBug() {
        DataProjeto.criarDataComCozinhaFuncionando();
        String item = "pao";
        int quantidade = 10;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: R$ %.2f", precoTotal));
    }

    private static void sextoBug() {
        DataProjeto.criarDataComCozinhaEncerradaSemDiaUtil();
        // Cliente 1
        String item = "sanduiche";
        int quantidade = 20;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));

        // Cliente 2
        String item2 = "sanduiche";
        int quantidade2 = 5;

        double precoTotal2 = registrarItem(item2, quantidade2);

        System.out.println(String.format("Valor total: %.2f", precoTotal2));
    }

}
