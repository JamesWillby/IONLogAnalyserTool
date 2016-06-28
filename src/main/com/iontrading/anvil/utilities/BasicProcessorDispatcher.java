package main.com.iontrading.anvil.utilities;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by jameswillby on 17/04/2016.
 */
public class BasicProcessorDispatcher implements ProcessorDispatcher {

    private static final Logger log = Logger.getLogger(ProcessorDispatcher.class.getName());

    @Override
    public void enactAnalysis(List<Processor> processors) {

        log.log(Level.INFO, "Beginning log analyser threads");

        try {
            for (Processor a : processors) {
                if (a instanceof BasicProcessor) {
                    BasicProcessor processor = (BasicProcessor) a;
                    Thread thread = new Thread(processor);
                    thread.start();
                } else {
                    throw new ClassNotFoundException("Not an instance of BasicProcessor");
                }

            }
        } catch (ClassNotFoundException ex) {
            log.log(Level.WARNING, ex.getMessage());
        }
    }
}
