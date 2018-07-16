package me.ning.DataStructure.CSV.src;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class TestCVSFile {

    private String filePath = "A:\\ProjectJava\\one\\learn-java\\learn-java-algorithms\\src\\main\\java\\me\\ning\\DataStructure\\CSV\\";

    @Test
    public void testConstructor1(){
        CSVFile testObj = new CSVFile(filePath+"testData.csv", ',');
        assertEquals(testObj.getElementDouble(1,1),65.78331,0.001);
        assertEquals(testObj.getElementString(1, 1),"65.78331");
        assertEquals(testObj.getElementString(0, 1),"\"Height(Inches)\"");
        assertEquals(testObj.getNumberOfRows(),25029);
    }

    @Test
    public void testConstructor2(){
        CSVFile testObj = new CSVFile(',');
        testObj.addRow("1,65.231,123.3");
        testObj.addRow("23,5.62,9.78");
        testObj.addRow("45.234,56.12,324.34");
        testObj.commit(new File(filePath+"testData2.csv"));
    }


    @Test
    public void testConstructor3(){

    }


}
