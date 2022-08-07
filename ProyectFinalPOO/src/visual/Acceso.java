package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Altice;
import logico.Empleado;
import logico.User;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Acceso extends JFrame {

	private JPanel contentPane;
	public JTextField txtUser;
	private JTextField txtPass;
	private JButton btnNewButton;
	public String userA;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				FileInputStream empresa;
				FileOutputStream empresa2;
				ObjectInputStream empresaRead;
				ObjectOutputStream empresaWrite;
				try {
					empresa = new FileInputStream ("empresa.dat");
					empresaRead = new ObjectInputStream(empresa);
					Altice temp = (Altice)empresaRead.readObject();
					Altice.setAltice(temp);
					empresa.close();
					empresaRead.close();
				} catch (FileNotFoundException e) {
					try {
						empresa2 = new  FileOutputStream("empresa.dat");
						empresaWrite = new ObjectOutputStream(empresa2);
						Empleado emp = new Empleado("", "", "", 0, "", "", "", "Administrador", "admin", "admin", 0);//new Empleado(null, null, null, null, null, null, null, "Administrador", "Admin", "Admin");
						Altice.getInstance().insertarEmpleado(emp);
						/*
						 * String codeEmpleado, String cedulaEmpleado, String nombreEmpleado, float sueldoBase, String direccion, String telefono, String sexo, 
			String tipo, String userName, String pass
						 */
						//User aux = new User("Administrador", "Admin", "Admin");
						//Altice.getInstance().regUser(aux);
						empresaWrite.writeObject(Altice.getInstance());
						empresa2.close();
						empresaWrite.close();
					} catch (FileNotFoundException e1) {
					} catch (IOException e1) {
						// TODO Auto-generated catch block
					}
				} catch (IOException e) {


				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				try {
					Acceso frame = new Acceso();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	
	}

	/**
	 * Create the frame.
	 */
	public Acceso() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 303, 298);
		//setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(122, 29, 45, 13);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Contraseña:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(104, 119, 80, 13);
		contentPane.add(lblNewLabel_1);

		txtUser = new JTextField();
		txtUser.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtUser.setBounds(96, 71, 96, 19);
		contentPane.add(txtUser);
		txtUser.setColumns(10);

		txtPass = new JTextField();
		txtPass.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtPass.setBounds(96, 161, 96, 19);
		contentPane.add(txtPass);
		txtPass.setColumns(10);
		System.out.println("hiii");
		
		btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("byee");
				System.out.println(txtUser.getText());
				System.out.println(txtPass.getText());				
				
				if(Altice.getInstance().confirmLogin(txtUser.getText(), txtPass.getText())) {
					System.out.println("Acceso OK");
					Principal fe = new Principal();					
					dispose();
					fe.setVisible(true);
					//RegEmpleado regE = new RegEmpleado();
					//regE.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Usuario y/o Contraseña incorrectos");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(102, 209, 85, 21);
		contentPane.add(btnNewButton);
	}
}
