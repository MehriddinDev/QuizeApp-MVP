package uz.gita.quizeappmvpmehriddins.ui.game;

import uz.gita.quizeappmvpmehriddins.model.TestData;
import uz.gita.quizeappmvpmehriddins.repository.AppRepasitory;

import java.util.ArrayList;
import java.util.List;

public class GameModel implements GameContract.Model {
    List<TestData> testList;
    private int currPos = 0;
    private int correctAns = 0;
    private int wrongAns = 0;
    private int skippedAns = 0;
    private AppRepasitory repasitory;

    public GameModel() {
        repasitory = AppRepasitory.getInstance();
        testList = new ArrayList<>();
        loadNeedData();
    }

    private void loadNeedData() {
        repasitory.shuffle();
        if (testList != null) {
            testList.addAll(repasitory.getNeedTests());
        }
    }

    @Override
    public TestData getNextTest() {
        return testList.get(currPos++);
    }

    @Override
    public boolean CheckAnswer(int pos) {
        switch (pos) {
            case 0:
                if (testList.get(currPos - 1).getVariant1().equals(testList.get(currPos - 1).getAnswer()))
                    return true;
                break;
            case 1:
                if (testList.get(currPos - 1).getVariant2().equals(testList.get(currPos - 1).getAnswer()))
                    return true;
                break;
            case 2:
                if (testList.get(currPos - 1).getVariant3().equals(testList.get(currPos - 1).getAnswer()))
                    return true;
                break;
            case 3:
                if (testList.get(currPos - 1).getVariant4().equals(testList.get(currPos - 1).getAnswer()))
                    return true;
                break;
        }

        return false;
    }

    @Override
    public int getCorrectAnsPos() {

        int i;
        if (testList.get(currPos - 1).getVariant1().equals(testList.get(currPos - 1).getAnswer())) {
            i = 0;
            return i;
        }
        if (testList.get(currPos - 1).getVariant2().equals(testList.get(currPos - 1).getAnswer())) {
            i = 1;
            return i;
        }
        if (testList.get(currPos - 1).getVariant3().equals(testList.get(currPos - 1).getAnswer())) {
            i = 2;
            return i;
        }
        if (testList.get(currPos - 1).getVariant4().equals(testList.get(currPos - 1).getAnswer())) {
            i = 3;
            return i;
        }
        return -1;
    }

    @Override
    public boolean hasNextQuestion() {
        return currPos < 10;
    }

    @Override
    public int getCurrentPos() {
        return currPos;
    }

    @Override
    public void incCorrectCount() {
        repasitory.incCorrectCount();
    }

    @Override
    public void incWrongCount() {
        repasitory.incWrongCount();
    }

    @Override
    public void incSkippedCount() {
        repasitory.incSkippedCount();
    }

    @Override
    public void saveRecord() {
        repasitory.saveRecords();
    }

}
