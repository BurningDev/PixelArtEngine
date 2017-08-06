package pixelartengine.ui.views;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import pixelartengine.ui.components.GamePanel;
import pixelartengine.ui.logic.PixelArtEngineLogic;

public class PixelArtEngineView extends PixelArtEngineLogic {

	private JFrame frame;
	
	private JMenuItem mntmNewGame;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void openView() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					
					initialize();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void initialize() {
		frame = new JFrame("PixelArtEngine");
		frame.setBounds(100, 100, 1600, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.9);
		GridBagConstraints gbc_splitPane = new GridBagConstraints();
		gbc_splitPane.fill = GridBagConstraints.BOTH;
		gbc_splitPane.gridx = 0;
		gbc_splitPane.gridy = 2;
		frame.getContentPane().add(splitPane, gbc_splitPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		splitPane.setLeftComponent(tabbedPane);
		
		GamePanel panel = new GamePanel();
		tabbedPane.addTab("Game", null, panel, null);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Logic", null, panel_1, null);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setResizeWeight(0.5);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setRightComponent(splitPane_1);
		
		JPanel panel_2 = new JPanel();
		splitPane_1.setLeftComponent(panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblProperties = new JLabel("Objects");
		lblProperties.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblProperties = new GridBagConstraints();
		gbc_lblProperties.anchor = GridBagConstraints.WEST;
		gbc_lblProperties.insets = new Insets(0, 0, 5, 0);
		gbc_lblProperties.gridx = 0;
		gbc_lblProperties.gridy = 0;
		panel_2.add(lblProperties, gbc_lblProperties);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 1;
		panel_2.add(panel_4, gbc_panel_4);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openAddObjectDialog();
			}
		});
		panel_4.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete");
		panel_4.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		panel_2.add(scrollPane, gbc_scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JPanel panel_3 = new JPanel();
		splitPane_1.setRightComponent(panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel lblObjects = new JLabel("Properties");
		GridBagConstraints gbc_lblObjects = new GridBagConstraints();
		gbc_lblObjects.anchor = GridBagConstraints.WEST;
		gbc_lblObjects.insets = new Insets(0, 0, 5, 0);
		gbc_lblObjects.gridx = 0;
		gbc_lblObjects.gridy = 0;
		panel_3.add(lblObjects, gbc_lblObjects);
		
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_5.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(0, 0, 5, 0);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 1;
		panel_3.add(panel_5, gbc_panel_5);
		
		JButton btnAdd = new JButton("Add");
		panel_5.add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		panel_5.add(btnDelete);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 2;
		panel_3.add(scrollPane_1, gbc_scrollPane_1);
		
		JList list_1 = new JList();
		scrollPane_1.setViewportView(list_1);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		mntmNewGame = new JMenuItem("New game");
		mntmNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openNewGameDialog();
			}
		});
		
		mnFile.add(mntmNewGame);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		mnFile.add(mntmExit);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openAboutDialog();
			}
		});
		mnHelp.add(mntmAbout);
	}

}
