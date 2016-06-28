package main.com.iontrading.anvil.utilities;

import java.util.List;

/**
 * Created by jameswillby on 17/04/2016.
 */
public interface ResultSet {

    public void processResultSet(List<BasicOptionResults> resultsList);

    public List<BasicOptionResults> getResultsList();

    public void sendEmail(String from, String to, String server, String password);

    public void generateExcel();

    public boolean hasResultSet();

}
