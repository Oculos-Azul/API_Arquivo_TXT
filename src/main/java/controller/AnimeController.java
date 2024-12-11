package controller;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
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

    public void toCreate(AnimeDTO anime) throws ValidationException, IOException, ClassNotFoundException {
        animeService.saveAnime(anime);
    }

    public void toDelete(UUID id) throws IllegalArgumentException, IOException, ClassNotFoundException, ValidationException {
        animeService.deleteAnime(id);
    }

    public AnimeDTO toSearch(UUID id) throws ValidationException, IllegalArgumentException, IOException, ClassNotFoundException {
        return animeService.findById(id).toDTO();
    }

    public Map<UUID, Anime> toList() throws IOException, ClassNotFoundException {
        return animeService.findAllAnime();
    }

    public void toUpdate(UUID id, String newValue, String field) throws ValidationException, IllegalArgumentException, IOException, ClassNotFoundException {
        animeService.updateAnime(id, newValue, field);
    }
}
