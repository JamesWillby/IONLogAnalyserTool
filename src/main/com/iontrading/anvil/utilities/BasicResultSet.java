package main.com.iontrading.anvil.utilities;

import java.io.FileWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by jameswillby on 02/05/2016.
 */
public class BasicResultSet implements ResultSet {

    private static final Logger log = Logger.getLogger(BasicResultSet.class.getName());
    private List<BasicOptionResults> processingList = null;
    private List<BasicOptionResults> outputList = null;

    public BasicResultSet() {
    }

    public boolean hasResultSet() {
        return processingList.isEmpty();
    }

    @Override
    public void processResultSet(List<BasicOptionResults> resultsList) {

        processingList = resultsList;
        outputList = new LinkedList<BasicOptionResults>();

        try {
            if (hasResultSet())
                throw new Exception("No results to process");

            /**
             * This is our regex. Essentially we want everything from the beginning of the line up to the first | character,
             * to give us the time when our element was seen. We take advantage of the inbuilt split function for the String class
             * rather than having to create anthing else.
             */

            for (BasicOptionResults a : resultsList) {

                BasicOptionResults result = new BasicOptionResults(a.getComponent());

                log.log(Level.INFO, "Timestamps options for : " + a.getComponent() + "\n");

                for (int i = 0; i < a.getSize(); i++) {
                    String splits[] = a.getOption(i).split("\\|");
                    String timeSplit = splits[0];
                    log.log(Level.INFO, "Found : " + timeSplit + "\n");
                    result.setOption(timeSplit);
                    outputList.add(result);
                }
            }

        } catch (Exception eX) {
            eX.getMessage();
        }
    }

    @Override
    public void sendEmail(String from, String to, String server, String password) {

    }

    public List<BasicOptionResults> getResultsList() {
        return outputList;
    }

    @Override
    public void generateExcel() {
        FileWriter writer = null;

        try {
            try {
                writer = new FileWriter("options.txt");
                for (BasicOptionResults a : outputList) {
                    writer.write("Component: " + a.getComponent() + " \n");
                    for (int i = 0; i < a.getSize(); i++) {
                        writer.write("TimeStamp: " + a.getOption(0) + " \n");
                    }
                }
            } finally {
                writer.close();
            }
        } catch (Exception Ex) {
            Ex.printStackTrace();
        }
    }
}
