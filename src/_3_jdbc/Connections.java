package _3_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class Connections {

	public Connections() {
		// TODO Auto-generated constructor stub
	}

	public static Connection getConnection() throws SQLException {
		Connection conn = null;

		Properties connectionProps = new Properties();
		connectionProps.put("user", "root");
		connectionProps.put("password", "root");

		conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/test",
				connectionProps);

		return conn;
	}

	public static void testJdbc() {
		RowSetFactory rsFactory = null;
		JdbcRowSet jdbcRs = null;
		ResultSet rs = null;
		Statement stmt = null;

		try {

			rsFactory = RowSetProvider.newFactory();
			jdbcRs = rsFactory.createJdbcRowSet();

			jdbcRs.setUrl("jdbc:mysql://localhost:3307/test");
			jdbcRs.setUsername("root");
			jdbcRs.setPassword("root");

			jdbcRs.setCommand("SELECT * FROM department");
			jdbcRs.execute();

			while (jdbcRs.next()) {

				int rowNo = jdbcRs.getRow();

				
				String s1 = jdbcRs.getString("name");

				int s2 = jdbcRs.getInt("idDepartment");
				System.out.println(rowNo + ": " + s1 + ", " + s2);

			}

		} catch (Exception e) {
e.printStackTrace();
		}
	}

	public static void main(String[] args) {
//		try (Connection nueva = Connections.getConnection();) {
//			System.out.println(nueva.getMetaData().getDatabaseProductName());
//			System.out.println(nueva.getMetaData().getDatabaseProductVersion());
//			System.out.println(nueva.getMetaData().getDriverVersion());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		testJdbc();
	}

}
