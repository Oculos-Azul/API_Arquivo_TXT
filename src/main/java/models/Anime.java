package models;

import java.io.Serializable;
import java.util.UUID;

import dto.AnimeDTO;

public class Anime implements Serializable {
	UUID id = UUID.randomUUID();
	private String name;
	private String genre;
	private String authorName;
	private int releaseYear;
	private int episodeCount;
	private UUID studio;

	public Anime(AnimeDTO animedto) {
		this.name = animedto.name();
		this.genre = animedto.genre();
		this.authorName = animedto.authorName();
		this.releaseYear = animedto.releaseYear();
		this.episodeCount = animedto.episodeCount();
		this.studio = animedto.studio();
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getGenre() {
		return genre;
	}

	public String getAuthorName() {
		return authorName;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public int getEpisodeCount() {
		return episodeCount;
	}

	public UUID getStudio() {
		return studio;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public void setEpisodeCount(int episodeCount) {
		this.episodeCount = episodeCount;
	}

	public void setStudio(UUID studio) {
		this.studio = studio;
	}
	
    public AnimeDTO toDTO() {
        return new AnimeDTO(
            this.name,
            this.genre,
            this.authorName,
            this.releaseYear,
            this.episodeCount,
            this.studio
        );
    }

	@Override
	public String toString() {
		return "Anime [id=" + id + ", name=" + name + ", genre=" + genre + ", authorName=" + authorName
				+ ", releaseYear=" + releaseYear + ", episodeCount=" + episodeCount + ", studio=" + studio + "]";
	}

}
