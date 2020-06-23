package Model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Observable;


/**
 * This class is the rules logger that saves and reads rules from a txt file.
 */
public class RulesLogger extends Observable {

    /**
     * Saves a new rule to the txt file.
     * @param rule new rule as string
     */
    public void writeRule(String rule) {
        File log = new File("buildingrules.txt");
        try {
            if (!log.exists()) {
                log.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(log, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(rule + "\n");
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setChanged();
        notifyObservers(rule);
    }

    /**
     *
     * @return Returns a string with all the rules from file.
     */
    public String readRules() {
        String rules = null;
        try {
            rules = new String(Files.readAllBytes(Paths.get("buildingrules.txt")), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Current rules:\n" + rules + "\n";
    }
}
