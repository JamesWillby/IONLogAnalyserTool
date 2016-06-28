package test.com.iontrading.anvil.utilities;

import main.com.iontrading.anvil.utilities.AnalysisStrategy;
import main.com.iontrading.anvil.utilities.BasicAnalyser;
import org.junit.Test;

import java.util.LinkedList;

/**
 * Created by jameswillby on 12/05/2016.
 */
public class TestBasicAnalyser {

    @Test
    public void testBasicRun() {

        String logFile = "/Users/jameswillby/IdeaProjects/LogAnalyserServer/src/resources/Test.log";
        LinkedList optionsList = new LinkedList<String>();
        optionsList.add("InternalAllocations");
        optionsList.add("SQL");
        AnalysisStrategy analyser = new BasicAnalyser();
        analyser.analyseLogFile(logFile, optionsList);

    }

    @Test
    public void testResponseFromAnalyser() {

        String logFile = "/Users/jameswillby/IdeaProjects/LogAnalyserServer/src/resources/Test.log";
        LinkedList optionsList = new LinkedList<String>();
        optionsList.add("InternalAllocations");
        optionsList.add("SQL");
        AnalysisStrategy analyser = new BasicAnalyser();
        analyser.analyseLogFile(logFile, optionsList);

    }

}
