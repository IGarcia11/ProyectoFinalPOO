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
import logico.Internet;
import logico.Telefono;
import logico.Television;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ListadoPlanes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] row;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListadoPlanes dialog = new ListadoPlanes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListadoPlanes() {
		setModal(true);
		setTitle("Listado de Planes");
		setBounds(100, 100, 600, 420);
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
				String[] headers = {"Plan", "Internet", "Teléfono", "Televisión", "Precio"};
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
				JButton btnModificar = new JButton("Modificar");
				buttonPane.add(btnModificar);
			}
			{
				JButton btnEliminar = new JButton("Eliminar");
				btnEliminar.setActionCommand("OK");
				buttonPane.add(btnEliminar);
				getRootPane().setDefaultButton(btnEliminar);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}

		loadPlanes();
	}

	private static void loadPlanes() {
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		for(int i = 0; i<Altice.getInstance().getMisPlanes().size(); i++) {
			row[0] = Altice.getInstance().getMisPlanes().get(i).getNombre();
			row[4] = Altice.getInstance().getMisPlanes().get(i).precioPlan();
			for(int j = 0; j<Altice.getInstance().getMisPlanes().get(i).getServiciosPlan().size(); j++) {
				if(Altice.getInstance().getMisPlanes().get(i).getServiciosPlan().get(j) instanceof Internet) {
					row[1] = Altice.getInstance().getMisPlanes().get(i).getServiciosPlan().get(j).velocidadB()+" Mbps / "+Altice.getInstance().getMisPlanes().get(i).getServiciosPlan().get(j).velocidadS()+" Mbps";
				}
				if(Altice.getInstance().getMisPlanes().get(i).getServiciosPlan().get(j) instanceof Telefono) {
					row[2] = Altice.getInstance().getMisPlanes().get(i).getServiciosPlan().get(j).minutos();
				}
				if(Altice.getInstance().getMisPlanes().get(i).getServiciosPlan().get(j) instanceof Television) {
					row[3] = Altice.getInstance().getMisPlanes().get(i).getServiciosPlan().get(j).canalesLoc()+" Loc. / "+Altice.getInstance().getMisPlanes().get(i).getServiciosPlan().get(j).canalesHD()+" HD";
				}
				/*row[1] = Altice.getInstance().getMisPlanes().get(i).getServiciosPlan().get(j).velocidadB()+" Mbps / "+Altice.getInstance().getMisPlanes().get(i).getServiciosPlan().get(j).velocidadS()+" Mbps";
				row[2] = Altice.getInstance().getMisPlanes().get(i).getServiciosPlan().get(j).minutos();
				row[3] = Altice.getInstance().getMisPlanes().get(i).getServiciosPlan().get(j).canalesLoc()+"Loc. / "+Altice.getInstance().getMisPlanes().get(i).getServiciosPlan().get(j).canalesHD()+"HD";*/
			}
			model.addRow(row);
		}
	}

}
