package br.com.cwi.reset.saimonfill;

import br.com.cwi.reset.saimonfill.exception.AtorException;
import br.com.cwi.reset.saimonfill.model.Ator;
import br.com.cwi.reset.saimonfill.model.Diretor;
import br.com.cwi.reset.saimonfill.model.StatusCarreira;
import br.com.cwi.reset.saimonfill.request.AtorRequest;
import br.com.cwi.reset.saimonfill.request.DiretorRequest;
import br.com.cwi.reset.saimonfill.service.AtorService;
import br.com.cwi.reset.saimonfill.service.DiretorService;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

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
        statusCarreira = StatusCarreira.EM_ATIVIDADE;
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

        System.out.println();

        //Lista os atores em atividade
        System.out.println("Atores em atividade:");
        System.out.println(atorService.listarAtoresEmAtividade(java.util.Optional.of("")));

        System.out.println();

        //Consulta ator por ID
        System.out.println("Consulta por ID:");
        System.out.println(fakeDatabase.consultarAtor(3));

        System.out.println();

        //Consulta todos os atores
        System.out.println("Lista atores:");
        System.out.println(fakeDatabase.consultarAtores());

        //Teste diretores -------------------------------------------------------------------------

        DiretorService diretorService = new DiretorService((fakeDatabase));

        nome = "Saimon Fill";
        dataNascimento = LocalDate.of(1996, Month.NOVEMBER, 15);
        anoInicioAtividade = 2014;
        DiretorRequest diretorRequest1 = new DiretorRequest(nome, dataNascimento, anoInicioAtividade);

        nome = "Natália Camargo";
        dataNascimento = LocalDate.of(1996, Month.FEBRUARY, 12);
        anoInicioAtividade = 2016;
        DiretorRequest diretorRequest2 = new DiretorRequest(nome, dataNascimento, anoInicioAtividade);

        diretorService.cadastrarDiretor(diretorRequest1);
        diretorService.cadastrarDiretor(diretorRequest2);

        List<Diretor> diretores = fakeDatabase.recuperaDiretores();

        //Lista diretores
        System.out.println();
        System.out.println("Lista Diretores:");
        System.out.println(fakeDatabase.listarDiretores(""));

        //Consulta diretor por ID
        System.out.println();
        System.out.println("Consulta diretor por ID:");
        System.out.println(fakeDatabase.consultarDiretor(1));
    }
}