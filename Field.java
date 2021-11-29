package TicTacToeOOP;

public abstract class Field implements Game {
    @Override
    public void MakeField(int dim) {

    }

    @Override
    public int[] MakeMove() {
        return new int[0];
    }

    @Override
    public boolean GameContinue() {
        return false;
    }
}
