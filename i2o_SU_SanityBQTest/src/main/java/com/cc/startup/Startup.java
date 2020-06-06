package com.cc.startup;

import org.testng.annotations.Test;

import com.cc.readexcel.ExcelLibrary;
import com.cc.utils.UtilServices;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class Startup  {
	
   public static  String Clientid=null;
	public static String file=null;
	public static String scenarioname=null;
	
	
  @Test
  public void RuntestSuite() throws EncryptedDocumentException, InvalidFormatException, IOException, ClassNotFoundException {
	 
	  ExcelLibrary lib=new ExcelLibrary();
	  int TotalClients = lib.Getrowcountfromclientfile("Clients");
	  System.out.println("Totalclients in  excel" + TotalClients);

	  
for (int client = 1; client <= TotalClients; client++) {
String Clientexecutionstatus=lib.getExcelValuegeneric("Clients", client, 1,".\\config\\Clients.xlsx");
System.out.println("Clientexecutionstatus"+Clientexecutionstatus);


if(Clientexecutionstatus.equalsIgnoreCase("Yes")){

	Clientid=lib.getExcelValuegeneric("Clients", client, 0,".\\config\\Clients.xlsx");		

	System.out.println("********************Test Is running for:-"+Clientid+"********************");
	  int  totaltests =0;
	  
if(Clientid.equals("i2o-dev-su"))	{
		  file=".\\Testcases\\testscenarios.xlsx";
          totaltests = lib.Getrowcountgeneric("scenarios",file);
			  for(int testscenario=1;testscenario<=totaltests;testscenario++) {
           String scenariosexecutionstatus=lib.getExcelValuegeneric("scenarios", testscenario, 1,file);
			  	if(scenariosexecutionstatus.equalsIgnoreCase("yes")) {
			  scenarioname=lib.getExcelValue("scenarios", testscenario, 0);
	System.out.println("********************Executing TestCases of:-"+scenarioname+"***************************");
			  UtilServices.callTestcases();
          lib.setExcelValueGeneric("scenarios", testscenario, 2, lib.getdateandtime(),file);

			  }
			  	
			  	}			
		}
else if(Clientid.equals("i2o-dev-dell"))	{
	  file=".\\Testcases\\testscenarios-dell.xlsx";
      totaltests = lib.Getrowcountgeneric("scenarios",file);
		  for(int testscenario=1;testscenario<=totaltests;testscenario++) {
       String scenariosexecutionstatus=lib.getExcelValuegeneric("scenarios", testscenario, 1,file);
		  	if(scenariosexecutionstatus.equalsIgnoreCase("yes")) {
		  scenarioname=lib.getExcelValue("scenarios", testscenario, 0);
System.out.println("********************Executing TestCases of:-"+scenarioname+"***************************");
		  UtilServices.callTestcases();
      lib.setExcelValueGeneric("scenarios", testscenario, 2, lib.getdateandtime(),file);

		  }
		  	
		  	}			
	}
else if(Clientid.equals("i2o-dev-victrola"))	{
	  file=".\\Testcases\\testscenarios-victrola.xlsx";
    totaltests = lib.Getrowcountgeneric("scenarios",file);
		  for(int testscenario=1;testscenario<=totaltests;testscenario++) {
     String scenariosexecutionstatus=lib.getExcelValuegeneric("scenarios", testscenario, 1,file);
		  	if(scenariosexecutionstatus.equalsIgnoreCase("yes")) {
		  scenarioname=lib.getExcelValue("scenarios", testscenario, 0);
System.out.println("********************Executing TestCases of:-"+scenarioname+"***************************");
		  UtilServices.callTestcases();
    lib.setExcelValueGeneric("scenarios", testscenario, 2, lib.getdateandtime(),file);

		  }
		  	
		  	}			
	}	  
else if(Clientid.equals("i2o-dev-ecovacs"))	{
	  file=".\\Testcases\\testscenarios-ecovacs.xlsx";
  totaltests = lib.Getrowcountgeneric("scenarios",file);
		  for(int testscenario=1;testscenario<=totaltests;testscenario++) {
   String scenariosexecutionstatus=lib.getExcelValuegeneric("scenarios", testscenario, 1,file);
		  	if(scenariosexecutionstatus.equalsIgnoreCase("yes")) {
		  scenarioname=lib.getExcelValue("scenarios", testscenario, 0);
System.out.println("********************Executing TestCases of:-"+scenarioname+"***************************");
		  UtilServices.callTestcases();
  lib.setExcelValueGeneric("scenarios", testscenario, 2, lib.getdateandtime(),file);

		  }
		  	
		  	}			
	}	
else if(Clientid.equals("i2o-dev-jvc"))	{
	  file=".\\Testcases\\testscenarios-jvc.xlsx";
    totaltests = lib.Getrowcountgeneric("scenarios",file);
		  for(int testscenario=1;testscenario<=totaltests;testscenario++) {
     String scenariosexecutionstatus=lib.getExcelValuegeneric("scenarios", testscenario, 1,file);
		  	if(scenariosexecutionstatus.equalsIgnoreCase("yes")) {
		  scenarioname=lib.getExcelValue("scenarios", testscenario, 0);
System.out.println("********************Executing TestCases of:-"+scenarioname+"***************************");
		  UtilServices.callTestcases();
    lib.setExcelValueGeneric("scenarios", testscenario, 2, lib.getdateandtime(),file);

		  }
		  	
		  	}			
	}
else if(Clientid.equals("i2o-dev-cedar"))	{
	  file=".\\Testcases\\testscenarios-cedar.xlsx";
totaltests = lib.Getrowcountgeneric("scenarios",file);
		  for(int testscenario=1;testscenario<=totaltests;testscenario++) {
 String scenariosexecutionstatus=lib.getExcelValuegeneric("scenarios", testscenario, 1,file);
		  	if(scenariosexecutionstatus.equalsIgnoreCase("yes")) {
		  scenarioname=lib.getExcelValue("scenarios", testscenario, 0);
System.out.println("********************Executing TestCases of:-"+scenarioname+"***************************");
		  UtilServices.callTestcases();
lib.setExcelValueGeneric("scenarios", testscenario, 2, lib.getdateandtime(),file);

		  }
		  	
		  	}			
	}	  	  
else if(Clientid.equals("i2o-dev-ausgold"))	{
	  file=".\\Testcases\\testscenarios-ausgold.xlsx";
totaltests = lib.Getrowcountgeneric("scenarios",file);
		  for(int testscenario=1;testscenario<=totaltests;testscenario++) {
String scenariosexecutionstatus=lib.getExcelValuegeneric("scenarios", testscenario, 1,file);
		  	if(scenariosexecutionstatus.equalsIgnoreCase("yes")) {
		  scenarioname=lib.getExcelValue("scenarios", testscenario, 0);
System.out.println("********************Executing TestCases of:-"+scenarioname+"***************************");
		  UtilServices.callTestcases();
lib.setExcelValueGeneric("scenarios", testscenario, 2, lib.getdateandtime(),file);

		  }
		  	
		  	}			
	}	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
  }
}
	}
}