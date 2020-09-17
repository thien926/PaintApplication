/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package paintdrawtools;

import painttools.StrokeStyle;
import java.awt.*;

public class EraserTool extends BrushTool
{
    EraserElement element; 

    public EraserTool(Color clr, int dim, StrokeStyle style)
    {
        super(clr, dim, style);
    }
}
