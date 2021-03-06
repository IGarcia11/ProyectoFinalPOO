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
import logico.Cliente;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListadoClientes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] row;
	private Cliente selected;
	private JButton btnMostrarPlanes;
	private JButton btnModificar;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			ListadoClientes dialog = new ListadoClientes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public ListadoClientes() {
		setModal(true);
		setTitle("Listado de Clientes");
		setBounds(100, 100, 620, 400);
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
							String cedula = table.getValueAt(index, 0).toString();
							selected = Altice.getInstance().buscarClienteByCedula(cedula);
							btnMostrarPlanes.setEnabled(true);
							btnModificar.setEnabled(true);
						}
					}
				});
				model = new DefaultTableModel();
				String[] headers = {"C??dula", "Nombre", "Direcci??n", "Tel??fono", "Cant. Planes"};
				model.setColumnIdentifiers(headers);
				table.setModel(model);
				scrollPane.setViewportView(table);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnModificar = new JButton("Modificar");
				btnModificar.setEnabled(false);
				buttonPane.add(btnModificar);
			}
			{
				btnMostrarPlanes = new JButton("Mostrar Planes del Cliente");
				btnMostrarPlanes.setEnabled(false);
				btnMostrarPlanes.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ListaPlanesCliente planesCliente = new ListaPlanesCliente(selected);
						planesCliente.setVisible(true);
						btnMostrarPlanes.setEnabled(false);
						btnModificar.setEnabled(false);
					}
				});
				btnMostrarPlanes.setActionCommand("OK");
				buttonPane.add(btnMostrarPlanes);
				getRootPane().setDefaultButton(btnMostrarPlanes);
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
		loadClientes();
	}

	public static void loadClientes() {
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		for(int i = 0; i<Altice.getInstance().getMisClientes().size(); i++) {
			row[0] = Altice.getInstance().getMisClientes().get(i).getCedCliente();
			row[1] = Altice.getInstance().getMisClientes().get(i).getNombreCliente();
			row[2] = Altice.getInstance().getMisClientes().get(i).getDireccion();
			row[3] = Altice.getInstance().getMisClientes().get(i).getTelefono();
			row[4] = Altice.getInstance().getMisClientes().get(i).getMisPlanes().size();
			model.addRow(row);
		}

	}
}
