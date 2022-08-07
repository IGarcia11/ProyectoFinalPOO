package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Factura;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReciboFactura extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public  DefaultTableModel model3;
	public  Object[] row3;
	private JTable table;
	private JTextField txtNombre;
	private JTextField txtTel;
	private JTextField txtDir;
	private Factura auxFact = null;
	private JLabel lblTT;
	private JLabel lblCod;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			ReciboFactura dialog = new ReciboFactura();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public ReciboFactura(Factura factura) {

		setTitle("Factura");
		auxFact = factura;
		setModal(true);
		setBounds(100, 100, 406, 465);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panelInfoCliente = new JPanel();
		panelInfoCliente.setBorder(new TitledBorder(null, "Informaci\u00F3n Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelInfoCliente.setBounds(10, 11, 370, 147);
		contentPanel.add(panelInfoCliente);
		panelInfoCliente.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 29, 63, 13);
		panelInfoCliente.add(lblNewLabel);

		JLabel lblNewLabel_1_1 = new JLabel("Teléfono:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 69, 63, 13);
		panelInfoCliente.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Dirección:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(10, 109, 63, 13);
		panelInfoCliente.add(lblNewLabel_1_2);

		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBounds(83, 29, 190, 20);
		panelInfoCliente.add(txtNombre);
		txtNombre.setColumns(10);

		txtTel = new JTextField();
		txtTel.setEditable(false);
		txtTel.setColumns(10);
		txtTel.setBounds(83, 70, 190, 20);
		panelInfoCliente.add(txtTel);

		txtDir = new JTextField();
		txtDir.setEditable(false);
		txtDir.setColumns(10);
		txtDir.setBounds(83, 111, 190, 20);
		panelInfoCliente.add(txtDir);

		JPanel panelTabla = new JPanel();
		panelTabla.setBounds(10, 167, 370, 187);
		contentPanel.add(panelTabla);
		panelTabla.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panelTabla.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		model3 = new DefaultTableModel();
		String[] headers = {"Cantidad", "Descripción", "Monto"};
		model3.setColumnIdentifiers(headers);
		table.setModel(model3);
		scrollPane.setViewportView(table);


		JLabel lblTotal = new JLabel("Total: ");
		lblTotal.setBounds(214, 365, 65, 13);
		contentPanel.add(lblTotal);

		lblTT = new JLabel("");
		lblTT.setBounds(289, 364, 46, 14);
		contentPanel.add(lblTT);

		JLabel lblNewLabel_1 = new JLabel("Cod. Factura:");
		lblNewLabel_1.setBounds(10, 365, 82, 14);
		contentPanel.add(lblNewLabel_1);
		
		lblCod = new JLabel("");
		lblCod.setBounds(102, 364, 46, 14);
		contentPanel.add(lblCod);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cerrar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadPlanes(factura);
	}
	
	private void loadPlanes(Factura factura) {
		String pre = String.valueOf(auxFact.getMiPlan().precioPlan());
		txtNombre.setText(auxFact.getMicliente().getNombreCliente());
		txtTel.setText(auxFact.getMicliente().getTelefono());
		txtDir.setText(auxFact.getMicliente().getDireccion());
		model3.setRowCount(0);
		row3 = new Object[model3.getColumnCount()];
		row3[0] = "1";
		row3[1] = auxFact.getMiPlan().getNombre();
		row3[2] = auxFact.getMiPlan().precioPlan();
		model3.addRow(row3);
		lblCod.setText(auxFact.getCodeFactura());
		lblTT.setText(pre);
	}
}




