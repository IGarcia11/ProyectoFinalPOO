package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Administrador;
import logico.Altice;
import logico.Comerciante;
import logico.Empleado;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class ListadoEmpleados extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tableEmpleado;
	private DefaultTableModel modelE;
	private Object[] rowE;
	Empleado empleado;
	Administrador admin;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListadoEmpleados dialog = new ListadoEmpleados();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListadoEmpleados() {
		setResizable(false);
		setModal(true);
		setTitle("Listado de Empleados");
		setBounds(100, 100, 685, 466);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPaneEmpleado = new JScrollPane();
		contentPanel.add(scrollPaneEmpleado, BorderLayout.CENTER);
		
		tableEmpleado = new JTable();
		tableEmpleado.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		modelE = new DefaultTableModel();
		String[] headers = {"ID", "Cédula", "Nombre", "Teléfono", "Dirección", "Sueldo", "Tipo"};
		modelE.setColumnIdentifiers(headers);
		tableEmpleado.setModel(modelE);
		scrollPaneEmpleado.setViewportView(tableEmpleado);
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
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadEmpleados();
	}
	private void loadEmpleados() {

		modelE.setRowCount(0);
		rowE = new Object[modelE.getColumnCount()];
			for(Empleado emp : Altice.getInstance().getMisEmpleados()) {
				if(emp instanceof Comerciante) {
					rowE[0] = emp.getCodeEmpleado();	
					rowE[1] = emp.getCedulaEmpleado();	
					rowE[2] = emp.getNombreEmpleado();					
					rowE[3] = emp.getTelefono();		
					rowE[4] = emp.getDireccion();
					System.out.println("Sueldo B --"+emp.getSueldoBruto());
					System.out.println("Porcentaje --"+((Comerciante) emp).getPorcentajeComision());
					System.out.println("Multiplicacion --"+(emp.getSueldoBruto() * ((Comerciante) emp).getPorcentajeComision())/100);
					rowE[5] = emp.getSueldoBase() + (emp.getSueldoBruto() * ((Comerciante) emp).getPorcentajeComision())/100;//((Comerciante) emp).sueldoBrutoComerciante();	//emp.sueldoTotalAdmin();//sueldoTotal();
					//((Comerciante) emp).getPorcentajeComision();
					rowE[6] = "Comerciante";
					modelE.addRow(rowE);
				}
				else if(emp instanceof Administrador) {
					
					rowE[0] = emp.getCodeEmpleado();	
					rowE[1] = emp.getCedulaEmpleado();	
					rowE[2] = emp.getNombreEmpleado();					
					rowE[3] = emp.getTelefono();		
					rowE[4] = emp.getDireccion();					
					//rowE[5] = admin//Altice.getInstance().getMisEmpleados().get(i) instanceof Administrador;					
					rowE[5] = ((Administrador) emp).sueldoByAdmin();//admin.sueldoByAdmin();						
					rowE[6] = "Administrador";
					modelE.addRow(rowE);
				}				
			}	
			
		//}
		
	}
}
