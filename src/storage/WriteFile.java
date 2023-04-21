package storage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteFile<T> {
    public  <T> void writeFile(List<T> element){
        File file = new File("manage.txt");
        try(
            OutputStream outputStream = new FileOutputStream(file);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream)) {
            objectOutputStream.writeObject(element);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
