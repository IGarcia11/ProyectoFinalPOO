package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Altice;
import logico.Plan;
import logico.Venta;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class Reportes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tableDinero;
	private DefaultTableModel modelDinero;
	private Object[] rowDinero;
	private DefaultTableModel modelCantidad;
	private Object[] rowCant;
	private JTable tableCantidad;
	JComboBox cbxTipoConsulta;
	JPanel panelGanancia;
	JPanel panelCantVentas;
	private String nombre = null;
	private String name = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Reportes dialog = new Reportes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Reportes() {
		setTitle("Reportes\r\n");
		setBounds(100, 100, 769, 570);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panelTipoReporte = new JPanel();
		panelTipoReporte.setBorder(new TitledBorder(null, "Tipo de Reporte", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTipoReporte.setBounds(10, 10, 730, 52);
		contentPanel.add(panelTipoReporte);
		panelTipoReporte.setLayout(null);
		
		//JComboBox cbxTipoConsulta = new JComboBox();
		cbxTipoConsulta = new JComboBox();
		cbxTipoConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedValue = cbxTipoConsulta.getSelectedIndex(); 	
				if(selectedValue == 1) {
					panelGanancia.setVisible(true);
					panelCantVentas.setVisible(false);
				}else if(selectedValue == 2) {
					panelGanancia.setVisible(false);
					panelCantVentas.setVisible(true);	
				}
			}
		});
		cbxTipoConsulta.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Ganancia por Plan", "Cantidad de Ventas por Plan"}));
		cbxTipoConsulta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbxTipoConsulta.setBounds(222, 15, 180, 21);
		panelTipoReporte.add(cbxTipoConsulta);
		
		panelGanancia = new JPanel();
		panelGanancia.setVisible(false);
		//JPanel panelGanancia = new JPanel();
		panelGanancia.setBorder(new TitledBorder(null, "Dinero Generado Por Cada Plan", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelGanancia.setBounds(10, 72, 360, 424);
		contentPanel.add(panelGanancia);
		panelGanancia.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPaneDinero = new JScrollPane();
		scrollPaneDinero.setEnabled(false);
		panelGanancia.add(scrollPaneDinero, BorderLayout.CENTER);
		
		tableDinero = new JTable();
		modelDinero = new DefaultTableModel();
		String[] headerDinero = {"Plan", "Ganancia Estimada", "Ganancia Real"};
		modelDinero.setColumnIdentifiers(headerDinero);
		tableDinero.setModel(modelDinero); 
		scrollPaneDinero.setViewportView(tableDinero);
		
		//JPanel panelCantVentas = new JPanel();
		panelCantVentas = new JPanel();
		panelCantVentas.setVisible(false);
		panelCantVentas.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Cant de Ventas Generadas por Cada Plan", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelCantVentas.setBounds(380, 72, 360, 424);
		contentPanel.add(panelCantVentas);
		panelCantVentas.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPaneCantidad = new JScrollPane();
		scrollPaneCantidad.setEnabled(false);
		panelCantVentas.add(scrollPaneCantidad, BorderLayout.CENTER);
		
		tableCantidad = new JTable();
		modelCantidad = new DefaultTableModel();
		String[] headerCantidad = {"Plan", "Cantidad"};
		modelCantidad.setColumnIdentifiers(headerCantidad);
		tableCantidad.setModel(modelCantidad);
		scrollPaneCantidad.setViewportView(tableCantidad);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
		loadTableCantidad();
		loadTableGanancias();
	}

	private void loadTableCantidad() {
		modelCantidad.setRowCount(0);;
		rowCant = new Object[modelCantidad.getColumnCount()];
		
		for(Plan v : Altice.getInstance().getMisPlanes()) {
		rowCant[0] = v.getNombre();
		name = v.getNombre();
		if(name != null) {							
			rowCant[1] = Altice.getInstance().cantVentasByPlan(name);	//p.getNombre());
			System.out.println("rowCant --- "+Altice.getInstance().cantVentasByPlan(name));
		}					
		System.out.println(name);
		modelCantidad.addRow(rowCant);
		}
		
		/*
		 * 	for(Venta v : Altice.getInstance().getMisVentas()) {
		rowCant[0] = v.getPlan().getNombre();
		name = v.getPlan().getNombre();
		if(name != null) {							
			rowCant[1] = Altice.getInstance().cantVentasByPlan(name);	//p.getNombre());
			System.out.println("rowCant --- "+Altice.getInstance().cantVentasByPlan(name));
		}					
		System.out.println(name);
		modelCantidad.addRow(rowCant);
		}
		
		 */		
	}


	private void loadTableGanancias() {
		modelDinero.setRowCount(0);;
		rowDinero = new Object[modelDinero.getColumnCount()];
		for(Plan v : Altice.getInstance().getMisPlanes()) {
			rowDinero[0] = v.getNombre();
			nombre = v.getNombre();
			if(nombre != null) {
				rowDinero[1] = Altice.getInstance().gananciaEstimada(nombre);
				System.out.println("rowDinero --- "+Altice.getInstance().gananciaEstimada(nombre));
				rowDinero[2] = Altice.getInstance().gananciaReal(nombre);
				System.out.println("rowDinero REAL--- "+Altice.getInstance().gananciaReal(nombre));
			}
			modelDinero.addRow(rowDinero);
		}
	}
}
