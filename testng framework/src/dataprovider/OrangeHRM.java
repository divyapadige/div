package dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import sample.Excel;

public class OrangeHRM {
	
	public Object[][] getExcelData(){
		Excel.setExcel("inputdata.xls", "Sheet1");
		int rc = Excel.getRowCount();
		int cc = Excel.getColumnCount();
		Object[][] data = new String[rc-1][cc];
		for(int r=1; r<rc;r++ ){
			for(int c=0;c<cc;c++){
				data[r-1][c] = Excel.readData(r, c);
			}
		}
		return data;
	}
	public Object[][] getExcelData(String fileName, String sheetName){
		Excel.setExcel(fileName, sheetName);
		int rc = Excel.getRowCount();
		int cc = Excel.getColumnCount();
		Object[][] data = new String[rc-1][cc];
		for(int r=1; r<rc;r++ ){
			for(int c=0;c<cc;c++){
				data[r-1][c] = Excel.readData(r, c);
			}
		}
		return data;
	}
	
	@Test(dataProvider = "dp1")
	public void dataProviderDemo(int data, String value){
		System.out.println(data+value);
	}

	
	@DataProvider(name="dp1")
	public Object[][] data(){
//		return new Object[][]{ new Object[]{"surya","password" },
		//new Object[]{"prakash","password"} };
		
//		Object[][] data = new Object[3][2];
//		data[0][0]=1;
//		data[0][1]="surya";
//		data[1][0]=12;
//		data[1][1]="prakash";
//		data[2][0]=13;
//		data[2][1]="surya prakash";
//		return data;
		return getExcelData();
	}
	@DataProvider(name = "roles")
	public Object[][] roleData(){
		return getExcelData("inputdata.xls","Sheet2");
	}
}
