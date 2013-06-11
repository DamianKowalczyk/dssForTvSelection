/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package damiankowalczyk.studies.swd;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author Damian
 */

public class ProgramFrame extends javax.swing.JFrame {

	private final int width = 1000;
	private final int height = 600;

	StartPanel startPanel;
	PanelForCompareTVs panelForCompareTVs;

	float[][] preferenceMatrix;
	float[][][] matrixesForEachFeauture;

	AhpEngine ahpEngine= new AhpEngine();

	/**
	 * Creates new form ProgramFrame
	 */
	public ProgramFrame() {
		initComponents();

		setSize(width, height);
		setFrameIcon();
		setLayout(new BorderLayout());
		setFrameInMiddleOfScreen(this);

		panelForCompareTVs = new PanelForCompareTVs(this);
		getContentPane().add(panelForCompareTVs);

		startPanel = new StartPanel(this);
		panelForCompareTVs.setStartPanel(startPanel);

		getContentPane().add(startPanel);

	}

	private void setFrameIcon() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = kit.getImage("images/google_tv_logo.jpg");
		setIconImage(img);
	}

	public void setPanelForCompareTVs(PanelForCompareTVs panelForCompareTVs) {
		this.panelForCompareTVs = panelForCompareTVs;
	}

	public StartPanel getStartPanel() {
		return startPanel;
	}

	public PanelForCompareTVs getPanelForCompareTVs() {
		return panelForCompareTVs;
	}

	public float[][] getPreferenceMatrix() {
		return ahpEngine.getPreferencesMatrix();
	}

	public void setPreferenceMatrix(float[][] preferenceMatrix) {		
		ahpEngine.setPreferencesMatrix(preferenceMatrix);		
	}

	public float[][][] getMatrixesForEachFeauture() {
		return ahpEngine.getMatrices();
	}

	public void setMatrixesForEachFeauture(float[][][] matrixesForEachFeauture) {
		ahpEngine.setMatrices(matrixesForEachFeauture);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Decision support system for selection of TV");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 654,
				Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 388,
				Short.MAX_VALUE));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	public void showCompareTVsPanel() {
		/* remove(startPanel); */
		startPanel.setVisible(false);
		panelForCompareTVs.setVisible(true);
		getContentPane().add(panelForCompareTVs);
	}

	public static void setFrameInMiddleOfScreen(JFrame frame) {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		int halfFrameWidth = frame.getSize().width / 2;
		int halfFrameHeight = frame.getSize().height / 2;
		Point p = new Point(screenWidth / 2 - halfFrameWidth, screenHeight / 2
				- halfFrameHeight);
		frame.setLocation(p);
	}

}
