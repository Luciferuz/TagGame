package pack;

import java.util.*;

public class Automation {

    private GameField initial;
    private List<GameField> result = new ArrayList<>();

    public Automation(GameField initial) {
        if (!initial.isSolvable()) throw new IllegalArgumentException("Нерешаемая комбинация");
        this.initial = initial;
        run();
    }

    private void run() {

        Comparator<Element> comparator = new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                int m1 = measure(o1);
                int m2 = measure(o2);
                return Integer.compare(m1, m2);
            }
        };
        PriorityQueue<Element> queue = new PriorityQueue<>(comparator);
        queue.add(new Element(null, initial));

        while(true) {
            Element current = queue.poll();

            if (current.getField().isWin()) {
                Element lastMove = new Element(current, current.getField());
                addToResult(lastMove);
                System.out.println("Количество ходов: " + result.size());
                break;
            }

            for (GameField neighbour : current.getField().neighbors()) {
                boolean logic1 = !containsInPath(current, neighbour); //чтобы не смотреть повторно
                boolean logic2 = neighbour != null;
                if (logic1 && logic2) {
                    queue.add(new Element(current, neighbour));
                }
            }
        }
    }

    private int measure(Element element) {
        Element temp = element;
        int g = 0;
        int h = element.getField().getH();
        while (true) {
            g++;
            temp = temp.getPrevious();
            if (temp == null) {
                return g + h; // g(x) + h(x)
            }
        }
    }

    private void addToResult(Element element) {
        Element temp = element;
        while (true) {
            temp = temp.getPrevious();
            if (temp == null) {
                Collections.reverse(result);
                break;
            }
            result.add(temp.getField());
        }
    }

    private boolean containsInPath(Element element, GameField field) {
        Element temp = element;
        while (temp != null) {
            if (temp.getField().equals(field)) return true;
            temp = temp.getPrevious();
        }
        return false;
    }

    public List<GameField> getSolution() {
        return result;
    }

}