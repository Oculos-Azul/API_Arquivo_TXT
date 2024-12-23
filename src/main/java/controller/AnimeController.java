package controller;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import dto.AnimeDTO;
import exceptions.ValidationException;
import models.Anime;
import service.AnimeService;

public class AnimeController {
    private final AnimeService animeService;

    public AnimeController() {
        this.animeService = new AnimeService();
    }

    public boolean toCreate(AnimeDTO anime) throws ValidationException, IOException, ClassNotFoundException {
        return animeService.saveAnime(anime);
    }

    public void toDelete(String name) throws IllegalArgumentException, IOException, ClassNotFoundException, ValidationException {
        animeService.deleteAnime(name);
    }

    public AnimeDTO toSearch(String name) throws ValidationException, IllegalArgumentException, IOException, ClassNotFoundException {
        return animeService.findById(name).toDTO();
    }

    public Map<String, Anime> toList() throws IOException, ClassNotFoundException {
        return animeService.findAllAnime();
    }

    public void toUpdate(String name, String newValue, String field) throws ValidationException, IllegalArgumentException, IOException, ClassNotFoundException {
        animeService.updateAnime(name, newValue, field);
    }
}
