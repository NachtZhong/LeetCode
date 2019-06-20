package solutions.No_0278_first_bad_version;

/**
 * https://leetcode.com/problems/first-bad-version/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 *
 * Example:
 *
 * Given n = 5, and version = 4 is the first bad version.
 *
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 *
 * Then 4 is the first bad version.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 一开始想直接用递归, 后来发现会超时, 所以要用二分查找
 */
public class Solution {
    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
    public int firstBadVersion(int n) {
        int begin = 1 ;
        int end = n;
        while(begin < end){
            int mid = begin + (end-begin)/2;
            if(isBadVersion(mid)){
                end = mid;
            }else{
                begin = mid + 1;
            }
        }
        return begin;
    }
    private boolean isBadVersion(int n){
        return false;
    }
}
