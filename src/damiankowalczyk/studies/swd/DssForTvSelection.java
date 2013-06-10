/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package damiankowalczyk.studies.swd;


/**
 * 
 * @author Damian
 */
public class DssForTvSelection {

	ProgramFrame programFrame;

	public DssForTvSelection() {
		ProgramFrame programFrame = new ProgramFrame();
		
		
        programFrame.setVisible(true);                
	}

	public static void main(String args[]) {

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new DssForTvSelection();
			}
		});
	}

}
