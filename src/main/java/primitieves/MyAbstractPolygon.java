/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primitieves;

import java.util.List;
import java.awt.geom.Point2D.Double;
import java.util.ArrayList;
import java.util.Objects;
/**
 *
 * @author asepu
 */
public abstract class MyAbstractPolygon extends MyAreaPrimitive2D{

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
        final MyAbstractPolygon other = (MyAbstractPolygon) obj;
        if (!Objects.equals(this._vertex, other._vertex)) {
            return false;
        }
        return true;
    }
    
    protected MyAbstractPolygon(List<Double> vertex){
        if( vertex.size() < 2){
            throw new IllegalArgumentException("Количество точек меньше трех");
        }
        else{
            vertex.forEach((i) -> {
                _vertex.add( i );
            } );
        }
    }
    
    protected List<Double> _vertex = new ArrayList();
    
    public List<Double> getVertex(){
        List<Double> vertex = new ArrayList();
        
        _vertex.forEach((i) -> {
            vertex.add( i );
        });
        return vertex;
    }
    
    @Override
    public boolean isInclude(Double point) {

        int vertexCount = _vertex.size();

        Double lastPoint = new Double(_vertex.get(vertexCount - 1).getX() - point.getX(),
                _vertex.get(vertexCount - 1).getY() - point.getY());

        double sum = 0;

        for (int i = 0; i < vertexCount; ++i) {
            Double currentPoint = new Double(_vertex.get(i).getX() - point.getX(),
                    _vertex.get(i).getY() - point.getY());

            double del = lastPoint.getX() * currentPoint.getY() - currentPoint.getX() * lastPoint.getY();
            double xy = lastPoint.getX() * currentPoint.getX() - currentPoint.getY() * lastPoint.getY();

            sum += Math.atan((lastPoint.getX() * lastPoint.getX() + lastPoint.getY() * lastPoint.getY() - xy) / del)
                    + Math.atan((currentPoint.getX() * currentPoint.getX() + currentPoint.getY() * currentPoint.getY() - xy) / del);

            lastPoint = currentPoint;

        }
        return Math.abs(sum) > 0.00000001;
    }
    
    @Override
    public double calcSquare() {

        double result = 0;

        int vertexCount = _vertex.size();

        for (int i = 0; i < vertexCount - 1; ++i) {
            result += _vertex.get(i).getX() * _vertex.get(i + 1).getY();
            result -= _vertex.get(i + 1).getX() * _vertex.get(i).getY();
        }
        result += _vertex.get(vertexCount - 1).getX() * _vertex.get(0).getY();
        result -= _vertex.get(0).getX() * _vertex.get(vertexCount - 1).getY();

        return result /= 2;

    }
    
}
