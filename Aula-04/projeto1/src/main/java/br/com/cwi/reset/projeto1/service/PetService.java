package br.com.cwi.reset.projeto1.service;

import br.com.cwi.reset.projeto1.domain.Pet;
import br.com.cwi.reset.projeto1.exception.FilmeNaoExistenteException;
import br.com.cwi.reset.projeto1.exception.PetJaExistenteException;
import br.com.cwi.reset.projeto1.exception.PetNaoExistenteException;
import br.com.cwi.reset.projeto1.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public List<Pet> listarTodos() {
        return petRepository.findAll();
    }

    public Pet buscarPorNome(String nome) {
        return petRepository.findByNome(nome);
    }

    public Pet cadastrarPet(Pet pet) throws PetJaExistenteException {
        Pet petExistente = petRepository.findByNome(pet.getNome());

        if (petExistente != null) {
            throw new PetJaExistenteException("Pet com o nome " + pet.getNome() + " já existe");
        }
        petRepository.save(pet);
        return pet;
    }

    public void atualizarPet(Pet pet) throws PetNaoExistenteException {
        Pet petExistente = petRepository.findByNome(pet.getNome());

        if (petExistente == null) {
            throw new PetNaoExistenteException("Pet com o nome " + pet.getNome() + " não existe");
        }
        petRepository.save(pet);
    }

    public void deletarPet(String nomePet) throws FilmeNaoExistenteException {
        Pet pet = buscarPorNome(nomePet);
        if (pet == null) {
            throw new FilmeNaoExistenteException("Pet com o nome " + nomePet + " não existe");
        }
        petRepository.delete(pet);
    }
}
