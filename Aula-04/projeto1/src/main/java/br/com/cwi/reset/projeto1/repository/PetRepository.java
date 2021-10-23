package br.com.cwi.reset.projeto1.repository;

import br.com.cwi.reset.projeto1.domain.Pet;

import java.util.ArrayList;
import java.util.List;

public class PetRepository {
    
    private List<Pet> pets = new ArrayList<>();
    
    public List<Pet> findAll() {
        return pets;
    }

    public Pet findByNome(String nome) {
        for (Pet pet : pets) {
            if (pet.getNome().equals(nome)) {
                return pet;
            }
        }
        return null;
    }

    public Pet save(Pet pet) {
        pets.add(pet);
        return pet;
    }

    public Pet update(Pet pet) {
        Pet petExistente = findByNome(pet.getNome());

        if (petExistente != null) {
            pets.remove(petExistente);
            pets.add(pet);
            return pet;
        }
        return null;
    }

    public void delete(Pet pet) {
        pets.remove(pet);
    }
}