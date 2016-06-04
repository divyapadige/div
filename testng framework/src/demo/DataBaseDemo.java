package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DataBaseDemo {

	@Test
	public void DBdemo() {
		try {
			// get the driver class
			Class.forName("com.mysql.jdbc.Driver");
			// connect to DB
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "surya");
			// create statement class object to execute the queries
			Statement st = con.createStatement();
			// st.executeUpdate("update ");
			ResultSet rs = st.executeQuery("select branchName from branches where branchId =5");
			while (rs.next()) {
//				System.out.println("branch id is "+rs.getString("branchId")+"\nbrnach name is "+rs.getString("branch name"));
//				System.out.println("branch name is "+rs.getString("branchName"));
				Assert.assertEquals(rs.getString("branchName"), "kuklly branch");
				System.out.println("test passed");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
