/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package damiankowalczyk.studies.swd;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;

/**
 *
 * @author Damian
 */
public class StartPanel extends javax.swing.JPanel {

    private ProgramFrame programFrame;
    
    private ArrayList<PanelForCompareTwoFeatures> panelsForCompTwoFeatures; 
	
	
	/**
     * Creates new form StartPanel
     */
    public StartPanel() {
    	initComponents();
    	    	
    	TVAllFeautures tvAllFeatures = new TVAllFeautures();
    	String[][] pairsOfFeauture = tvAllFeatures.getAllPossiblePairs();
    	
        int featuresPairsNumber = tvAllFeatures.getAllPossiblePairs().length;
        panelsForCompTwoFeatures = new ArrayList<>(featuresPairsNumber);
        
        jPanelForFeauturePairsList.setLayout(new GridLayout(featuresPairsNumber, 1));
        
        for (int i = 0; i < featuresPairsNumber; i++) {
        	String leftText, rightText;
        	leftText = pairsOfFeauture[i][0];
        	rightText = pairsOfFeauture[i][1];
        	PanelForCompareTwoFeatures tmp = new PanelForCompareTwoFeatures(leftText,rightText);
			panelsForCompTwoFeatures.add(tmp);
			jPanelForFeauturePairsList.add(tmp);
		} 
        
        /*jPanel1.getLayout().
        .add(new JButton("this is some button"));*/
        
        //jPanelForFeauturePairsList.add(new JButton("this is some button"));
        //jScrollPane1.setVisible(true);
        
        setVisible(true);
    }
    
    private void customizeAndAddSlidersForFeatures(){
    	//for
    }
    
    public StartPanel(ProgramFrame programFrame){
    	this();
    	this.programFrame = programFrame;
    	setOkButtonListener();
    }
    
    private void setOkButtonListener() {
		jButton1.addActionListener(programFrame.getPanelForCompareTVs().getOkListener());
	}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelForFeauturePairsList = new javax.swing.JPanel();

        jLabel1.setText("Choose panel:");

        jCheckBox1.setText("LCD");

        jCheckBox2.setText("LED");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jCheckBox3.setText("Plazma");

        jLabel2.setText("Choose size:");

        jCheckBox4.setText("19''-28''");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        jCheckBox5.setText("32''-39''");
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });

        jCheckBox6.setText("40''-42''");
        jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox6ActionPerformed(evt);
            }
        });

        jCheckBox7.setText("50'' and more");

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Set your priority");

        jButton2.setText("OK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanelForFeauturePairsList.setLayout(new java.awt.GridLayout(1, 1));
        jScrollPane1.setViewportView(jPanelForFeauturePairsList);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 509, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(0, 16, Short.MAX_VALUE))
        );

        jButton2.getAccessibleContext().setAccessibleName("ApproveWeightOfGeneralPreferences");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox1)
                            .addComponent(jCheckBox6)
                            .addComponent(jCheckBox5)
                            .addComponent(jCheckBox3)
                            .addComponent(jCheckBox2)
                            .addComponent(jLabel2)
                            .addComponent(jCheckBox4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton1)
                                .addComponent(jCheckBox7)))
                        .addGap(28, 28, 28)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(23, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(278, 278, 278))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox3)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox7)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jButton1.getAccessibleContext().setAccessibleName("ApproveChoiceOfTVKind");
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox5ActionPerformed

    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox6ActionPerformed
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	// TODO add your handling code here:
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        programFrame.showCompareTVsPanel();
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelForFeauturePairsList;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables


	public JButton getJButton1() {
		return jButton1;		
	}
}
