import Model.Repository;
import Server.Server;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("iteration2");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Repository repository = new Repository(entityManager);

        Server server = new Server(9000, repository);
        new Thread(server).start();

        Scanner in = new Scanner(System.in);
        while(true) {
            if (in.nextLine().equals("-stop")) {
                server.stop();
                break;
            }
        }

        in.close();
        entityManager.close();
        entityManagerFactory.close();

    }
}
