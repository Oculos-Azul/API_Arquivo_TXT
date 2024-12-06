package dto;

import models.Studio;

public record AnimeDTO(
		String name,
		String genre,
		String authorName,
		int releaseYear,
		int episodeCount,
		Studio studio) {

	public String name() {
		return name;
	}

	public String genre() {
		return genre;
	}

	public String authorName() {
		return authorName;
	}

	public int releaseYear() {
		return releaseYear;
	}

	public int episodeCount() {
		return episodeCount;
	}

	public Studio studio() {
		return studio;
	}

}
