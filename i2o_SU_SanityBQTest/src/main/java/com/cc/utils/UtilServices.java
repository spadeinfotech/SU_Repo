package com.cc.utils;

import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.JUnitCore;

import com.cc.filereader.ReadWER;
import com.cc.readexcel.ExcelLibrary;
import com.cc.startup.Startup;

public class UtilServices extends Startup {
	static ReadWER wer = new ReadWER();
	public void getPreAndMartDiff(String scenarioname, ExcelLibrary lib) throws EncryptedDocumentException, InvalidFormatException, IOException {
		Double PrestageVal = 0.0;
		Double Martval = 0.0;
		Double countdifference = 0.0;
		int Totalteststeps = lib.Getrowcountgeneric(scenarioname,file);
	for (int teststep = 1; teststep <= Totalteststeps; teststep++) {	
		PrestageVal = lib.getExcelValueIntGeneric(scenarioname, teststep, 5,file);
		Martval = lib.getExcelValueIntGeneric(scenarioname, teststep, 6,file);
		countdifference = PrestageVal - Martval;
		lib.setExcelValueIntgeneric(scenarioname, teststep, 7, countdifference,file);

		if (countdifference == 0.0) {
			System.out.println("matching condition");
			lib.setExcelValueGeneric(scenarioname, teststep, 8, "Pass",file);

		} else if (Double.compare(countdifference, Double.valueOf(0.0)) > 0
				|| Double.compare(countdifference, Double.valueOf(0.0)) < 0) {
			lib.setExcelValueGeneric(scenarioname, teststep, 8, "Fail",file);
			System.out.println("not matching condition");
		String Failedscenarios=	lib.getExcelValuegeneric(scenarioname, teststep, 2, file);
			System.out.println( Failedscenarios+"is failing for="+Clientid);
			
		}
		}
	}

public static void callTestcases() throws ClassNotFoundException {

	 JUnitCore runTest = new JUnitCore();
	  Class c;
c = Class.forName("com.cc.testcases."+scenarioname);
   //System.out.println("Running tescase:-"+c);
		runTest.run(c);
}



public String ReplaceString(String Query) throws IOException {
	String ratval=null;
	Scanner sc = new Scanner(Query);
    StringBuffer buffer = new StringBuffer();
    while (sc.hasNextLine()) {
       buffer.append(sc.nextLine()+System.lineSeparator());
    }
    String bufferquery = buffer.toString();
    System.out.println("Contents of the file in method: "+bufferquery);
    sc.close();
   // String oldLine = "'2020-05-17' and '2020-05-23'";
    String oldScrapedate=wer.getelemnetfromWER("OldScrape_Date",".\\config\\config.properties");
    String newScrapedate=wer.getelemnetfromWER("NewScrape_Date",".\\config\\config.properties");
    bufferquery = bufferquery.replaceAll(oldScrapedate, newScrapedate);
    ratval=bufferquery;

	return ratval;
}






}
