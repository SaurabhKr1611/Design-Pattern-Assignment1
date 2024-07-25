package net.media.training.live.dip;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class FileReader implements Reader {
    @Override
    public List<String> readFile(String inputFile){
        List<String> stringList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new java.io.FileReader(inputFile));

            String aLine;
            while ((aLine = reader.readLine()) != null) {
                stringList.add(aLine);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringList;
    }
}
