import org.junit.jupiter.api.Test;
import pack.Automation;
import pack.GameField;
import java.util.*;

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
    private int[][] array7 = new int[][]{
            {1,2,3,7},
            {5,6,8,4},
            {9,13,0,15},
            {12,14,10,11},
    };
    private int[][] array8 = new int[][]{
            {5,2,1,7},
            {3,6,8,4},
            {9,10,0,15},
            {12,13,14,11},
    };
    private int[][] array9 = new int[][]{
            {5,2,7,15},
            {3,6,1,0},
            {13,10,4,8},
            {9,12,14,11},
    };
    private int[][] array10 = new int[][]{
            {2,3,1,11},
            {0,9,10,15},
            {5,13,7,4},
            {14,12,6,8},
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
    private int[][] arrayMoves = new int[][]{
            {2,3,4,0},
            {1,6,7,8},
            {5,10,11,12},
            {9,13,14,15},
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
        assertTrue(new GameField(array7).isSolvable());
        assertTrue(new GameField(array8).isSolvable());
        assertTrue(new GameField(array9).isSolvable());
        assertTrue(new GameField(array10).isSolvable());
        assertTrue(new GameField(arrayMoves).isSolvable());
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
        Automation automation7 = new Automation(new GameField(array7));
        Automation automation8 = new Automation(new GameField(array8));
        Automation automation9 = new Automation(new GameField(array9));
        Automation automation10 = new Automation(new GameField(array10));
        Automation automation11 = new Automation(new GameField(arrayMoves));
        assertEquals(1,  automation0.getSolution().size());
        assertEquals(25, automation1.getSolution().size());
        assertEquals(4,  automation2.getSolution().size());
        assertEquals(24, automation3.getSolution().size());
        assertEquals(12, automation4.getSolution().size());
        assertEquals(39, automation5.getSolution().size());
        assertEquals(43, automation6.getSolution().size());
        assertEquals(35, automation7.getSolution().size());
        assertEquals(41, automation8.getSolution().size());
        assertEquals(47, automation9.getSolution().size());
        assertEquals(48, automation10.getSolution().size());
        assertEquals(10, automation11.getSolution().size());
    }

    @Test
    void checkMoves() {
        Automation automation0 = new Automation(new GameField(arrayMoves));
        List<GameField> moves = new ArrayList<>();
        GameField step1 = new GameField(new int[][]{
                {2,3,4,0},
                {1,6,7,8},
                {5,10,11,12},
                {9,13,14,15},
        });
        GameField step2 = new GameField(new int[][]{
                {2,3,0,4},
                {1,6,7,8},
                {5,10,11,12},
                {9,13,14,15},
        });
        GameField step3 = new GameField(new int[][]{
                {2,0,3,4},
                {1,6,7,8},
                {5,10,11,12},
                {9,13,14,15},
        });
        GameField step4 = new GameField(new int[][]{
                {0,2,3,4},
                {1,6,7,8},
                {5,10,11,12},
                {9,13,14,15},
        });
        GameField step5 = new GameField(new int[][]{
                {1,2,3,4},
                {0,6,7,8},
                {5,10,11,12},
                {9,13,14,15},
        });
        GameField step6 = new GameField(new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {0,10,11,12},
                {9,13,14,15},
        });
        GameField step7 = new GameField(new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {0,13,14,15},
        });
        GameField step8 = new GameField(new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,0,14,15},
        });
        GameField step9 = new GameField(new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,0,15},
        });
        GameField step10 = new GameField(done);

        moves.add(step1);
        moves.add(step2);
        moves.add(step3);
        moves.add(step4);
        moves.add(step5);
        moves.add(step6);
        moves.add(step7);
        moves.add(step8);
        moves.add(step9);
        moves.add(step10);
        assertEquals(moves,  automation0.getSolution());
    }

}