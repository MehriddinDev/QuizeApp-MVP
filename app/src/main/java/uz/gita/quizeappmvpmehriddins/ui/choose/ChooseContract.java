package uz.gita.quizeappmvpmehriddins.ui.choose;

public interface ChooseContract {
    interface Model{
        void loadDataByPos(int pos);
    }

    interface View{
        void startGameActivity();
        void startInfoActivity();
    }

    interface Presenter{
        void clicktarxBtn();
        void clickOnaTiliBtn();
        void clickMatemBtn();

        void clickInfoBtn();
    }
}
