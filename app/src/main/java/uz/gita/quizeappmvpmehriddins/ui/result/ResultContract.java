package uz.gita.quizeappmvpmehriddins.ui.result;

public interface ResultContract {
    interface Model {
        int getWrongCount();
        int getCorrectCount();
        int getSkippedCount();
        void clearAllStatistics();
        int[] getRecord();
    }
    interface View{
        void describeCorrectCount(int correct, int wrong, int skipped);
        void openChooseActivity();

        void showDialog();
        void setDialog(int[] arr);
    }

    interface Presenter{
        void clickBtnMenu();
        void clickBtnRecord();
    }
}
