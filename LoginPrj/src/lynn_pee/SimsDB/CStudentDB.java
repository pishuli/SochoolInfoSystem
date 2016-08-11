package lynn_pee.SimsDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import lynn_pee.Student.*;

public class CStudentDB 
{
	final String studentTable = "student_info";
	final String nameColumn   = "name";
	final String passwdColumn = "password";
	final String ageColumn    = "age";
	final String phoneColumn  = "phone";
	public Connection getDBConn()
	{
		Connection connDB;
		connDB = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connDB = DriverManager.getConnection("jdbc:mysql://localhost:3306/sims", "root", "1");
		}
        catch(Exception e)
		{
        	e.printStackTrace();
		}
		return connDB;
	}

	//查找是某条学生信息
	public int findStudent(String name, CStudentInfo retInfo)
	{
		Connection connDB;
		connDB = getDBConn();
		if (connDB != null)
		{
			String sql = "select * from " + studentTable + " where "+nameColumn+"=?";
			System.out.println(sql);
			try
			{
				PreparedStatement ps = connDB.prepareStatement(sql);
				ps.setString(1, name);
				ResultSet ret = ps.executeQuery();
				
				if (ret.next())
				{
					if (retInfo != null)
					{
						retInfo.setName(ret.getString(nameColumn));
						retInfo.setPassword(ret.getString(passwdColumn));
						retInfo.setAge(ret.getInt(ageColumn));
						retInfo.setPhone(ret.getString(phoneColumn));
					}
					return 0;
				}
				else
				{
					return -1;
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return -1; 
	}
	
	//插入某条信息
	public int addStudent(CStudentInfo retInfo)
	{
		Connection connDB;
		connDB = getDBConn();
		if (connDB != null)
		{
			String sql = "select * from " + studentTable + " where "+nameColumn+"=?";
			System.out.println(sql);
			try
			{
				PreparedStatement ps = connDB.prepareStatement(sql);
				ps.setString(1, retInfo.getName());
				ResultSet ret = ps.executeQuery();
				
				if (ret.next())
				{
					//已经存在了
					return -1;
				}
				else
				{
					String insertSQL = String.format("insert into student_info(%s,%s,%s,%s) value(?,?,?,?)", 
						                              nameColumn, passwdColumn, ageColumn, phoneColumn);
					System.out.println(insertSQL);
					PreparedStatement psInsert = connDB.prepareStatement(insertSQL);
					//psInsert.setString(1, nameColumn);
					//psInsert.setString(2, passwdColumn);
					//psInsert.setString(3, ageColumn);
					//psInsert.setString(4, phoneColumn);
					
					psInsert.setString(1, retInfo.getName());
					psInsert.setString(2, retInfo.getPassword());
					psInsert.setInt(3, retInfo.getAge());
					psInsert.setString(4, retInfo.getPhone());
					psInsert.executeUpdate();
					return 0;
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return -1; 
	}
}
