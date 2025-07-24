package static2.ex;

public class MathArrayUtils {

    private MathArrayUtils(){} // 인스턴스 생성을 막기 위해 private로 사용

    public static int sum(int[] values){
        int total = 0;
        for (int i : values) {
            total += i;
        }
        return total;
    }

    public static double average(int[] values){
        return (double) sum(values) / values.length;
    }

    public static int min(int[] values){
        int minValue = values[0];
        for (int value : values) {
            if(minValue > value){
                minValue = value;
            }
        }
        return minValue;
    }

    public static int max(int[] values){
        int maxValue = values[0];
        for (int value : values) {
            if(maxValue < value){
                maxValue = value;
            }
        }
        return maxValue;
    }

}
