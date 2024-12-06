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
	private Studio studio;

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

	@Override
	public String toString() {
		return "Anime [id=" + id + ", name=" + name + ", genre=" + genre + ", authorName=" + authorName
				+ ", releaseYear=" + releaseYear + ", episodeCount=" + episodeCount + ", studio=" + studio + "]";
	}

}
