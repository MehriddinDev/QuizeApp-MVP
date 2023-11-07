package uz.gita.quizeappmvpmehriddins.ui.choose;

import uz.gita.quizeappmvpmehriddins.repository.AppRepasitory;

public class ChooseModel implements ChooseContract.Model{
    private AppRepasitory repasitory;
    public ChooseModel() {
        repasitory = AppRepasitory.getInstance();
    }

    @Override
    public void loadDataByPos(int pos) {
        repasitory.loadTestsByPos(pos);
    }
}
