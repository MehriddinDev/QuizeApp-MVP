package uz.gita.quizeappmvpmehriddins.ui.game;

import android.view.View;

public class GamePresenter implements GameContract.Presenter{
    GameContract.View view;
    GameContract.Model model;
    public GamePresenter(GameContract.View view) {
        this.view = view;
        model = new GameModel();

        loadNextQuestion();
    }

    private void loadNextQuestion(){
       if(model.hasNextQuestion()){
           view.describeTest(model.getNextTest(), model.getCurrentPos());
       }else {
           view.openResultActivity();
           model.saveRecord();
       }
       view.setProgressBar(model.getCurrentPos()-1);
        view.stateNextBtn(false);
    }

    @Override
    public void clickSkipBtn() {
        view.clearOldBackground();
        view.stateSkipBtn(View.VISIBLE);
        view.stateNextBtn(false);
        loadNextQuestion();
        model.incSkippedCount();
    }

    @Override
    public void clickNextBtn() {
        view.setAllEnabletState(true);
        view.setAllCheckedState(false);
        view.clearOldBackground();
        loadNextQuestion();
        view.stateSkipBtn(View.VISIBLE);
        view.stateNextBtn(false);
    }

    @Override
    public void clickBackBtn() {
        view.openChooseActivity();
    }

    @Override
    public void clickRadio(int clickedRadioPos) {

        if(model.CheckAnswer(clickedRadioPos)){
            view.setGreenBackgroundToTrueRadio(clickedRadioPos);
            model.incCorrectCount();
        }else {
            model.incWrongCount();
            view.setRedBackgroundToClickedRadio(clickedRadioPos);
            view.setGreenBackgroundToTrueRadio(model.getCorrectAnsPos());
        }
        view.setAllEnabletState(false);
        view.stateSkipBtn(View.GONE);
        view.stateNextBtn(true);
    }

    @Override
    public void clickOnBackPressed() {
        view.openChooseActivity();
    }
}
