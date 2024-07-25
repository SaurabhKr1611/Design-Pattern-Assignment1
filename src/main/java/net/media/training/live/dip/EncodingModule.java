package net.media.training.live.dip;


import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: goyalamit
 * Date: Jul 13, 2011
 * Time: 10:05:38 AM
 * To change this template use File | Settings | File Templates.
 */
public class EncodingModule {
    public void encodeWithFiles(String inputFile, String outputFile) {
        FileReader fileReader = new FileReader();
        List<String> stringList = fileReader.readFile(inputFile);
        List<String> encodedStringList = new ArrayList<>();

        for(String aLine:stringList){
            String encodedLine = Base64.getEncoder().encodeToString(aLine.getBytes());
            encodedStringList.add(encodedLine);
        }

        FileWriter fileWriter = new FileWriter();
        fileWriter.writeFile(encodedStringList, outputFile);
    }

    public void encodeBasedOnNetworkAndDatabase(String urlString) {
        URL url = null;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        InputStream in = null;
        try {
            in = url.openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStreamReader reader = new InputStreamReader(in);
        StringBuilder inputString1 = new StringBuilder();
        try {
            int c;
            c = reader.read();
            while (c != -1) {
                inputString1.append((char) c);
                c = reader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String inputString = inputString1.toString();
        String encodedString = Base64.getEncoder().encodeToString(inputString.getBytes());
        MyDatabaseWriter myDatabaseWriter = new MyDatabaseWriter();
        myDatabaseWriter.writeData(encodedString);
    }
}

