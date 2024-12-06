package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.UUID;

import models.Anime;

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

    public void writeToFile(Anime newAnime) throws IOException, ClassNotFoundException {
        Map<UUID, Anime> animeMap = readFromFile();

        animeMap.put(newAnime.getId(), newAnime);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(animeMap);
    }

    public void writeToFile(Map<UUID, Anime> map) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(map);
    }

    public Map<UUID, Anime> readFromFile() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        return (Map<UUID, Anime>) ois.readObject(); // Ler o HashMap inteiro
    }

}
