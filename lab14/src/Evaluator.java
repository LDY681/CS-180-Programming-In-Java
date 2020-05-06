import java.lang.reflect.Array;
import java.util.DoubleSummaryStatistics;
import java.util.Stack;

/**
 * Created by liu1589 on 4/21/16.
 */
public class Evaluator {
    public static boolean isnum(String c){
        boolean num = false;
        if (c.matches("[0-9]")){
            num = true;
        }
        return num;
    }
    public static double evaluate(String c){
        Stack<Double> eva = new Stack<Double>();
        String a [] = c.split(" ");
        for (int i = 0; i < a.length; i++){
            if (isnum(a [i])){
            eva.push(Double.parseDouble(a [i]));
            }else{
                double op2 = (Double) eva.pop();
                double op1 = (Double) eva.pop();
                if (a [i].equals("+")){
                    eva.push(op1 + op2);
                }
                else if (a [i].equals("-")){
                    eva.push(op1 - op2);
                }
                else if (a [i].equals("*")){
                    eva.push(op1 * op2);
                }
                else if (a [i].equals("/")){
                    eva.push(op1 / op2);
                }else{
                    throw new RuntimeException("unknown operator");
                }
            }
        }
        return (Double) eva.pop();
    }

    public static void main(String[] args) {
        System.out.println(evaluate("5 1 2 + 4 * + 3 -"));
    }
}
