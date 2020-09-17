/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paintcontrols;

import painttools.Tool;
import paintvisuals.*;
import myutilities.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PaintToolPanel extends JPanel
{
    protected ToolButton[] buttons;
    
    public ToolOptionPanel toolOptionPanel; 
    
    public PaintToolPanel(ToolOptionPanel toolOptionPanel)
    {
        setBackground   (Color.darkGray           );
        setPreferredSize(new Dimension   (192,0));
        setLayout       (new BorderLayout( 8,   8 ));
        
        JPanel toolPanel =  new JPanel(        );
        toolPanel.setLayout(new GridLayout(5,2));
        toolPanel.setBackground(Color.darkGray );
        toolPanel.setPreferredSize(new Dimension(292,350));
        
        this.toolOptionPanel = toolOptionPanel;

        buttons = new ToolButton[10];

        Icon[] icons = new ImageIcon[10];
        String[] names = {"pencil.png", "eraser.png"};
        for(int i=0; i<icons.length; i++)
        {

        }
        Icon pencil      = new ImageIcon(getClass().getResource("pencil.png"));
        Icon eraser      = new ImageIcon(getClass().getResource("eraser.png"));
        Icon rectangle   = new ImageIcon(getClass().getResource("rectangle.png"));
        Icon oval        = new ImageIcon(getClass().getResource("oval.png"));
        Icon colorPicker = new ImageIcon(getClass().getResource("color-picker.png"));
        Icon paintBucket = new ImageIcon(getClass().getResource("paint-bucket.png"));
        Icon airBrush    = new ImageIcon(getClass().getResource("air-brush.png"));
        Icon polygon     = new ImageIcon(getClass().getResource("polygon.png"));
        Icon lineTool    = new ImageIcon(getClass().getResource("line-tool.png"));
        Icon paintBrush  = new ImageIcon(getClass().getResource("paint-brush.png"));

        buttons[0] = new ToolButton(pencil, Tool.PENCIL);
        buttons[1] = new ToolButton(paintBrush, Tool.BRUSH);
        buttons[2] = new ToolButton(eraser, Tool.ERASER);
        buttons[3] = new ToolButton(paintBucket, Tool.FILLER);
        buttons[4] = new ToolButton(colorPicker, Tool.PICKER);
        buttons[5] = new ToolButton(airBrush, Tool.AIRBRUSH);
        buttons[6] = new ToolButton(rectangle, Tool.RECTANGLE);
        buttons[7] = new ToolButton(oval, Tool.OVAL);
        buttons[9] = new ToolButton(lineTool, Tool.LINE);
        buttons[8] = new ToolButton(polygon, Tool.ROUND_RECT);

        for(int i=0; i<buttons.length; i++)
        {
            toolPanel.add(buttons[i]);
        }

        add(toolPanel, BorderLayout.NORTH);
        add(toolOptionPanel, BorderLayout.SOUTH);

    }
    
    public void setToolOptionPanel (ToolOptionPanel panel)
    {
        this.remove(toolOptionPanel);
        toolOptionPanel = panel;
        add(toolOptionPanel, BorderLayout.SOUTH);
        revalidate();
        repaint();
    }
}
