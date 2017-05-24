package graficos;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JButton;

import calcular.BarnsleyFern;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Fractal extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fractal frame = new Fractal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Fractal() {
		setTitle("Helecho de Barnsley");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 619);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final Grafica grafica = new Grafica();
		grafica.setBackground(SystemColor.controlHighlight);
		grafica.setBounds(20, 10, 550, 550);
		contentPane.add(grafica);
		
		JButton btnGraficar = new JButton("Graficar");
		btnGraficar.setBounds(611, 94, 117, 25);
		contentPane.add(btnGraficar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(611, 131, 117, 25);
		contentPane.add(btnLimpiar);
		
		//click sobre el boton graficar
		btnGraficar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BarnsleyFern h = new BarnsleyFern();
				grafica.dibujar(h.calcular());
			}
		});
		
		//click sobre el boton limpiar
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				grafica.limpiar();
			}
		});
	}
}
