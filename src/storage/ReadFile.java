package storage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFile<T> {
    public  <T> List<T> ReadFile(){
        File file = new File("manager.txt");
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
