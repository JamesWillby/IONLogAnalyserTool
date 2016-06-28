package test.com.iontrading.anvil.utilities;

import main.com.iontrading.anvil.utilities.*;
import org.junit.Test;

import java.util.logging.Logger;

/**
 * Created by jameswillby on 16/04/2016.
 */
public class TestBasicPropertiesFileLoader {

    private static final Logger log = Logger.getLogger(BasicPropertiesFileLoader.class.getName());


    PropertiesFileLoader basicLoader = new BasicPropertiesFileLoader();
    Processor basicProcessor = new BasicProcessor();
    String file = "/Users/jameswillby/IdeaProjects/LogAnalyserServer/src/resources/properties.txt";
    String logFile = "/Users/jameswillby/IdeaProjects/LogAnalyserServer/src/resources/Test.log";
    List<BasicComponentOptions> options = basicLoader.returnComponentOptions(file);
    List<Processor> dispatchList = new LinkedList<Processor>();
    ProcessorDispatcher dispatcher = new BasicProcessorDispatcher();
    AnalysisStrategy analyser = null;
    List<String> optionsList = null;


    @Test
    public void TestProcessDispatcher() {
        basicProcessor.setComponentAndOptionsList(options, "InternalAllocation", logFile);
        dispatchList.add(basicProcessor);
        dispatcher.enactAnalysis(dispatchList);
    }

}