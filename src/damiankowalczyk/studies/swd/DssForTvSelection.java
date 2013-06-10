/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package damiankowalczyk.studies.swd;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JLabel;

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
				DssForTvSelection dssForTvSelection = new DssForTvSelection();
			}
		});
	}

}
