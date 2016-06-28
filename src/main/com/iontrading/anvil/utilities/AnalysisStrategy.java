package main.com.iontrading.anvil.utilities;

import java.util.List;

/**
 * Created by jameswillby on 24/04/2016.
 */
public interface AnalysisStrategy {

    void analyseLogFile(String logFile, List<String> componentAndOptions);

    boolean resultsProcessing();

}
