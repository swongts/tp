package seedu.duke;

public class TourPlanner {
    /**
     * Main entry-point for the java.duke.Duke application.
     */

    public TourPlanner() {
        ;
    }

    public static void main(String[] args) {
        Ui ui = new Ui();
        ui.showWelcome();
        boolean isExit = false;
        String command;
        ClientList clientList = new ClientList();
        while (!isExit) {
            command = ui.readCommand();
            try {
                Command dummy = Parser.parse(command);
                dummy.execute(clientList, ui);
                isExit = dummy.isExit();
            } catch (NullPointerException | NumberFormatException e) {
                System.out.println();
            } catch (TourPlannerException e) {
                System.out.println(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }


}