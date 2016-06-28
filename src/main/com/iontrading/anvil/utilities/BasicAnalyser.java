package main.com.iontrading.anvil.utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by jameswillby on 24/04/2016.
 */
public class BasicAnalyser implements AnalysisStrategy {

    private static final Logger log = Logger.getLogger(BasicAnalyser.class.getName());
    private List<String> componentAndOptions = null;
    private BufferedReader br = null;
    private ResultSet resultSet = null;
    private List<BasicOptionResults> results = null;

    public BasicAnalyser() {
    }

    public boolean resultsProcessing() {
        return resultSet.hasResultSet();
    }

    @Override
    public void analyseLogFile(String logFile, List<String> componentAndOptions) {

        try {

            this.componentAndOptions = componentAndOptions;
            br = new BufferedReader(new FileReader(logFile));
            resultSet = new BasicResultSet();
            results = new LinkedList<BasicOptionResults>();

            try {

                log.log(Level.INFO, "Analysing file: " + logFile + "\n");
                log.log(Level.INFO, "Options: " + componentAndOptions + "\n");

                boolean hasNextLine = true;
                while (hasNextLine) {


                    String element = br.readLine();

                    if (null == element) {
                        hasNextLine = false;
                    } else {

                        for (int i = 1; i < componentAndOptions.size(); i++) {
                            String compare = componentAndOptions.get(i);

                            if (element.contains(compare)) {
                                log.log(Level.INFO, "Found " + compare + "\n");

                                if (results.isEmpty()) {
                                    BasicOptionResults row = new BasicOptionResults(compare);
                                    row.setOption(element);
                                    results.add(row);
                                } else {
                                    boolean added = false;
                                    for (int j = 0; j < results.size(); j++) {
                                        if (compare.equals(results.get(j).getComponent())) {
                                            results.get(j).setOption(element);
                                            added = true;
                                        }
                                    }
                                    if (!added) {
                                        BasicOptionResults row = new BasicOptionResults(compare);
                                        row.setOption(element);
                                        results.add(row);
                                    }
                                }
                            }
                        }
                    }
                }

                resultSet.processResultSet(results);
                resultSet.generateExcel();

            } finally {

                log.log(Level.INFO, "Completed processing of file: " + logFile + "\n");
                br.close();

            }
        } catch (IOException ioEx) {

            log.log(Level.WARNING, "No file at location" + logFile + "\n");
            ioEx.printStackTrace();
        }


    }


}

