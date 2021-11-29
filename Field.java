package TicTacToeOOP;

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
        for (int i = dim; i > 0; i--) {
            System.out.println(MakeLine(i));
            System.out.println("-".repeat(4 * dim + 1));
        }
    }

    private String MakeLine(int i) {
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

    }

    private void ComputerStep() {

    }

    @Override
    public boolean GameContinue() {
        return true;
    }
}
