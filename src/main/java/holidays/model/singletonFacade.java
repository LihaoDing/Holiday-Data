package holidays.model;
import holidays.model.clientserver.*;
import holidays.model.Facade;

public class singletonFacade {

    private Facade facade;

    public singletonFacade(Client c, Output o) {
        this.facade = new Facade(c, o);
    }

    /**
     * get a Facade object;
     * @return the Facade object
     */
    public Facade getFacade() {
        return this.facade;
    }


}