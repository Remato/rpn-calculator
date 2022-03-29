package rpnCalculator;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.util.Stack;
import java.io.File;

public class Main {

	public static void main(String[] args) throws IOException {
		Stack<String> stack = new Stack<String>();

		File file = new File("Calc1.stk");
		byte[] content = Files.readAllBytes(file.toPath());
		String rpnExpression[] = new String(content).split("\n");
		int expressionsCount = 1;
		String output;

		public void sum(BigDecimal left, BigDecimal right) {
			stack.push(left.add(right).toString());
		}

		public void sub(BigDecimal left, BigDecimal right) {
			stack.push(left.subtract(right).toString());
		}

		public void mul(BigDecimal left, BigDecimal right) {
			stack.push(left.multiply(right).toString());
		}

		public void div(BigDecimal left, BigDecimal right) {
			stack.push(left.divide(right).toString());
		}

		public void selectOperation() {
    	if ("+-*/".contains(rpnExpression[i])) {

				BigDecimal leftOp = new BigDecimal(stack.pop());
				BigDecimal rightOp = new BigDecimal(stack.pop());

				switch (rpnExpression[i]) {
				case "+":
					sum(leftOp, rightOp);
					return;
				case "-":
					sub(leftOp, rightOp);
					return;
				case "*":
					mul(leftOp, rightOp);
					return;
				case "/":
					div(leftOp, rightOp);
					return;
				}
			}
  	}

		for (int i = 0; i < rpnExpression.length; i++) {
			if (!rpnExpression[i].equals("=")) {
				
				boolean isADigit = rpnExpression[i].matches("[0-9]*"); //regex numbers 0 -> 9
				isADigit ? stack.push(rpnExpression[i]) : selectOperation();

			} else {
				output = stack.pop();
				System.out.println("The result of the expression " + expressionsCount + " in RPN is: " + output);
				expressionsCount++;
			}
		}

		output = stack.pop();
		System.out.println("The result of the expression " + expressionsCount + " in RPN is: " + output);
	}
}
