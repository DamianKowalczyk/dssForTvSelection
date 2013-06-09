/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package damiankowalczyk.studies.swd;

import java.awt.Container;
import java.awt.Frame;

import javax.swing.JLabel;

/**
 *
 * @author Damian
 */
public class DssForTvSelection {
    
    public static void main(String args[]) {
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProgramFrame programFrame = new ProgramFrame();
                programFrame.setVisible(true);
                
            }
        });
    }
    
}
