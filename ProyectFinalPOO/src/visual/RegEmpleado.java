package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.TitledBorder;

import logico.Administrador;
import logico.Altice;
import logico.Comerciante;
import logico.Empleado;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegEmpleado extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtName;
	private JTextField txtPhone;
	private JTextField txtId;
	private JTextField txtAdress;
	private JTextField txtComision;
	private JTextField txtSueldoC;
	private JTextField txtSueldoA;
	private JTextField txtExperiencia;
	private JRadioButton rdbtnComerciante;
	private JRadioButton rdbtnAdmin;
	private JPanel panelInfoCategoriaC;
	private JPanel panelInfoCategoriaAdmin;
	private JPanel panelCategoria;
	private JPanel panelInfoBasica;
	private JComboBox cbxSexo;
	private JLabel lblNombreUsuario;
	private JLabel lblContrasea;
	private JLabel lblConfirmarContrasea;
	private JTextField txtUser;
	private JTextField txtPwd;
	private JTextField txtConfirmar;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegEmpleado dialog = new RegEmpleado();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegEmpleado() {
		setTitle("Registar Empleado");
		setBounds(100, 100, 459, 534);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			//JPanel panelInfoBasica = new JPanel();
			panelInfoBasica = new JPanel();
			panelInfoBasica.setBorder(new TitledBorder(null, "Informaci\u00F3n del Empleado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelInfoBasica.setBounds(10, 10, 418, 285);
			contentPanel.add(panelInfoBasica);
			panelInfoBasica.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("Código:");
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblNewLabel.setBounds(7, 14, 75, 25);
				panelInfoBasica.add(lblNewLabel);
			}
			{
				JLabel lblNombre = new JLabel("Nombre:");
				lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblNombre.setBounds(7, 43, 75, 25);
				panelInfoBasica.add(lblNombre);
			}
			{
				JLabel lblCdula = new JLabel("Cédula:");
				lblCdula.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblCdula.setBounds(7, 77, 75, 25);
				panelInfoBasica.add(lblCdula);
			}
			{
				JLabel lblDireccin = new JLabel("Dirección:");
				lblDireccin.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblDireccin.setBounds(7, 111, 75, 25);
				panelInfoBasica.add(lblDireccin);
			}
			{
				JLabel lblTelfono = new JLabel("Teléfono:");
				lblTelfono.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblTelfono.setBounds(7, 145, 75, 25);
				panelInfoBasica.add(lblTelfono);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Sexo:");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblNewLabel_1.setBounds(217, 145, 52, 25);
				panelInfoBasica.add(lblNewLabel_1);
			}
			{
				txtCodigo = new JTextField();
				txtCodigo.setEditable(false);
				txtCodigo.setBounds(89, 17, 96, 19);
				txtCodigo.setText("E-"+Empleado.generadorCodEmpleado);		//Altice.generadorCodEmpleado);
				panelInfoBasica.add(txtCodigo);
				txtCodigo.setColumns(10);
			}
			{
				txtName = new JTextField();
				txtName.setBounds(89, 46, 322, 19);
				panelInfoBasica.add(txtName);
				txtName.setColumns(10);
			}
			{
				//JComboBox cbxSexo = new JComboBox();
				cbxSexo = new JComboBox();
				cbxSexo.setFont(new Font("Tahoma", Font.PLAIN, 14));
				cbxSexo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Femenino", "Masculino"}));
				cbxSexo.setBounds(279, 147, 123, 21);
				panelInfoBasica.add(cbxSexo);
			}
			{
				txtPhone = new JTextField();
				txtPhone.setBounds(89, 148, 114, 19);
				panelInfoBasica.add(txtPhone);
				txtPhone.setColumns(10);
			}
			{
				txtId = new JTextField();
				txtId.setBounds(89, 80, 322, 19);
				panelInfoBasica.add(txtId);
				txtId.setColumns(10);
			}
			{
				txtAdress = new JTextField();
				txtAdress.setColumns(10);
				txtAdress.setBounds(89, 114, 322, 19);
				panelInfoBasica.add(txtAdress);
			}
			{
				lblNombreUsuario = new JLabel("Nombre Usuario:");
				lblNombreUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblNombreUsuario.setBounds(7, 179, 123, 25);
				panelInfoBasica.add(lblNombreUsuario);
			}
			{
				lblContrasea = new JLabel("Contraseña:");
				lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblContrasea.setBounds(7, 213, 110, 25);
				panelInfoBasica.add(lblContrasea);
			}
			{
				lblConfirmarContrasea = new JLabel("Confirmar Contraseña:");
				lblConfirmarContrasea.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblConfirmarContrasea.setBounds(7, 247, 166, 25);
				panelInfoBasica.add(lblConfirmarContrasea);
			}
			{
				txtUser = new JTextField();
				txtUser.setBounds(140, 182, 271, 19);
				panelInfoBasica.add(txtUser);
				txtUser.setColumns(10);
			}
			{
				txtPwd = new JTextField();
				txtPwd.setBounds(140, 216, 271, 19);
				panelInfoBasica.add(txtPwd);
				txtPwd.setColumns(10);
			}
			{
				txtConfirmar = new JTextField();
				txtConfirmar.setBounds(183, 250, 225, 19);
				panelInfoBasica.add(txtConfirmar);
				txtConfirmar.setColumns(10);
			}
		}
		{
			//JPanel panelCategoria = new JPanel();
			panelCategoria = new JPanel();
			panelCategoria.setBorder(new TitledBorder(null, "Categor\u00EDa del Empleado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelCategoria.setBounds(10, 305, 418, 65);
			contentPanel.add(panelCategoria);
			panelCategoria.setLayout(null);
			{
				//JRadioButton rdbtnComerciante = new JRadioButton("Comerciante");
				rdbtnComerciante = new JRadioButton("Comerciante");					
				rdbtnComerciante.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(rdbtnComerciante.isSelected()) {
							rdbtnAdmin.setSelected(false);
							panelInfoCategoriaAdmin.setVisible(false);
							panelInfoCategoriaC.setVisible(true);
						}
					}
				});
				rdbtnComerciante.setSelected(true);
				rdbtnComerciante.setFont(new Font("Tahoma", Font.BOLD, 14));
				rdbtnComerciante.setBounds(50, 22, 134, 21);
				panelCategoria.add(rdbtnComerciante);
			}
			{
				//JRadioButton rdbtnAdmin = new JRadioButton("Administrador");
				rdbtnAdmin = new JRadioButton("Administrador");
				rdbtnAdmin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(rdbtnAdmin.isSelected()) {
							rdbtnComerciante.setSelected(false);
							panelInfoCategoriaAdmin.setVisible(true);
							panelInfoCategoriaC.setVisible(false);
						}
					}
				});
				
				rdbtnAdmin.setFont(new Font("Tahoma", Font.BOLD, 14));
				rdbtnAdmin.setBounds(234, 22, 134, 21);
				panelCategoria.add(rdbtnAdmin);
			}
		}
		{
			//JPanel panelInfoCategoriaC = new JPanel();
			panelInfoCategoriaC = new JPanel();
			panelInfoCategoriaC.setBorder(new TitledBorder(null, "Informaci\u00F3n de Categor\u00EDa", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelInfoCategoriaC.setBounds(9, 380, 419, 82);
			contentPanel.add(panelInfoCategoriaC);
			panelInfoCategoriaC.setLayout(null);
			{
				JLabel lblSueldo = new JLabel("Sueldo Base:");
				lblSueldo.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblSueldo.setBounds(7, 45, 96, 25);
				panelInfoCategoriaC.add(lblSueldo);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Comisión:");
				lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblNewLabel_2.setBounds(7, 14, 84, 25);
				panelInfoCategoriaC.add(lblNewLabel_2);
			}
			{
				txtComision = new JTextField();
				txtComision.setBounds(110, 19, 84, 19);
				panelInfoCategoriaC.add(txtComision);
				txtComision.setColumns(10);
			}
			{
				txtSueldoC = new JTextField();
				txtSueldoC.setBounds(110, 50, 84, 19);
				panelInfoCategoriaC.add(txtSueldoC);
				txtSueldoC.setColumns(10);
			}
		}
		{
			//JPanel panelInfoCategoriaAdmin = new JPanel();
			panelInfoCategoriaAdmin = new JPanel();
			panelInfoCategoriaAdmin.setVisible(false);
			panelInfoCategoriaAdmin.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelInfoCategoriaAdmin.setBounds(10, 380, 419, 82);
			contentPanel.add(panelInfoCategoriaAdmin);
			panelInfoCategoriaAdmin.setLayout(null);
			{
				txtSueldoA = new JTextField();
				txtSueldoA.setBounds(316, 51, 96, 19);
				panelInfoCategoriaAdmin.add(txtSueldoA);
				txtSueldoA.setColumns(10);
			}
			{
				txtExperiencia = new JTextField();
				txtExperiencia.setBounds(316, 20, 96, 19);
				panelInfoCategoriaAdmin.add(txtExperiencia);
				txtExperiencia.setColumns(10);
			}
			{
				JLabel lblNewLabel_3 = new JLabel("Años Experiencia:");
				lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblNewLabel_3.setBounds(205, 14, 104, 25);
				panelInfoCategoriaAdmin.add(lblNewLabel_3);
			}
			{
				JLabel lblNewLabel_4 = new JLabel("Sueldo Base:");
				lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblNewLabel_4.setBounds(205, 45, 104, 25);
				panelInfoCategoriaAdmin.add(lblNewLabel_4);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						/*
						 * 
						 */
						Empleado aux = null;
						String codeEmpleado = "E-"+Empleado.generadorCodEmpleado;	//Altice.generadorCodEmpleado;
						String nombre = txtName.getText();
						String cedula = txtId.getText();
						String direccion = txtAdress.getText();
						String telefono = txtPhone.getText();
						String sexo = cbxSexo.getSelectedItem().toString();//getSelectedItem().toString());
						String user = txtUser.getText();
						String password = txtPwd.getText();
						String confirmP = txtConfirmar.getText();
						//cbxSexo.getSelectedItem().toString();
						if(rdbtnComerciante.isSelected()) {
							float comision = new Float(txtComision.getText());		//Float.parseFloat(txtComision.getText()); 
							float sueldoBC = new Float(Float.parseFloat(txtSueldoC.getText()));		//Float.parseFloat(txtSueldoC.getText());
							String tipo = "Comerciante";
							aux = new Comerciante(codeEmpleado, cedula, nombre, 
									sueldoBC, 		//Float.parseFloat(txtComision.getText()),   //comision, 	//Float.parseFloat(comision), 
									direccion, 
									telefono, 
									sexo, 
									tipo, 
									user, 
									password,									
									comision, 0);//sueldoBC);
							Altice.getInstance().getMisEmpleados().add(aux);	
						}
						else if(rdbtnAdmin.isSelected()) {
							int annoE = new Integer(txtExperiencia.getText());//Integer.parseInt(txtHExtra.getText());//new Float(txtHExtra.getText());
							float sueldoBA = new Float(txtSueldoA.getText());		//Float.parseFloat(txtSueldoA.getText());
							String tipo = "Administrador";
							aux = new Administrador(codeEmpleado, cedula, nombre,
									sueldoBA,//Float.parseFloat(sueldoBA), 
									direccion, telefono, sexo, tipo, user, password, 0, annoE, sueldoBA);//Integer.parseInt(annoE));
							//Altice.getInstance().regUser(user);
							//dispose();
							System.out.println("SueldoBA en RegE "+sueldoBA);
							System.out.println("ANNOE "+annoE);
							Altice.getInstance().getMisEmpleados().add(aux);	

						}
						//Altice.getInstance().getMisEmpleados().add(aux);	
						if(aux != null) {
							JOptionPane.showMessageDialog(null, "Registrado Satisfactoriamente", "Información", JOptionPane.INFORMATION_MESSAGE);
							//clean();
							dispose();
							Principal prin = new Principal();
							prin.setVisible(true);
						}else {
							JOptionPane.showMessageDialog(null, "Registro fallido", "Información", JOptionPane.WARNING_MESSAGE);
							clean();
						}
						
						}

					
				});
				btnRegistrar.setActionCommand("Registrar");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
	private void clean() {
		
		txtCodigo.setText("E-"+Empleado.generadorCodEmpleado);//Altice.generadorCodEmpleado);
		txtName.setText("");
		txtId.setText("");
		txtAdress.setText("");
		txtPhone.setText("");
		cbxSexo.setSelectedIndex(0);
		txtComision.setText("");
		txtSueldoA.setText("");
		txtSueldoC.setText("");
		txtExperiencia.setText("");
		txtUser.setText("");
		txtPwd.setText("");
		txtConfirmar.setText("");
	}

}
