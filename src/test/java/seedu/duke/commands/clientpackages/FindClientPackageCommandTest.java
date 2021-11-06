package seedu.duke.commands.clientpackages;

import org.junit.jupiter.api.Test;
import seedu.duke.TourPlannerException;
import seedu.duke.Ui;
import seedu.duke.commands.Command;
import seedu.duke.data.Client;
import seedu.duke.data.ClientList;
import seedu.duke.data.ClientPackage;
import seedu.duke.data.ClientPackageList;
import seedu.duke.data.Flight;
import seedu.duke.data.FlightList;
import seedu.duke.data.Tour;
import seedu.duke.data.TourList;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindClientPackageCommandTest {

    PrintStream previousConsole = System.out;
    ByteArrayOutputStream newConsole = new ByteArrayOutputStream();

    ClientList dummyClientList = new ClientList();
    TourList dummyTourList = new TourList();
    FlightList dummyFlightList = new FlightList();
    ClientPackageList testPackageList = new ClientPackageList();
    Ui testUi = new Ui();

    @Test
    void findTourCommand_validSubscription_correctlyConstructed() throws TourPlannerException {
        System.setOut(new PrintStream(newConsole));

        Client botuan = new Client(new String[]{"c001", "Bo Tuan", "93338333", "bt@mail.com"});
        Tour jpn = new Tour(new String[]{"JPN", "Japan Basic Tour", "1500.00"});
        Flight sqjpn = new Flight(new String[]{"SQ-JPN", "JPN", "SG", "20/10/2021 18:00", "21/10/2021 03:00"});
        dummyClientList.add(botuan);
        dummyTourList.add(jpn);
        dummyFlightList.add(sqjpn);

        ClientPackage jpnPackage = new ClientPackage("p001", botuan, jpn, sqjpn);
        testPackageList.add(jpnPackage);

        Command findPackage = new FindClientPackageCommand(1);
        findPackage.setData(dummyClientList, dummyFlightList, dummyTourList, testPackageList, testUi);
        findPackage.execute();

        previousConsole.println(newConsole.toString());
        System.setOut(previousConsole);
        String expectedString = "This is the packages that matches your search\n"
                + "Package ID: p001\n" + "\n"
                + "Client: \n"
                + "Client ID: c001";

        String[] actualStringArray = newConsole.toString().trim().split("\r\n", 2);
        String actualString = actualStringArray[0] + "\n" + actualStringArray[1].trim().split("\r\n", 2)[0];
        assertEquals(expectedString, actualString);
    }
}