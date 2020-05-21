package com.cc.utils;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.cc.readexcel.ExcelLibrary;
import com.cc.startup.Startup;

public class UtilServices extends Startup {

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
		}
		}
	}

}
