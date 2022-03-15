package sinks.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class FileSink implements Sink{


    private static FileSink fileSink;
    private static String fileName;

    //private constructor
    private FileSink(){}

    //can be improved
    public  static  FileSink getInstance(String fileName){
        if(fileSink==null){
            fileName = fileName;
            return new FileSink();

        }

        return null;
    }

    @Override
    public void write(List<String> messages) throws IOException {


        Path path = Paths.get(fileName);

        messages.stream().forEach(message ->{
            byte[] strToBytes = message.getBytes();

            try {
                Files.write(path, strToBytes);
            } catch (IOException e) {
                e.printStackTrace(); // can be logged.
            }
        });


    }


}
