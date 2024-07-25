package net.media.training.live.dip;

import java.util.List;

public interface Writer {
    void writeFile(List<String> encodedStringList, String outputFile);
}
