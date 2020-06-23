package Agent.BugReportAgent;

import java.util.Scanner;

public class BugReportAgentMain {
    public static void main(String[] args){
        BugReportAgent bugReportAgent = new BugReportAgent(9003);
        new Thread(bugReportAgent).start();

        Scanner in = new Scanner(System.in);
        while(true) {
            if (in.nextLine().equals("-stop")) {
                bugReportAgent.stop();
                break;
            }
        }
        in.close();
    }
}
