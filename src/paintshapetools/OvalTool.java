/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package paintshapetools;

import painttools.*;

import java.awt.*;

public class OvalTool extends DragTool
{
    public OvalTool(Color clr, int dim)
    {
        super(clr, dim);
        strokeStyle = StrokeStyle.OPEN_OVAL;
    }
}
