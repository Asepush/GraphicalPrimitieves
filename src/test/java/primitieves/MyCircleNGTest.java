/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primitieves;

import java.awt.geom.Point2D;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.awt.geom.Point2D.Double;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asepu
 */
public class MyCircleNGTest {
    
    public MyCircleNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of getCenter method, of class MyCircle.
     */
    @Test
    public void testGetCenter() {
        System.out.println("1. getCenter");
        MyCircle instance = new MyCircle( new Double( 0, 0 ), 5);
        Point2D.Double expResult = new Double( 0, 0 );
        Point2D.Double result = instance.getCenter();
        
        assertEquals(result, expResult);
    }

    /**
     * Test of getRadius method, of class MyCircle.
     */
    @Test
    public void testGetRadius() {
        System.out.println("2. getRadius");
        MyCircle instance = new MyCircle( new Double( 0, 0 ), 5);
        double expResult = 5.0;
        double result = instance.getRadius();
        
        assertEquals(result, expResult, 0.0);
    }

    /**
     * Test of MoveObj method, of class MyCircle.
     */
    @Test
    public void testMoveObjPos() {
        System.out.println("3. MoveObj - перемещение в положительное направление осей");
        double offsetX = 4.2;
        double offsetY = 6.3;
        
        MyCircle instance = new MyCircle( new Double( 0, 0 ), 5);
        MyCircle expResult = new MyCircle( new Double( 4.2, 6.3 ), 5);
        
        MyCircle result = instance.MoveObj(offsetX, offsetY);
        
        assertEquals(result, expResult);
    }
    
    @Test
    public void testMoveObjNeg() {
        System.out.println("4. MoveObj - перемещение в отрицательное направление осей");
        double offsetX = -4.2;
        double offsetY = -6.3;
        
        MyCircle instance = new MyCircle( new Double( 0, 0 ), 5);
        MyCircle expResult = new MyCircle( new Double( -4.2, -6.3 ), 5);
        
        MyCircle result = instance.MoveObj(offsetX, offsetY);
        
        assertEquals(result, expResult);
    }
    
    @Test
    public void testMoveObjComp() {
        System.out.println("5. MoveObj - перемещение в смешанное направление осей");
        double offsetX = -4.2;
        double offsetY = 6.3;
        
        MyCircle instance = new MyCircle( new Double( 0, 0 ), 5);
        MyCircle expResult = new MyCircle( new Double( -4.2, 6.3 ), 5);
        
        MyCircle result = instance.MoveObj(offsetX, offsetY);
        
        assertEquals(result, expResult);
    }
    
    @Test
    public void testMoveObjZero() {
        System.out.println("6. MoveObj - перемещение на нулевое расстояние");
        double offsetX = 0;
        double offsetY = 0;
        
        MyCircle instance = new MyCircle( new Double( 0, 0 ), 5);
        MyCircle expResult = new MyCircle( new Double( 0, 0 ), 5);
        
        MyCircle result = instance.MoveObj(offsetX, offsetY);
        
        assertEquals(result, expResult);
    }

    /**
     * Test of Rectangle method, of class MyCircle.
     */
    @Test
    public void testRectangle() {
        System.out.println("7. Rectangle");
        MyCircle instance = new MyCircle( new Double( 0, 0 ), 5);
        
        List<Double> RectCoord = new ArrayList<>();
        RectCoord.add( new Double( -5, 5 ));
        RectCoord.add( new Double( 5, 5 ));
        RectCoord.add( new Double( -5, -5 ));
        RectCoord.add( new Double( 5, -5 ));
        
        MyRectangle expResult = new MyRectangle( RectCoord );
        
        MyRectangle result = instance.Rectangle();
        assertEquals(result, expResult);
    }

    /**
     * Test of calcSquare method, of class MyCircle.
     */
    @Test
    public void testCalcSquare() {
        System.out.println("8. calcSquare");
        MyCircle instance = new MyCircle( new Double( 0, 0 ), 5);
        double expResult = 25*Math.PI;
        double result = instance.calcSquare();
        assertEquals(result, expResult, 0.0);
    }
    
    /**
     * Test of isInclude method, of class MyCircle.
     */
    @Test
    public void testIsInclude() {
        System.out.println("9. isInclude - точка в области");
        Double point = new Double( 1, 0 );
        MyCircle instance = new MyCircle( new Double( 0, 0 ), 5);
        boolean expResult = true;
        boolean result = instance.isInclude(point);
        assertEquals(result, expResult);
    }

    @Test
    public void testIsIncludeNoDot() {
        System.out.println("10. isInclude - точка не в области");
        Double point = new Double( 6, 0 );
        MyCircle instance = new MyCircle( new Double( 0, 0 ), 5);
        boolean expResult = false;
        boolean result = instance.isInclude(point);
        assertEquals(result, expResult);
    }
    
    @Test
    public void testIsIncludeBorder() {
        System.out.println("11. isInclude - точка границе");
        Double point = new Double( -5, 0 );
        MyCircle instance = new MyCircle( new Double( 0, 0 ), 5);
        boolean expResult = true;
        boolean result = instance.isInclude(point);
        assertEquals(result, expResult);
    }
    
    @Test
    public void testIsIncludeCenter() {
        System.out.println("12. isInclude - точка центр окружности");
        Double point = new Double( 0, 0 );
        MyCircle instance = new MyCircle( new Double( 0, 0 ), 5);
        boolean expResult = true;
        boolean result = instance.isInclude(point);
        assertEquals(result, expResult);
    }
}
