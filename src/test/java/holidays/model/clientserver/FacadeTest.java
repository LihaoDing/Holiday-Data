package holidays.model.clientserver;
import holidays.model.Facade;

import holidays.model.database.DataControl;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import static org.junit.Assert.*;

public class FacadeTest {
    Client input;
    Output output;
    Client offlineInput;
    Output offlineOutput;
    DataControl dc;

    @Before
    public void init() {
        input = mock(ClientImpl.class);
        output = mock(OutputImpl.class);
        offlineInput = mock(offlineInput.class);
        offlineOutput = mock(offlineOutput.class);
        dc = mock(DataControl.class);
    }

    @Test
    public void getOnlineInput() throws Exception {
        Facade facade = new Facade(input, output);
        when(input.getHolidaysSingleDay("US", 2010,12,12)).thenReturn("Test");
        assertNotNull(facade.getInput("US", 2010,12,12));
    }

    @Test
    public void sendOnlineOutput() throws Exception {
        Facade facade = new Facade(input, output);
        when(output.createPaste("test")).thenReturn("abc");
        assertEquals("abc", facade.sendOutput("test"));
    }

    @Test
    public void getOfflineInput() throws Exception {
        Facade facade = new Facade(offlineInput, offlineOutput);
        when(offlineInput.getHolidaysSingleDay("US",2010,12,12)).thenReturn("OfflineTest");
        assertNotNull(facade.getInput("US",2010,12,12));
    }

    @Test
    public void getOnlineOutput() throws Exception {
        Facade facade = new Facade(offlineInput, offlineOutput);
        when(offlineOutput.createPaste("test")).thenReturn("abc");
        assertEquals("abc", facade.sendOutput("test"));
    }

    @Test
    public void databaseInsert() {
        Facade facade = new Facade(offlineInput, offlineOutput);
        facade.createDatabase(dc);
        when(dc.insert("test", "test")).thenReturn("success");
        assertEquals(true, facade.writeIntoDatabase("test","test"));
    }

    @Test
    public void databaseGet() {
        Facade facade = new Facade(offlineInput, offlineOutput);
        facade.createDatabase(dc);
        when(dc.get("test")).thenReturn("success");
        assertEquals("success", facade.readFromDatabase("test"));
    }

    @Test
    public void setThresholdHolidayCountTestTrue() {
        Facade facade = new Facade(offlineInput, offlineOutput);
        facade.createDatabase(dc);
        assertEquals(false, facade.setThresholdHolidayCount(6));
    }

    @Test
    public void checkLotsOfHolidayTestFalse() {
        Facade facade = new Facade(offlineInput, offlineOutput);
        facade.createDatabase(dc);
        for (int i = 1; i < 2; i++) {
            when(dc.get("202110"+i+"CN")).thenReturn("success");
        }
        for (int i = 2; i < 32; i++) {
            when(dc.get("202110"+i+"CN")).thenReturn(null);
        }
        assertEquals(false, facade.checkLotsOfHoliday(2021, 10, "CN"));
    }


}