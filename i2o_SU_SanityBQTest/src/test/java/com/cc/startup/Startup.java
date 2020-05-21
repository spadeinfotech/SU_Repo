package com.cc.startup;

import org.junit.runner.JUnitCore;
import org.testng.annotations.Test;

import com.cc.BQutils.BQutils;
import com.cc.ExecuteBQ.Testexecutor;
import com.cc.filereader.ReadWER;
import com.cc.readexcel.ExcelLibrary;
import com.google.auth.oauth2.ClientId;
import com.google.cloud.bigquery.BigQuery;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class Startup  {
	
	
	public static  String Clientid=null;
	public static String file=null;
  @Test
  public void RuntestSuite() throws EncryptedDocumentException, InvalidFormatException, IOException {
	 
	  ExcelLibrary lib=new ExcelLibrary();
	  int TotalClients = lib.Getrowcountfromclientfile("Clients");
	  System.out.println("Totalclients in  excel" + TotalClients);
for (int client = 1; client <= TotalClients; client++) {
String Clientexecutionstatus=lib.getExcelValuegeneric("Clients", client, 1,".\\config\\Clients.xlsx");
System.out.println("Clientexecutionstatus"+Clientexecutionstatus);


if(Clientexecutionstatus.equalsIgnoreCase("Yes")){

	Clientid=lib.getExcelValuegeneric("Clients", client, 0,".\\config\\Clients.xlsx");		

	System.out.println("Clientid in startup"+Clientid);
	  int  totaltests =0;
	  if(Clientid.equals("i2o-dev-su"))	{
		  file=".\\Testcases\\testscenarios.xlsx";
		 
		  totaltests = lib.Getrowcountgeneric("scenarios",file);
			System.out.println("Under SU condition");
			 System.out.println("totaltests"+totaltests);
			  for(int testscenario=1;testscenario<=totaltests;testscenario++) {
         String scenariosexecutionstatus=lib.getExcelValuegeneric("scenarios", testscenario, 1,file);
			  	System.out.println("executionstatus"+scenariosexecutionstatus);
//			  	System.out.println(executionstatus);
			  	if(scenariosexecutionstatus.equalsIgnoreCase("yes")) {
			  String scenarioname=lib.getExcelValue("scenarios", testscenario, 0);
			  System.out.println("********************scenario name******************************"+scenarioname);

			  JUnitCore runTest = new JUnitCore();
			  @SuppressWarnings("rawtypes")
			  Class c;
			  try {
			  	
			  	c = Class.forName("com.cc.testcases."+scenarioname);
			  	
			  	System.out.println(c);
			  	runTest.run(c);
		lib.setExcelValueGeneric("scenarios", testscenario, 2, lib.getdateandtime(),file);
			  	} catch (ClassNotFoundException e) {
			  	// TODO Auto-generated catch block
			  	e.printStackTrace();
			       }	

			  }
			  	
			  	}		
			
			
			 
			
		}
	  else  if(Clientid.equals("i2o-dev-cedar"))	{
		  file=".\\Testcases\\testscenarios-cedar.xlsx";
		  totaltests = lib.Getrowcountgeneric("scenarios",file);
			System.out.println("Under cedar condition");
			 System.out.println("totaltests"+totaltests);
			  for(int testscenario=1;testscenario<=totaltests;testscenario++) {
			  	
			  	String scenariosexecutionstatus=lib.getExcelValuegeneric("scenarios", testscenario, 1,file);
			  	System.out.println("executionstatus"+scenariosexecutionstatus);
//			  	System.out.println(executionstatus);
			  	if(scenariosexecutionstatus.equalsIgnoreCase("yes")) {
			  String scenarioname=lib.getExcelValue("scenarios", testscenario, 0);
			  System.out.println("********************scenario name******************************"+scenarioname);

			  JUnitCore runTest = new JUnitCore();
			  @SuppressWarnings("rawtypes")
			  Class c;
			  try {
			  	
			  	c = Class.forName("com.cc.testcases."+scenarioname);
			  	
			  	System.out.println(c);
			  	 lib.setExcelValueGeneric("scenarios", testscenario, 2, lib.getdateandtime(),file);
			  	runTest.run(c);
			  	} catch (ClassNotFoundException e) {
			  	// TODO Auto-generated catch block
			  	e.printStackTrace();
			       }	

			  }
			  	
			  	}	
			
			
			
		}
	  

  }
}
	}
}