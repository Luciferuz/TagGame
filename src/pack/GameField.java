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
        if (!isSolvable()) newGame();
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

    public void move(int xCord, int yCord) { //x y - координаты ячейки, на которую нажали


    }

}
// 0  1  2  3
// 4  5  6  7
// 8  9  10 11
// 12 13 14 15