package main.com.iontrading.anvil.utilities;

import java.util.List;

/**
 * Created by jameswillby on 16/04/2016.
 */
public interface PropertiesFileLoader {

    public List<BasicComponentOptions> returnComponentOptions(String fileLocation);

}
