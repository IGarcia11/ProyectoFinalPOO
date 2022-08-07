package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Altice;
import logico.Cliente;
import logico.Factura;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PagoFactura extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTable table;
	private JTextField txtNombre;
	private static DefaultTableModel model;
	private static Object[] row;
	private Factura selected; 
	private JButton btnPago;
	private JButton btnLimpiar;
	private Cliente auxCliente = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PagoFactura dialog = new PagoFactura();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PagoFactura() {
		setModal(true);
		setTitle("Pago de Factura");
		setBounds(100, 100, 600, 400);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("No. de Cedula:");
		lblNewLabel.setBounds(10, 26, 82, 14);
		contentPanel.add(lblNewLabel);

		txtCedula = new JTextField();
		txtCedula.setBounds(102, 23, 139, 20);
		contentPanel.add(txtCedula);
		txtCedula.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBounds(10, 94, 564, 218);
		contentPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			panel.add(scrollPane, BorderLayout.CENTER);
			{
				table = new JTable();
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int index = table.getSelectedRow();
						if(index>=0) {
							String codigo = table.getValueAt(index, 0).toString();
							selected = Altice.getInstance().buscarFacturaByCode(codigo);
							btnPago.setEnabled(true);
						}
					}
				});
				model = new DefaultTableModel();
				String[] headers = {"Cod. Factura", "Plan", "Total", "Fecha", "Estado"};
				model.setColumnIdentifiers(headers);
				table.setModel(model);
				scrollPane.setViewportView(table);
			}
		}
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(10, 66, 82, 14);
		contentPanel.add(lblCliente);

		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		txtNombre.setBounds(102, 63, 139, 20);
		contentPanel.add(txtNombre);

		JButton btnBuscar = new JButton("Buscar Cliente");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cedula = txtCedula.getText();
				auxCliente = Altice.getInstance().buscarClienteByCedula(cedula);
				if(auxCliente!=null) {
					txtNombre.setText(auxCliente.getNombreCliente());
					loadFacturasVencidas(auxCliente);
					btnLimpiar.setEnabled(true);
				}else {
					JOptionPane.showMessageDialog(null, "El Cliente no ha sido econtrado, revise el numero de cedula", "Información", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnBuscar.setBounds(251, 22, 139, 23);
		contentPanel.add(btnBuscar);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnPago = new JButton("Realizar Pago");
				btnPago.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(selected.getEstado().equalsIgnoreCase("Vencida")) {
							selected.setEstado("Pagada");
							JOptionPane.showMessageDialog(null, "Pago exitoso", "Información", JOptionPane.INFORMATION_MESSAGE);
							loadFacturasVencidas(null);
							btnPago.setEnabled(false);
						}
					}
				});
				btnPago.setEnabled(false);
				btnPago.setActionCommand("OK");
				buttonPane.add(btnPago);
				getRootPane().setDefaultButton(btnPago);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});

				btnLimpiar = new JButton("Limpiar Tabla");
				btnLimpiar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						limpiarTabla();
						btnLimpiar.setEnabled(false);
					}
				});
				btnLimpiar.setEnabled(false);
				buttonPane.add(btnLimpiar);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	private void loadFacturasVencidas(Cliente auxCliente) {
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		for(int i = 0; i<auxCliente.getMisFacturas().size(); i++) {
			if(auxCliente.getMisFacturas().get(i).getEstado().equalsIgnoreCase("Vencida")) {
				row[0] = auxCliente.getMisFacturas().get(i).getCodeFactura();
				row[1] = auxCliente.getMisFacturas().get(i).getMiPlan().precioPlan();
				row[2] = auxCliente.getMisFacturas().get(i).getMiPlan().getNombre();
				row[3] = auxCliente.getMisFacturas().get(i).getFechaFactura();
				row[4] = auxCliente.getMisFacturas().get(i).getEstado();
				model.addRow(row);
			}
		}
	}

	public void limpiarTabla() {
		if(table.getRowCount()>1) {
			for(int i = 0; i<table.getRowCount(); i++) {
				model.removeRow(i);
				i-=1;
			}
		}else {
			JOptionPane.showMessageDialog(null, "La tabla esta Limpia", "Información", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
