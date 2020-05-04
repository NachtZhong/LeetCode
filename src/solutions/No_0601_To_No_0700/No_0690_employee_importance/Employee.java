package solutions.No_0601_To_No_0700.No_0690_employee_importance;

import java.util.List;

/**
 * @author Nacht
 * Created on 2019/10/29
 */
public class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
}
