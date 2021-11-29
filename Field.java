package TicTacToeOOP;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Field implements Game {
    int dim = 3;
    int[] points = new int[dim * dim];
    int stepDecision;

    @Override
    public void setStepDecision(int stepDecision) {
        this.stepDecision = stepDecision;// 1 - Player, 2 - Computer
    }

    private void MakeField(int dim) {
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
            if (points[j] != 0) {
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
        MakeField(dim);
        StepMake();
    }

    private void StepMake() {
        if (stepDecision == 1) {
            PlayerStep();
            ComputerStep();
        } else {
            ComputerStep();
            PlayerStep();
        }
    }

    private void PlayerStep() {
        System.out.println("Введите число соответствующее свободной ячейке.");
        while (true) {
            int step = new Scanner(System.in).nextInt();
            if (points[step - 1] == 0) {
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
            if (points[step] == 0) {
                points[step] = 2;
                System.out.println(Arrays.toString(points));
                break;
            }
        }
    }

    @Override
    public boolean GameContinue() {
        return true;
    }
}
