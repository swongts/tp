package seedu.duke.commands.flights;

import org.junit.jupiter.api.Test;
import seedu.duke.TourPlannerException;
import seedu.duke.Ui;
import seedu.duke.commands.Command;
import seedu.duke.data.ClientList;
import seedu.duke.data.ClientPackageList;
import seedu.duke.data.Flight;
import seedu.duke.data.FlightList;
import seedu.duke.data.TourList;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListFlightCommandTest {

    PrintStream previousConsole = System.out;
    ByteArrayOutputStream newConsole = new ByteArrayOutputStream();

    ClientList dummyClientList = new ClientList();
    TourList dummyTourList = new TourList();
    FlightList testFlightList = new FlightList();
    ClientPackageList dummyPackageList = new ClientPackageList();
    Ui testUi = new Ui();

    @Test
    void listClientCommand_validData_correctlyConstructed() throws TourPlannerException {
        System.setOut(new PrintStream(newConsole));

        Flight sqjpn = new Flight(new String[]{"SQ-JPN", "JPN", "SG",
            "20/10/2021 18:00", "21/10/2021 03:00"});
        Flight sqkor = new Flight(new String[]{"SQ-KOR", "KOR", "SG",
            "23/10/2021 18:00", "30/10/2021 03:00"});
        testFlightList.add(sqjpn);
        testFlightList.add(sqkor);
        Command listTour = new ListFlightCommand();
        listTour.setData(dummyClientList, testFlightList, dummyTourList, dummyPackageList, testUi);
        listTour.execute();

        previousConsole.println(newConsole.toString());
        System.setOut(previousConsole);
        String expectedString = "Here is a list of all flights:\n"
                + "1. Flight ID: SQ-JPN\n"
                + "Departure Flight: JPN, 20/10/2021 18:00\n"
                + "Return Flight: SG, 21/10/2021 03:00\n" + "\n"
                + "2. Flight ID: SQ-KOR\n"
                + "Departure Flight: KOR, 23/10/2021 18:00\n"
                + "Return Flight: SG, 30/10/2021 03:00\n" + "\n"
                + "Total Flights: 2";
        String actualString = newConsole.toString().trim().replace("\r\n", "\n");
        assertEquals(expectedString, actualString);
    }

    @Test
    void listTourCommand_noData_correctlyConstructed() throws TourPlannerException {
        System.setOut(new PrintStream(newConsole));

        Command listTour = new ListFlightCommand();
        listTour.setData(dummyClientList, testFlightList, dummyTourList, dummyPackageList, testUi);
        listTour.execute();

        previousConsole.println(newConsole.toString());
        System.setOut(previousConsole);
        String expectedString = "I'm sorry, there seems to be no flights";
        String actualString = newConsole.toString().trim().replace("\r\n", "\n");
        assertEquals(expectedString, actualString);
    }
}