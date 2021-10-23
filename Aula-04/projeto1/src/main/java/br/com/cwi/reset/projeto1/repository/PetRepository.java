package br.com.cwi.reset.projeto1.repository;

import br.com.cwi.reset.projeto1.domain.Pet;

import java.util.List;

public interface PetRepository {

    List<Pet> findAll();

    Pet findByNome(String nome);

    Pet save(Pet pet);

    Pet update(Pet pet);

    void delete(Pet pet);
}
