package utils;

import exceptions.*;
import models.Anime;
import models.Studio;

import java.util.Set;
import java.util.UUID;
import java.util.regex.Pattern;

import dto.AnimeDTO;

public class AnimeValidator {
    private static final Pattern UUID_PATTERN = Pattern.compile(
            "^[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[1-5][a-fA-F0-9]{3}-[89abAB][a-fA-F0-9]{3}-[a-fA-F0-9]{12}$"
    );
    private static final Set<String> VALID_FIELDS = Set.of("name", "genre", "authorname", "releaseyear", "episodecount", "studio");

    private AnimeValidator() {
        throw new UnsupportedOperationException("Esta classe não pode ser instanciada.");
    }

    public static void validateAnime(Anime anime) {
        validateUUID(anime.getId());
        validateName(anime.getName());
        validateGenre(anime.getGenre());
        validateAuthorName(anime.getAuthorName());
        validateReleaseYear(anime.getReleaseYear());
        validateEpisodeCount(anime.getEpisodeCount());
        validateStudio(anime.getStudio());
    }

    public static void validateAnime(AnimeDTO anime) {
        validateName(anime.name());
        validateGenre(anime.genre());
        validateAuthorName(anime.authorName());
        validateReleaseYear(anime.releaseYear());
        validateEpisodeCount(anime.episodeCount());
        validateStudio(anime.studio());
    }

    public static void validateUUID(UUID input) {
        if (input == null || !UUID_PATTERN.matcher(input.toString()).matches()) {
            throw new InvalidUUIDException("O ID é inválido ou nulo.");
        }
    }
    
    public static void validateField(String field) {
        if (field == null || !VALID_FIELDS.contains(field.toLowerCase())) {
            throw new InvalidFieldException("Campo inválido para atualização: " + field);
        }
    }

    private static void validateName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() > 100) {
            throw new InvalidNameException("O nome é inválido. Deve ter no máximo 100 caracteres.");
        }
    }

    private static void validateGenre(String genre) {
        if (genre == null || genre.trim().isEmpty() || genre.length() > 50) {
            throw new InvalidGenreException("O gênero é inválido. Deve ter no máximo 50 caracteres.");
        }
    }

    private static void validateAuthorName(String authorName) {
        if (authorName == null || authorName.trim().isEmpty() || authorName.length() > 100) {
            throw new InvalidAuthorNameException("O nome do autor é inválido. Deve ter no máximo 100 caracteres.");
        }
    }

    private static void validateReleaseYear(int releaseYear) {
        if (releaseYear <= 1900 || releaseYear > java.time.Year.now().getValue()) {
            throw new InvalidReleaseYearException("O ano de lançamento é inválido.");
        }
    }

    private static void validateEpisodeCount(int episodeCount) {
        if (episodeCount < 0) {
            throw new InvalidEpisodeCountException("A contagem de episódios não pode ser negativa.");
        }
    }

    private static void validateStudio(UUID studio) {
        if (studio == null) {
            throw new InvalidStudioException("O estúdio não pode ser nulo.");
        }
    }
}
