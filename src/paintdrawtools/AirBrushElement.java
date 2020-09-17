/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package paintdrawtools;

import painttools.*;

import java.awt.*;
import java.util.Random;

public class AirBrushElement extends PencilElement
{
    boolean newElement;

    int[][] points;

    public AirBrushElement(Point pt, Color clr, int dim, StrokeStyle style)
    {
        super(pt, clr, dim, style);

        newElement = true;
    }

    @Override
    public void update(Graphics g)
    {
        g.setColor(color);
        
        if (newElement)
        {
            Random rand = new Random();

            points = new int[strokeWidth*strokeWidth/10][2];
            for(int i=0; i<strokeWidth*strokeWidth/10; i++)
            {
                int[] pts = new int[2];
                do{
                    pts[0] = rand.nextInt(strokeWidth);
                    pts[1] = rand.nextInt(strokeWidth);
                } while (!isNew(pts));

                g.drawRect(coors.x + pts[0] , coors.y+ pts[1], 1, 1);
                points[i] = pts; 
            }
            newElement = false;
        }
        else
        {
            for(int i=0; i<points.length; i++)
            {
                g.drawRect(coors.x+points[i][0], coors.y+points[i][1], 1, 1);
            }
        }
    }

    public boolean isNew(int[] pts)
    {
        for(int i=0; i<points.length; i++)
        {
            if (pts == points[i])
                return false;
        }
        return true;
    }
}
