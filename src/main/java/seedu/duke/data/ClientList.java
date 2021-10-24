package seedu.duke.data;

import seedu.duke.TourPlannerException;
import seedu.duke.Ui;
import seedu.duke.data.Client;

import java.util.ArrayList;

/**
 * List of clients.
 */
public class ClientList {
    private static final String CLIENT_NOT_FOUND_MESSAGE = "Client cannot be found. Please try another client ID";

    private static ArrayList<Client> clients;
    private static int clientCount = 0;

    /**
     * Class constructor for ClientList.
     */
    public ClientList() {
        clients = new ArrayList<>();
        clientCount = 0;
    }

    /**
     * Main method for adding a client.
     *
     * @param client the client to-be-added
     */
    public void add(Client client) {
        clientCount++;
        clients.add(client);
    }

    /**
     * Getter for number of clients in the client list.
     *
     * @return the number of clients in client list.
     */
    public int getClientCount() {
        return clientCount;
    }

    /**
     * Getter for client object in the client list, corresponding to the index given.
     *
     * @param index the index of the specific client in the client list
     * @return the client object corresponding to the index
     */
    public Client getClient(int index) {
        return clients.get(index);
    }

    public Client getClientById(String clientId) throws TourPlannerException {
        for (int i = 0; i < clientCount; i++) {
            if (clients.get(i).getId().equals(clientId)) {
                return clients.get(i);
            }
        }
        throw new TourPlannerException(CLIENT_NOT_FOUND_MESSAGE);
    }

    /**
     * Main method for clearing the client list.
     */
    public void clearAllClients() throws TourPlannerException {
        if (clientCount == 0) {
            throw new TourPlannerException("Your client list is currently empty.\n"
                    + "Please first add clients to clear.");
        }
        clients.clear();
        clientCount = 0;
    }

    /**
     * Main method for deleting a client.
     */
    public void cut(Client client) {
        clients.remove(client);
        clientCount--;
    }
}