package sample;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.WritableByteChannel;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Excel {

	private static String folderPath ="//Users//surya//Documents//";
	private static Workbook book;
	private static Sheet sh;
	private static WritableWorkbook wbook;
	public static WritableSheet wsh;

	
	public static String getFolderPath(){
		return folderPath;
	}
	// to create readable excel connection
	public static void setExcel(String filename, String sheetName) {
		try {
			FileInputStream fi = new FileInputStream(folderPath + filename);
			book = Workbook.getWorkbook(fi);
			sh = book.getSheet(sheetName);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// to create readable excel connection
	public static void setExcel(String filename, int sheetnum) {
		try {
			FileInputStream fi = new FileInputStream(folderPath + filename);
			book = Workbook.getWorkbook(fi);
			sh = book.getSheet(sheetnum);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// to create writable excel conneciton
	public static void setOutputExcel(String ifilename, String ofilename, String sheetname) {
		try {
			FileInputStream fi = new FileInputStream(folderPath + ifilename);
			book = Workbook.getWorkbook(fi);
			FileOutputStream fo = new FileOutputStream(folderPath + ofilename);
			wbook = Workbook.createWorkbook(fo);
			wsh = wbook.getSheet(sheetname);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// read data
	public static String readData(int rnum, int cnum) {
		return sh.getCell(cnum, rnum).getContents();
	}

	// writedata
	public static void writedata(String result, int rnum, int cnum) {
		try {
//			Label l = new Label(cnum, rnum, result);
//			wsh.addCell(l);
			wsh.addCell(new Label(cnum, rnum, result));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// writedata
	public static void writedata(int result, int rnum, int cnum) {
		try {
//			Number n = new Number(cnum, rnum, result);
//			wsh.addCell(n);
			wsh.addCell(new Number(cnum, rnum, result));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// row count
	public static int getRowCount() {
		return sh.getRows();
	}
	
	//columng count
	public static int getColumnCount(){
		return sh.getColumns();
	}
	
	//save workbook
	public static void saveWorkbook(){
		try {
			wbook.write();
			wbook.close();
			book.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
