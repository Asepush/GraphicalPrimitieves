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
public class MyLineSegment extends MyGraphicsPrimitive2D{

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
        final MyLineSegment other = (MyLineSegment) obj;
        if (!Objects.equals(this._beginning_lane, other._beginning_lane)) {
            return false;
        }
        if (!Objects.equals(this._ending_lane, other._ending_lane)) {
            return false;
        }
        return true;
    }

    private Double _beginning_lane;
    
    private Double _ending_lane;
    
    public MyLineSegment(Double beginning_lane, Double ending_lane) {
        _beginning_lane = beginning_lane;
        _ending_lane = ending_lane;
       
    }

    public Double getBeginning_lane() {
        return _beginning_lane;
    }

    public Double getEnding_lane() {
        return _ending_lane;
    }

    public double getLength() {
        
       return  Math.sqrt(Math.pow(_beginning_lane.getX() - _ending_lane.getX(), 2) + Math.pow(_beginning_lane.getY() - _ending_lane.getY(), 2)) ;
    }
    
    
    @Override
    public boolean isInclude(Double point) {
        //Векторы, образованные отрезком и началом отрезка point коллинеарны и координата по оси Х point находится между координатами по оси Х концов отрезка
        return ((point.getX() - _beginning_lane.getX()) * (_ending_lane.getY() - _beginning_lane.getY()) - (point.getY() - _beginning_lane.getY())
                * (_ending_lane.getX() - _beginning_lane.getX())) == 0 && point.getX() < _ending_lane.getX() && point.getX() > _beginning_lane.getX();
    }

    @Override
    public Object MoveObj(double offsetX, double offsetY) {
        return new MyLineSegment( new Double( _beginning_lane.getX() + offsetX , _beginning_lane.getY() + offsetY), 
                new Double( _ending_lane.getX() + offsetX , _ending_lane.getY() + offsetY));
    }

    @Override
    public MyRectangle Rectangle() {
        List<Double> coordinates = new ArrayList();
        
        coordinates.add(_beginning_lane);
        coordinates.add( new Double( _ending_lane.getX() , _beginning_lane.getY()) );
        coordinates.add( new Double( _beginning_lane.getX() , _ending_lane.getY()) );        
        coordinates.add(_ending_lane);
        
        return new MyRectangle(coordinates);
    }
    
    
    
    
}
