import java.sql.*;

public class pracAll{

	public static Connection getConnect(){
		Connection con = null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","system","Ma87591@");
		}catch(ClassNotFoundException | SQLException e){
			System.out.println(e.toString());
		}
		return con;
	}

	public static void showRecods(){
		try{
			Connection con = getConnect();
			Statement st = con.createStatement();
			String sql = "select*from record";
			ResultSet rs = st.executeQuery(sql);

			System.out.println("ID\tName\t\tAge\tAddress");
			while(rs.next()){
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t\t"+rs.getInt(3)+"\t"+rs.getString(4));
			}
		con.close();
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}

	public static int insertRecord(int id, String name, int age, String addr){
		int res = 0;
		try{
			Connection con = getConnect();
			String sql = "insert into record values("+id+",'"+name+"',"+age+",'"+addr+"')";
			Statement st = con.createStatement();
			res = st.executeUpdate(sql);
		}catch(Exception e){
			System.out.println(e.toString());
		}
		return res;
	}

	//Create a method for delete the data from the Oracle database
	public static int delRecord(int gid){
		int res = 0;
		try{
			Connection con = getConnect();
			Statement st = con.createStatement();
			String sql = "delete from record where id = "+gid+"";
			res = st.executeUpdate(sql);
		}catch(Exception e){
			System.out.println(e.toString());
		}
		return res;
	}

	public static void main(String[] args){
	
		//insertRecord(104, "MyLove", 20, "Karad");
		delRecord(103);
		showRecods();
	}
}