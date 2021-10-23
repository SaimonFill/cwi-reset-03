package br.com.cwi.reset.projeto1.controller;

import br.com.cwi.reset.projeto1.domain.Filme;
import br.com.cwi.reset.projeto1.domain.Pet;
import br.com.cwi.reset.projeto1.exception.FilmeJaExistenteException;
import br.com.cwi.reset.projeto1.exception.FilmeNaoExistenteException;
import br.com.cwi.reset.projeto1.exception.PetJaExistenteException;
import br.com.cwi.reset.projeto1.exception.PetNaoExistenteException;
import br.com.cwi.reset.projeto1.service.PetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {

    private PetService petService = new PetService();

    @GetMapping
    public List<Pet> getPet() {
        return petService.listarTodos();
    }

    @GetMapping("/{nome}")
    public Pet getById(@PathVariable String nome) {
        return petService.buscarPorNome(nome);
    }

    @PostMapping
    public Pet cadastrarPet(@RequestBody Pet pet) throws FilmeJaExistenteException {
        return petService.cadastrarPet(pet);
    }

    @PutMapping
    public void atualizarPet(@RequestBody Pet pet) throws PetNaoExistenteException, PetJaExistenteException {
        petService.atualizarPet(pet);
    }

    @DeleteMapping("/{nome}")
    public void deletarPet(@PathVariable String nome) throws FilmeNaoExistenteException {
        petService.deletarPet(nome);
    }

}
