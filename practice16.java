import java.sql.*;

public class practice16{

	//Create a method for Connect the Oracle database
	public static Connection getConnect(){

		Connection con = null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521";
			con = DriverManager.getConnection(url,"system","Ma87591@");

		}catch(ClassNotFoundException | SQLException e){
			System.out.println(e.toString());
		}
		return con;
	}

	//Create this method for Read the Oracle Databases
	public static void showrecords(){

		Connection con = null;
		Statement st;
		ResultSet rs;
	
		try{

			con = getConnect();
			st = con.createStatement();
			String sql = "select * from record";
			rs = st.executeQuery(sql);

			System.out.println("ID\tName\t\tAge\tAddress");
			while(rs.next()){

				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2)+"\t\t");
				System.out.print(rs.getInt(3)+"\t");
				System.out.println(rs.getString(4)+"\t");
			}
			con.close();
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}

	//Create this method for Add(Insert) the data in the Oracle databases
	public static int insertRecord(int id, String name, int age, String addr){
		Connection con = null;
		Statement st;
		int res = 0;
		
		try{
			con = getConnect();
			String sql = "insert into record values("+id+",'"+name+"',"+age+",'"+addr+"')";
			st = con.createStatement();
			res = st.executeUpdate(sql);

		}catch(Exception e){
			System.out.println(e.toString());
		}
		return res;
	}
	
	//Create this method for Delete data from the Oracle databases
	public static int delRecord(int gid){
		Connection con = null;
		Statement st;
		int res = 0;

		try{
			con = getConnect();
			st = con.createStatement();
			String sql = "delete from record where id="+gid+"";
			res = st.executeUpdate(sql);


		}catch(Exception e){
			System.out.println(e.toString());
		}
		return res;
	}

	//This is the Main Method
	public static void main(String[] args){
		
		//insertRecord(107,"Tanmay", 33, "Dhaka");
		delRecord(104);
		showrecords();


	}
}





































