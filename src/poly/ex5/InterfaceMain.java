package poly.ex5;

public class InterfaceMain {

    public static void main(String[] args) {
        //InterfaceAnimal interfaceAnimal = new InterfaceAnimal(); 완전 추상이라 생성 불가

        Dog dog = new Dog();
        Cat cat = new Cat();
        Caw caw = new Caw();

        soundAnimal(dog);
        soundAnimal(cat);
        soundAnimal(caw);
    }
    //변하지 않는 부분
    private static void soundAnimal(InterfaceAnimal animal) {
        System.out.println("동물 소리 테스트 시작");
        animal.sound();
        System.out.println("동물 소리 테스트 종료");
    }
}
