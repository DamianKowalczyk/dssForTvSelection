/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package damiankowalczyk.studies.swd;

/**
 *
 * @author Damian
 */
public class NewPanelToCompareOneFeautureBtwTwoTVs extends javax.swing.JPanel {
	
	

    /**
     * Creates new form NewPanelToCompareOneFeautureBtwTwoTVs
     */
    public NewPanelToCompareOneFeautureBtwTwoTVs() {
        initComponents();        
    }
    
    public NewPanelToCompareOneFeautureBtwTwoTVs(String label) {
        this();        
        jLabel1.setText(label);
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

        jLabel1 = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();

        setLayout(new java.awt.BorderLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("jLabel1");
        add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jSlider1.setMaximum(8);
        jSlider1.setMinorTickSpacing(1);
        jSlider1.setValue(4);
        add(jSlider1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSlider jSlider1;
    // End of variables declaration//GEN-END:variables
}
