package main.com.iontrading.anvil.utilities;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by jameswillby on 17/04/2016.
 */
public class BasicProcessor implements Processor, Runnable {

    private static final Logger log = Logger.getLogger(BasicProcessor.class.getName());

    private String logFile = null;
    private List<String> componentAndOptions = new LinkedList<String>();
    private AnalysisStrategy analyser = new BasicAnalyser();

    public BasicProcessor() {
    }

    public BasicProcessor(String _logFile, List<String> _componentAndOptions) {
        logFile = _logFile;
        componentAndOptions = _componentAndOptions;
    }

    @Override
    public void run() {
        analyseFile();
    }

    @Override
    public void setComponentAndOptionsList(List<BasicComponentOptions> list, String component, String fileName) {

        logFile = fileName;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getComponent().equals(component)) {
                componentAndOptions.add(list.get(i).getComponent());
                for (int j = 0; j < list.get(i).getSize(); j++) {
                    componentAndOptions.add(list.get(i).getOption(j));
                }
                log.log(Level.INFO, "Added options for component: " + component + "\n");
                return;
            }

        }
        log.log(Level.WARNING, "No options found for component: " + component + "\n");

    }

    @Override
    public void analyseFile() {

        analyser.analyseLogFile(logFile, componentAndOptions);

    }
}
