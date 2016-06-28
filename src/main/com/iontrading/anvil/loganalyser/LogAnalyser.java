package main.com.iontrading.anvil.loganalyser;

import main.com.iontrading.anvil.gui.BasicLogAnalyserGUI;
import main.com.iontrading.anvil.gui.LogAnalyserGUI;
import main.com.iontrading.anvil.utilities.BasicPropertiesFileLoaderFactory;
import main.com.iontrading.anvil.utilities.PropertiesFileLoader;

public class LogAnalyser {

    public static void main(String[] args) {

        LogAnalyserGUI gui = new BasicLogAnalyserGUI();
        gui.start();

        PropertiesFileLoader loader = BasicPropertiesFileLoaderFactory.returnInstance().getFactory();
    }
}
