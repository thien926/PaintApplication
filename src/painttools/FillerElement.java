/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package painttools;

import paintdrawtools.PaintElement;
import paintapplication.Main;

import java.awt.Graphics;
import java.awt.Color;

public class FillerElement extends PaintElement
{
    public FillerElement(Color clr)
    {
        super(clr);
    }

    @Override
    public void update(Graphics g)
    {
        Main.paint.drawPanel.setBackground(color);
        Main.paint.drawPanel.backgroundColor = color;
        Main.paint.drawPanel.repaint();
    }
}
