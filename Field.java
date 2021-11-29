package TicTacToeOOP;

public class Field implements Game {
    int dim = 3;
    int[] points = new int[dim * dim];

    @Override
    public void MakeField(int dim) {
        System.out.println("-".repeat(4 * dim + 1));
        for (int i = 0; i < dim; i++) {
            System.out.println(MakeLine(i));
            System.out.println("-".repeat(4 * dim + 1));
        }
    }

    @Override
    public String MakeLine(int i) {
        StringBuilder line = new StringBuilder().append("|");
        String symbol;
        for (int j = i * 3; j < i * 3 + 3; j++) {
            if (points[i] != 0) {
                symbol = (points[i] == 1 ? " X |" : " 0 |");
            } else {
                symbol = "   |";
            }
            line.append(symbol);
        }
        return line.toString();
    }

    @Override
    public int[] MakeMove() {
        MakeField(dim);
        return points;
    }

    @Override
    public boolean GameContinue() {
        return true;
    }
}
