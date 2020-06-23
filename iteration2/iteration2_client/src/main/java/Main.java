import Client.Client;
import Controller.MainFrameController;
import View.MainFrame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        MainFrame mainFrame = new MainFrame();
        MainFrameController controller = new MainFrameController();

        Client client = new Client("localhost", 9000);
        client.setMainFrame(mainFrame);
        client.setMainFrameController(controller);

        new Thread(client).start();

        Scanner in = new Scanner(System.in);
        while(true) {
            if (in.nextLine().equals("-exit")) {
                client.stop();
                break;
            }
        }

        in.close();

    }
}
