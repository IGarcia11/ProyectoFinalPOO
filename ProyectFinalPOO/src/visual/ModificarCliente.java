package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import logico.Altice;
import logico.Cliente;

public class ModificarCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private static Cliente auxCliente = null;
	private JButton okButton;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			ModificarCliente dialog = new ModificarCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public ModificarCliente(Cliente cliente) {
		setTitle("Modificar Información del Cliente");
		setModal(true);
		auxCliente = cliente;
		setBounds(100, 100, 300, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cedula:");
		lblNewLabel.setBounds(30, 34, 56, 14);
		contentPanel.add(lblNewLabel);
		
		txtCedula = new JTextField();
		txtCedula.setEditable(false);
		txtCedula.setBounds(116, 29, 138, 20);
		contentPanel.add(txtCedula);
		txtCedula.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(30, 82, 56, 14);
		contentPanel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		txtNombre.setBounds(116, 78, 138, 20);
		contentPanel.add(txtNombre);
		
		JLabel lblTelfono = new JLabel("Teléfono:");
		lblTelfono.setBounds(30, 130, 56, 14);
		contentPanel.add(lblTelfono);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(116, 127, 138, 20);
		contentPanel.add(txtTelefono);
		
		JLabel lblDireccin = new JLabel("Dirección:");
		lblDireccin.setBounds(30, 178, 56, 14);
		contentPanel.add(lblDireccin);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(116, 176, 138, 20);
		contentPanel.add(txtDireccion);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Modificar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						auxCliente.setCedCliente(txtCedula.getText());
						auxCliente.setNombreCliente(txtNombre.getText());
						auxCliente.setDireccion(txtDireccion.getText());
						auxCliente.setTelefono(txtTelefono.getText());
						Altice.getInstance().modificarCliente(auxCliente);
						ListadoClientes.loadClientes();
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
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
		loadCliente();
	}
	
	private void loadCliente() {
		if(auxCliente!=null) { 
			txtCedula.setText(auxCliente.getCedCliente());
			txtNombre.setText(auxCliente.getNombreCliente());
			txtDireccion.setText(auxCliente.getDireccion());
			txtTelefono.setText(auxCliente.getTelefono());
		}
	}
}
