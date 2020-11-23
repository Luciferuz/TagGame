package pack;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GameField {

    private int[][] field;      //игровое поле
    private final int size = 4; //можно будет потом придумать что-то с этим и сделать возможность менять
    private Point blank;        //пустая ячейка
    private int h;              //мера

    public GameField(int[][] field) {
        this.field = copy(field);
        analyzeH();
    }

    //если ячейка не на своем месте, то считаем расстояние до ее нужного места: (дельта х) + (дельта у)
    private void analyzeH() {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (field[x][y] == 0) {
                    blank = new Point(x, y);
                } else if (field[x][y] != x * size + y + 1) { //если ячейка не равна своему номиналу и не ноль
                    //считаем меру
                    int nominal = field[x][y];
                    int y0 = (nominal - 1) / size; //на таком x должна быть
                    int x0 = nominal - y0 * size - 1; //на таком y должна быть
                    int dx = Math.abs(x - x0);
                    int dy = Math.abs(y - y0);
                    h = h + dx + dy;
                }
            }
        }
    }

    public Iterable<GameField> neighbors() {
        Set<GameField> neighbors = new HashSet<>();
        int x = blank.getX();
        int y = blank.getY();

        //если походить нельзя, будет null
        GameField move1 = move(x, y, x - 1, y); //left
        GameField move2 = move(x, y, x + 1, y); //right
        GameField move3 = move(x, y, x, y - 1); //up
        GameField move4 = move(x, y, x, y + 1); //down

        neighbors.add(move1);
        neighbors.add(move2);
        neighbors.add(move3);
        neighbors.add(move4);

        return neighbors;
    }

    private GameField move(int x1, int y1, int x2, int y2) {
        int[][] tempField = copy(field);
        if (x2 >= size || y2 >= size || x2 < 0 || y2 < 0) return null;

        int temp = tempField[x2][y2];
        tempField[x2][y2] = tempField[x1][y1];
        tempField[x1][y1] = temp;
        return new GameField(tempField);
    }

    private int[][] copy(int[][] array) {
        int[][] newArray = new int[size][size];
        for (int x = 0; x < size; x++) {
            System.arraycopy(array[x], 0, newArray[x], 0, size);
        }
        return newArray;
    }

    public int[][] getField() {
        return field;
    }

    public void printField() {
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                System.out.print(String.format("%2d ", field[y][x]));
            }
            System.out.println();
        }
        System.out.println("-----------");
    }

    //Если N + K - четное, решение существует;
    //где N - количество инверсий, а K = (номер строки пустоты) / 4 + 1; (это доказали несколько человек)
    // https://e-maxx.ru/algo/15_puzzle
    public boolean isSolvable() {
        int n = 0;
        int[] temp = new int[size * size];
        int counter = 0;
        //записал в темп чтобы проходиться по одномерному массиву
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                temp[counter] = field[x][y];
                counter++;
            }
        }
        //прохожусь по одномерному массиву и считаю перестановки
        for (int i = 0; i < size * size; i++) {
            if (temp[i] != 0) {
                for (int j = 0; j < i; j++) {
                    if (temp[j] > temp[i]) n++;
                }
            } else {
                n = n + 1 + i / size;
            }
        }
        return n % 2 == 0;
    }

    //создает новую игру с рандомными значениями и проверяет на решаемость
    public void newRandomGame() {
        field = new int[size][size];
        Set<Integer> numbers = new HashSet<>();
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                while (true) {
                    int random = (int) (Math.random() * size * size);
                    if (!numbers.contains(random)) {
                        if (random == 0) {
                            blank.setNewPoint(x, y);
                        }
                        field[x][y] = random;
                        numbers.add(random);
                        break;
                    }
                }
            }
        }
        if (!isSolvable()) newRandomGame(); //если не существует решений, создаем новую игру еще раз
    }

    public int getH() {
        return h;
    }

    public int getCell(int x, int y) {
        return field[x][y];
    }

    public int getSize() {
        return size;
    }

    public boolean isWin() {
        return h == 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        GameField gamefield = (GameField) obj;
        return Arrays.deepEquals(gamefield.field, field);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(field);
    }
}
// 0  1  2  3
// 4  5  6  7
// 8  9  10 11
// 12 13 14 15

// 1  2  3  4
// 5  6  7  8  для 7  х = 2 ????               у = 1
// 9  10 11 12
// 13 14 15 0

// 6  2  3  4
// 5  1  7  8     nominal / size
// 9  10 11 12    nominal - yo * size - 1
// 13 14 15 0

//   ---------> x 0 1 2 3
//  |
//  |
//  |
//  |
//  \/
//   y 0 1 2 3