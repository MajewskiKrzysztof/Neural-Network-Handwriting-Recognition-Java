package utils;

public class MathUtils {

    public static double sigmoidValue(Double arg) {
        return (1 / (1 + Math.exp(-arg)));
    }

}
