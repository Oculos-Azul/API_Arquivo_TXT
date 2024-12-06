package utils;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import dto.StudioDTO;
import dto.AnimeDTO;
import models.Anime;
import models.Studio;

import java.time.LocalDate;

public class FileUtils {
    private final Charset CHARSET = StandardCharsets.US_ASCII;
    private File file;

    public FileUtils(String path) {
        this.file = new File(path);
    }

    public String getPath() {
        return file.toString();
    }

    public boolean createFile() throws IOException {
        return file.createNewFile();
    }
    
    public void addObjectToFile(Anime newAnime) throws IOException, ClassNotFoundException {
        Map<UUID, Anime> animeMap = readObjectsFromFile();

        animeMap.put(newAnime.getId(), newAnime);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(animeMap);
    }

    public Map<UUID, Anime> readObjectsFromFile() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            return (Map<UUID, Anime>) ois.readObject();  // Ler o HashMap inteiro
    }


    public static void main(String[] args) {
        FileUtils file = new FileUtils("/opt/dev/aqui.txt");

        // Teste de gravação
        try {
            StudioDTO studio = new StudioDTO("Eu aqui poora", LocalDate.of(2008, 6, 28));
            Studio estudio = new Studio(studio);

            Anime anime = new Anime(new AnimeDTO("Naruto", "Action", "Masashi Kishimoto", 2002, 220, estudio));
            file.addObjectToFile(anime);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

        // Teste de leitura
        try {
            // Recupera o HashMap de Animes
            Map<UUID, Anime> animes = file.readObjectsFromFile();
            
            // Itera sobre as entradas do HashMap
            for (Map.Entry<UUID, Anime> entry : animes.entrySet()) {
                UUID id = entry.getKey();  // A chave, que é o ID do Anime
                Anime a = entry.getValue();  // O valor, que é o objeto Anime
                
                // Exibe o ID e os detalhes do Anime
                System.out.println("ID: " + id + ", Anime: " + a);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
