/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primitieves;
import java.awt.geom.Point2D.Double;
import java.util.List;
/**
 *
 * @author asepu
 */
public abstract class MyGraphicsPrimitive2D {
    
    //isINclude - занимает ли примитив точку
    public abstract boolean isInclude(Double point);
    
    public abstract Object MoveObj(double offsetX, double offsetY);
    
    public abstract MyRectangle Rectangle();
    
    
}
