package test.com.iontrading.anvil.utilities;

import main.com.iontrading.anvil.utilities.AnalysisStrategy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by jameswillby on 24/04/2016.
 */
public class TestAnalyser implements AnalysisStrategy {

    private static final Logger log = Logger.getLogger(TestAnalyser.class.getName());
    private List<String> componentAndOptions = null;
    private BufferedReader br = null;

    public TestAnalyser() {
    }

    @Override
    public void analyseLogFile(String logFile, List<String> componentAndOptions) {

        try {
            br = new BufferedReader(new FileReader(logFile));
            List<String> list = new LinkedList<String>();
            try {

                log.log(Level.INFO, "Run the dispatcher" + "\n" + "For file: " + logFile + "\n");
                boolean hasLines = true;


                while (hasLines) {

                    String element = br.readLine();
                    if (null == element) {
                        hasLines = false;
                        continue;
                    }
                    list.add(element);
                    System.out.print(element);
                }


            } finally {
                br.close();
            }
        } catch (Exception ex) {
        }
    }

    @Override
    public boolean resultsProcessing() {
        return false;
    }
}
