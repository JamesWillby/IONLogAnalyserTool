package test.com.iontrading.anvil.utilities;

import main.com.iontrading.anvil.utilities.BasicOptionResults;
import main.com.iontrading.anvil.utilities.BasicResultSet;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by jameswillby on 12/05/2016.
 */
public class TestBasicResultSet {

    @Test
    public void testBasicResultsSet() {

        BasicResultSet resultSet = new BasicResultSet();
        BasicOptionResults optionResults = new BasicOptionResults("SQL");
        List<BasicOptionResults> list = new LinkedList<BasicOptionResults>();
        optionResults.setOption("00:20:09:323|0092-00027:SQL: {INFO} Action");
        list.add(optionResults);
        resultSet.processResultSet(list);
        List<BasicOptionResults> listResponse = resultSet.getResultsList();

        Assert.assertEquals("SQL", listResponse.get(0).getComponent());


    }

    @Test
    public void confirmNoPipes() {

        BasicResultSet resultSet = new BasicResultSet();
        BasicOptionResults optionResults = new BasicOptionResults("SQL");
        List<BasicOptionResults> list = new LinkedList<BasicOptionResults>();
        optionResults.setOption("00:20:09:323|0092-00027:SQL: {INFO} Action");
        list.add(optionResults);
        resultSet.processResultSet(list);
        List<BasicOptionResults> listResponse = resultSet.getResultsList();
        Assert.assertTrue(listResponse.get(0).getOption(0).contains("0"));


    }

    @Test
    public void confirmWriteToFile() {

        BasicResultSet resultSet = new BasicResultSet();
        BasicOptionResults optionResults = new BasicOptionResults("SQL");
        List<BasicOptionResults> list = new LinkedList<BasicOptionResults>();
        optionResults.setOption("00:20:09:323|0092-00027:SQL: {INFO} Action");
        list.add(optionResults);
        resultSet.processResultSet(list);
        resultSet.generateExcel();
    }
}
