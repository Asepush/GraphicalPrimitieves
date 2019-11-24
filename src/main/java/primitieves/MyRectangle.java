/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primitieves;

import java.awt.geom.Point2D.Double;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author asepu
 */
public class MyRectangle extends MyAbstractPolygon{

    public MyRectangle(List<Double> vertex){
        super(vertex);
        if( ! (vertex.size() == 4 && vertex.get(0).getY() == vertex.get(1).getY() && vertex.get(0).getX() == vertex.get(2).getX() &&
                vertex.get(3).getY() == vertex.get(2).getY() && vertex.get(3).getX() == vertex.get(1).getX() ) ){
            
            _vertex.clear();
            throw new IllegalArgumentException("Координаты не соответствубт прямоугольнику!");
        }
        
    }
    
    public double getHeight(){
        return _vertex.get(3).getY() - _vertex.get(0).getY();
    }
    
    public double getLength(){
        
        return _vertex.get(3).getX() - _vertex.get(0).getX();
    }
    
    public Double getLeftTop(){
        
        return _vertex.get(0);
    }
    
    public Double getRightBottom(){
        
        return _vertex.get(3);
    }

    @Override
    public Object MoveObj(double offsetX, double offsetY) {
        List<Double> coordinates = new ArrayList();
        
        _vertex.forEach((i) -> {
            coordinates.add( new Double( i.getX()+offsetX, i.getY()+offsetY ) );
        });
        
        return new MyRectangle(coordinates);
    }

    @Override
    public MyRectangle Rectangle() {
        List<Double> coordinates = new ArrayList();
        
        coordinates.forEach((i) -> {
                _vertex.add( i );
            } );
        
        return new MyRectangle(coordinates);
    }
    
    
}
