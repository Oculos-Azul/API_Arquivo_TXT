package repository;

import java.io.IOException;
import java.util.Collections;
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

	public void deleteAnime(String name) throws ClassNotFoundException, IOException {
	    Map<String, Anime> map = file.readFromFile();
	    map.remove(name);
	    file.writeToFile(map);
	}
	
	public Map<String, Anime> findAllAnime() throws ClassNotFoundException, IOException {
	    return Collections.unmodifiableMap(file.readFromFile());
	}

	
	public Anime findById(String name) throws ClassNotFoundException, IOException {
		Map<String, Anime> map = file.readFromFile();
		return map.get(name);
	}

	public void updateAnime(String name, String value, String fild) throws ClassNotFoundException, IOException {
		Anime anime = findById(name);
		
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
			anime.setStudio(value);
			break;
		}
		
		file.writeToFile(anime);
		
	}
}
