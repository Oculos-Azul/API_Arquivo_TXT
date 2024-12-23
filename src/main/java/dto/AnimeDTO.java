package dto;

import java.util.UUID;

public record AnimeDTO(
		String name,
		String genre,
		String authorName,
		int releaseYear,
		int episodeCount,
		String studio) {

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

	public String studio() {
		return studio;
	}
	
    @Override
    public String toString() {
        return String.format(
            "==========================\n" +
            "  Name: %s\n" +
            "  Genre: %s\n" +
            "  Author: %s\n" +
            "  Release Year: %d\n" +
            "  Episode Count: %d\n" +
            "  Studio: %s\n", 
            name, genre, authorName, releaseYear, episodeCount, studio
        );
    }

}
