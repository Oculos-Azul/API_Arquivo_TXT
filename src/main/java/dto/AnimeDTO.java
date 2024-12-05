package dto;

import models.Studio;

public record AnimeDTO(
		String name,
		String genre,
		String authorName,
		int releaseYear,
		int episodeCount,
		Studio studio) {

}
