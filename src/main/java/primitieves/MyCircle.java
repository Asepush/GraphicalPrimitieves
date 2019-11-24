/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primitieves;

import java.awt.geom.Point2D.Double;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author asepu
 */
public class MyCircle extends MyAreaPrimitive2D{


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MyCircle other = (MyCircle) obj;
        if (java.lang.Double.doubleToLongBits(this._radius) != java.lang.Double.doubleToLongBits(other._radius)) {
            return false;
        }
        if (!Objects.equals(this._center, other._center)) {
            return false;
        }
        return true;
    }

    private Double _center;
    private double _radius;
    
    public MyCircle(Double center, double radius) {
        
        if(center != null && radius > 0){
            _center = center;
            _radius = radius;
        }
        else {
        throw new IllegalArgumentException("Радиус не может быть нулевым или отрицательным");
        }        
    }    
    
    public Double getCenter() {
        return _center;
    }

    public double getRadius() {
        return _radius;
    }
    
    @Override
    public boolean isInclude(Double point) {
        return Math.sqrt(Math.pow(point.getX() - _center.getX(), 2) + Math.pow(point.getY() - _center.getY(), 2)) <= _radius;
    }

    @Override
    public MyCircle MoveObj(double offsetX, double offsetY) {
        return new MyCircle( new Double( _center.getX() + offsetX, _center.getY() + offsetY ), _radius );
    }

    @Override
    public MyRectangle Rectangle() {
        List<Double> coordinates = new ArrayList();
        coordinates.add(new Double(_center.getX() - _radius, _center.getY() + _radius ));
        coordinates.add(new Double(_center.getX() + _radius, _center.getY() + _radius ));
        coordinates.add(new Double(_center.getX() - _radius, _center.getY() - _radius ));
        coordinates.add(new Double(_center.getX() + _radius, _center.getY() - _radius ));
        
        return new MyRectangle(coordinates);
    }

    @Override
    public double calcSquare() {
        return _radius*_radius*Math.PI;
    }
    
}
