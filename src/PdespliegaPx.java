/*
Created by CarlosGalvez
*/

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class PdespliegaPx extends JFrame {

	private JTextField sexoPx,fechaNacimientoPx,nombrePx,apellidoPx,ciudadPx,callePx,codigoPostalPx,sangrePx,numeroCuartoPx,numeroCamaPx,estatusPx,asiloIdPx;
	private JButton altaDoc, guardarCambios, cambiarFoto;
	private ImageIcon imageIcon;

	public PdespliegaPx(){
		createUIR();
		setTitle("Despliega Nuevo Paciente");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		Toolkit tk = Toolkit.getDefaultToolkit();
		int xSize = ((int) tk.getScreenSize().getWidth());
		int ySize = ((int) tk.getScreenSize().getHeight());
		setSize(xSize-100,ySize-100);
		setLocationRelativeTo(null);
		setResizable(false);
	}

	private void createUIR(){
		JPanel panelMainReg = new JPanel();
		panelMainReg.setBorder(new EmptyBorder(5,5,5,5));
		panelMainReg.setLayout(new BorderLayout());
		getContentPane().add(panelMainReg);

		//NORTH
		JPanel panelNorthReg = new JPanel(new BorderLayout());
		panelMainReg.add(panelNorthReg, BorderLayout.NORTH);

		//NORTHWEST
		JPanel panelNWReg = new JPanel(new GridBagLayout());
		panelNorthReg.add(panelNWReg, BorderLayout.WEST);
		GridBagConstraints d = new GridBagConstraints();
		d.gridx=0;
		d.gridy=0;
		d.anchor = GridBagConstraints.LINE_START;

		cambiarFoto = new JButton("Cambiar Foto");
		cambiarFoto.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				String pathPhoto;
				pathPhoto = aceptarPhoto();
				imageIcon = setupImage(imageIcon, pathPhoto);
				panelNWReg.add(new JLabel(imageIcon), d);
			}
		});
		panelNWReg.add(cambiarFoto,d);

		//NORTHCENTER
		JPanel panelNCReg = new JPanel (new GridBagLayout());
		panelNorthReg.add(panelNCReg, BorderLayout.CENTER);
		d.gridy=0;
		d.anchor = GridBagConstraints.LINE_END;

		nombrePx = new JTextField("Nombre del paciente",32);
		panelNCReg.add(nombrePx,d);
		d.gridy++;

		ciudadPx = new JTextField("Direccion del paciente",32);
		panelNCReg.add(ciudadPx,d);
		d.gridy++;

		callePx = new JTextField("Direccion del paciente",32);
		panelNCReg.add(callePx,d);
		d.gridy++;

		codigoPostalPx = new JTextField("Direccion del paciente",32);
		panelNCReg.add(codigoPostalPx,d);
		d.gridy++;

		fechaNacimientoPx = new JTextField("Fecha de nacimiento",32);
		panelNCReg.add(fechaNacimientoPx,d);

		//Reset pos
		d.gridy=0;
		d.gridx=1;
		d.anchor = GridBagConstraints.LINE_START;

		numeroCuartoPx = new JTextField("Cuarto del Paciente",32);
		panelNCReg.add(numeroCuartoPx,d);
		d.gridy++;

		numeroCamaPx = new JTextField("Cama del paciente",32);
		panelNCReg.add(numeroCamaPx,d);

		//NORTHEAST
		JPanel panelNEReg = new JPanel(new GridBagLayout());
		panelNorthReg.add(panelNEReg, BorderLayout.EAST);
		d.gridx=0;
		d.gridy=0;
		d.anchor = GridBagConstraints.LINE_START;

		altaDoc = new JButton("Dar de alta con documento");
		altaDoc.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				aceptarArchivo();
			}
		});
		panelNEReg.add(altaDoc,d);
		d.gridy++;

		guardarCambios = new JButton("Guardar Cambios");
		guardarCambios.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event){
				try {
					Class.forName("com.mysql.jdbc.Driver");

					//Get connection with MySQL database
					Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema_asilo?useSSL=false",
							"root", "1212");
					Statement myStmt = mycon.createStatement();
					//Adds the new score to the database
					String mySQLTable = "paciente";

					String sql = "INSERT INTO " + mySQLTable + "(sexo,fecha_nacimiento,nombre,apellido,ciudad,calle,codigo_postal,sangre,numero_cuarto,numero_cama,estatus,asilo_id) "
							+ "VALUES (0,'2017-04-11 3:15',\"Pepe\",\"Gomez\",\"Aguascalientes\",\"FR #125\",64340,\"O\",1,2,0,1);";

					myStmt.executeUpdate(sql);
					//Execute SQL query
					ResultSet myRs = myStmt.executeQuery("SELECT * from " + mySQLTable);

					while (myRs.next()) {
						System.out.println(myRs.getString(1)); //gets the first column's rows.
					}
				} catch (Exception e) {
					System.out.println("Error with database connection");
					e.printStackTrace();
				}
			}
		});
		panelNEReg.add(guardarCambios,d);

		//CENTER

		JPanel panelCenterReg = new JPanel();
		panelCenterReg.setLayout(new GridBagLayout());
		JTabbedPane jTPReg = new JTabbedPane();
		d.weightx = d.weighty = 1.0;
		d.gridx=0;
		d.fill=GridBagConstraints.BOTH;
		jTPReg.add("Tratamientos", Tratamientos());
		//d.gridx++;
		jTPReg.add("Familiares", Familiares(" "));
		//d.gridx++;
		jTPReg.add("Emergencia", Emergencia());
		//d.gridx++;
		jTPReg.add("Expediente", Expediente("Panel de Expediente"));
		//d.gridx++;
		jTPReg.add("Medicamentos", Medicamentos("Panel de Medicamentos"));
		panelCenterReg.add(jTPReg,d);
		panelMainReg.add(panelCenterReg, BorderLayout.CENTER);

	}

	//Lo que va dentro de Tratamientos
	//Hacerlo con Layout
	protected JComponent Tratamientos() {
		JPanel panelEmergencia = new JPanel();
		panelEmergencia.setLayout(new BoxLayout(panelEmergencia, BoxLayout.PAGE_AXIS));
		JLabel Tratamiento = new JLabel();
		JTextArea info = new JTextArea();
		info.setEditable(true);
		info.setLineWrap(true);
		info.setWrapStyleWord(true);

		//JScrollPane scrollInfo = new JScrollPane(info);
		//scrollInfo.setPreferredSize(new Dimension(700,56));

		JPanel panelEM = new JPanel(new GridBagLayout());
		//panelEM.setLayout(new BoxLayout(panelEM, BoxLayout.LINE_AXIS));


		GridBagConstraints gbc2 = new GridBagConstraints();
		gbc2.gridx = 0;
		gbc2.gridy = 0;
		gbc2.anchor = GridBagConstraints.LINE_END;

		panelEM.add(new JLabel("Padecimiento: Hipertension			Su presion arterial promedio es de 90/120"),gbc2);
		gbc2.gridy++;


		//Reset positions
		gbc2.gridy = 0;
		gbc2.gridx = 1;
		gbc2.anchor = GridBagConstraints.LINE_START;

		panelEM.add(Tratamiento,gbc2);
		gbc2.gridy++;

		//panelEM.add(scrollInfo,gbc2);

		panelEmergencia.add(panelEM, BorderLayout.NORTH);

		return panelEmergencia;
	}

	//Lo que va dentro de Familiares
	protected JComponent Familiares(String text) {
		JPanel panelFamiliares = new JPanel();
		panelFamiliares.setLayout(new BoxLayout(panelFamiliares, BoxLayout.PAGE_AXIS));
		JLabel Nombre = new JLabel();
		JLabel Parentezco = new JLabel();
		JLabel Incumbencia = new JLabel();
		JLabel TelCasa = new JLabel();
		JLabel TelCelular = new JLabel();
		JLabel Email = new JLabel();
		JTextArea info = new JTextArea();
		info.setEditable(true);
		info.setLineWrap(true);
		info.setWrapStyleWord(true);

		//JScrollPane scrollInfo = new JScrollPane(info);
		//scrollInfo.setPreferredSize(new Dimension(700,56));

		JPanel panelEM = new JPanel(new GridBagLayout());
		//panelEM.setLayout(new BoxLayout(panelEM, BoxLayout.LINE_AXIS));


		GridBagConstraints gbc2 = new GridBagConstraints();
		gbc2.gridx = 0;
		gbc2.gridy = 0;
		gbc2.anchor = GridBagConstraints.LINE_END;

		panelEM.add(new JLabel("Nombre: Panchis Lopez"),gbc2);
		gbc2.gridy++;
		panelEM.add(new JLabel("Parentezco: Hijo"),gbc2);
		gbc2.gridy++;
		panelEM.add(new JLabel("Incumbencia: Emergencias"),gbc2);
		gbc2.gridy++;
		panelEM.add(new JLabel("Telefono Casa: 83384174"),gbc2);
		gbc2.gridy++;
		panelEM.add(new JLabel("Telefono Celular: 8116534550"),gbc2);
		gbc2.gridy++;
		panelEM.add(new JLabel("Email: panchislopez@hotmail.com"),gbc2);

		//Reset positions
		gbc2.gridy = 0;
		gbc2.gridx = 1;
		gbc2.anchor = GridBagConstraints.LINE_START;

		panelEM.add(Nombre,gbc2);
		gbc2.gridy++;
		panelEM.add(Parentezco,gbc2);
		gbc2.gridy++;
		panelEM.add(Incumbencia,gbc2);
		gbc2.gridy++;
		panelEM.add(TelCasa,gbc2);
		gbc2.gridy++;
		panelEM.add(TelCelular,gbc2);
		gbc2.gridy++;
		panelEM.add(Email,gbc2);
		gbc2.gridy++;
		//panelEM.add(scrollInfo,gbc2);

		panelFamiliares.add(panelEM, BorderLayout.NORTH);

		return panelFamiliares;
	}

	//Lo que va dentro de Emergencia
	protected JComponent Emergencia() {
    	JPanel panelEmergencia = new JPanel();
    	panelEmergencia.setLayout(new BoxLayout(panelEmergencia, BoxLayout.PAGE_AXIS));
    	JPanel poliza = new JPanel();
		JPanel vencimiento = new JPanel();
		JPanel telefonos = new JPanel();
		JPanel hospital = new JPanel();
    	JTextArea info = new JTextArea();
    	info.setEditable(true);
    	info.setLineWrap(true);
    	info.setWrapStyleWord(true);

    	//JScrollPane scrollInfo = new JScrollPane(info);
    	//scrollInfo.setPreferredSize(new Dimension(700,56));

    	JPanel panelEM = new JPanel(new GridBagLayout());
    	//panelEM.setLayout(new BoxLayout(panelEM, BoxLayout.LINE_AXIS));


    	GridBagConstraints gbc2 = new GridBagConstraints();
    	gbc2.gridx = 0;
    	gbc2.gridy = 0;
    	gbc2.anchor = GridBagConstraints.LINE_END;

    	panelEM.add(new JLabel("Poliza de seguro: Metlife 00000000001"),gbc2);
    	gbc2.gridy++;
    	panelEM.add(new JLabel("Fecha de vencimiento de poliza: 01/02/03"),gbc2);
    	gbc2.gridy++;
    	panelEM.add(new JLabel("Telefonos de ambulancia: 12345678"),gbc2);
    	gbc2.gridy++;
    	panelEM.add(new JLabel("Hospital de preferencia: Cristus Muguerza"),gbc2);
    	gbc2.gridy++;
    	panelEM.add(new JLabel("Informacion en caso de emergencia: Llamar a su hijo al 83384174. Preguntar por Dra. Julia"),gbc2);

    	//Reset positions
    	gbc2.gridy = 0;
    	gbc2.gridx = 1;
    	gbc2.anchor = GridBagConstraints.LINE_START;

    	panelEM.add(poliza,gbc2);
    	gbc2.gridy++;
    	panelEM.add(vencimiento,gbc2);
    	gbc2.gridy++;
    	panelEM.add(telefonos,gbc2);
    	gbc2.gridy++;
    	panelEM.add(hospital,gbc2);
    	gbc2.gridy++;
    	//panelEM.add(scrollInfo,gbc2);

    	panelEmergencia.add(panelEM, BorderLayout.CENTER);

    	return panelEmergencia;
	}

	//Lo que va dentro de Expediente
	protected JComponent Expediente(String text) {
    	JPanel panelG = new JPanel(false);
    	JLabel filler = new JLabel(text);
    	filler.setHorizontalAlignment(JLabel.CENTER);
    	panelG.setLayout(new GridLayout(1, 1));
    	panelG.add(filler);
    	return panelG;
	}

	//Lo que va dentro de Medicamentos
	protected JComponent Medicamentos(String text) {
    	JPanel panelG = new JPanel(false);
    	JLabel filler = new JLabel(text);
    	filler.setHorizontalAlignment(JLabel.CENTER);
    	panelG.setLayout(new GridLayout(1, 1));
    	panelG.add(filler);
    	return panelG;
	}

	public ImageIcon setupImage(ImageIcon imagee, String path){
		imagee = new ImageIcon(path); // load the image to a imageIcon
		Image image = imagee.getImage(); // transform it
		Image newimg = image.getScaledInstance(120, 120,  Image.SCALE_SMOOTH); // scale it the smooth way
		imagee = new ImageIcon(newimg);  // transform it back
		return imagee;
	}

	private void aceptarArchivo(){
		JPanel contentPane = new JPanel();
		//Crear el objeto JFileChooser
		JFileChooser fc = new JFileChooser();
		//Abrir la ventana, guardar la opcion
		int seleccion = fc.showOpenDialog(contentPane);
		//Si el usuario, da click en aceptar
		if(seleccion == JFileChooser.APPROVE_OPTION){
			//Seleccionar el archivo
			File archivo = fc.getSelectedFile();
			//Test de que si agarra el archivo
			//direccionPx.setText(archivo.getAbsolutePath());
		}
	}

	private String aceptarPhoto(){
		JPanel contentPane = new JPanel();
		//Crear el objeto JFileChooser
		JFileChooser fc = new JFileChooser();
		//Abrir la ventana, guardar la opcion
		int seleccion = fc.showOpenDialog(contentPane);
		File archivo;
		String path = "";
		//Si el usuario, da click en aceptar
		if(seleccion == JFileChooser.APPROVE_OPTION){
			//Seleccionar el archivo
			archivo = fc.getSelectedFile();
			//Test de que si agarra el archivo
			path = archivo.getAbsolutePath();
		}
		return path;
	}


	//Entry point of the program
	public static void main (String [] args){
		//Create a frame and shouw it through SwingUtilites
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				new PdespliegaPx().setVisible(true);
			}

		});

	}
}













