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
import logico.Internet;
import logico.Plan;
import logico.Servicio;
import logico.Telefono;
import logico.Television;
import logico.Venta;
import logico.Factura;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.JSpinner;
import java.util.Locale;

public class RealizarVenta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTable tableOne;
	private DefaultTableModel model;
	private Object[] row;
	private Plan selected = null;
	private Factura fac = null;
	private Venta sale = null;
	//private Altice a = null;
	private JTextField txtMuestraInternet;
	private JTextField txtMuestraCable;
	private JTextField txtMuestraTelefono;
	public JTable tableTwo;
	public DefaultTableModel model2;
	private JTextField txtSubtotal;
	//private Plan selected = null;
	private float subtotal = 0;
	private JTextField txtFechaFac;
	private JTextField txtCodeVenta;
	private ReciboFactura rFact;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RealizarVenta dialog = new RealizarVenta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RealizarVenta() {
		//Altice alt = null;
		//Factura fac = null;
		setTitle("Realizar Venta");
		setBounds(100, 100, 662, 535);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panelInfoCliente = new JPanel();
			panelInfoCliente.setBorder(new TitledBorder(null, "Informaci\u00F3n del Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelInfoCliente.setBounds(10, 10, 628, 163);
			contentPanel.add(panelInfoCliente);
			panelInfoCliente.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("Cédula:");
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblNewLabel.setBounds(10, 21, 78, 13);
				panelInfoCliente.add(lblNewLabel);
			}
			{
				txtCedula = new JTextField();
				txtCedula.setBounds(98, 21, 219, 19);
				panelInfoCliente.add(txtCedula);
				txtCedula.setColumns(10);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Nombre:");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblNewLabel_1.setBounds(10, 55, 78, 13);
				panelInfoCliente.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Teléfono:");
				lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblNewLabel_2.setBounds(10, 89, 78, 13);
				panelInfoCliente.add(lblNewLabel_2);
			}
			{
				JLabel lblNewLabel_3 = new JLabel("Dirección: ");
				lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblNewLabel_3.setBounds(10, 123, 78, 19);
				panelInfoCliente.add(lblNewLabel_3);
			}
			{
				txtNombre = new JTextField();
				txtNombre.setBounds(98, 55, 219, 19);
				panelInfoCliente.add(txtNombre);
				txtNombre.setColumns(10);
			}
			{
				txtTelefono = new JTextField();
				txtTelefono.setBounds(98, 89, 219, 19);
				panelInfoCliente.add(txtTelefono);
				txtTelefono.setColumns(10);
			}
			{
				txtDireccion = new JTextField();
				txtDireccion.setBounds(98, 123, 219, 19);
				panelInfoCliente.add(txtDireccion);
				txtDireccion.setColumns(10);
			}
			{
				JButton btnBuscar = new JButton("Buscar");
				btnBuscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					Cliente aux = Altice.getInstance().buscarClienteByCedula(txtCedula.getText());
					if(aux != null) {
						txtNombre.setText(aux.getNombreCliente());
						txtTelefono.setText(aux.getTelefono());
						txtDireccion.setText(aux.getDireccion());
						tableOne.enable(true);
						txtNombre.setEditable(false);
						txtTelefono.setEditable(false);
						txtDireccion.setEditable(false);
						
						
					}else {
						JOptionPane.showMessageDialog(null, "Cliente no encontrado. Registre a uno nuevo.", "No encontrado", JOptionPane.ERROR_MESSAGE);
						//clean();
					}
					}

					
				});
				btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 11));
				btnBuscar.setBounds(348, 21, 85, 19);
				panelInfoCliente.add(btnBuscar);
			}
			
			txtFechaFac = new JTextField();
			txtFechaFac.setEditable(false);
			txtFechaFac.setBounds(502, 55, 96, 19);
			
			/* ESTO ES OTRA FORMA
			sdf = new SimpleDateFormat("dd/MM/yyyy");
			String dateP = sdf.format(sale.getFechaPrueba().getTime());
			txtFechaFac.setText(""+dateP);*/
			
			panelInfoCliente.add(txtFechaFac);
			txtFechaFac.setColumns(10);
			
			txtCodeVenta = new JTextField();
			txtCodeVenta.setEditable(false);
			txtCodeVenta.setBounds(502, 21, 96, 19);
			txtCodeVenta.setText("V-"+Altice.generadorCodVenta);
			panelInfoCliente.add(txtCodeVenta);
			txtCodeVenta.setColumns(10);
			
		}
		{
			JPanel panelSeleccion = new JPanel();
			panelSeleccion.setBorder(new TitledBorder(null, "Selecci\u00F3n de Plan", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelSeleccion.setBounds(10, 183, 628, 241);
			contentPanel.add(panelSeleccion);
			panelSeleccion.setLayout(null);
			
			JPanel panelTablaPlan = new JPanel();
			panelTablaPlan.setBounds(10, 25, 147, 195);
			panelSeleccion.add(panelTablaPlan);
			panelTablaPlan.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPaneOne = new JScrollPane();
			panelTablaPlan.add(scrollPaneOne, BorderLayout.CENTER);
			
			tableOne = new JTable();
			tableOne.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					//Servicio ser;
					int select = tableOne.rowAtPoint(e.getPoint());//  e.getPoint()
					for (Plan plan : Altice.getInstance().getMisPlanes()) {
						if(String.valueOf(tableOne.getValueAt(select, 0)).equalsIgnoreCase(plan.getNombre())) {
							txtMuestraInternet.setText("");
							txtMuestraCable.setText("");
							txtMuestraTelefono.setText("");
							
							for(Servicio s : plan.getServiciosPlan()) {
								if(s instanceof Internet) {
									txtMuestraInternet.setText(""+s.capacidad());	
								}
								
								if(s instanceof Television) {
									txtMuestraCable.setText(""+s.capacidad());
								}								
								
								if(s instanceof Telefono) {
									txtMuestraTelefono.setText(""+s.capacidad());
								}									
							}							
						}			
					}
				}

				
			});
			model = new DefaultTableModel();
			String header = "Planes Disponibles:";
			model.addColumn(header);
			tableOne.setModel(model);
			tableOne.setFont(new Font("Tahoma", Font.PLAIN, 13));
			scrollPaneOne.setViewportView(tableOne);
			{
				JPanel panelMuestraPlan = new JPanel();
				panelMuestraPlan.setBorder(new TitledBorder(null, "Detalles del Plan", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panelMuestraPlan.setBounds(167, 25, 159, 195);
				panelSeleccion.add(panelMuestraPlan);
				panelMuestraPlan.setLayout(null);
				{
					JLabel lblNewLabel_4 = new JLabel("Internet:");
					lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
					lblNewLabel_4.setBounds(43, 18, 73, 13);
					panelMuestraPlan.add(lblNewLabel_4);
				}
				{
					JLabel lblNewLabel_4 = new JLabel("Cable:");
					lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
					lblNewLabel_4.setBounds(56, 74, 46, 13);
					panelMuestraPlan.add(lblNewLabel_4);
				}
				{
					JLabel lblNewLabel_4 = new JLabel("Teléfono:");
					lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
					lblNewLabel_4.setBounds(43, 134, 73, 13);
					panelMuestraPlan.add(lblNewLabel_4);
				}
				{
					txtMuestraInternet = new JTextField();
					txtMuestraInternet.setEditable(false);
					txtMuestraInternet.setBounds(18, 41, 122, 19);
					panelMuestraPlan.add(txtMuestraInternet);
					txtMuestraInternet.setColumns(10);
				}
				{
					txtMuestraCable = new JTextField();
					txtMuestraCable.setEditable(false);
					txtMuestraCable.setBounds(18, 101, 122, 19);
					panelMuestraPlan.add(txtMuestraCable);
					txtMuestraCable.setColumns(10);
				}
				{
					txtMuestraTelefono = new JTextField();
					txtMuestraTelefono.setEditable(false);
					txtMuestraTelefono.setBounds(18, 161, 122, 19);
					panelMuestraPlan.add(txtMuestraTelefono);
					txtMuestraTelefono.setColumns(10);
				}
			}
			
			JButton btnAgregar = new JButton("Agregar");
			btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int filaSelected = tableOne.getSelectedRow();
				
					if(filaSelected >= 0) {
						String planSelected = tableOne.getValueAt(filaSelected, 0).toString();
						row = new Object[model2.getColumnCount()];	
						row[0] =  (String) tableOne.getValueAt(filaSelected, 0);
			
						for (Plan plan : Altice.getInstance().getMisPlanes()) {
							if(plan.getNombre().equalsIgnoreCase(planSelected)) {
								
								row[1] = plan.precioPlan();
								subtotal += plan.precioPlan();
								
							}	
						}
						model2.addRow(row);
						txtSubtotal.setText(String.valueOf(subtotal));
					}
					}				
			});
			
			btnAgregar.setBounds(330, 73, 89, 21);
			panelSeleccion.add(btnAgregar);
			{
				JPanel panelCarrito = new JPanel();
				panelCarrito.setBounds(424, 25, 194, 195);
				panelSeleccion.add(panelCarrito);
				panelCarrito.setLayout(new BorderLayout(0, 0));
				{
					JScrollPane scrollPane = new JScrollPane();
					panelCarrito.add(scrollPane, BorderLayout.CENTER);
					{
						tableTwo = new JTable();
						model2 = new DefaultTableModel();
						scrollPane.setViewportView(tableTwo);
						String[] headers = {"Plan", "Monto"};
						model2.setColumnIdentifiers(headers);
						tableTwo.setModel(model2);
						tableTwo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
					}
				}
			}
		}
		{
			JLabel lblNewLabel_5 = new JLabel("Subtotal:");
			lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_5.setBounds(40, 434, 83, 20);
			contentPanel.add(lblNewLabel_5);
		}
		{
			txtSubtotal = new JTextField();
			txtSubtotal.setFont(new Font("Tahoma", Font.BOLD, 14));
			txtSubtotal.setEditable(false);
			txtSubtotal.setText(String.valueOf(subtotal));
	
			txtSubtotal.setBounds(136, 434, 83, 20);
			contentPanel.add(txtSubtotal);
			txtSubtotal.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnFacturar = new JButton("Facturar");
				btnFacturar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ReciboFactura rF = new ReciboFactura();
						rF.txtNombre.setText(txtNombre.getText().toString());
						rF.txtCedula.setText(txtCedula.getText().toString());
						rF.txtTelefono.setText(txtTelefono.getText());
						rF.txtDireccion.setText(txtDireccion.getText());
						rF.txtCodeFactura.setText(txtCodeVenta.getText());
						rF.setVisible(true);
						int existe = 1;
						for(int i = 0; i < tableTwo.getRowCount(); i++) {
							String dato = null, Datos[] = new String[3];
							int columna = 1;
							/*for(int j = 0; j< tableTwo.getRowCount();j++) {
								if(tableTwo.getValueAt(j, columna).equals(tableTwo.getValueAt(j, columna+1))){	//Datos[1])){//Datos[0])) {
									existe++;
									JOptionPane.showMessageDialog(null, existe);
								}
							}*/
							Datos[0] = "1";
							Datos[1] = tableTwo.getValueAt(i, 0).toString();
							Datos[2] = tableTwo.getValueAt(i, 1).toString();
							ReciboFactura.model3.addRow(Datos);
						}
						dispose();
						ArrayList<Plan> planes = new ArrayList<>();
						Factura fac;
						//for(int i = 0; i < )
						Cliente aux = Altice.getInstance().buscarClienteByCedula(txtCedula.getText());						
						if(aux != null) {
							fac = new Factura("F-"+Altice.generadorCodFactura,aux, null);
							fac.setPlanes(planes);
							aux.getMisFacturas().add(fac);
							aux.getMisCompras().add(sale);
							Altice.getInstance().getMisFacturas().add(fac);
						}else {
							Cliente nuevo = new Cliente(txtCedula.getText(), txtNombre.getText(), txtDireccion.getText(), txtTelefono.getText());
							Altice.getInstance().getMisClientes().add(nuevo);
							fac = new Factura("F-"+Altice.generadorCodFactura,aux, null);
							fac.setPlanes(planes);
							nuevo.getMisFacturas().add(fac);
							nuevo.getMisCompras().add(sale);
							Altice.getInstance().getMisFacturas().add(fac);
						}
						JOptionPane.showMessageDialog(null, "Registrado satisfactoriamente", "Información", JOptionPane.INFORMATION_MESSAGE);
						
					}
				});
				btnFacturar.setActionCommand("Cancel");
				buttonPane.add(btnFacturar);
			}
		}
		loadPlanes();
	}
	
	
	private void loadPlanes() {

		model.setRowCount(0);
		row = new Object[model.getColumnCount()];		
		
		for(int i = 0; i < Altice.getInstance().getMisPlanes().size(); i++) {
			row[0] = Altice.getInstance().getMisPlanes().get(i).getNombre();
			model.addRow(row);
			//Object object = row[i];
		}
		
	}
	
	
	private void clean() {
		txtCodeVenta.setText("V-"+Altice.generadorCodVenta);
		txtNombre.setText("");
		txtTelefono.setText("");
		txtDireccion.setText("");
		txtNombre.setEditable(true);
		txtTelefono.setEditable(true);
		txtDireccion.setEditable(true);
		tableTwo.removeAll();
		tableOne.enable(true);
		//listQuesos.enable(true);
	}
}

