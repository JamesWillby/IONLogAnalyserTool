package main.com.iontrading.anvil.utilities;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by jameswillby on 17/04/2016.
 */
public class BasicOptionResults {

    private String component = null;
    private List<String> options = null;

    public BasicOptionResults() {
    }

    public BasicOptionResults(String s) {
        component = s;
        options = new LinkedList<String>();
    }

    public String getComponent() {
        return component;
    }

    public void setOption(String _option) {
        this.options.add(_option);

    }

    public String getOption(int _value) {
        return this.options.get(_value);
    }

    public int getSize() {
        return this.options.size();
    }


}
