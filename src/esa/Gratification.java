package esa;

public class Gratification {

    public double calcEuro(String string) {
        if (string == null) {
            throw new IllegalArgumentException("String was null!");
        }
        return string.length() / 10D;
    }

    public int countImages(String s) {
        if (s == null) {
            throw new IllegalArgumentException("String was null!");
        }

        int count = ( s.split(".jpg", -1).length ) - 1;

        return count;
    }
}
