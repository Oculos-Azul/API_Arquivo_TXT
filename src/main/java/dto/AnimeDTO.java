package dto;

import java.util.UUID;

public record AnimeDTO(
		String name,
		String genre,
		String authorName,
		int releaseYear,
		int episodeCount,
		UUID studio) {

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

	public UUID studio() {
		return studio;
	}

}
