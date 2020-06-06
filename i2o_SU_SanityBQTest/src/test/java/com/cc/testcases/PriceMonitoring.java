package com.cc.testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Test;

import com.cc.ExecuteBQ.Testexecutor;
import com.cc.filereader.ReadWER;
import com.cc.readexcel.ExcelLibrary;
import com.cc.utils.UtilServices;

public class PriceMonitoring {
	 ExcelLibrary lib=new ExcelLibrary();
	ReadWER wer=new ReadWER();
	public UtilServices utilServices = new UtilServices();
	@Test
	public void test() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		 System.out.println("under  PriceMonitoring test");
			Testexecutor Te=new Testexecutor();
			Te.getAllcolumnsPrestage(this.getClass().getSimpleName());
             System.out.println("after prestgae");
        Te.getAllcolumnsDataMart(this.getClass().getSimpleName());
			 System.out.println("after datamart");
		this.utilServices.getPreAndMartDiff(this.getClass().getSimpleName(), lib);

	}

	
}