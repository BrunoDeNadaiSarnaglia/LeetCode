import java.util.Stack;

public class DailyTemperatures {
  public int[] dailyTemperatures(int[] temperatures) {
    Stack<Integer> stk = new Stack<>();
    int[] waitToWarmerDays = new int[temperatures.length];
    for (int i = 0; i < temperatures.length; i++) {
      while(!stk.isEmpty() && temperatures[stk.peek()] < temperatures[i]) {
        int day = stk.pop();
        waitToWarmerDays[day] = i - day;
      }
      stk.push(i);
    }
    return waitToWarmerDays;
  }
}
