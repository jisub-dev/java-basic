package oop1.ex;

public class Ractangle {
    int width;
    int height;

    int calculateArea(){
        return width * height;
    }

    int calculatePerimeter(){
        return 2 * (width + height);
    }

    boolean isSquare(){
        return width == height;
    }
}
