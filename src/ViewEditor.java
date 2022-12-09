import java.awt.BorderLayout;

public class ViewEditor {
    private View view;

    private EditorPanelBoard board;
    private EditorPanelHand hand;

    public ViewEditor(View view) {
        this.view = view;
        board = new EditorPanelBoard();
        hand = new EditorPanelHand();
    }

    public void add() {
        view.setLayout(new BorderLayout());
        view.add(board, BorderLayout.CENTER);
        view.add(hand, BorderLayout.SOUTH);
    }
}
