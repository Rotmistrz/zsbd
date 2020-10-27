package DataReceivers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class FileParser {
    public ArrayList<String> parse(String path) {
        ArrayList<String> result = new ArrayList<String>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            String line;

            while ((line = br.readLine()) != null) {
                result.add(line.trim());
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return result;
    }
}
