package TicTacToeOOP;

import java.util.Random;
import java.util.Scanner;

public class Field implements Game {
    int dim = 3;
    int[] points = pointConstructor();
    int stepDecision;
    int count = 0;

    private int[] pointConstructor() {
        int[] arr = new int[dim * dim];
        for (int i = 0; i < dim * dim; i++) {
            arr[i] = -(i + 1);
        }
        return arr;
    }

    @Override
    public void setStepDecision(int stepDecision) {
        this.stepDecision = stepDecision;// 1 - Player, 2 - Computer
    }

    @Override
    public void MakeField() {
        System.out.println("-".repeat(4 * dim + 1));
        for (int i = dim - 1; i >= 0; i--) {
            System.out.println(MakeLine(i));
            System.out.println("-".repeat(4 * dim + 1));
        }
    }

    private String MakeLine(int i) {
        StringBuilder line = new StringBuilder().append("|");
        String symbol;
        for (int j = i * 3; j < i * 3 + 3; j++) {
            if (points[j] > 0) {
                symbol = (points[j] == 1 ? " X |" : " 0 |");
            } else {
                symbol = "   |";
            }
            line.append(symbol);
        }
        return line.toString();
    }

    @Override
    public void MakeMove() {
        MakeField();
        StepMake();
    }

    private void StepMake() {
        count++;
        if ((count + stepDecision) % 2 == 0) {
            PlayerStep();
        } else {
            ComputerStep();
        }
    }

    private void PlayerStep() {
        System.out.println("Введите число соответствующее свободной ячейке.");
        while (true) {
            int step = new Scanner(System.in).nextInt();
            if (points[step - 1] < 0) {
                points[step - 1] = 1;
                break;
            } else {
                System.out.println("Ячейка занята. Попробуйте еще раз");
            }
        }


    }

    private void ComputerStep() {
        while (true) {
            int step = new Random().nextInt(9);
            if (points[step] < 0) {
                points[step] = 2;
                break;
            }
        }
    }

    @Override
    public boolean GameContinue() {
        if (Win()) {
            return false;
        } else if (count == 9) {
            System.out.println("Ничья");
            return false;
        } else {
            return true;
        }
    }

    private void WhoIsTheWinner(int i) {
        if (points[i] == 1) {
            System.out.println("YOU WON!");
        } else {
            System.out.println("COMPUTER WON!");
        }
    }

    private boolean Win() {
        boolean row;
        boolean col;
        boolean diagonal = ((points[0] == points[4] && points[0] == points[8])
                || (points[2] == points[4] && points[2] == points[6])
                && points[4] > 0);
        boolean decision;
        for (int i = 0; i < 3; i++) {
            col = (points[i] == points[i + 3] && points[i] == points[i + 6]) && points[i] > 0;
            row = (points[i * 3] == points[i * 3 + 1] && points[i * 3] == points[i * 3 + 2]) && points[i * 3] > 0;
            decision = row || col || diagonal;
            if (decision) {
                WhoIsTheWinner(i);
                return true;
            }
        }
        return false;
    }

}
