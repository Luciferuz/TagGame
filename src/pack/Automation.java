package pack;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Automation {

    private GameField field;
    private int size;

    public Automation (GameField field){ //передаем изначальную позицию
        this.field = field;
        size = field.getSize();
        run();
    }

    public void run() { //основной алгоритм авторешателя
        List<Point> moves = field.nearMoves();
        ArrayDeque<Element> queue = new ArrayDeque<>();

    }

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



}
