package uz.gita.quizeappmvpmehriddins.ui.result;

import uz.gita.quizeappmvpmehriddins.repository.AppRepasitory;

public class ResultModel implements ResultContract.Model {
    private AppRepasitory repasitory;

    public ResultModel() {
        repasitory = AppRepasitory.getInstance();
    }

    @Override
    public int getWrongCount() {
        return repasitory.getWrongCount();
    }

    @Override
    public int getCorrectCount() {
        return repasitory.getCorrectCount();
    }

    @Override
    public int getSkippedCount() {
        return repasitory.getSkippedCount();
    }

    @Override
    public void clearAllStatistics() {
        repasitory.setSkippedCount(0);
        repasitory.setWrongCount(0);
        repasitory.setCorrectCount(0);
    }

    @Override
    public int[] getRecord() {
        return repasitory.getRecords();
    }

}
