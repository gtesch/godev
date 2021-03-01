package br.com.godev.views;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.MenuKeyListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import br.com.godev.dbutils.DAOAluno;
import br.com.godev.dbutils.DAOCafe;
import br.com.godev.dbutils.DAOSalas;
import br.com.godev.domain.Aluno;
import br.com.godev.domain.Salas;

import javax.swing.event.MenuKeyEvent;
import javax.swing.JTable;
import java.awt.List;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JDesktopPane;
import javax.swing.JLayeredPane;

public class Principal extends JFrame {

	private JPanel contentPane;
	private String user;
	private String pass;
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private DAOAluno dao = new DAOAluno();
	String[] colunas = {"id", "nome", "sobrenome"};
	ArrayList<Object[]> dados = new ArrayList<>();
	DefaultTableModel model = new DefaultTableModel(colunas,0);
	private JTable tblDados;
	private JScrollPane scroll_table;
	private JTable table;
	private JTextField txtSalas;
	private JTextField txtCapacidade;
	private JTable table_1;
	private JTextField textCafe;
	private JTextField textHorario;
	private DAOSalas dao01 = new DAOSalas();
	String[] colunas01 = {"local", "capacidade"};
	ArrayList<Object[]> dados01 = new ArrayList<>();
	DefaultTableModel model01 = new DefaultTableModel(colunas,0);


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}

	
	public void findAllAlunos(){
		model.setRowCount(0);
		dados = dao.consultar();
		for (Object[] obj : dados) {
			model.addRow(obj);
		}
		
		this.tblDados.setModel(model);
	}	
	
	
	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550,500);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.BLACK);
		menuBar.setBackground(Color.LIGHT_GRAY);
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Cadastros");
		menuBar.add(mnNewMenu);
		
		CardLayout cl = new CardLayout();
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(cl);		
		
		
		JPanel pnlPrincipal = new JPanel();
		contentPane.add(pnlPrincipal, "name_4895195611700");
		pnlPrincipal.setLayout(null);
		pnlPrincipal.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("GoDEV");
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD | Font.ITALIC, 32));
		lblNewLabel.setBounds(202, 25, 136, 37);
		pnlPrincipal.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 11, 504, 2);
		pnlPrincipal.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 73, 504, 2);
		pnlPrincipal.add(separator_1);
		
		JLabel lblNewLabel_1 = new JLabel("Seja bem vindo ao sistema GoDEV,");
		lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(117, 101, 319, 37);
		pnlPrincipal.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("acima no menu cont\u00E9m as opera\u00E7\u00F5es");
		lblNewLabel_2.setFont(new Font("Roboto", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(117, 149, 341, 24);
		pnlPrincipal.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("dispon\u00EDveis.");
		lblNewLabel_3.setFont(new Font("Roboto", Font.BOLD, 20));
		lblNewLabel_3.setBounds(223, 184, 113, 24);
		pnlPrincipal.add(lblNewLabel_3);
		
		JPanel pnlAluno = new JPanel();
		contentPane.add(pnlAluno, "name_4899845715400");
		pnlAluno.setLayout(null);
		
		tblDados = new JTable();
		tblDados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtNome.setText(String.valueOf(tblDados.getValueAt(tblDados.getSelectedRow(), 1)));
				txtSobrenome.setText(String.valueOf(tblDados.getValueAt(tblDados.getSelectedRow(), 2)));
			}
		});
		tblDados.setBounds(10, 163, 314, -49);
		pnlAluno.add(tblDados);
		scroll_table = new JScrollPane(tblDados);            // add table to scroll panel
	    scroll_table.setBounds(10, 181, 441, 238);
	    scroll_table.setVisible(true);
	    pnlAluno.add(scroll_table);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 26, 37, 14);
		pnlAluno.add(lblNome);
	
		
		txtNome = new JTextField();
		txtNome.setBounds(10, 43, 152, 20);
		pnlAluno.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setBounds(172, 26, 81, 14);
		pnlAluno.add(lblSobrenome);
		
		txtSobrenome = new JTextField();
		txtSobrenome.setColumns(10);
		txtSobrenome.setBounds(172, 43, 152, 20);
		pnlAluno.add(txtSobrenome);
		
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Inserir(txtNome.getText(), txtSobrenome.getText());
				
				findAllAlunos();
			}
		});
		btnIncluir.setBounds(10, 86, 89, 23);
		pnlAluno.add(btnIncluir);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Aluno alu = new Aluno();
				alu.setId(Integer.valueOf(String.valueOf(tblDados.getValueAt(tblDados.getSelectedRow(), 0))));
				alu.setNome(txtNome.getText());
				alu.setSobrenome(txtSobrenome.getText());
				
				dao.alterar(alu);
				
				findAllAlunos();
			}
		});
		btnEditar.setBounds(109, 86, 89, 23);
		pnlAluno.add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int input = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o aluno?");
				// sim
				if (input == 0) {
					dao.excluir(Integer.valueOf(String.valueOf(tblDados.getValueAt(tblDados.getSelectedRow(), 0))));
				}
				findAllAlunos();
			}
		});
		btnExcluir.setBounds(209, 86, 89, 23);
		pnlAluno.add(btnExcluir);
		
		JLabel lblNewLabel_4 = new JLabel("Alunos cadastrados:");
		lblNewLabel_4.setFont(new Font("Roboto", Font.BOLD, 13));
		lblNewLabel_4.setBounds(10, 159, 152, 14);
		pnlAluno.add(lblNewLabel_4);
		pnlAluno.setVisible(false);
		
		JPanel pnlSalas = new JPanel();
		contentPane.add(pnlSalas, "name_93338073909100");
		pnlSalas.setLayout(null);
		
		JMenuItem menuItemAlunos = new JMenuItem("Alunos");
		menuItemAlunos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				contentPane.add(pnlAluno);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		mnNewMenu.add(menuItemAlunos);
		
		JMenuItem menuitemSalas = new JMenuItem("Salas");
		menuitemSalas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				contentPane.add(pnlSalas);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		mnNewMenu.add(menuitemSalas);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Caf\u00E9");
		mnNewMenu.add(mntmNewMenuItem);
		
		
		cl.show(contentPane, "1");
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		table.setBounds(453, 412, -443, -235);
		pnlSalas.add(table);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 181, 441, 237);
		pnlSalas.add(scrollPane);
		
		txtSalas = new JTextField();
		txtSalas.setBounds(10, 67, 156, 20);
		pnlSalas.add(txtSalas);
		txtSalas.setColumns(10);
		
		JLabel lblSalas = new JLabel("Nome da Sala");
		lblSalas.setBounds(10, 50, 156, 14);
		pnlSalas.add(lblSalas);
		
		txtCapacidade = new JTextField();
		txtCapacidade.setBounds(201, 67, 86, 20);
		pnlSalas.add(txtCapacidade);
		txtCapacidade.setColumns(10);
		
		JLabel lblCapacidade = new JLabel("Capacidade");
		lblCapacidade.setBounds(201, 50, 72, 14);
		pnlSalas.add(lblCapacidade);
		
		JButton btnNewButton = new JButton("Incluir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InserirSala(txtSalas.getText(), txtCapacidade.getText());
			}
		});
		btnNewButton.setBounds(10, 98, 89, 23);
		pnlSalas.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Editar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(109, 98, 89, 23);
		pnlSalas.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Excluir");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(211, 98, 89, 23);
		pnlSalas.add(btnNewButton_2);
		
		JLabel lblNewLabel_4_1 = new JLabel("Salas cadastradas:");
		lblNewLabel_4_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_4_1.setBounds(10, 163, 152, 14);
		pnlSalas.add(lblNewLabel_4_1);
		
		JPanel pnlCafe = new JPanel();
		contentPane.add(pnlCafe, "name_95570343970200");
		pnlCafe.setLayout(null);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Local do caf\u00E9", "Hor\u00E1rio"
			}
		));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(202);
		table_1.setBounds(455, 414, -444, -233);
		pnlCafe.add(table_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 181, 441, 237);
		pnlCafe.add(scrollPane_1);
		
		textCafe = new JTextField();
		textCafe.setBounds(10, 64, 175, 20);
		pnlCafe.add(textCafe);
		textCafe.setColumns(10);
		
		JLabel lblCafe = new JLabel("Local do caf\u00E9");
		lblCafe.setBounds(10, 39, 104, 14);
		pnlCafe.add(lblCafe);
		
		textHorario = new JTextField();
		textHorario.setText("");
		textHorario.setBounds(216, 64, 86, 20);
		pnlCafe.add(textHorario);
		textHorario.setColumns(10);
		
		JLabel lblHorario = new JLabel("Hor\u00E1rio");
		lblHorario.setBounds(216, 39, 46, 14);
		pnlCafe.add(lblHorario);
		
		JButton btnIncluir01 = new JButton("Incluir");
		btnIncluir01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnIncluir01.setBounds(10, 95, 89, 23);
		pnlCafe.add(btnIncluir01);
		
		JButton btnEditar01 = new JButton("Editar");
		btnEditar01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditar01.setBounds(109, 95, 89, 23);
		pnlCafe.add(btnEditar01);
		
		JButton btnExcluir01 = new JButton("Excluir");
		btnExcluir01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExcluir01.setBounds(213, 95, 89, 23);
		pnlCafe.add(btnExcluir01);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Locais e hor\u00E1rios do caf\u00E9:");
		lblNewLabel_4_1_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_4_1_1.setBounds(10, 162, 228, 14);
		pnlCafe.add(lblNewLabel_4_1_1);
		findAllAlunos();
	}
	
	public Principal (String user, String pass) {
		this.user = user;
		this.pass = pass;
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	private void Inserir(String nome, String sobrenome) {
		if (nome.trim().length() == 0) {
			JOptionPane.showMessageDialog(contentPane, "Informe o nome", "Error", JOptionPane.ERROR_MESSAGE);
	    	throw new RuntimeException("Nome obrigat√≥rio.");
		}
		
		if (sobrenome.trim().length() == 0) {
			JOptionPane.showMessageDialog(contentPane, "Informe o sobrenome", "Error", JOptionPane.ERROR_MESSAGE);
	    	throw new RuntimeException("Sobrenome obrigat√≥rio.");
		}
		
		Aluno alu = new Aluno();
		alu.setNome(nome);
		alu.setSobrenome(sobrenome);
		
		dao.inserir(alu);		
	}
	
	private void InserirSala(String nome, String capacidade) {
		if (nome.trim().length() == 0) {
			JOptionPane.showMessageDialog(contentPane, "Informe o nome", "Error", JOptionPane.ERROR_MESSAGE);
	    	throw new RuntimeException("Nome obrigatÛrio.");
		}
		
		if (Integer.parseInt(capacidade) <= 0) {
			JOptionPane.showMessageDialog(contentPane, "A capacidade deve ser maior do que zero", "Error", JOptionPane.ERROR_MESSAGE);
	    	throw new RuntimeException("Nome obrigatÛrio.");
		}
		
		Salas sala = new Salas();
		sala.setNome(nome);
		sala.setCapacidade(capacidade);
		
		dao01.inserir(sala);
	}

	
}
