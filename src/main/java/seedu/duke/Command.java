package seedu.duke;

/**
 * Abstract command that outlines the 'execute' and 'isExit' method.
 */
public abstract class Command {
    protected ClientList clients;
    protected FlightList flights;
    protected TourList tours;
    protected ClientPackageList packages;
    protected Ui ui;

    /**
     * Executes the specific command depending on the command constructed.
     */
    public abstract void execute();

    public void setData(ClientList clients, FlightList flights, TourList tours, ClientPackageList packages, Ui ui) {
        this.clients = clients;
        this.flights = flights;
        this.tours = tours;
        this.packages = packages;
        this.ui = ui;
    }

    /**
     * Function that controls the exit condition of the loop.
     *
     * @return the exit condition from the loop
     */
    public boolean isExit() {
        return false;
    }
}
