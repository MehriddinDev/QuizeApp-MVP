package uz.gita.quizeappmvpmehriddins.ui.result;

public class ResultPresenter implements ResultContract.Presenter {
    ResultContract.Model model;
    ResultContract.View view;
    public ResultPresenter(ResultContract.View view) {
        model = new ResultModel();
        this.view = view;
        loadData();
    }
    private void loadData(){
        view.describeCorrectCount(model.getCorrectCount(),model.getWrongCount(),model.getSkippedCount());
    }

    @Override
    public void clickBtnMenu() {
        model.clearAllStatistics();
        view.openChooseActivity();
    }

    @Override
    public void clickBtnRecord() {
        view.setDialog(model.getRecord());
        view.showDialog();
    }
}
