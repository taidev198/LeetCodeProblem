package com.company.superme198.HashTable;

import java.util.*;

/**
 * Created by traig on 9:41 PM, 11/22/2018
 */
public class EmployeeImportance {
    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    };


    /**Link:https://leetcode.com/problems/employee-importance/
     * You are given a data structure of employee information, which includes the employee's unique id,
     * his importance value and his direct subordinates' id.

     For example, employee 1 is the leader of employee 2, and employee 2 is the leader of employee 3.
     They have importance value 15, 10 and 5, respectively. Then employee 1 has a data structure like [1, 15, [2]], and employee 2 has [2, 10, [3]], and employee 3 has [3, 5, []]. Note that although employee 3 is also a subordinate of employee 1, the relationship is not direct.

     Now given the employee information of a company, and an employee id, you need to return the total importance value of this employee and
     all his subordinates.

     Example 1:
     Input: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
     Output: 11
     Explanation:
     Employee 1 has importance value 5, and he has two direct subordinates: employee 2 and employee 3. They both have importance value 3.
     So the total importance value of employee 1 is 5 + 3 + 3 = 11.
     Note:
     One employee has at most one direct leader and may have several subordinates.
     The maximum number of employees won't exceed 2000.*/
    static int getImportance(List<Employee> employees, int id) {
        Queue<Employee> queue = new LinkedList<>();
        int ans =0;
        Map<Integer, Integer> mapImportance =new HashMap<>();
        Map<Integer, Employee> mapEmployee =new HashMap<>();
        for(Employee em : employees){
            mapImportance.put(em.id, em.importance);
            mapEmployee.put(em.id, em);
        }

        queue.add(mapEmployee.get(id));
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i< size; i++){
                Employee cur = queue.poll();
                ans += mapImportance.get(cur.id);
                for(int j = 0; j< cur.subordinates.size(); j++)
                    queue.add(mapEmployee.get(cur.subordinates.get(j)));
            }

        }
        return ans;
    }
}
