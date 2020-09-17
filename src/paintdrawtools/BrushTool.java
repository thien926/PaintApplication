/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package paintdrawtools;

import painttools.StrokeStyle;
import paintcontrols.*;
import java.awt.*;

public class BrushTool extends PencilTool
{
    public BrushTool(Color clr, int dim, StrokeStyle style)
    {
        super(clr, dim);

        strokeStyle = style;

        element = new BrushElement();
    }

    @Override
    public void drawElement(Graphics g)
    {
        element.update(g);
    }
}
