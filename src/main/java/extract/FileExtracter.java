package extract;

import extract.parser.AbstractParser;
import extract.parser.STLParser;
import lombok.Data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

@Data
public class FileExtracter extends AbstractExtracter {

    private String relativeFileDirectory;

    public FileExtracter() {

    }

    public FileExtracter(AbstractParser parser) {
        super(parser);
    }

    @Override
    public void setExtractionMap(Map<String, String> extractionMap) {
        this.relativeFileDirectory = extractionMap.get("file");
    }

    @Override
    public boolean read() {

        try {
            BufferedReader b = new BufferedReader(new FileReader(new File(this.relativeFileDirectory)));
            String readLine;
            while ((readLine = b.readLine()) != null) {
                super.getParser().parse(readLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;


    }
}