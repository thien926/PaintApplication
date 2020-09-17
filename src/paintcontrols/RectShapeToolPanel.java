/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package paintcontrols;

import painttools.*;
import paintvisuals.*;
import paintapplication.*;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

public class RectShapeToolPanel extends DragShapeToolPanel
{
    JButton fillButton  ;
    JButton unFillButton;

    public RectShapeToolPanel(Tool tool, int stroke)
    {
        super(tool, stroke);

        remove(buttonHolder);

        JPanel fillButtonPanel = new JPanel();
        fillButtonPanel.setLayout(new GridLayout(1, 2));
        fillButtonPanel.setBackground(Color.darkGray);
        fillButtonPanel.setPreferredSize(new Dimension(150, 50));

        fillButton = new JButton();
        unFillButton=new JButton();

        ButtonListener listener = new ButtonListener();

        fillButton.addActionListener(listener);
        unFillButton.addActionListener(listener);

        if (tool == Tool.RECTANGLE)
        {
            fillButton.add(new ToolOptionIcon(StrokeStyle.FILL_RECT));
            unFillButton.add(new ToolOptionIcon(StrokeStyle.OPEN_RECT));
        }
        if (tool == Tool.OVAL)
        {
            fillButton.add(new ToolOptionIcon(StrokeStyle.FILL_OVAL));
            unFillButton.add(new ToolOptionIcon(StrokeStyle.OPEN_OVAL));
        }
        if (tool == Tool.ROUND_RECT)
        {
            fillButton.add(new ToolOptionIcon(StrokeStyle.FILL_ROUND_RECT));
            unFillButton.add(new ToolOptionIcon(StrokeStyle.OPEN_ROUND_RECT));
        }

        fillButtonPanel.add(fillButton);
        fillButtonPanel.add(unFillButton);

        add(fillButtonPanel);

        buttonHolder.setPreferredSize(new Dimension(100, 90));
        
        revalidate();
        repaint();
    }

    private class ButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            if (event.getSource() == fillButton)
            {
                switch(tool)
                {
                    case RECTANGLE:
                    {
                        Main.paint.drawPanel.tool.setStrokeStyle(StrokeStyle.FILL_RECT);
                        break;
                    }
                    case ROUND_RECT:
                    {
                        Main.paint.drawPanel.tool.setStrokeStyle(StrokeStyle.FILL_ROUND_RECT);
                        break;
                    }
                    case OVAL:
                    {
                        Main.paint.drawPanel.tool.setStrokeStyle(StrokeStyle.FILL_OVAL);
                        break;
                    }
                }
            }
            if (event.getSource()==unFillButton)
            {
               switch(tool)
                {
                    case RECTANGLE:
                    {
                        Main.paint.drawPanel.tool.setStrokeStyle(StrokeStyle.OPEN_RECT);
                        break;
                    }
                    case ROUND_RECT:
                    {
                        Main.paint.drawPanel.tool.setStrokeStyle(StrokeStyle.OPEN_ROUND_RECT);
                        break;
                    }
                    case OVAL:
                    {
                        Main.paint.drawPanel.tool.setStrokeStyle(StrokeStyle.OPEN_OVAL);
                        break;
                    }
                }
            }
            repaint();
        }
    }
}
