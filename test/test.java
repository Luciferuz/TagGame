import org.junit.jupiter.api.Test;
import pack.Automation;
import pack.GameField;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class test {

    private int[][] done = new int[][]{
            {1,2,3,4},
            {5,6,7,8,},
            {9,10,11,12},
            {13,14,15,0},
    };
    private int[][] array1 = new int[][]{
            {1,2,0,8},
            {5,6,3,7},
            {9,10,11,12},
            {13,14,15,4}
    };
    private int[][] array2 = new int[][]{
            {1,2,3,4},
            {5,6,7,8},
            {9,10,15,11},
            {13,14,0,12}
    };
    private int[][] array3 = new int[][]{
            {1,2,3,0},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,4}
    };
    private int[][] array4 = new int[][]{
            {1,6,2,3},
            {9,5,8,4},
            {10,0,7,11},
            {13,14,15,12},
    };
    private int[][] array5 = new int[][]{
            {9,14,6,3},
            {1,0,2,4},
            {5,7,8,11},
            {10,13,15,12},
    };
    private int[][] array6 = new int[][]{
            {9,14,6,3},
            {1,7,2,4},
            {5,13,8,11},
            {10,15,12,0},
    };
    private int[][] badArray1 = new int[][]{
            {1,7,6,2},
            {0,3,11,4},
            {14,9,5,15},
            {10,13,8,12},
    };
    private int[][] badArray2 = new int[][]{
            {1,6,7,2},
            {0,11,3,4},
            {14,9,5,15},
            {10,13,8,12},
    };
    private int[][] badArray3 = new int[][]{
            {1,13,4,14},
            {0,12,3,15},
            {10,2,5,7},
            {11,8,9,6},
    };

    @Test
    void isSolvable() {
        assertTrue(new GameField(done).isSolvable());
        assertTrue(new GameField(array1).isSolvable());
        assertTrue(new GameField(array2).isSolvable());
        assertTrue(new GameField(array3).isSolvable());
        assertTrue(new GameField(array4).isSolvable());
        assertTrue(new GameField(array5).isSolvable());
        assertTrue(new GameField(array6).isSolvable());
        assertFalse(new GameField(badArray1).isSolvable());
        assertFalse(new GameField(badArray2).isSolvable());
        assertFalse(new GameField(badArray3).isSolvable());
    }

    @Test
    void solutionLength() {
        Automation automation0 = new Automation(new GameField(done));
        Automation automation1 = new Automation(new GameField(array1));
        Automation automation2 = new Automation(new GameField(array2));
        Automation automation3 = new Automation(new GameField(array3));
        Automation automation4 = new Automation(new GameField(array4));
        Automation automation5 = new Automation(new GameField(array5));
        Automation automation6 = new Automation(new GameField(array6));
        assertEquals(1,  automation0.getSolution().size());
        assertEquals(23, automation1.getSolution().size());
        assertEquals(4,  automation2.getSolution().size());
        assertEquals(20, automation3.getSolution().size());
        assertEquals(12, automation4.getSolution().size());
        assertEquals(29, automation5.getSolution().size());
        assertEquals(33, automation6.getSolution().size());
    }
}
