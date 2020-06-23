package Agent.RepositoryAgent;

import Model.Repository.Repository;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class RepositoryAgentMain {
    public static void main(String[] args){

        RepositoryAgent repositoryAgent = new RepositoryAgent(9001);
        new Thread(repositoryAgent).start();

        Scanner in = new Scanner(System.in);
        while(true) {
            if (in.nextLine().equals("-stop")) {
                repositoryAgent.stop();
                break;
            }
        }
        in.close();

    }
}
