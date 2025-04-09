package todo.factory;

import java.util.HashMap;
import java.util.Map;

import todo.ctrl.TodoCheckController;
import todo.ctrl.TodoDeleteController;
import todo.ctrl.TodoReadController;
import todo.ctrl.TodoSelectController;
import todo.ctrl.TodoSortController;
import todo.ctrl.TodoUncheckController;
import todo.ctrl.TodoUpdateController;
import todo.ctrl.TodoinsertController;
import todo.service.TodoService;

public class BeanFactory { 

    public Map<String, Object> map;  //map : 컨트롤러 객체를 저장하는 맵 , Object 다형성
    private static BeanFactory instance; 
    //instance는 싱글톤 패턴을 위한 정적(static) 인스턴스 변수
    //한 번 생성된 BeanFactory 객체를 프로그램 전체에서 공유할 수 있도록 합니다.
    private BeanFactory(){
        map = new HashMap<>(); //map을 HashMap으로 초기화하여, 이후 컨트롤러 객체들을 저장할 수 있도록 합니다.
        TodoService service = new TodoService();
        //TodoService 객체를 한 번만 생성하여 재사용
        //모든 컨트롤러에서 같은 service 인스턴스를 공유하도록 설정


        // CONTROLLER가 SERVICE를 가져와야한다.
        map.put("list", new TodoSelectController(service));  //--> list라는 키를 이용해서service를 매개변수로 하는 컨트롤러 객체 생성한다.
        map.put("register", new TodoinsertController(service)); // --> register 라는 키를 이용해서service를 매개변수로 하는 컨트롤러 객체 생성한다.
        map.put("update", new TodoUpdateController(service));
        map.put("delete", new TodoDeleteController(service));
        map.put("read",new TodoReadController(service));
        map.put("check",new TodoCheckController(service));
        map.put("uncheck",new TodoUncheckController(service));
        map.put("sort",new TodoSortController(service));
        //나머지 하기
    }

    //getInstance 메서드가 싱글톤 객체를 가져오는 역할 , static 메서드이므로, BeanFactory의 인스턴스를 생성하지 않고도 호출
    public static BeanFactory getInstance(){
        if (instance == null) {                 //instance가 null이면 새로운 BeanFactory 객체를 생성 , 최초 한 번만 객체가 생성되며, 이후에는 기존 객체를 반환
            instance = new BeanFactory();
        }
        return instance;                        //instance를 반환하여, 어디서든 같은 BeanFactory 인스턴스를 사용할 수 있도록 합니다
    }

    //getCtrl(String key) 메서드는 map에 저장된 컨트롤러 객체를 반환하는 역할
    public Object getCtrl(String key){
        return map.get(key);                    //해당 키(String)에 해당하는 컨트롤러 객체를 반환 --> list를 하면 TodoSelectController 객체를 반환
    }
}
