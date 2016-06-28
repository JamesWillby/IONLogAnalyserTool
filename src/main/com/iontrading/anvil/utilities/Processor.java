package main.com.iontrading.anvil.utilities;

import java.util.List;

/**
 * Created by jameswillby on 17/04/2016.
 */
public interface Processor {

    public void setComponentAndOptionsList(List<BasicComponentOptions> list, String component, String fileName);

    public void analyseFile();

}
