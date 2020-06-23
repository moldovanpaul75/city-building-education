package Agent.UpdateAgent;

import Model.Repository.Repository;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class UpdateAgentMain {
    public static void main(String[] args){

        UpdateAgent updateAgent = new UpdateAgent(9002);
        new Thread(updateAgent).start();

        Scanner in = new Scanner(System.in);
        while(true) {
            if (in.nextLine().equals("-stop")) {
                updateAgent.stop();
                break;
            }
        }
        in.close();
    }
}
