package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Altice;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReciboFactura extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public static DefaultTableModel model3;
	public Object[] row3;
	public JTable tableFactura;
	public JTextField txtNombre;
	public JTextField txtCedula;
	public JTextField txtDireccion;
	public JTextField txtTelefono;
	public JTextField txtFecha;
	public JTextField txtCodeFactura;
	public RealizarVenta makeS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ReciboFactura dialog = new ReciboFactura();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ReciboFactura() {

		setTitle("Factura");
		setModal(true);
		setBounds(100, 100, 400, 420);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panelInfoCliente = new JPanel();
		panelInfoCliente.setBorder(new TitledBorder(null, "Informaci\u00F3n Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelInfoCliente.setBounds(10, 10, 547, 147);
		contentPanel.add(panelInfoCliente);
		panelInfoCliente.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 19, 63, 13);
		panelInfoCliente.add(lblNewLabel);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBounds(97, 19, 96, 19);
		panelInfoCliente.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Cédula:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 51, 63, 13);
		panelInfoCliente.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Teléfono:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 83, 63, 13);
		panelInfoCliente.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Dirección:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(10, 115, 63, 13);
		panelInfoCliente.add(lblNewLabel_1_2);
		
		txtCedula = new JTextField();
		txtCedula.setEditable(false);
		txtCedula.setColumns(10);
		txtCedula.setBounds(97, 51, 96, 19);
		panelInfoCliente.add(txtCedula);
		
		txtDireccion = new JTextField();
		txtDireccion.setEditable(false);
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(97, 115, 96, 19);
		panelInfoCliente.add(txtDireccion);
		
		txtTelefono = new JTextField();
		txtTelefono.setEditable(false);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(97, 83, 96, 19);
		panelInfoCliente.add(txtTelefono);
		
		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setBounds(356, 19, 96, 19);
		panelInfoCliente.add(txtFecha);
		txtFecha.setColumns(10);
		
		txtCodeFactura = new JTextField();
		txtCodeFactura.setEditable(false);
		txtCodeFactura.setBounds(356, 51, 96, 19);
		panelInfoCliente.add(txtCodeFactura);
		txtCodeFactura.setColumns(10);
		
		JPanel panelTabla = new JPanel();
		panelTabla.setBounds(10, 167, 547, 244);
		contentPanel.add(panelTabla);
		panelTabla.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panelTabla.add(scrollPane, BorderLayout.CENTER);
		
		tableFactura = new JTable();
		//table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		model3 = new DefaultTableModel();
		String[] headers = {"Cantidad", "Descripción", "Monto"};
		model3.setColumnIdentifiers(headers);
		tableFactura.setModel(model3);
		
		scrollPane.setViewportView(tableFactura);
		
		JLabel label = new JLabel("New label");
		label.setBounds(356, 421, 45, 13);
		contentPanel.add(label);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadPlanes();
	}
	private void loadPlanes() {

		model3.setRowCount(0);
		row3 = new Object[model3.getColumnCount()];
		String dato = "";
		float precio = 0;
		int columna = 0, existe = 0;
		
		for(int i = 0; i< tableFactura.getRowCount();i++) {
			if(tableFactura.getValueAt(i, columna).equals(dato)) {
				existe += 1;
			}
		}
		
		for(int i = 0; i < Altice.getInstance().getMisPlanes().size(); i++){ 	//Fabrica.getInstance().getMyClients().size(); i++) {
			/*row[0] = Fabrica.getInstance().getMyClients().get(i).getCedula();
			row[1] = Fabrica.getInstance().getMyClients().get(i).getNameClient();
			row[2] = Fabrica.getInstance().getMyClients().get(i).getPhoneNumber();
			row[3] = Fabrica.getInstance().getMyClients().get(i).getAdressClient();
			row[4] = Fabrica.getInstance().getMyClients().get(i).getMisFacturas().size();
			model.addRow(row);*/
			//Object object = row[i];
		}
		
	}
	
	
}


