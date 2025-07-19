public class RationalArrayGenerator {

    public Rational[] generate(int n) throws DivisionByZeroException {
        if (n == 0) {
            throw new DivisionByZeroException("0 can not be set as denominator!");
        }

        Rational[] numbers = new Rational[5];

        for (int i = 0; i < 5; i++) {
            numbers[i] = new Rational(i+1, n);
        }

        return numbers;
    }
}