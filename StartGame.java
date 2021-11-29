package TicTacToeOOP;

import java.util.Scanner;

public class StartGame {
    public static void main(String[] args) {
        Game field = new Field();
        System.out.println("Who wil be the first?\nEnter the number:\n1.Player\n2.Computer");
        field.setStepDecision(new Scanner(System.in).nextInt());
        while (field.GameContinue()) {
            field.MakeMove();
        }
        field.MakeField();
    }
}
