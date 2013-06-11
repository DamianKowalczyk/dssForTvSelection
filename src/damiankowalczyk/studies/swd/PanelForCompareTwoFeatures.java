/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package damiankowalczyk.studies.swd;

/**
 *
 * @author Damian
 */
public class PanelForCompareTwoFeatures extends javax.swing.JPanel {

    /**
     * Creates new form PanelForCompareTwoFeatures
     */
    public PanelForCompareTwoFeatures() {
        initComponents();
    }
    
    public PanelForCompareTwoFeatures(String leftText, String righText) {
        this();
        jLabelLeft.setText(leftText);
        jLabelRight.setText(righText);
    }
    
    public int getSliderValue(){
    	return jSlider1.getValue();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelLeft = new javax.swing.JPanel();
        jLabelLeft = new javax.swing.JLabel();
        jPanelRight = new javax.swing.JPanel();
        jLabelRight = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();

        setLayout(new java.awt.BorderLayout());

        jPanelLeft.setMinimumSize(new java.awt.Dimension(150, 40));
        jPanelLeft.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanelLeft.setLayout(new java.awt.BorderLayout());

        jLabelLeft.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLeft.setText("jLabel3");
        jPanelLeft.add(jLabelLeft, java.awt.BorderLayout.CENTER);

        add(jPanelLeft, java.awt.BorderLayout.LINE_START);

        jPanelRight.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanelRight.setLayout(new java.awt.BorderLayout());

        jLabelRight.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRight.setText("jLabel4");
        jPanelRight.add(jLabelRight, java.awt.BorderLayout.CENTER);

        add(jPanelRight, java.awt.BorderLayout.LINE_END);

        jSlider1.setMajorTickSpacing(1);
        jSlider1.setMaximum(8);
        jSlider1.setSnapToTicks(true);
        jSlider1.setValue(4);
        jSlider1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(jSlider1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelLeft;
    private javax.swing.JLabel jLabelRight;
    private javax.swing.JPanel jPanelLeft;
    private javax.swing.JPanel jPanelRight;
    private javax.swing.JSlider jSlider1;
    // End of variables declaration//GEN-END:variables
}
