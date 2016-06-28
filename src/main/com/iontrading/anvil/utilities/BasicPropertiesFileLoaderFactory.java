package main.com.iontrading.anvil.utilities;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by jameswillby on 17/04/2016.
 */
public class BasicPropertiesFileLoaderFactory {

    private static final Logger log = Logger.getLogger(BasicPropertiesFileLoaderFactory.class.getName());
    private static BasicPropertiesFileLoaderFactory instance = null;

    private BasicPropertiesFileLoaderFactory() {
    }

    public static BasicPropertiesFileLoaderFactory returnInstance() {
        if (null == instance)
            instance = new BasicPropertiesFileLoaderFactory();
        return instance;
    }

    public BasicPropertiesFileLoader getFactory() {
        log.log(Level.INFO, "Providing new instance of BasicPropertiesFileLoader" + "\n");
        return new BasicPropertiesFileLoader();
    }
}
