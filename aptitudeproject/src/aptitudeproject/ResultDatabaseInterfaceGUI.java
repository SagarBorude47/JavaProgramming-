package aptitudeproject;
import javax.swing.*;
import java.util.Vector;
import java.sql.*; 
import java.awt.*;

class ResultDatabaseInterfaceGUI extends JFrame implements Runnable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTable sheet;
	Thread t;
	Vector<String> row;
	Vector<String> col;
	Vector<String> roedata;

	ResultDatabaseInterfaceGUI()
	{
		try
		{
			row=new Vector<>();

			col=new Vector<String>();
			col.add("Id");
			col.add("Name");
			col.add("Mark");
			col.add("Subject");

			setVisible(true);
			setLocation(350,250);
			setSize(300,300);
			setResizable(false);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			t=new Thread(this);
			t.start();
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null,""+e);
		}
	}
	public void run()
	{
		try
		{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			String url = "jdbc:ucanaccess://C:\\Users\\prakash\\eclipse-workspace\\aptitudeproject.zip_expanded\\aptitudeproject\\src\\aptitudeproject\\ResultDatabase.mdb";
			Connection con = DriverManager.getConnection(url);
			String sql=new String("select * from result_sheet");
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();

			//String id,nm,mrk,sub;

			
			while(rs.next())
			{
				    Vector<String> roedata = new Vector<>();
	                roedata.add(rs.getString("Id"));
	                roedata.add(rs.getString("Name"));
	                roedata.add(rs.getString("Mark"));
	                roedata.add(rs.getString("Subject"));
	                row.addAll(roedata);
				
			}
			
			sheet=new JTable();
			add(sheet,BorderLayout.CENTER);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			//JOptionPane.showMessageDialog(null,""+e);
		}
		
	}
	public static void main(String []args)
	{
		new ResultDatabaseInterfaceGUI();
	}
}
