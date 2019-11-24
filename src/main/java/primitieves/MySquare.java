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
public class MySquare extends MyRectangle{

    protected MySquare(List<Double> vertex) {
        super(vertex);
        if( !( vertex.get(0).getY() - vertex.get(1).getY() == vertex.get(2).getX() - vertex.get(0).getX() ) ){
            _vertex.clear();
            throw new IllegalArgumentException("Координаты не соответствуют квадрату!");
        }
    }
    
    public double getSize(){
        return getHeight();
    }
}
