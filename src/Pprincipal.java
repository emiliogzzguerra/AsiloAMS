/*
Created by CarlosGalvez
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import javax.imageio.ImageIO;
import java.io.IOException;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.*;
import java.sql.*;
import java.util.*;

public class Pprincipal extends JFrame{

	private JButton buttonSubmit,Pacientes, RegistrarPaciente, CapturaReceta, NuevoEvento, Emergencia, ReOrdenMed, PacientesPorMedicar;
	private JTextField BuscarPaciente;

	public Pprincipal(){
		createUI();

		//Make window exit appication on close
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Toolkit tk = Toolkit.getDefaultToolkit();
		int xSize = ((int) tk.getScreenSize().getWidth());
		int ySize = ((int) tk.getScreenSize().getHeight());
		setSize(xSize,ySize);
		setLocationRelativeTo(null);
		//Disable resize
		setResizable(false);
	}

	//Initializes all UI Components
	private void createUI(){
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(10,10,10,10));
		panel.setLayout(new BorderLayout());
		getContentPane().add(panel);

		//North
		JPanel panelNorth = new JPanel(new BorderLayout());
		panel.add(panelNorth, BorderLayout.NORTH);
		panelNorth.add(new JLabel("Buscar Paciente: "), BorderLayout.WEST);
		BuscarPaciente = new JTextField("Nombre del paciente..");
		panelNorth.add(BuscarPaciente, BorderLayout.CENTER);
		buttonSubmit = new JButton("Buscar");
		buttonSubmit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event){
				JFrame frame = new JFrame();
				frame.add(TableFromSql());
				frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		});
		panelNorth.add(buttonSubmit, BorderLayout.EAST);

		//WEST
		JPanel panelWest = new JPanel(new GridBagLayout());
		panel.add(panelWest, BorderLayout.WEST);
		GridBagConstraints d = new GridBagConstraints();
		d.gridx = 0;
		d.gridy = 0;
		d.anchor = GridBagConstraints.LINE_END;

		Pacientes = new JButton("Pacientes");
		Pacientes.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
			}
		});

		panelWest.add(Pacientes, d);
		d.gridy++;


		RegistrarPaciente = new JButton("Registrar Paciente");
		RegistrarPaciente.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){

			}
		});
		panelWest.add(RegistrarPaciente, d);
		d.gridy++;

		CapturaReceta = new JButton("Capturar Receta");
		CapturaReceta.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){

			}
		});
		panelWest.add(CapturaReceta, d);
		d.gridy++;

		NuevoEvento = new JButton("Nuevo Evento");
		NuevoEvento.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){

			}
		});
		panelWest.add(NuevoEvento, d);
		d.gridy++;

		Emergencia = new JButton("Emergencia");
		Emergencia.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){

			}
		});
		panelWest.add(Emergencia, d);
		d.gridy++;

		ReOrdenMed = new JButton("Re-orden de medicinas");
		ReOrdenMed.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){

			}
		});
		panelWest.add(ReOrdenMed, d);
		d.gridy++;

		PacientesPorMedicar = new JButton("Pacientes Por Medicar");
		PacientesPorMedicar.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){

			}
		});
		panelWest.add(PacientesPorMedicar, d);


		//CENTER

		JPanel panelCenter = new JPanel();
		panelCenter.setLayout(new GridBagLayout());
		JTabbedPane jTP = new JTabbedPane();
		GridBagConstraints myConstraints = new GridBagConstraints();
		myConstraints.weightx = myConstraints.weighty = 1.0;
		myConstraints.gridx=0;
		myConstraints.fill=GridBagConstraints.BOTH;
		jTP.add("Pacientes por medicar", PxPorMedicar("Panel pacientesXmed"));
		myConstraints.gridx=1;
		jTP.add("Re-Orden Meds en 7 días", ReOrMeds("ReOrdenMed"));
		panelCenter.add(jTP,myConstraints);
		panel.add(panelCenter, BorderLayout.CENTER);
	}
	//Lo que va dentro de pacientes por medicar
	protected JComponent PxPorMedicar(String text) {
		JPanel panelG = new JPanel(false);
		JLabel filler = new JLabel(text);
		filler.setHorizontalAlignment(JLabel.CENTER);
		panelG.setLayout(new GridLayout(1, 1));
		panelG.add(filler);
		return panelG;
	}

	//Lo que va dentro de Reorden Meds
	protected JComponent ReOrMeds(String text) {
		JPanel panelG = new JPanel(false);
		JLabel filler = new JLabel(text);
		filler.setHorizontalAlignment(JLabel.CENTER);
		panelG.setLayout(new GridLayout(1, 1));
		panelG.add(filler);
		return panelG;
	}

	private JPanel TableFromSql (){
		String nombrePx = BuscarPaciente.getText();

		ArrayList columnNames = new ArrayList();
		ArrayList data = new ArrayList();


		try {

			Class.forName("com.mysql.jdbc.Driver");

			//Get connection with MySQL database
			Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema_asilo?useSSL=false",
					"root", "1212");
			Statement myStmt = mycon.createStatement();
			//Adds the new score to the database
			String mySQLTable = "paciente";

			String query = "select * from paciente where nombre like '" + nombrePx + "%' or apellido like '" + nombrePx +"%'";;

			//Execute SQL query
			ResultSet myRs = myStmt.executeQuery(query);

			ResultSetMetaData md = myRs.getMetaData();
			int columns = md.getColumnCount();

			//Get column names
			for (int i = 1; i<= columns; i++){
				columnNames.add(md.getColumnName(i));
			}
			//Get row data
			while (myRs.next()){
				ArrayList row = new ArrayList(columns);
				for (int i = 1; i<= columns; i++){
					row.add(myRs.getObject(i));
				}
				data.add(row);
			}

			/*while (myRs.next()) {
			System.out.println(myRs.getString(4)); //gets the first column's rows.
			}*/
		}
		catch (Exception e) {
			System.out.println("Error with database connection");
			e.printStackTrace();
		}
		// Create Vectors and copy over elements from ArrayLists to them
		// Vector is deprecated but I am using them in this example to keep
		// things simple - the best practice would be to create a custom defined
		// class which inherits from the AbstractTableModel class
		Vector columnNamesVector = new Vector();
		Vector dataVector = new Vector();

		for (int i = 0; i<data.size(); i++){
			ArrayList subArray = (ArrayList)data.get(i);
			Vector subVector = new Vector();
			for (int j = 0; j < subArray.size(); j++){
				subVector.add(subArray.get(j));
			}
			dataVector.add(subVector);
		}

		for (int i = 0; i < columnNames.size(); i++ )
			columnNamesVector.add(columnNames.get(i));

		//  Create table with database data
		JTable table = new JTable(dataVector, columnNamesVector)
		{
			public Class getColumnClass(int column)
			{
				for (int row = 0; row < getRowCount(); row++)
				{
					Object o = getValueAt(row, column);

					if (o != null)
					{
						return o.getClass();
					}
				}

				return Object.class;
			}
		};

		JPanel sendPanel = new JPanel(new BorderLayout());
		JScrollPane scrollTable = new JScrollPane(table);
		sendPanel.add(scrollTable);

		JPanel buttonPanel = new JPanel();
		sendPanel.add(buttonPanel, BorderLayout.SOUTH);

		return sendPanel;
	}

	//Entry point of the program
	public static void main (String [] args){
		//Create a frame and shouw it through SwingUtilites
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				new Pprincipal().setVisible(true);
			}

		});

	}


}