package main.com.iontrading.anvil.utilities;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Created by jameswillby on 16/04/2016.
 */
public class BasicPropertiesFileLoader implements PropertiesFileLoader {

    private static final Logger log = Logger.getLogger(BasicPropertiesFileLoader.class.getName());

    public BasicPropertiesFileLoader() {
    }

    @Override
    public List<BasicComponentOptions> returnComponentOptions(String fileLocation) {

        BufferedReader br = null;
        List<BasicComponentOptions> components = null;

        try {
            br = new BufferedReader(new FileReader(fileLocation));

            try {

                components = new LinkedList<BasicComponentOptions>();
                boolean moreLines = true;


                while (moreLines) {

                    String element = br.readLine();
                    if (null == element) {
                        moreLines = false;
                        continue;
                    }


                    if (element.contains("COMPONENTS")) {
                        String split = element.substring(element.lastIndexOf("=") + 1);
                        String[] componentList = split.split(",");

                        for (String a : componentList) {
                            components.add(new BasicComponentOptions(a));
                        }
                    } else {
                        for (int i = 0; i < components.size(); i++) {

                            if (element.contains(components.get(i).getComponent()))
                                components.get(i).setOption(element.substring(element.lastIndexOf("=") + 1));
                        }
                    }
                }
            } finally {
                br.close();
            }
        } catch (IOException eX) {
            log.log(Level.WARNING, eX.getMessage());
        }
        return components;
    }
}
