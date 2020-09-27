import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/jdbc-test";
		String user = "root";
		String password = "haicntt28";
		String driver = "com.mysql.cj.jdbc.Driver";
		Connection cn = null;
		try {
			Class.forName(driver);
			 cn = DriverManager.getConnection(url, user, password);
			// insert(cn);
			print(cn);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			cn.close();
		}
	}

	private static void print(Connection cn) {
		// TODO Auto-generated method stub
		String sql = "select * from student";
		try {
			// tao thu tuc
			PreparedStatement ps = cn.prepareStatement(sql);
			// tao con tro trong mang va lay du lieu ra
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(
				"id = "+rs.getInt("id")+" & name= "+rs.getString("name")
				+" & Age = "+rs.getInt("Age")+" & address = "+rs.getString("address")
					             );
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private static void insert(Connection cn) {
		// TODO Auto-generated method stub
		String sql = "insert into student(name,Age,address) values (?,?,?)";
		try {
			for (int i = 1; i <= 5; i++) {
				PreparedStatement ps = cn.prepareStatement(sql);
				ps.setString(1, "Hai" + i);
				ps.setInt(2, 20 + i);
				ps.setString(3, "Ha Tinh");
				if (ps.execute() == true) {
					System.out.println("Them that bai");

				} else {
					System.out.println("Them thành công");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
