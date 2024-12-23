package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import models.Anime;

public class FileUtils {
    private File file;

    public FileUtils(String path) {
        this.file = new File(path);
    }

    public String getPath() {
        return file.toString();
    }

    public void ensureFileExists() throws IOException {
        if (file.createNewFile()) { 
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(new HashMap<String, Anime>());
        }
    }


    public void writeToFile(Anime newAnime) throws IOException, ClassNotFoundException {
        ensureFileExists();
        Map<String, Anime> animeMap = readFromFile();

        animeMap.put(newAnime.getName(), newAnime);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(animeMap);
    }

    public void writeToFile(Map<String, Anime> map) throws IOException {
        ensureFileExists();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(map);
    }

    @SuppressWarnings("unchecked")
    public Map<String, Anime> readFromFile() throws IOException, ClassNotFoundException {
        ensureFileExists();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
       return (Map<String, Anime>) ois.readObject();
    }
}
