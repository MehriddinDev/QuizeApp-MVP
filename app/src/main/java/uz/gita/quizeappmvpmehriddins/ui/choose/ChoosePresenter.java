package uz.gita.quizeappmvpmehriddins.ui.choose;

public class ChoosePresenter implements ChooseContract.Presenter {
    private ChooseContract.View view;
    private ChooseContract.Model model;

    public ChoosePresenter(ChooseContract.View view) {
        this.view = view;
        model = new ChooseModel();
    }

    @Override
    public void clicktarxBtn() {
        model.loadDataByPos(1);
        view.startGameActivity();
    }

    @Override
    public void clickOnaTiliBtn() {
        model.loadDataByPos(2);
        view.startGameActivity();
    }

    @Override
    public void clickMatemBtn() {
        model.loadDataByPos(3);
        view.startGameActivity();
    }

    @Override
    public void clickInfoBtn() {
        view.startInfoActivity();
    }
}
