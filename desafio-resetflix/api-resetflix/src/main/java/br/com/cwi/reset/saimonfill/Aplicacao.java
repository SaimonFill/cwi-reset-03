package br.com.cwi.reset.saimonfill;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

public class Aplicacao {

    public static void main(String[] args) throws AtorException {
        FakeDatabase fakeDatabase = new FakeDatabase();

        AtorService atorService = new AtorService(fakeDatabase);

        String nome = "Will Smith";
        LocalDate dataNascimento = LocalDate.of(1968, Month.SEPTEMBER, 25);
        StatusCarreira statusCarreira = StatusCarreira.EM_ATIVIDADE;
        Integer anoInicioAtividade = 1986;
        AtorRequest atorRequest1 = new AtorRequest(nome, dataNascimento, statusCarreira, anoInicioAtividade);

        nome = "Denzel Washington";
        dataNascimento = LocalDate.of(1954, Month.DECEMBER, 28);
        statusCarreira = StatusCarreira.APOSENTADO;
        anoInicioAtividade = 1982;
        AtorRequest atorRequest2 = new AtorRequest(nome, dataNascimento, statusCarreira, anoInicioAtividade);

        nome = "Jennifer Aniston";
        dataNascimento = LocalDate.of(1969, Month.FEBRUARY, 11);
        statusCarreira = StatusCarreira.APOSENTADO;
        anoInicioAtividade = 1990;
        AtorRequest atorRequest3 = new AtorRequest(nome, dataNascimento, statusCarreira, anoInicioAtividade);

        atorService.criarAtor(atorRequest1);
        atorService.criarAtor(atorRequest2);
        atorService.criarAtor(atorRequest3);

        List<Ator> atores = fakeDatabase.recuperaAtores();

        //Lista os atores
        for (Ator ator : atores) {
            System.out.println(ator.toString());
        }
        System.out.println();

        //Lista os atores em atividade
        System.out.println("Atores em atividade:" + atorService.listarAtoresEmAtividade(""));
    }
}