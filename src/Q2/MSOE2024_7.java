package Q2;

import java.util.*;
import Algorithms.SortingAlgorithms;

public class MSOE2024_7 {
    public static class Box implements Comparable<Box> {
        double length;
        double width;
        double height;
        double size;

        public Box(double l, double w, double h) {
            length = l;
            width = w;
            height = h;
            size = Math.round(length * width * height * 1000) / 1000.0;
        }

        public int compareTo(Box o) {
            return -1 * Double.compare(this.size, o.size);
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Box> boxes = new ArrayList<>();
        String curBox;
        while (true) {
            curBox = input.nextLine();
            if (curBox.equals("")) {
                break;
            }
            String[] curBoxArr = curBox.split("x");
            double l = Double.parseDouble(curBoxArr[0]);
            double w = Double.parseDouble(curBoxArr[1]);
            double h = Double.parseDouble(curBoxArr[2]);
            Box box = new Box(l, w, h);
            if (box.size != 0) {
                boxes.add(box);
            }
        }
        Box[] boxesArr = new Box[boxes.size()];
        for (int i = 0; i < boxes.size(); i++) {
            boxesArr[i] = boxes.get(i);
        }
        SortingAlgorithms.quickSort(boxesArr);
        ArrayList<Box> maxChain = new ArrayList<>();
        for (int i = 0; i < boxesArr.length; i++) {
            Box current = boxesArr[i];
            int curIndex = i;
            ArrayList<Box> curChain = new ArrayList<>();
            curChain.add(current);
            boolean hasNext = true;
            while (hasNext) {
                hasNext = false;
                for (int j = curIndex+1; j < boxesArr.length; j++) {
                    Box check = boxesArr[j];
                    if (check.size * 1.55 <= current.size && check.size * 1.65 >= current.size) {
                        current = check;
                        curIndex = j;
                        curChain.add(current);
                        hasNext = true;
                    }
                }
            }
            if (curChain.size() > maxChain.size()) {
                maxChain = curChain;
            }
        }
        for (Box b : maxChain) {
            String boxString = b.length + "x" + b.width + "x" + b.height + " (" + b.size + ")";
            System.out.print(boxString + ", ");
        }
    }

}
/*
11x3.3x2.7
8.7x4.6x9.2
16.3x13.2x2.7
21.8x6.3x4.3
1.7x10.8x7.5
19.5x11.2x3.8
9.4x9.4x9.4
3.7x13.5x7.6
3.2x5.8x21.9
32.4x6.5x4.8
5.9x15.2x14.7
6.8x9.2x26.4
13.2x15.4x17.2
1.5x3.8x5.2
2.6x5.9x1.8
6.4x1.75x4.5
24x3.6x21.7
18x15.4x7.4
12x7x9.45
6x4.5x3x2
9x1.4x2.1
7.3x8.1x9
8x9x7.2
6x4.9x7

18.0x15.4x7.4 (2051.28), 5.9x15.2x14.7 (1318.296), 9.4x9.4x9.4 (830.584), 7.3x8.1x9.0 (532.17),
 */