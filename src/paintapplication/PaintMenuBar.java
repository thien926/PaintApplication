/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paintapplication;

import painttools.*;

import javax.swing.*; 
import java.awt.*; 
import javax.swing.event.*;
import java.awt.event.*;
import java.util.ArrayList; 
import java.io.*;

public class PaintMenuBar extends JMenuBar 
{
    JMenu file;
        JMenuItem quit;
        JMenuItem newSketch;
        JMenuItem openSketch;
        JMenuItem saveSketch; 

    JMenu view;
        
    JMenu options; 

    JMenu help;
        JMenuItem howToPaint;

    PaintMenuBar()
    {
        PaintMenuBar.ItemHandler itemHandler = new PaintMenuBar.ItemHandler();

        file   = new JMenu("File");
        help   = new JMenu("Help");
        view   = new JMenu("View");
        options=new JMenu("Options");

        newSketch = new JMenuItem("New Sketch");
        openSketch = new JMenuItem("Open Sketch");
        saveSketch = new JMenuItem("Save Sketch");
        quit = new JMenuItem("Quit");

        newSketch.addActionListener(itemHandler);
        openSketch.addActionListener(itemHandler);
        saveSketch.addActionListener(itemHandler);
        quit.addActionListener(itemHandler);

        file.add(newSketch);
        file.add(openSketch);
        file.add(saveSketch);
        file.addSeparator();
        file.add(quit);

        howToPaint = new JMenuItem("Help...");
        howToPaint.addActionListener(itemHandler);

        help.add(howToPaint); 

        add(file);
        add(view);
        add(options);
        add(help);
    }

    private class ItemHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            if ( event.getSource() == quit)
            {
                Main.paint.dispose();
                System.exit(0); 
            }

            if ( event.getSource() == newSketch )
            {
                Main.paint.drawPanel.elements = new ArrayList();
                Main.paint.drawPanel.elements.add(new FillerElement(Color.white));
            }

            if ( event.getSource() == saveSketch )
            {
                Main.paint.saveFile();
            }

            if ( event.getSource() == openSketch )
            {
                File fileName = Main.paint.getFileName();
                Main.paint.loadFile(fileName);
                Main.paint.loadElementsFromFile();
                Main.paint.closeFile();
            }
            Main.paint.repaint();
            setFocusable(false);
        }
    }
}