package storage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFile<T> {
    private ReadFile(){}
    private static ReadFile readFile = null;
    public static ReadFile getReadFile(){
        if (readFile == null){
            readFile = new ReadFile();
        }return readFile;
    }
    public  <T> List<T> readFile(){
        File file = new File("manage.txt");
        List<T> element = new ArrayList<>();
        try(InputStream inputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream)) {
            element = (List<T>) objectInputStream.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }
        return element;
    }
}
