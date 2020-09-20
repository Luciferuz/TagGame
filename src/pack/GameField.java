package pack;

import java.util.HashSet;
import java.util.Set;

public class GameField {

    private int[][] field;
    private int size;
    private EmptyPoint blank;

    public GameField(int size) {
        this.size = size;
        newGame();
    }

    private void newGame() {
        field = new int[size][size];
        Set<Integer> numbers = new HashSet<>();
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                while (true) {
                    int random = (int) (Math.random() * size * size);
                    if (!numbers.contains(random)) {
                        if (random == 0) blank = new EmptyPoint(x, y);
                        field[x][y] = random;
                        numbers.add(random);
                        break;
                    }
                }
            }
        }
        if (!isSolvable()) newGame(); //если не существует решений, создаем новую игру
    }

    //Если N + K - четное, решение существует;
    //где N - количество инверсий, а K = (номер строки пустоты) / 4 + 1; (это доказали несколько человек)
    private boolean isSolvable() {
        int n = 0;
        int[] temp = new int[size * size];
        int counter = 0;
        //записал в темп чтобы проходиться по одномерному массиву
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                temp[counter] = field[x][y];
                counter++;
            }
        }
        //прохожусь по одномерному массиву и считаю перестановки
        for (int i = 0; i < size * size - 1; i++) {
            if (temp[i] < temp[i + 1]) n++;
        }

        return (blank.getY() / 4 + n + 1) % 2 == 0;
    }

    public void printField() {
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                System.out.print(field[x][y] + " ");
            }
            System.out.println();
        }
    }

    public void move(int x, int y) { //x y - координаты ячейки, которую надо передвинуть
        int xEmpty = blank.getX();
        int yEmpty = blank.getY();
        if (isEmptyNear(x, y)) {
            int valueBefore = field[x][y]; //temp
            field[x][y] = 0;
            field[xEmpty][yEmpty] = valueBefore;
            blank.setNewPoint(x, y);
        } else System.out.println("Перемещения не было");
    }

    //находится ли пустая ячейка около ячейки, которую надо передвинуть
    public boolean isEmptyNear(int x, int y) { //x y - координаты ячейки, которую надо передвинуть
        int xEmpty = blank.getX();
        int yEmpty = blank.getY();
        if (y == yEmpty) {
            if (x + 1 == xEmpty || xEmpty + 1 == x) return true;
        }
        if (x == xEmpty) {
            if (y + 1 == yEmpty || yEmpty + 1 == y) return true;
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    public int getCell(int x, int y) {
        return field[x][y];
    }

}
// 0  1  2  3
// 4  5  6  7
// 8  9  10 11
// 12 13 14 15