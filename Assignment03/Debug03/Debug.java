enum Operator {
  ADD, 
  SUBTRACT, 
  MULTIPLY, 
  DIVIDE
}

//Should not be instanciated with right_==0 and op_==DIVIDE
class Expression {
  double left_, right_;
  Operator op_;

  Expression(double left, double right, Operator op){
    this.left_  = left;
    this.right_ = right;
    this.op_    = op;
  }

  double evaluate() {
    switch (op_) { // no need to write this.op
      case ADD: // Operator removed (it wouldn't be workin in java 17)
        return left_ + right_;
      case SUBTRACT:
        return left_ - right_;
      case MULTIPLY:
        return left_ * right_;
      case DIVIDE: {
        if (right_ == 0) {
          System.out.println("Error: Division by zero");
          return Double.NaN;
        }
        return left_ / right_;
      }
      default:
        return 0.0;
    }
  }
}

class Debug {

  public static void main(String[] args) {
    Operator[] ops = new Operator[4]; // null pointer because it was with length 5
    ops[0] = Operator.DIVIDE;
    ops[1] = Operator.SUBTRACT;
    ops[2] = Operator.MULTIPLY;
    ops[3] = Operator.ADD;

    Expression[] exp = new Expression[ops.length];
    for (int i = 0; i < ops.length; ++i) {
      exp[i] = new Expression(i + 1, i, ops[i]);
    }

    for (int i = 0; i < ops.length; ++i) {
      System.out.println(exp[i].evaluate());
    }
  }
}
/*
Exception in thread "main" java.lang.NullPointerException: Cannot invoke "Operator.ordinal()" because "this.op_" is null
        at Expression.evaluate(Debug.java:20)
        at Debug.main(Debug.java:50)

*/