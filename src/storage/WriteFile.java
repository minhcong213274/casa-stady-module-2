package storage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteFile<T> {
    private WriteFile(){}
    private static WriteFile writeFile = null;
    public static WriteFile getWriteFile(){
        if (writeFile==null){
            writeFile = new WriteFile();
        }return writeFile;
    }
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
