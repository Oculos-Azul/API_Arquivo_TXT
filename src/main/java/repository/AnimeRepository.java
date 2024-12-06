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
	    
	    if (map.remove(id) != null) {
	        file.writeToFile(map);
	        
	    } else {
	        throw new IllegalArgumentException("Anime com ID: " + id + " não achado");
	    }
	}
	
	public Map<UUID, Anime> findAllAnime() throws ClassNotFoundException, IOException {
		return file.readFromFile();
	}
	
	public Anime findById(UUID id) throws ClassNotFoundException, IOException {
		Map<UUID, Anime> map = file.readFromFile();
		return map.get(id);
	}

	public void updateAnime(UUID id, AnimeDTO upAnime, String fild) throws ClassNotFoundException, IOException {
		Anime anime = findById(id);
		
		switch(fild.toLowerCase()) {
		case "name":
			anime.setName(upAnime.name());
			break;
		case "genre":
			anime.setGenre(upAnime.genre());
			break;
		case "authorName":
			anime.setAuthorName(upAnime.authorName());
			break;
		case "releaseYear":
			anime.setReleaseYear(upAnime.releaseYear());
			break;
		case "episodeCount":
			anime.setEpisodeCount(upAnime.episodeCount());
			break;
		case "studio":
			anime.setStudio(upAnime.studio());
			break;
		}
		
		file.w
		
	}
}
