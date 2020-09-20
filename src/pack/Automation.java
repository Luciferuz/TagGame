package pack;

import java.sql.SQLOutput;
import java.util.List;

public class Automation {

    private GameField field;
    private int size;

    public Automation (GameField field){
        this.field = field;
        size = field.getSize();
        run();
    }

    //нужно сначала собрать первую строку и левую линию (1 2 3 4 5 9 13)
    public void run() { //основной алгоритм авторешателя
       // while (!endOfGame()) {
            List<Point> moves = field.nearMoves();
            for (Point element : moves) {
                System.out.println(element.getX() + "" + element.getY());
            }

        //}

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

    public boolean endOfGame() {
        return howManyCellsOnPlace() == 15;
    }

    public int howManyCellsOnPlace() {
        int counter = 1;
        int answer = 0;
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                if (field.getCell(x, y) == counter) answer++;
                counter++;
            }
        }
        return answer;
    }
}
