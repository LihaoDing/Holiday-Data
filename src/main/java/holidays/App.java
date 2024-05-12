package holidays;
import holidays.model.Facade;
import holidays.model.database.DataControl;
import holidays.model.clientserver.Client;
import holidays.model.clientserver.ClientImpl;
import holidays.model.singletonFacade;
import holidays.model.clientserver.Output;
import holidays.model.clientserver.OutputImpl;
import holidays.view.Window;

import java.awt.*;

//import T3.window.program;
//import T3.program.Client;
//import T3.program.ClientImpl;

public class App {

    public static void main(String args[]) throws Exception {

        boolean input = true;
        boolean output = true;
        if (args.length == 2) {
            input = args[0].equals("online");
            output = args[1].equals("online");
        }

        Window wi = new Window(input, output);
        wi.setTitle("Holiday Calendar");


        /*Client c = new ClientImpl();
        c.getHolidaysSingleDay(2010,12, 12);
        Output o = new OutputImpl();

        singletonFacade sf = new singletonFacade(c,o);
        Facade facade = sf.getFacade();
        facade.createEntity(facade.getInput(2010,12,12));*/



        //Output o = new OutputImpl();
        //o.createPaste("Thisisatestmessage!");
        //DataControl datacontrol = new DataControl();



    }

}