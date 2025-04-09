package todo.view;

import java.util.List;
import java.util.Scanner;

import todo.front.FrontController;
import todo.model.domain.TodoResponseDTO;

public class TodoView {

    private FrontController front;

    public TodoView() {
        front = new FrontController();
    }

    public void menu() {
        while (true) {
            // 예외처리
            try {
                System.out.println(" ");
                System.out.println(">>> Todo Main Service <<<");
                System.out.println("1.서브메뉴보기 | 2.작성 | 3.수정 | 4.삭제 | 5.상세보기 | 99.종료");
                System.out.println("원하시는 번호를 입력하세요 : ");
                Scanner scan = new Scanner(System.in); // in 클래스 이름
                int number = scan.nextInt();
                switch (number) {
                    case 1:
                        // list();
                        subMenu();
                        break;
                    case 2:
                        register();
                        break;
                    case 3:
                        update();
                        break;
                    case 4:
                        delete();
                        break;
                    case 5:
                        read();
                        break;
                    case 99:
                        System.out.println("시스템을 종료할까요? (Y/N)");
                        Scanner scan1 = new Scanner(System.in);
                        String a = scan1.nextLine();
                        if (a.toLowerCase().equals("y") ){
                            System.exit(0);
                        }
                        
                } // switch end

            } catch (Exception e) {
                e.printStackTrace();
            } // try~catch end
        } // while end
    }

    public void read() {
        System.out.println(" ");
        System.out.println(">>> Todo Read <<<");
        Scanner scan = new Scanner(System.in);
        System.out.println("상세보기 : ");
        int number = scan.nextInt();
        TodoResponseDTO reponse = front.read(number);
        System.out.println(reponse);
    }

    public void subMenu() {
        while (true) {
            try {
                System.out.println(" ");
                System.out.println(">>> Todo Service SubMenu<<<");
                System.out.println("1.목록보기 | 2.완료된 일정 | 3.미완료된 일정 | 4.상위메뉴이동 | 5.정렬");
                System.out.println("원하시는 번호를 입력하세요 : ");
                Scanner scan = new Scanner(System.in);
                int number = scan.nextInt();
                switch (number) {
                    case 1:
                        list();
                        break;

                    case 2:
                        checkList();
                        break;
                    case 3:
                        uncheckList();
                        break;
                    case 4:
                        return;
                    case 5 :
                        prioritySort();
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void prioritySort(){
        List<TodoResponseDTO> list = front.sort();
        System.out.println(" ");
        System.out.println(">>> Todo sort List <<<");
        for (TodoResponseDTO response : list) {
            System.out.println(response);
        }
    }


    public void list() {
        List<TodoResponseDTO> list = front.list();
        System.out.println(" ");
        System.out.println("view list size " + list.size());
        for (TodoResponseDTO response : list) {
            System.out.println(response);
        }
    }

    public void checkList(){
        //완료된 리스트를 불러와야지.  
        //어디에서 ? response list 에서 check가 되어 있는 부분을.
        List<TodoResponseDTO> list = front.checkList();
        System.out.println(" ");
        System.out.println(">>> Todo Check List <<<");
        for (TodoResponseDTO response : list) {
            System.out.println(response);
        }
    }

    public void uncheckList(){
        List<TodoResponseDTO> list = front.uncheckList();
        System.out.println(" ");
        System.out.println(">>> Todo uncheck List");
        for(TodoResponseDTO response : list){
            System.out.println(response);
        }
    }


    public void register() {
        System.out.println(" ");
        System.out.println(">>> Todo Register <<<");
        Scanner scan = new Scanner(System.in);
        System.out.print("제목");
        String title = scan.nextLine();
        System.out.print("내용");
        String content = scan.nextLine();
        System.out.print("우선순위");
        int priority = scan.nextInt();

        int insertFlag = front.register(title, content, priority);
        System.out.println(insertFlag);
    }

    public void update() {
        System.out.println(" ");
        System.out.println(">>> Todo Update <<<");
        Scanner scan = new Scanner(System.in);
        System.out.print("번호");
        int seq = scan.nextInt();
        scan.nextLine(); // 수정 내용 오류가 생겨서 추가함.
        System.out.print("내용");
        String content = scan.nextLine();
        System.out.print("완료여부");
        String check = scan.nextLine();

        int updateFlag = front.update(seq, content, check);
        System.out.println(updateFlag);
    }

    public void delete() {
        System.out.println(" ");
        System.out.println(">>> Todo Delete <<<");
        Scanner scan = new Scanner(System.in);
        System.out.println("삭제할 일정 번호를 입력하세요 : ");
        // 뭘 삭제를 해야 하는가?
        // TodoResponseDTO 리스트에 있는 데이터를 삭제를 할껀데, 그러면 변수가 seq를 가져와야 하나?
        // 그러면 seq 변수로 잡고, 숫자를 입력하게 하고, 그 숫자에 해당한 리스트를 지우게 한다?

        int number = scan.nextInt();

        int deleteFlag = front.delete(number);
        System.out.println(deleteFlag);
    }

}
