package br.com.cwi.reset.saimonfill;

import java.util.List;

public class AtorService {

    private FakeDatabase fakeDatabase;
    private Ator ator;

    public AtorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    //Confirmar se este método está correto
    public void criarAtor(AtorRequest atorRequest) throws AtorException {
        ator = new Ator(
                atorRequest.getNome(),
                atorRequest.getDataNascimento(),
                atorRequest.getStatusCarreira(),
                atorRequest.getAnoInicioAtividade());

        verificaCamposObrigatorios();

        fakeDatabase.persisteAtor(ator);
    }

    //terminar de implementar a regra do método
    public void verificaCamposObrigatorios() throws AtorException {

        if (ator.getNome().isEmpty()) {
            throw new AtorException("Campo obrigatório não informado. Favor informar o campo 'Nome'.");
        }
        if (ator.getDataNascimento() == null) {
            throw new AtorException("Campo obrigatório não informado. Favor informar o campo 'dataNascimento'.");
        }
    }

    // Demais métodos da classe
}