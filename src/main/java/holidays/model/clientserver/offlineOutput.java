package holidays.model.clientserver;
import holidays.model.clientserver.Output;

public class offlineOutput implements Output {
    /**
     * send data to the offline output;
     * @param message the data to be send to the new pastebin
     * @return the generated url
     */
    public String createPaste(String message){
        return "Print the offline version url";
    }
}