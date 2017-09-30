import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * Created by Sarnaglia on 9/30/17.
 */
public class EmployeeImportance {

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> setEmployees = new HashMap<>();
        for (Employee e:
             employees) {
            setEmployees.put(e.id, e);
        }
        Stack<Integer> stk = new Stack<>();
        int sum = 0;
        while (!stk.isEmpty()) {
            Employee employee = setEmployees.get(stk.pop());
            for (Integer employeeId:
                 employee.subordinates) {
                stk.push(employeeId);
            }
            sum += employee.importance;
        }
        return sum;
    }
}
