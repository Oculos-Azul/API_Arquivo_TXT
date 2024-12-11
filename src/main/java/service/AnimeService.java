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

    public void deleteAnime(UUID id) throws ValidationException, IOException, ClassNotFoundException {
        AnimeValidator.validateUUID(id);
        findById(id);
        animeRepository.deleteAnime(id);
    }

    public Map<UUID, Anime> findAllAnime() throws IOException, ClassNotFoundException {
        Map<UUID, Anime> map = animeRepository.findAllAnime();
        if (map.isEmpty()) {
            throw new IllegalArgumentException("Nenhum anime cadastrado");
        }
        return map;
    }

    public Anime findById(UUID id) throws InvalidUUIDException, IOException, ClassNotFoundException {
        AnimeValidator.validateUUID(id);
        Anime anime = animeRepository.findById(id);
        if (anime == null) {
            throw new IllegalArgumentException("Anime com ID: " + id + " não encontrado.");
        }
        return anime;
    }

    public void updateAnime(UUID id, String value, String field) throws ValidationException, IOException, ClassNotFoundException {
        AnimeValidator.validateUUID(id);
        AnimeValidator.validateField(field);
        Anime existingAnime = findById(id);
        if (existingAnime == null) {
            throw new IllegalArgumentException("Anime com ID: " + id + " não encontrado.");
        }
        animeRepository.updateAnime(id, value, field);
    }
}
