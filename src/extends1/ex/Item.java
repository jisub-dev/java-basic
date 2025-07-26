package extends1.ex;

public class Item {
    String name;
    int price;

    public int getPrice(){
        return price;
    }

    public void print(){
        System.out.println("이름:" + name + ", 가격:" + price);
    }
}
