package aptitudeproject;
import java.sql.*;
import javax.swing.JOptionPane;

class QuestionFill
{
	static Connection con;
	static PreparedStatement ps;
	static String sql;
	static ResultSet rs;

	Question que;
	int id;
	static String table;


	static
	{
		try
		{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			String url = "jdbc:ucanaccess://C:\\Users\\prakash\\eclipse-workspace\\aptitudeproject.zip_expanded\\aptitudeproject\\src\\aptitudeproject\\AptiDatabase.mdb";
		 con = DriverManager.getConnection(url);
			sql=new String();		
		}
		catch (Exception a)
		{
			System.out.println(""+a);
		}
	}
	public QuestionFill()
	{
		que=new Question();
		id=1;
		//System.out.println(QueFillSubject.getSubject());
		if(QueFillSubject.getSubject().trim().equals("C Programming"))table="c_apti_db";
		if(QueFillSubject.getSubject().trim().equals("C++ Programming"))table="cpp_apti_db";
		if(QueFillSubject.getSubject().trim().equals("Java Programming"))table="j_apti_db";
		if(QueFillSubject.getSubject().trim().equals("C# Programming"))table="ch_apti_db";
	}


	public void storeQuestion(int id,String que,String o1,String o2,String o3,String o4,String ans)
	{
		try
		{
//			sql="insert into apti_db values(?,?,?,?,?,?,?)";
			sql="insert into "+table+" (id, question, opt1, opt2, opt3, opt4, answer) values(?,?,?,?,?,?,?)";
			
			ps=con.prepareStatement(sql);
			ps.setString(1,""+id);
			ps.setString(2,que.trim());
			ps.setString(3,o1.trim());
			ps.setString(4,o2.trim());
			ps.setString(5,o3.trim());
			ps.setString(6,o4.trim());
			ps.setString(7,ans.trim());
			ps.executeUpdate();
			ps.close();
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null,"Check Id "+e);
		}
	}
	
	public void updateQuestion(int id,String que,String o1,String o2,String o3,String o4,String ans)
	{
		try
		{
//			sql="update apti_db set question=?,opt1=?,opt2=?,opt3=?,opt4=?,answer=? where id="+id;
			sql="update "+table +" set question=?,opt1=?,opt2=?,opt3=?,opt4=?,answer=? where id="+id;
			ps=con.prepareStatement(sql);
			ps.setString(1,que.trim());
			ps.setString(2,o1.trim());
			ps.setString(3,o2.trim());
			ps.setString(4,o3.trim());
			ps.setString(5,o4.trim());
			ps.setString(6,ans.trim());
			ps.executeUpdate();
			ps.close();
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null,"Check Id "+e);
		}
	}
	public int getNextID()
	{
		try
		{
			sql="select id from "+table;
			ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				id=rs.getInt("id");

			}
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null,"Result Set Error "+e);
			e.printStackTrace();
		}
		return id+1 ;
	}
	
	public Question getfullQuestion(int id)
	{
		try
		{
			System.out.println("table is: "+table);
			sql="select * from "+table+" where id= "+id;
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next())
			{
				que.setID(id);
				que.setQuestion(rs.getString("question").trim());
				que.setOption1(rs.getString("opt1").trim());
				que.setOption2(rs.getString("opt2").trim());
				que.setOption3(rs.getString("opt3").trim());
				que.setOption4(rs.getString("opt4").trim());
				que.setAnswer(rs.getString("answer").trim());
			}
	
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null,""+e);
			e.printStackTrace();
		}
		return que;
	}

	public static void main(String[] args) 
	{
		JOptionPane.showMessageDialog(null,""+new QuestionFill().getNextID());
		new QueFillSubject("QueFillSubject");
	}
}
