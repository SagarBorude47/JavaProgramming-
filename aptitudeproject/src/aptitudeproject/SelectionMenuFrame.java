package aptitudeproject;
import javax.swing.*;
import java.awt.event.*;

class SelectionMenuFrame extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JMenuBar bar;

	JMenu client;
	JMenuItem ins;
	JMenuItem soe;
	JMenuItem qfs;
	JMenuItem ex;
	

	JMenu abt;
	JMenuItem dev;
	JMenuItem sys;

	SelectionMenuFrame(String ttl)
	{
		super(ttl);

		bar=new JMenuBar();

		client=new JMenu("Client");
		ins=new JMenuItem("Instructions");
		ins.addActionListener(this);
		client.add(ins);
		soe=new JMenuItem("Start Exam");
		soe.addActionListener(this);
		client.add(soe);
		qfs = new JMenuItem("Modify");
		qfs.addActionListener(this);
		client.add(qfs);
		ex=new JMenuItem("Exit");
		ex.addActionListener(this);
		client.add(ex);
		bar.add(client);

		abt=new JMenu("About");
		dev=new JMenuItem("Developer Team");
		dev.addActionListener(this);
		abt.add(dev);
		sys=new JMenuItem("Product Help");
		sys.addActionListener(this);
		abt.add(sys);
		bar.add(abt);

		setJMenuBar(bar);

		setVisible(true);
		setLocation(350,250);
		setSize(300,300);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());	
			SwingUtilities.updateComponentTreeUI(this);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==ins)
		{
			new InstructionFrame("Instructions Must Be Read");
			InstructionFrame.makeDisable();
		}
		if(e.getSource()==soe)
		{
			new LoginFrame("Login System");
		}
		if(e.getSource()==qfs)
		{
			new QueFillSubject("Modify");
		}
		if(e.getSource()==ex)
		{
			System.exit(0);
		}
		if(e.getSource()==dev)
		{
			new DeveloperInfoFrame("We Are Developers..");
		}
		if(e.getSource()==sys)
		{
			new ProductHelpFrame("product Help");
		}

	}
}
