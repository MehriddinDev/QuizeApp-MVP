package uz.gita.quizeappmvpmehriddins.ui.game;

import uz.gita.quizeappmvpmehriddins.model.TestData;

public interface GameContract {
    interface Model{
        TestData getNextTest();
        boolean CheckAnswer(int pos);
        int getCorrectAnsPos();
        boolean hasNextQuestion();
        int getCurrentPos();

        void incCorrectCount();
        void incWrongCount();
        void incSkippedCount();

        void saveRecord();
    }

    interface View{
        void describeTest(TestData test, int currPos);
        void stateNextBtn(boolean bool);
        void stateSkipBtn(int visibility);
        void openChooseActivity();
        void openResultActivity();
        void clearOldBackground();

        void setAllCheckedState(boolean bool);
        void setAllEnabletState(boolean bool);
        void setGreenBackgroundToTrueRadio(int pos);
        void setRedBackgroundToClickedRadio(int pos);

        void setProgressBar(int currentPos);
    }

    interface Presenter{
        void clickSkipBtn();
        void clickNextBtn();
        void clickBackBtn();

        void clickRadio(int clickedRadioPos);

        void clickOnBackPressed();
    }
}
