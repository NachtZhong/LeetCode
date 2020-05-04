package solutions.No_0601_To_No_0700.No_0690_employee_importance;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/employee-importance/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * You are given a data structure of employee information, which includes the employee's unique id, his importance value and his direct subordinates' id.
 *
 * For example, employee 1 is the leader of employee 2, and employee 2 is the leader of employee 3. They have importance value 15, 10 and 5, respectively. Then employee 1 has a data structure like [1, 15, [2]], and employee 2 has [2, 10, [3]], and employee 3 has [3, 5, []]. Note that although employee 3 is also a subordinate of employee 1, the relationship is not direct.
 *
 * Now given the employee information of a company, and an employee id, you need to return the total importance value of this employee and all his subordinates.
 *
 * Example 1:
 *
 * Input: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
 * Output: 11
 * Explanation:
 * Employee 1 has importance value 5, and he has two direct subordinates: employee 2 and employee 3. They both have importance value 3. So the total importance value of employee 1 is 5 + 3 + 3 = 11.
 *
 *
 * Note:
 *
 * One employee has at most one direct leader and may have several subordinates.
 * The maximum number of employees won't exceed 2000.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 递归怪
 */
public class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Employee employee = getEmployeeById(employees,id);
        if(employee.subordinates == null || employee.subordinates.isEmpty()){
            return employee.importance;
        }else{
            int subImportance = 0 ;
            for(int subId : employee.subordinates){
                subImportance += getImportance(employees,subId);
            }
            return subImportance + employee.importance;
        }
    }

    private Employee getEmployeeById(List<Employee> employees, int id) {
        for(Employee employee : employees){
            if(employee.id == id){
                return employee;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Employee employee1 = new Employee();
        employee1.id = 1 ;
        employee1.importance = 2;
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        employee1.subordinates = list1;
        Employee employee2 = new Employee();
        employee2.id = 2 ;
        employee2.importance = 3;
        employee2.subordinates = new ArrayList<>();
        List<Employee> list = new ArrayList<>();
        list.add(employee1);
        list.add(employee2);
        System.out.println(new Solution().getImportance(list,2));
    }
}
