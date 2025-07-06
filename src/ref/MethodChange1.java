package ref;

public class MethodChange1 {
    public static void main(String[] args) {
        int a = 10;
        System.out.println("메서드 호출 전: a = " + a);
        changePrimitive(a);
        System.out.println("메서드 호출 후: a = " + a);
    }

    static void changePrimitive(int x){ // 값을 복사해서 하는 것이기 때문에 주소가 아니어서 10이라는 값만 복사한 것임
        x = 20;
    }

}
