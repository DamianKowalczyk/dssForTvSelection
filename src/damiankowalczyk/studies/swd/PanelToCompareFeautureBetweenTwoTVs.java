/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package damiankowalczyk.studies.swd;

/**
 *
 * @author Damian
 */
public class PanelToCompareFeautureBetweenTwoTVs extends javax.swing.JPanel {

    /**
     * Creates new form PanelToCompareFeautureBetweenTwoTVs
     */
    public PanelToCompareFeautureBetweenTwoTVs() {
        initComponents();
    }
    
    public PanelToCompareFeautureBetweenTwoTVs(String labelText) {
        initComponents();
        jLabelToCompareFeautureInTwoTVs.setText(labelText);
    } 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelToCompareFeautureInTwoTVs = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();

        setLayout(new java.awt.BorderLayout());

        jLabelToCompareFeautureInTwoTVs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelToCompareFeautureInTwoTVs.setText("jLabel1");
        add(jLabelToCompareFeautureInTwoTVs, java.awt.BorderLayout.PAGE_START);

        jSlider1.setMajorTickSpacing(1);
        jSlider1.setMaximum(9);
        jSlider1.setMinimum(1);
        jSlider1.setPaintLabels(true);
        jSlider1.setValue(5);
        jSlider1.setValueIsAdjusting(true);
        add(jSlider1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelToCompareFeautureInTwoTVs;
    private javax.swing.JSlider jSlider1;
    // End of variables declaration//GEN-END:variables
}