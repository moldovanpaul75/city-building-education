package Business;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;

public class LoggerSystem {
    public void logAction(String msg) {
        File log = new File("log.txt");
        try {
            if (!log.exists()) {
                log.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(log, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            bufferedWriter.write("************** " + timestamp.toString() + " **************" + "\n");
            bufferedWriter.write(msg + "\n");
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
