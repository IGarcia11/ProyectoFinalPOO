package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Altice;
import logico.Cliente;
import logico.Factura;
import logico.Internet;
import logico.Telefono;
import logico.Television;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListaFacturasCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] row;
	private static Cliente auxCliente = null;
	private JButton btnPagar;
	private Factura selected; 

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			ListaPlanesCliente dialog = new ListaPlanesCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public ListaFacturasCliente(Cliente cliente) {
		setModal(true);
		auxCliente = cliente;
		setTitle("Listado Facturas del Cliente");
		setBounds(100, 100, 680, 400);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				table = new JTable();
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int index = table.getSelectedRow();
						if(index>=0) {
							String codigo = table.getValueAt(index, 0).toString();
							selected = Altice.getInstance().buscarFacturaByCode(codigo);
							btnPagar.setEnabled(true);
						}
					}
				});
				model = new DefaultTableModel();
				String[] headers = {"Cod. Factura","Plan", "Total", "Fecha", "Estado"};
				model.setColumnIdentifiers(headers);
				table.setModel(model);
				scrollPane.setViewportView(table);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnPagar = new JButton("Pagar factura");
				btnPagar.setEnabled(false);
				btnPagar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(selected.getEstado().equalsIgnoreCase("Vencida")) {
							selected.setEstado("Pagada");
							JOptionPane.showMessageDialog(null, "Pago exitoso", "Información", JOptionPane.INFORMATION_MESSAGE);
							loadFacturasCliente(cliente);
							btnPagar.setEnabled(false);
						}else {
							JOptionPane.showMessageDialog(null, "Esta Factura ya esta pagada", "Información", JOptionPane.INFORMATION_MESSAGE);
							btnPagar.setEnabled(false);
						}
					}
				});
				btnPagar.setActionCommand("OK");
				buttonPane.add(btnPagar);
				getRootPane().setDefaultButton(btnPagar);
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
		loadFacturasCliente(cliente);
	}

	private static void loadFacturasCliente(Cliente cliente) {
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		auxCliente = Altice.getInstance().buscarClienteByCedula(cliente.getCedCliente());
		if(auxCliente != null) {
		for(int i = 0; i<auxCliente.getMisFacturas().size(); i++) {
			row[0] = auxCliente.getMisFacturas().get(i).getCodeFactura();
			row[1] = auxCliente.getMisFacturas().get(i).getMiPlan().getNombre();
			row[2] = auxCliente.getMisFacturas().get(i).getMiPlan().precioPlan();
			row[3] = auxCliente.getMisFacturas().get(i).getFechaFactura();
			row[4] = auxCliente.getMisFacturas().get(i).getEstado();
			model.addRow(row);
		}
		}
		
	}

}
