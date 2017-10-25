/*
Created by CarlosGalvez
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
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
import javax.swing.border.MatteBorder;
import java.awt.EventQueue;
import java.sql.*;


public class PregistraPx extends JFrame {

	private JTextField fechaNacimientoPx,nombrePx,apellidoPx,ciudadPx,callePx,codigoPostalPx,sangrePx,numeroCuartoPx,numeroCamaPx,estatusPx,asiloIdPx;
	private Integer sexoPx = -1;
	private JButton altaDoc, guardarCambios, cambiarFoto;
	private ImageIcon imageIcon;

	public PregistraPx (){
		createUIR();
		setTitle("Registrar Nuevo Paciente");
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

		ciudadPx = new JTextField("Ciudad",32);
		panelNCReg.add(ciudadPx,d);
		d.gridy++;

		callePx = new JTextField("Calle",32);
		panelNCReg.add(callePx,d);
		d.gridy++;

		codigoPostalPx = new JTextField("Código Postal",32);
		panelNCReg.add(codigoPostalPx,d);
		d.gridy++;

		//Reset pos
		d.gridy=0;
		d.gridx=1;
		d.anchor = GridBagConstraints.LINE_START;

		fechaNacimientoPx = new JTextField("Fecha de nacimiento (yyyy/mm/dd)",32);
		panelNCReg.add(fechaNacimientoPx,d);
		d.gridy++;

		numeroCuartoPx = new JTextField("Cuarto del Paciente",32);
		panelNCReg.add(numeroCuartoPx,d);
		d.gridy++;

		numeroCamaPx = new JTextField("Cama del paciente",32);
		panelNCReg.add(numeroCamaPx,d);
		d.gridy++;

		String[] description = { "Sexo", "Masculino", "Femenino"};

		JComboBox c = new JComboBox();


		final int[] count = {0};

		for (int i = 0; i < 3; i++)
			c.addItem(description[count[0]++]);

		c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sexoPx = c.getSelectedIndex()-1;
			}
		});

		panelNCReg.add(c,d);
		d.gridy++;

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
				int proceed = 1;
				System.out.println(nombrePx.getText());

				if (nombrePx.getText().equals("Nombre del paciente") || ciudadPx.getText().equals("Ciudad") || callePx.getText().equals("Calle") || codigoPostalPx.getText().equals("Código Postal") || fechaNacimientoPx.getText().equals("Fecha de nacimiento (yyyy/mm/dd)") || numeroCuartoPx.getText().equals("Cuarto del Paciente") || numeroCamaPx.getText().equals("Cama del paciente") || sexoPx.equals(-1)){
					String warning = "Advertencia, uno o más campos no fueron modificados: (";
					if (nombrePx.getText().equals("Nombre del paciente")){
						warning += "Nombre del paciente, ";
					}

					if (ciudadPx.getText().equals("Ciudad")){
						warning += "Ciudad, ";
					}

					if (callePx.getText().equals("Calle")){
						warning += "Calle, ";
					}

					if (codigoPostalPx.getText().equals("Código Postal")){
						warning += "Código Postal, ";
					}

					if (fechaNacimientoPx.getText().equals("Fecha de nacimiento (yyyy/mm/dd)")){
						warning += "Fecha de nacimiento (yyyy/mm/dd), ";
					}

					if (numeroCuartoPx.getText().equals("Cuarto del Paciente")){
						warning += "Cuarto del Paciente, ";
					}

					if (numeroCamaPx.getText().equals("Cama del paciente")){
						warning += "Cama del paciente, ";
					}

					if (sexoPx.equals(-1)){
						warning += "Sexo";
					}

					warning += ") ¿Quiere proceder?";
					if (JOptionPane.showConfirmDialog(null, warning, "Información posiblemente incompleta",
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						proceed = 1;
					} else {
						proceed = 0;
					}
					System.out.println("Proceed: " + proceed);
				}

				String sup =
						"INSERT INTO "
								+ "paciente"
								+ "(sexo,fecha_nacimiento,nombre,apellido,ciudad,calle,codigo_postal,sangre,numero_cuarto,numero_cama,estatus,asilo_id) "
								+ "VALUES ("
								+ sexoPx + ",'"
								+ fechaNacimientoPx.getText() + "','"
								+ nombrePx.getText() + "','"
								+ apellidoPx.getText()  + "','"
								+ ciudadPx.getText()  + "','"
								+ callePx.getText()  + "',"
								+ codigoPostalPx.getText() + ",'"
								+ sangrePx.getText() + "',"
								+ numeroCuartoPx.getText() + ","
								+ numeroCamaPx.getText() + ","
								+ estatusPx.getText() + ","
								+ asiloIdPx.getText()  + ")";

				System.out.println(sup);

				if(proceed == 1){
					try {
						Class.forName("com.mysql.jdbc.Driver");

						String mySQLTable = "paciente";

						String sql =
							"INSERT INTO " 
							+ mySQLTable 
							+ "(sexo,fecha_nacimiento,nombre,apellido,ciudad,calle,codigo_postal,sangre,numero_cuarto,numero_cama,estatus,asilo_id) " 
							+ "VALUES (" 
								+ sexoPx + ",'"
								+ fechaNacimientoPx.getText() + "','" 
								+ nombrePx.getText() + "','" 
								+ apellidoPx.getText()  + "','" 
								+ ciudadPx.getText()  + "','" 
								+ callePx.getText()  + "'," 
								+ codigoPostalPx.getText() + ",'"  
								+ sangrePx.getText() + "',"  
								+ numeroCuartoPx.getText() + ","   
								+ numeroCamaPx.getText() + ","   
								+ estatusPx.getText() + ","   
								+ asiloIdPx.getText()  + ")";

						System.out.println(sql);

						//Get connection with MySQL database
						Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema_asilo?useSSL=false",
								"root", "1212");
						Statement myStmt = mycon.createStatement();
						//Adds the new score to the database

						myStmt.executeUpdate(sql);

						//Execute SQL query
						ResultSet myRs = myStmt.executeQuery("SELECT * from " + mySQLTable);
						ResultSetMetaData rsmd = myRs.getMetaData();
						int columnsNumber = rsmd.getColumnCount();

						while (myRs.next()) {
							System.out.println(myRs.getString(4)); //gets the first column's rows.
						}

						System.out.print(myRs);
					} catch (Exception e) {
						System.out.println("Error with database connection");
						e.printStackTrace();
					}
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
		jTPReg.add("Familiares", Familiares());
		//d.gridx++;
		jTPReg.add("Emergencia", Emergencia());
		//d.gridx++;
		jTPReg.add("Expediente", Expediente());
		//d.gridx++;
		jTPReg.add("Medicamentos", Medicamentos());
		panelCenterReg.add(jTPReg,d);
		panelMainReg.add(panelCenterReg, BorderLayout.CENTER);

	}

	//Lo que va dentro de Tratamientos
	//Hacerlo con Layout
	protected JComponent Tratamientos() {
    	JPanel listContainer = new JPanel();
    	JPanel send = new JPanel();
    	JScrollPane scrollPaneF = new JScrollPane(send);

    	listContainer.setLayout(new BoxLayout(listContainer, BoxLayout.Y_AXIS));
    	send.add(new JScrollPane(listContainer), BorderLayout.CENTER);
    	JButton button = new JButton("Agregar nuevo tratamiento");
    	button.addActionListener(new ActionListener(){

    		@Override
    		public void actionPerformed(ActionEvent evt){
    			final JPanel newPanel = new JPanel();
    			newPanel.add(new JTextField("Nombre del tratamiento", 16));
    			listContainer.add(newPanel);
    			listContainer.revalidate();

    			JTextArea textArea = new JTextArea();
				textArea.setEditable(true);
				//Go to next line when reach horizontal limit
				textArea.setLineWrap(true);
				textArea.setWrapStyleWord(true);

				JScrollPane scrollPane = new JScrollPane(textArea);
				scrollPane.setPreferredSize(new Dimension(700, 56));
				newPanel.add(scrollPane);
				listContainer.add(newPanel);
				listContainer.revalidate();

    			//Scroll down to last added panel
    			SwingUtilities.invokeLater(new Runnable(){
    				@Override
    				public void run(){
    					newPanel.scrollRectToVisible(newPanel.getBounds());
    				}
    			});
    		}
    	});
    	send.add(button, BorderLayout.PAGE_END);
    	return scrollPaneF;

	}

	//Lo que va dentro de Familiares
	protected JComponent Familiares() {
    	JPanel panelFamiliares = new JPanel(false);
    	JLabel filler = new JLabel("Contacto");
    	filler.setHorizontalAlignment(JLabel.CENTER);
        JTextField nombre = new JTextField(32);
        JTextField parentesco = new JTextField(32);
        JTextField incumbencia = new JTextField(32);
    	JTextField telefonoCas = new JTextField(32);
        JTextField telefonoCel = new JTextField(32);
        JTextField email = new JTextField(32);

        panelFamiliares.setLayout(new BoxLayout(panelFamiliares, BoxLayout.PAGE_AXIS));
    	panelFamiliares.add(filler);
        JTextArea info = new JTextArea();
        info.setEditable(true);
        info.setLineWrap(true);
        info.setWrapStyleWord(true);

        JScrollPane scrollInfo = new JScrollPane(info);
        scrollInfo.setPreferredSize(new Dimension(700,56));

        JPanel panelFAM = new JPanel(new GridBagLayout());
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        gbc1.anchor = GridBagConstraints.LINE_END;

        panelFAM.add(new JLabel("Nombre del Familiar"),gbc1);
        gbc1.gridy++;
        panelFAM.add(new JLabel("Parentesco"),gbc1);
        gbc1.gridy++;
        panelFAM.add(new JLabel("Incumbencia"),gbc1);
        gbc1.gridy++;
        panelFAM.add(new JLabel("Telefono de Casa"),gbc1);
        gbc1.gridy++;
        panelFAM.add(new JLabel("Telefono de Cel"),gbc1);
        gbc1.gridy++;
        panelFAM.add(new JLabel("Email"),gbc1);
        gbc1.gridy++;

        gbc1.gridy = 0;
        gbc1.gridx = 1;
        gbc1.anchor = GridBagConstraints.LINE_START;

        panelFAM.add(nombre,gbc1);
        gbc1.gridy++;
        panelFAM.add(parentesco,gbc1);
        gbc1.gridy++;
        panelFAM.add(incumbencia,gbc1);
        gbc1.gridy++;
        panelFAM.add(telefonoCas,gbc1);
        gbc1.gridy++;
        panelFAM.add(telefonoCel,gbc1);
        gbc1.gridy++;
        panelFAM.add(email,gbc1);
        gbc1.gridy++;

        panelFamiliares.add(panelFAM, BorderLayout.CENTER);


        return panelFamiliares;
	}

	//Lo que va dentro de Emergencia
	protected JComponent Emergencia() {
    	JPanel panelEmergencia = new JPanel();
    	panelEmergencia.setLayout(new BoxLayout(panelEmergencia, BoxLayout.PAGE_AXIS));
    	JTextField poliza = new JTextField(32);
    	JTextField vencimiento = new JTextField(32);
    	JTextField telefonos = new JTextField(32);
    	JTextField hospital = new JTextField(32);
    	JTextArea info = new JTextArea();
    	info.setEditable(true);
    	info.setLineWrap(true);
    	info.setWrapStyleWord(true);

    	JScrollPane scrollInfo = new JScrollPane(info);
    	scrollInfo.setPreferredSize(new Dimension(700,56));

    	JPanel panelEM = new JPanel(new GridBagLayout());
    	//panelEM.setLayout(new BoxLayout(panelEM, BoxLayout.LINE_AXIS));


    	GridBagConstraints gbc2 = new GridBagConstraints();
    	gbc2.gridx = 0;
    	gbc2.gridy = 0;
    	gbc2.anchor = GridBagConstraints.LINE_END;

    	panelEM.add(new JLabel("Poliza de seguro"),gbc2);
    	gbc2.gridy++;
    	panelEM.add(new JLabel("Fecha de vencimiento de poliza"),gbc2);
    	gbc2.gridy++;
    	panelEM.add(new JLabel("Telefonos de ambulancia"),gbc2);
    	gbc2.gridy++;
    	panelEM.add(new JLabel("Hospital de preferencia"),gbc2);
    	gbc2.gridy++;
    	panelEM.add(new JLabel("Informacion en caso de emergencia"),gbc2);

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
    	panelEM.add(scrollInfo,gbc2);

    	panelEmergencia.add(panelEM, BorderLayout.CENTER);

    	return panelEmergencia;
	}

	//Lo que va dentro de Expediente
	protected JComponent Expediente() {
    	JPanel panelExpediente = new JPanel(false);
        panelExpediente.setLayout(new BoxLayout(panelExpediente, BoxLayout.PAGE_AXIS));
        JLabel filler = new JLabel("Expediente Pasado");
    	filler.setHorizontalAlignment(JLabel.CENTER);
    	panelExpediente.add(filler);
        JTextField enfermedad = new JTextField(32);
        JTextField fechainicio = new JTextField(32);
        JTextField fechafinal = new JTextField(32);
        JTextField descripcion = new JTextField(32);
        JTextField fechaevento = new JTextField(32);

        JTextArea info = new JTextArea();
        info.setEditable(true);
        info.setLineWrap(true);
        info.setWrapStyleWord(true);

        JScrollPane scrollInfo = new JScrollPane(info);
        scrollInfo.setPreferredSize(new Dimension(700,56));

        JPanel panelEXP = new JPanel(new GridBagLayout());

        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx = 0;
        gbc3.gridy = 0;
        gbc3.anchor = GridBagConstraints.LINE_END;

        panelEXP.add(new JLabel("Nombre Enfermedad"),gbc3);
        gbc3.gridy++;
        panelEXP.add(new JLabel("Fecha Inicio"),gbc3);
        gbc3.gridy++;
        panelEXP.add(new JLabel("Fecha Final"),gbc3);
        gbc3.gridy++;
        panelEXP.add(new JLabel("Descripcion Evento"),gbc3);
        gbc3.gridy++;
        panelEXP.add(new JLabel("Fecha Evento"),gbc3);
        gbc3.gridy++;



        gbc3.gridy = 0;
        gbc3.gridx = 1;
        gbc3.anchor = GridBagConstraints.LINE_START;

        panelEXP.add(enfermedad,gbc3);
        gbc3.gridy++;
        panelEXP.add(fechainicio,gbc3);
        gbc3.gridy++;
        panelEXP.add(fechafinal,gbc3);
        gbc3.gridy++;
        panelEXP.add(descripcion,gbc3);
        gbc3.gridy++;
        panelEXP.add(fechaevento,gbc3);
        gbc3.gridy++;

        panelExpediente.add(panelEXP, BorderLayout.CENTER);



        return panelExpediente;
	}

	//Lo que va dentro de Medicamentos
	protected JComponent Medicamentos() {
    	JPanel panelMedicamento = new JPanel(false);
		panelMedicamento.setLayout(new BoxLayout(panelMedicamento, BoxLayout.PAGE_AXIS));
    	JLabel filler = new JLabel("Medicinas");
    	filler.setHorizontalAlignment(JLabel.CENTER);
    	panelMedicamento.add(filler);
    	JTextField nombreMed = new JTextField(32);
		JTextField tipoMed = new JTextField(32);
		JTextField medicionMed = new JTextField(32);
		JTextField cantidadMed = new JTextField(32);


		JTextArea info = new JTextArea();
		info.setEditable(true);
		info.setLineWrap(true);
		info.setWrapStyleWord(true);

		JScrollPane scrollInfo = new JScrollPane(info);
		scrollInfo.setPreferredSize(new Dimension(700,56));

		JPanel panelMED = new JPanel(new GridBagLayout());

		GridBagConstraints gbc4 = new GridBagConstraints();
		gbc4.gridx = 0;
		gbc4.gridy = 0;
		gbc4.anchor = GridBagConstraints.LINE_END;

		panelMED.add(new JLabel("Nombre de Medicina"),gbc4);
		gbc4.gridy++;
		panelMED.add(new JLabel("Tipo de Medicina"),gbc4);
		gbc4.gridy++;
		panelMED.add(new JLabel("Medicion de Medicina"),gbc4);
		gbc4.gridy++;
		panelMED.add(new JLabel("Cantidad de Medicina"),gbc4);
		gbc4.gridy++;

		gbc4.gridy = 0;
		gbc4.gridx = 1;
		gbc4.anchor = GridBagConstraints.LINE_START;

		panelMED.add(nombreMed,gbc4);
		gbc4.gridy++;
		panelMED.add(tipoMed,gbc4);
		gbc4.gridy++;
		panelMED.add(medicionMed,gbc4);
		gbc4.gridy++;
		panelMED.add(cantidadMed,gbc4);
		gbc4.gridy++;

		panelMedicamento.add(panelMED, BorderLayout.CENTER);


		return panelMedicamento;
	}

	public ImageIcon setupImage(ImageIcon imagee, String path){
		imagee = new ImageIcon(path); // load the image to a imageIcon
		Image image = imagee.getImage(); // transform it 
		Image newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
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
				new PregistraPx().setVisible(true);
			}

		});

	}
}













