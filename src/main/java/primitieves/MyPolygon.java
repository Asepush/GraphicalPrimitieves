/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primitieves;

import java.awt.geom.Point2D.Double;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asepu
 */
public class MyPolygon extends MyAbstractPolygon{

    public MyPolygon( List<Double> vertex){
        super(vertex);
    }

    @Override
    public Object MoveObj(double offsetX, double offsetY) {
       
        List<Double> coordinates = new ArrayList();
        
        _vertex.forEach((i) -> {
            coordinates.add( new Double( i.getX()+offsetX, i.getY()+offsetY ) );
        });
        
        return new MyPolygon(coordinates);
    }

    @Override
    public MyRectangle Rectangle() {
        List<Double> coordinates = new ArrayList();
        
        List<Integer> indexes = new ArrayList();
        
        for( int i = 0; i < 4; i++){
            indexes.add(0);
        }
        
        for( int i = 1; i < _vertex.size(); i++){
            
            if( _vertex.get(i).getX() > _vertex.get(indexes.get(0)).getX()){
                indexes.set(0, i);
            }
            
            if( _vertex.get(i).getX() < _vertex.get(indexes.get(1)).getX()){
                indexes.set(1, i);
            }
            
            if( _vertex.get(i).getY() > _vertex.get(indexes.get(2)).getY()){
                indexes.set(2, i);
            }
            
            if( _vertex.get(i).getY() < _vertex.get(indexes.get(3)).getY()){
                indexes.set(3, i);
            }
        }
        
        
        coordinates.add( new Double( _vertex.get(indexes.get(0)).getX(), _vertex.get(indexes.get(2)).getY()) );        
        coordinates.add( new Double( _vertex.get(indexes.get(1)).getX(), _vertex.get(indexes.get(3)).getY()) );
        
        coordinates.add( 1 , new Double ( coordinates.get(1).getX(), coordinates.get(0).getY() ) );
        coordinates.add( 2 , new Double ( coordinates.get(0).getX(), coordinates.get(2).getY() ) );
        
        return new MyRectangle(coordinates);
    }
    
}
