import Controller.MainFrameController;
import Model.Repository;
import Model.RulesLogger;
import View.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("iteration1");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Repository repository = new Repository(entityManager);
        MainFrame mainFrame = new MainFrame();
        MainFrameController controller = new MainFrameController();
        RulesLogger rulesLogger = new RulesLogger();

        controller.setMainFrame(mainFrame);
        controller.setRepository(repository);
        controller.setRulesLogger(rulesLogger);
        controller.initializeMainFrame();

        entityManager.close();
        entityManagerFactory.close();
    }
}
