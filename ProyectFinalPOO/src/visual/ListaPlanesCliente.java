package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Altice;
import logico.Cliente;
import logico.Internet;
import logico.Telefono;
import logico.Television;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaPlanesCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] row;
	private static Cliente auxCliente = null;

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
	public ListaPlanesCliente(Cliente cliente) {
		setModal(true);
		auxCliente = cliente;
		setTitle("Listado Planes del Cliente");
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
				model = new DefaultTableModel();
				String[] headers = {"Plan","Internet", "Teléfono", "Televisión", "Precio"};
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
		loadPlanesCliente(cliente);
	}

	private static void loadPlanesCliente(Cliente cliente) {
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		auxCliente = Altice.getInstance().buscarClienteByCedula(cliente.getCedCliente());
		if(auxCliente != null) {
		for(int i = 0; i<auxCliente.getMisPlanes().size(); i++) {
			row[0] = auxCliente.getMisPlanes().get(i).getNombre();
			row[4] = auxCliente.getMisPlanes().get(i).precioPlan();
			row[1] = "N/A";
			row[2] = "N/A";
			row[3] = "N/A";
			for(int j = 0; j<auxCliente.getMisPlanes().get(i).getServiciosPlan().size(); j++) {
				if(auxCliente.getMisPlanes().get(i).getServiciosPlan().get(j) instanceof Internet) {
					row[1] = auxCliente.getMisPlanes().get(i).getServiciosPlan().get(j).capacidad();
				}
				if(auxCliente.getMisPlanes().get(i).getServiciosPlan().get(j) instanceof Telefono) {
					row[2] = auxCliente.getMisPlanes().get(i).getServiciosPlan().get(j).capacidad();
				}
				if(auxCliente.getMisPlanes().get(i).getServiciosPlan().get(j) instanceof Television) {
					row[3] = auxCliente.getMisPlanes().get(i).getServiciosPlan().get(j).capacidad();
				}
			}
			model.addRow(row);
		}
		}
		
	}

}
