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

import logico.Altice;
import logico.Internet;
import logico.Plan;
import logico.Servicio;
import logico.Telefono;
import logico.Television;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class RegistrarPlan extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombrePlan;
	private JCheckBox cbInternet;
	private JCheckBox cbTelefono;
	private JCheckBox cbTelevision;
	private JSpinner spnVelBajada;
	private JSpinner spnVelSubida;
	private JSpinner spnMinutos;
	private JSpinner spnCanalesLoc;
	private JSpinner spnCanalesHD;
	private JLabel lblPrecioPlan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarPlan dialog = new RegistrarPlan();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarPlan() {
		setModal(true);
		setTitle("Registrar Plan");
		setBounds(100, 100, 480, 420);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 444, 49);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Nombre del Plan:");
		label.setBounds(10, 14, 110, 14);
		panel.add(label);
		
		txtNombrePlan = new JTextField();
		txtNombrePlan.setColumns(10);
		txtNombrePlan.setBounds(130, 11, 226, 20);
		panel.add(txtNombrePlan);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Servicios del Plan", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 71, 444, 74);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		cbTelefono = new JCheckBox("Tel\u00E9fono");
		cbTelefono.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbTelefono.isSelected()) {
					spnMinutos.setEnabled(true);
				}else {
					spnMinutos.setEnabled(false);
				}
			}
		});
		cbTelefono.setBounds(179, 26, 85, 23);
		panel_1.add(cbTelefono);
		
		cbTelevision = new JCheckBox("televisi\u00F3n");
		cbTelevision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbTelevision.isSelected()) {
					spnCanalesLoc.setEnabled(true);
					spnCanalesHD.setEnabled(true);
				}else {
					spnCanalesLoc.setEnabled(false);
					spnCanalesHD.setEnabled(false);
				}
			}
		});
		cbTelevision.setBounds(340, 26, 85, 23);
		panel_1.add(cbTelevision);
		
		cbInternet = new JCheckBox("Internet");
		cbInternet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbInternet.isSelected()) {
					spnVelBajada.setEnabled(true);
					spnVelSubida.setEnabled(true);
				}else {
					spnVelBajada.setEnabled(false);
					spnVelSubida.setEnabled(false);
				}
			}
		});
		cbInternet.setBounds(20, 26, 85, 23);
		panel_1.add(cbInternet);
		
		JPanel panelInternet = new JPanel();
		panelInternet.setEnabled(false);
		panelInternet.setLayout(null);
		panelInternet.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panelInternet.setBounds(10, 156, 145, 125);
		contentPanel.add(panelInternet);
		
		JLabel lblNewLabel = new JLabel("Velocidad de Bajada");
		lblNewLabel.setBounds(10, 11, 116, 14);
		panelInternet.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Velocidad de Subida");
		lblNewLabel_1.setBounds(10, 61, 116, 14);
		panelInternet.add(lblNewLabel_1);
		
		spnVelBajada = new JSpinner();
		spnVelBajada.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				calcularPrecioPlan();
			}
		});
		spnVelBajada.setEnabled(false);
		spnVelBajada.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spnVelBajada.setBounds(10, 30, 125, 20);
		panelInternet.add(spnVelBajada);
		
		spnVelSubida = new JSpinner();
		spnVelSubida.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				calcularPrecioPlan();
			}
		});
		spnVelSubida.setEnabled(false);
		spnVelSubida.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spnVelSubida.setBounds(10, 79, 125, 20);
		panelInternet.add(spnVelSubida);
		
		JPanel panelTelefono = new JPanel();
		panelTelefono.setLayout(null);
		panelTelefono.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panelTelefono.setBounds(165, 156, 134, 125);
		contentPanel.add(panelTelefono);
		
		JLabel lblCantDeMinutos = new JLabel("Cantidad de Minutos");
		lblCantDeMinutos.setBounds(10, 11, 116, 14);
		panelTelefono.add(lblCantDeMinutos);
		
		spnMinutos = new JSpinner();
		spnMinutos.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				calcularPrecioPlan();
			}
		});
		spnMinutos.setEnabled(false);
		spnMinutos.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spnMinutos.setBounds(10, 30, 116, 20);
		panelTelefono.add(spnMinutos);
		
		JPanel panelTelevision = new JPanel();
		panelTelevision.setLayout(null);
		panelTelevision.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panelTelevision.setBounds(309, 156, 145, 125);
		contentPanel.add(panelTelevision);
		
		JLabel lblCantCanalesLocales = new JLabel("Cant. Canales locales");
		lblCantCanalesLocales.setBounds(10, 11, 125, 14);
		panelTelevision.add(lblCantCanalesLocales);
		
		JLabel lblCantCanalesHd = new JLabel("Cant. Canales HD");
		lblCantCanalesHd.setBounds(10, 61, 125, 14);
		panelTelevision.add(lblCantCanalesHd);
		
		spnCanalesLoc = new JSpinner();
		spnCanalesLoc.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				calcularPrecioPlan();
			}
		});
		spnCanalesLoc.setEnabled(false);
		spnCanalesLoc.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spnCanalesLoc.setBounds(10, 30, 125, 20);
		panelTelevision.add(spnCanalesLoc);
		
		spnCanalesHD = new JSpinner();
		spnCanalesHD.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				calcularPrecioPlan();
			}
		});
		spnCanalesHD.setEnabled(false);
		spnCanalesHD.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spnCanalesHD.setBounds(10, 79, 125, 20);
		panelTelevision.add(spnCanalesHD);
		
		JLabel lblNewLabel_2 = new JLabel("Precio del Plan:");
		lblNewLabel_2.setBounds(10, 299, 100, 14);
		contentPanel.add(lblNewLabel_2);
		
		lblPrecioPlan = new JLabel("");
		lblPrecioPlan.setBounds(120, 299, 100, 14);
		contentPanel.add(lblPrecioPlan);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton(" Registrar Plan");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Plan p1 = null;
						Servicio s1 = null;
						Servicio s2 = null;
						Servicio s3 = null;
						p1 = new Plan(txtNombrePlan.getText(),0);
						if(cbInternet.isSelected()) {
							s1 = new Internet(Integer.parseInt(spnVelSubida.getValue().toString()), Integer.parseInt(spnVelBajada.getValue().toString()));
							p1.insertarServicio(s1);
							/*lblPrecioPlan.setText(Float.toString(p1.precioPlan()));
							Altice.getInstance().insertarPlan(p1);
							JOptionPane.showMessageDialog(null, "Registro Exitoso", "Informacion", JOptionPane.INFORMATION_MESSAGE);
							clear();*/
						}
						if(cbTelefono.isSelected()) {
							s2 = new Telefono(Integer.parseInt(spnMinutos.getValue().toString()));
							p1.insertarServicio(s2);
							/*lblPrecioPlan.setText(Float.toString(p1.precioPlan()));
							Altice.getInstance().insertarPlan(p1);
							JOptionPane.showMessageDialog(null, "Registro Exitoso", "Informacion", JOptionPane.INFORMATION_MESSAGE);
							clear();*/
						}
						if(cbTelevision.isSelected()) {
							s3 = new Television(Integer.parseInt(spnCanalesLoc.getValue().toString()), Integer.parseInt(spnCanalesHD.getValue().toString()));
							p1.insertarServicio(s3);
							/*lblPrecioPlan.setText(Float.toString(p1.precioPlan()));
							Altice.getInstance().insertarPlan(p1);
							JOptionPane.showMessageDialog(null, "Registro Exitoso", "Informacion", JOptionPane.INFORMATION_MESSAGE);
							clear();*/
						}
						lblPrecioPlan.setText(Float.toString(p1.precioPlan()));
						Altice.getInstance().insertarPlan(p1);
						JOptionPane.showMessageDialog(null, "Registro Exitoso", "Informacion", JOptionPane.INFORMATION_MESSAGE);
						clear();
					}

				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton(" Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private void clear() {
		txtNombrePlan.setText(" ");
		spnVelBajada.setValue(Float.valueOf("0"));
		spnVelSubida.setValue(Float.valueOf("0"));
		spnMinutos.setValue(Float.valueOf("0"));
		spnCanalesLoc.setValue(Float.valueOf("0"));;
		spnCanalesHD.setValue(Float.valueOf("0"));;
		cbInternet.setSelected(false);
		cbTelefono.setSelected(false);
		cbTelevision.setSelected(false);
		lblPrecioPlan.setText("");
		spnMinutos.setEnabled(false);
		spnCanalesLoc.setEnabled(false);
		spnCanalesHD.setEnabled(false);
		spnVelBajada.setEnabled(false);
		spnVelSubida.setEnabled(false);
	}
	
	private void calcularPrecioPlan() {
		String bajada = spnVelBajada.getValue().toString();
		float baj = Float.valueOf(bajada);
		float precioBaj = baj*130;
		String subida = spnVelSubida.getValue().toString();
		float sub = Float.valueOf(subida);
		float preciosub = sub*175;
		String min = spnMinutos.getValue().toString();
		float mi = Float.valueOf(min);
		float preciomin = (float) (mi*1.85);
		String canLo = spnCanalesLoc.getValue().toString();
		float loc = Float.valueOf(canLo);
		float precioCanLoc = (float) (loc*5.80);
		String canHD = spnCanalesHD.getValue().toString();
		float HD = Float.valueOf(canHD);
		float precioCanHD = (float) (HD*7.35);
		lblPrecioPlan.setText(Float.toString(precioBaj+preciosub));
		if(mi > 0 && baj > 0) {
			lblPrecioPlan.setText(Float.toString(((precioBaj+preciosub+preciomin)*85)/100));
		}else {
			lblPrecioPlan.setText(Float.toString(precioBaj+preciosub+preciomin));
		}
		if((loc > 0 || HD > 0) && baj > 0 && mi > 0) {
			lblPrecioPlan.setText(Float.toString(((precioBaj+preciosub+preciomin+precioCanLoc+precioCanHD)*70)/100));
		}else {
			lblPrecioPlan.setText(Float.toString(precioBaj+preciosub+preciomin+precioCanLoc+precioCanHD));
		}
	}
}
