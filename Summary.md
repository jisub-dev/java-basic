김영한 자바 강의

# Section 5. 생성자

* 최근 코딩 스타일 동향은 this를 무조건 사용하지 않음
  this를 사용하면 객체의 멤버면수임을 단번에 알 수 있지만 최근 IDE발달로 this를 사용하지 않아도 객체의 멤버변수임을 쉽게 알아차릴 수 있기 때문에 잘 사용하지 않음, 단 매개변수와 객체 멤버변수의 이름이 같다면 당연히 사용해야한다.

*  생성자를 사용해야 하는 이유
   제약조건이 생겨 실수로 정의한 생성자에 맞지 않은 값을 매개변수로 전달하면 컴파일 오류가 발생해 개발자가 확인할 수 있다. - 좋은 프로그램은 무한한 자유 대신 어느정도 제약이 있는 프로그램임

* 생성자가 하나라고 있으면 자바는 기본 생성자를 만들지 않음
- 만약 굳이 초기화를 하지 않아도 되는 경우 개발자가 일일히 다 초기화 해줘야하기 때문이다.

# Section 6. 패키지

* 같은 이름의 클래스를 쓴다면 import는 그 중 하나만 쓸 수 있다
  User userA = new User();
  pack.b.User userB = new pack.b.User();
  이처럼 하나는 직접 경로를 지정해줘야한다. 보통 많이 쓰는 클래스를 import한다.

* 패키지를 구성할 때 서로 관련된 클래스는 하나의 패키지로, 관련이 적은 클래스는 다른 패키지로 분리하는 것이 좋다.

# Section 7. 접근 제어자
* 사용하는 이유
  직접 접근을 막아 제약을 만들기 위해서이다. 만약 private을 외부에서 접근할 수 없게 된다. default는 같은 패키지에서만 접근이 가능하다.

* 하나의 클래스에는 여러 클래스에 만들 수 있지만 public클래스는 반드시 파일명과 이름이 같아야 한다. 이를 어길 시 파일명을 정할때 혼돈이 오기 때문이다.

* 캡슐화
1. 데이터 숨기기, 객체의 데이터는 메서드를 통해서 접근해야 함 - 클래스 내 데이터 제어 로직을 무시하기 때문
2. 필요한 기능만 노출하라

* 접근지정자를 신중하게 선택해서 사용해야하는 이유
  여러 개발자들이 유지보수 할 때 public을 사용하면 해당 필드나 메서드를 외부에서 사용하라는뜻으로 인식하기 때문에 접근지정자를 의도에 따라 사용해야한다.

* if else vs return
  // 검증 로직
  if(count >= max){
  System.out.println("최대값을 초과할 수 없습니다.");
  return;
  }
  // 실행 로직
  count++;
  와 같은 경우 if else 문 보다 더 명확하게 검증과 실행 로직을 분리할 수 있기 때문에 조금 더 좋다. (취향차이기도 함)

# Section 8. 자바 메모리 구조와 static
* 정적 변수는 메서드 영역에서 관리 (인스턴스 영역 X)
* static이 붙은 정적 변수에 접근하는 법
-> 클래스명 + .(dot) + 변수명
* 인스턴스 변수는 만드는 대로 갯수가 늘어남.(인스턴스는 new 연산자로 만든 객체) 
* static 변수는 클래스 별로 1개만 존재한다.(모든 인스턴스가 공유)
* 지역변수 -> 스택 영역, 인스턴스 변수 -> 힙 영역(garbage collection 전까지 생존), 클래스 변수 -> 메서드 영역(JVM 종료시까지 생존)
```java
    Data3 data4 = new Data3("D");
    System.out.println(data4.count);
```
이런식으로 인스턴스를 통해 static변수 접근도 가능하다. 처음에 힙 영역에 갔다가 메서드 영역에서 찾아서 출력한다.   
하지만 코드를 읽을 때 마치 인스턴스 변수에 접근하는 것처럼 오해할 수 있다.

* 정적 메서드와 정적 변수   
static 메서드에는 static변수만 사용가능하다. 인스턴스 변수는 사용 불가능하다.
* 정적 메서드를 사용할 수 있는 경우   
단순 계산기 같이 간단한 메서드 하나로 끝나는 유틸리티성 메서드에 자주 사용함
* 정적메서드를 자주 사용할 때
static import 기능을 사용하면 클래스명을 생략하고 클래스를 호출할 수 있다.
* main() 메서드는 인스턴스 없이 호출되는 메서드 중 가장 유명함

## 문제와 풀이
### 문제1: 구메한 자동차 수
```java
package static2.ex;

public class Car {
    private static String[] name = new String[10];
    private static int count;

    public Car(String name){
        this.name[count] = name;
        count++;
    }

    public static void showTotalCars(){
        for(int i = 0; i < count; i++){
            String car_name = name[i];
            System.out.println("차량 구입, 이름: " + car_name);
        }
        System.out.println("구매한 차량 수: " + count);
    }

}
```
처음에 이렇게 작성했더니 알고보니 new로 생서시마다 차 이름을 출력하는 것이었다.

### 개선 후
```java
package static2.ex;

public class Car {
    private String name;
    private static int totalCars;

    public Car(String name){
        System.out.println("차량 구입, 이름: " + name);
        this.name = name;
        totalCars++;
    }

    public static void showTotalCars(){
        System.out.println("구매한 차량 수: " + totalCars);
    }

}

```

### 문제2: 수학 유틸리티 클래스
* 인스턴스 생성을 막기 위해 private를 이용할 수 있다
```java
private MathArrayUtils(){}
```

### 개선 전 코드
```java
package static2.ex;

public class MathArrayUtils {
    
    public static int sum(int[] values){
        int total = 0;
        for (int i : values) {
            total += i;
        }
        return total;
    }

    public static float average(int[] values){
        float amount = 0;
        amount = sum(values) / values.length;
        return amount;
    }

    public static int min(int[] values){
        int mini = values[0];
        for (int i : values) {
            if(mini > i){
                mini = i;
            }
        }
        return mini;
    }

    public static int max(int[] values){
        int big = values[0];
        for (int i : values) {
            if(big < i){
                big = i;
            }
        }
        return big;
    }

}

```

### 개선 후 코드


# Section 9. final
* static final로 메모리 절약하기
```java
public class FieldInit {
    static final int CONST_VALUE = 10;
    final int value = 10; // 각 인스턴스 생성 시 같은 같인데도 메모리에 기록되면서 메모리가 낭비됨 -> static 사용하여 메모리 낭비를 줄여야 함
}
```

* 클래스에서 상수를 선언할 땐
```java
public static final double = 3.14; 
```
처럼 선언하면 된다.

* 상수는 중앙에서 한번에 관리할 수 있다   
-> 유지보수에 용이해짐

* final이 붙었으므로 참조형 변수가 참조하는 대상 자체를 변경하지는 못함
```java
final Data data = new Data();
        //data = new Data();
```
하지만 참조하는 대상의 값에 final이 붙지 않는 이상 변경 가능하다
```java
//참조 대상의 값은 변경 가능
        data.value = 10;
        System.out.println(data.value);
        data.value = 20;
        System.out.println(data.value);
```

* 고객의 id같이 값을 변경하면 안될때   
-> final로 선언하고 생성자로 값을 할당하면 실수로 id를 변경할 때 컴파일러가 이를 찾아낸다.

* 코드는 제약이 중요함   
-> final과 같이 처음에 코딩할 때 제약을 걸어놔야 추후 의도를 파악할 수 있다.