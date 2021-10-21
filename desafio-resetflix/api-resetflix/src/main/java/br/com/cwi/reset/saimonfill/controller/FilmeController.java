package br.com.cwi.reset.saimonfill.controller;

import br.com.cwi.reset.saimonfill.FakeDatabase;
import br.com.cwi.reset.saimonfill.request.FilmeRequest;
import br.com.cwi.reset.saimonfill.service.FilmeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

public class FilmeController {

    @RestController
    @RequestMapping("/filmes")
    public class FilmeController {

        private FilmeService filmeService;

        public FilmeController() {
            this.filmeService = new FilmeService((FakeDatabase.getInstance()));
        }

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public void criarFilme(@RequestBody FilmeRequest filmeRequest) throws Exception {
            this.filmeService.criarFilme(filmeRequest);

        }
    }
}
