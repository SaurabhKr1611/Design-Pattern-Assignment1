package net.media.training.live.dip;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

public class FileWriter implements Writer{

    @Override
    public void writeFile(List<String> encodedStringList, String outputFile){
        try {
            BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(outputFile));

            for(String encodedLine:encodedStringList){
                writer.write(encodedLine);
            }

            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
