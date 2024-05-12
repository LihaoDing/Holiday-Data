package holidays.model.clientserver;

public interface Output {

    /**
     * send data to the output API;
     * @param message the data to be send to the new pastebin
     * @return the generated url
     */
    public String createPaste(String message);
}