package solutions.No_0901_To_No_1000.No_0985_sum_of_even_numbers_after_queries;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sum-of-even-numbers-after-queries/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * We have an array A of integers, and an array queries of queries.
 *
 * For the i-th query val = queries[i][0], index = queries[i][1], we add val to A[index].  Then, the answer to the i-th query is the sum of the even values of A.
 *
 * (Here, the given index = queries[i][1] is a 0-based index, and each query permanently modifies the array A.)
 *
 * Return the answer to all queries.  Your answer array should have answer[i] as the answer to the i-th query.
 *
 *
 *
 * Example 1:
 *
 * Input: A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
 * Output: [8,6,2,4]
 * Explanation:
 * At the beginning, the array is [1,2,3,4].
 * After adding 1 to A[0], the array is [2,2,3,4], and the sum of even values is 2 + 2 + 4 = 8.
 * After adding -3 to A[1], the array is [2,-1,3,4], and the sum of even values is 2 + 4 = 6.
 * After adding -4 to A[0], the array is [-2,-1,3,4], and the sum of even values is -2 + 4 = 2.
 * After adding 2 to A[3], the array is [-2,-1,3,6], and the sum of even values is -2 + 6 = 4.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 第一个查询需要计算所有偶数之和, 第二次开始只需要查询根据改变的数结合前一个计算出的和得出即可(节省计算量)
 */
public class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] result = new int[queries.length];
        int i = 0 ;
        for(int[] query : queries){
            if(i == 0){
                A[query[1]] += query[0];
                int sum = 0 ;
                for(int a : A){
                    if(isEven(a)){
                        sum += a;
                    }
                }
                result[i++] = sum;
            }else{
                int oriNum = A[query[1]];
                int addNum = query[0];
                if(isEven(oriNum) && isEven(addNum)){
                    result[i] = result[i-1] + addNum;
                }
                if(isEven(oriNum) && !isEven(addNum)){
                    result[i] = result[i-1] - A[query[1]];
                }
                if(!isEven(oriNum) && isEven(addNum)){
                    result[i] = result[i-1];
                }
                if(!isEven(oriNum) && !isEven(addNum)){
                    result[i] = result[i-1] + oriNum + addNum;
                }
                i++;
                A[query[1]] += addNum;
            }
        }
        return result;
    }
    private boolean isEven(int x){
        return x % 2 == 0;
    }

    public static void main(String[] args) {
        int[][] a = new int[4][2];
        a[0] = new int[]{1,0};
        a[1] = new int[]{-3,1};
        a[2] = new int[]{-4,0};
        a[3] = new int[]{2,3};
        System.out.println(Arrays.toString(new Solution().sumEvenAfterQueries(new int[]{1,2,3,4},a)));
    }
}
