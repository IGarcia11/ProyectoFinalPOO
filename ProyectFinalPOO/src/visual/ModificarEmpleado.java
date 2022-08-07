package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Altice;
import logico.Cliente;
import logico.Empleado;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarEmpleado extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnModificar;
	private JTextField txtCed;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTextField txtCod;
	private JTextField txtSueldo;
	private static Empleado auxEmpleado = null;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			ModificarEmpleado dialog = new ModificarEmpleado();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public ModificarEmpleado(Empleado empleado) {
		setModal(true);
		auxEmpleado = empleado;
		setTitle("Modificar Empleado");
		setBounds(100, 100, 320, 400);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("Cedula:");
			label.setBounds(20, 82, 105, 14);
			contentPanel.add(label);
		}
		{
			txtCed = new JTextField();
			txtCed.setEditable(false);
			txtCed.setColumns(10);
			txtCed.setBounds(145, 78, 138, 20);
			contentPanel.add(txtCed);
		}
		{
			JLabel label = new JLabel("Nombre:");
			label.setBounds(20, 130, 105, 14);
			contentPanel.add(label);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setEditable(false);
			txtNombre.setColumns(10);
			txtNombre.setBounds(145, 127, 138, 20);
			contentPanel.add(txtNombre);
		}
		{
			JLabel label = new JLabel("Teléfono:");
			label.setBounds(20, 178, 105, 14);
			contentPanel.add(label);
		}
		{
			txtTelefono = new JTextField();
			txtTelefono.setColumns(10);
			txtTelefono.setBounds(145, 176, 138, 20);
			contentPanel.add(txtTelefono);
		}
		{
			JLabel label = new JLabel("Dirección:");
			label.setBounds(20, 226, 105, 14);
			contentPanel.add(label);
		}
		{
			txtDireccion = new JTextField();
			txtDireccion.setColumns(10);
			txtDireccion.setBounds(145, 225, 138, 20);
			contentPanel.add(txtDireccion);
		}
		{
			JLabel lblCodEmpleado = new JLabel("Cod. Empleado:");
			lblCodEmpleado.setBounds(20, 34, 105, 14);
			contentPanel.add(lblCodEmpleado);
		}
		{
			txtCod = new JTextField();
			txtCod.setEditable(false);
			txtCod.setColumns(10);
			txtCod.setBounds(145, 29, 138, 20);
			contentPanel.add(txtCod);
		}
		{
			JLabel lblSueldo = new JLabel("Sueldo:");
			lblSueldo.setBounds(20, 274, 105, 14);
			contentPanel.add(lblSueldo);
		}
		{
			txtSueldo = new JTextField();
			txtSueldo.setColumns(10);
			txtSueldo.setBounds(145, 274, 138, 20);
			contentPanel.add(txtSueldo);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnModificar = new JButton("Modificar");
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						float sueldob = Float.parseFloat(txtSueldo.getText());
						auxEmpleado.setCodeEmpleado(txtCod.getText());
						auxEmpleado.setCedulaEmpleado(txtCed.getText());
						auxEmpleado.setNombreEmpleado(txtNombre.getText());
						auxEmpleado.setDireccion(txtDireccion.getText());
						auxEmpleado.setTelefono(txtTelefono.getText());
						auxEmpleado.setSueldoBase(sueldob);
						Altice.getInstance().modificarEmpleado(auxEmpleado);
						ListadoEmpleados.loadEmpleados();
						dispose();
					}
				});
				btnModificar.setActionCommand("OK");
				buttonPane.add(btnModificar);
				getRootPane().setDefaultButton(btnModificar);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadEmpleado();
	}

	private void loadEmpleado() {
		if(auxEmpleado!=null) { 
			String sueldo = String.valueOf(auxEmpleado.getSueldoBase());
			txtCod.setText(auxEmpleado.getCodeEmpleado());
			txtCed.setText(auxEmpleado.getCedulaEmpleado());
			txtNombre.setText(auxEmpleado.getNombreEmpleado());
			txtDireccion.setText(auxEmpleado.getDireccion());
			txtTelefono.setText(auxEmpleado.getTelefono());
			txtSueldo.setText(sueldo);
		}
		
	}

}
