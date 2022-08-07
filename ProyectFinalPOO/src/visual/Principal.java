package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Altice;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private Dimension dim;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Principal() {
		setTitle("Sistema de Control de Altice");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				FileOutputStream empresa2;
				ObjectOutputStream empresaWrite;
				try {
					empresa2 = new  FileOutputStream("empresa.dat");
					empresaWrite = new ObjectOutputStream(empresa2);
					empresaWrite.writeObject(Altice.getInstance());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		System.out.println("Hello");
		setBounds(100, 100, 622, 379);
		dim = getToolkit().getScreenSize();
		setSize(dim.width, dim.height-50);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnPlanes = new JMenu("Planes");
		menuBar.add(mnPlanes);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Registrar Plan");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarPlan registrar = new RegistrarPlan();
				registrar.setVisible(true);
			}
		});
		mnPlanes.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Listado de Planes");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoPlanes listaPlanes = new ListadoPlanes();
				listaPlanes.setVisible(true);
			}
		});
		mnPlanes.add(mntmNewMenuItem_1);
		
		JMenu mnTienda = new JMenu("Tienda");
		menuBar.add(mnTienda);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Realizar Venta");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RealizarVenta makeSale = new RealizarVenta();
				makeSale.setVisible(true);
			}
		});
		mnTienda.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Listado de Facturas");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoFacturas listaFactura = new ListadoFacturas();
				listaFactura.setVisible(true);
			}
		});
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Realizar Pago de Factura");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PagoFactura pf = new PagoFactura();
				pf.setVisible(true);
			}
		});
		mnTienda.add(mntmNewMenuItem_8);
		mnTienda.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Listado de Ventas");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoVentas listaV= new ListadoVentas();
				listaV.setVisible(true);
			}
		});
		mnTienda.add(mntmNewMenuItem_4);
		
		JMenu mnClientes = new JMenu("Clientes");
		menuBar.add(mnClientes);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Listado de Clientes");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoClientes lista = new ListadoClientes();
				lista.setVisible(true);
			}
		});
		mnClientes.add(mntmNewMenuItem_5);
		
		JMenu mnEmpleados = new JMenu("Empleados");
		menuBar.add(mnEmpleados);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Registrar Empleado");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*RegUser users = new RegUser();
				users.setModal(true);
				users.setVisible(true);*/
				RegEmpleado rE = new RegEmpleado();
				rE.setVisible(true);
				//dispose();
				//rE.setModal(true);
			}
		});
		mnEmpleados.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Listado de Empleados");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoEmpleados lE = new ListadoEmpleados();
				lE.setVisible(true);
			}
		});
		mnEmpleados.add(mntmNewMenuItem_7);
		//if(Altice.getLoginUser().getTipo().equalsIgnoreCase("Comercial")) {
		if(!Altice.getLoginUser().getTipo().equalsIgnoreCase("Administrador")) {
			mnClientes.setEnabled(true);
			mnEmpleados.setEnabled(false);
			mnPlanes.setEnabled(false);
			mnTienda.setEnabled(true);
			mntmNewMenuItem_3.setEnabled(false);
			mntmNewMenuItem_4.setEnabled(false);
		}
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
	}

}
