package hello.core.singleton;

public class SingletonService {
    // static으로 1개만 존재
    private static final SingletonService instance = new SingletonService();

    //public인 객체 인스터스가 필요하면, static 메서드를 통해서만 조회하도록 허용
    public static SingletonService getInstance() {
        return instance;
    }

    //3. 생성자를 private으로 선언해서 외부에서 new 키워드를 사용한 객체 생성을 못하게
    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
