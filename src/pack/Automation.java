package pack;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Automation {

    private GameField initial;
    private int size;

    public Automation (GameField field){ //передаем изначальную позицию
        initial = field;
        size = field.getSize();
        run();
    }

    public void run() { //основной алгоритм авторешателя
        List<Point> moves = initial.nearMoves();
        ArrayDeque<Element> queue = new ArrayDeque<>();
        List<GameField> temp = newGameFields(initial, moves);
        for (GameField element : temp) {
            element.printField();
        }
    }

    public List<GameField> newGameFields (GameField before, List<Point> cellsThatCanBeMoved) { //будет создавать список новых игровыхполей которые могут возикнуть при передвижении пустого места в любом направдении (1 ход)
        LinkedList<GameField> answer = new LinkedList<>();
        for (Point cell : cellsThatCanBeMoved) {
            int x = cell.getX();
            int y = cell.getY();
            int[][] fieldBefore = before.getField();
            GameField temp = new GameField(fieldBefore);
            temp.move(x,y);
            answer.add(temp);
        }
        return answer;
    }

    /*
    public boolean topLineIsDone() {
        int counter = 1;
        for (int x = 0; x < size; x++) {
            if (field.getCell(x, 0) != counter) return false;
            counter++;
        }
        return true;
    }

    public boolean leftLineIsDone() {
        int counter = 1;
        for (int y = 0; y < size; y++) {
            if (field.getCell(0, y) != counter) return false;
            counter += size;
        }
        return true;
    }


     */


}
