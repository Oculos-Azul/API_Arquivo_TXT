package service;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import exceptions.ValidationException;
import exceptions.InvalidUUIDException;

import dto.AnimeDTO;
import models.Anime;
import repository.AnimeRepository;
import utils.AnimeValidator;

public class AnimeService {
    private final AnimeRepository animeRepository;

    public AnimeService() {
        this.animeRepository = new AnimeRepository();
    }

    public boolean saveAnime(AnimeDTO animeDTO) throws ValidationException, IOException, ClassNotFoundException {
        AnimeValidator.validateAnime(animeDTO);
        animeRepository.saveAnime(animeDTO);
        return true;
    }

    public void deleteAnime(String name) throws ValidationException, IOException, ClassNotFoundException {
//        AnimeValidator.validateUUID(id);
        findById(name);
        animeRepository.deleteAnime(name);
    }

    public Map<String, Anime> findAllAnime() throws IOException, ClassNotFoundException {
        Map<String, Anime> map = animeRepository.findAllAnime();
        if (map.isEmpty()) {
            throw new IllegalArgumentException("Nenhum anime cadastrado");
        }
        return map;
    }

    public Anime findById(String name) throws InvalidUUIDException, IOException, ClassNotFoundException {
//        AnimeValidator.validateUUID(id);
        Anime anime = animeRepository.findById(name);
        if (anime == null) {
            throw new IllegalArgumentException("Anime \"" + name + "\" não encontrado.");
        }
        return anime;
    }

    public void updateAnime(String name, String value, String field) throws ValidationException, IOException, ClassNotFoundException {
//        AnimeValidator.validateUUID(id);
        AnimeValidator.validateField(field);
        Anime existingAnime = findById(name);
        if (existingAnime == null) {
            throw new IllegalArgumentException("Anime \"" + name + "\" não encontrado.");
        }
        animeRepository.updateAnime(name, value, field);
    }
}
