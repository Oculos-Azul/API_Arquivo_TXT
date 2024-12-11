package repository;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import dto.AnimeDTO;
import models.Anime;
import utils.FileUtils;

public class AnimeRepository {
	FileUtils file = new FileUtils("./src/main/resources/Anime.txt");

	public void saveAnime(AnimeDTO anime) throws ClassNotFoundException, IOException {
		file.writeToFile(new Anime(anime));
	}

	public void deleteAnime(UUID id) throws ClassNotFoundException, IOException {
	    Map<UUID, Anime> map = file.readFromFile();
	    map.remove(id);
	    file.writeToFile(map);
	}
	
	public Map<UUID, Anime> findAllAnime() throws ClassNotFoundException, IOException {
		return file.readFromFile();
	}
	
	public Anime findById(UUID id) throws ClassNotFoundException, IOException {
		Map<UUID, Anime> map = file.readFromFile();
		return map.get(id);
	}

	public void updateAnime(UUID id, String value, String fild) throws ClassNotFoundException, IOException {
		Anime anime = findById(id);
		
		switch(fild.toLowerCase()) {
		case "name":
			anime.setName(value);
			break;
		case "genre":
			anime.setGenre(value);
			break;
		case "authorname":
			anime.setAuthorName(value);
			break;
		case "releaseyear":
			anime.setReleaseYear(Integer.parseInt(value));
			break;
		case "episodecount":
			anime.setEpisodeCount(Integer.parseInt(value));
			break;
		case "studio":
			anime.setStudio(UUID.fromString(value));
			break;
		}
		
		file.writeToFile(anime);
		
	}
}
