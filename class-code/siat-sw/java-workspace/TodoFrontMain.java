import todo.view.TodoView;

public class TodoFrontMain {
    public static void main(String[] args) {
        // view만 실행하고 바져야한다.
        // FrontController front = new FrontController();
        // TodoReadController selectCtrl = front.requestProcess(1);
        // TodoInsertController insertCtrl = front.requestProcess(2);
        // TodoDeleteController deleteCtrl = front.requestProcess(3);
        // TodoUpdateController updateCtrl = front.requestProcess(4);

        TodoView view = new TodoView();
        view.menu();
    }
}
