package solutions.No_1201_To_No_1300.No_1222_queens_that_can_attack_the_king;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/queens-that-can-attack-the-king/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * On an 8x8 chessboard, there can be multiple Black Queens and one White King.
 * <p>
 * Given an array of integer coordinates queens that represents the positions of the Black Queens, and a pair of coordinates king that represent the position of the White King, return the coordinates of all the queens (in any order) that can attack the King.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: queens = [[0,1],[1,0],[4,0],[0,4],[3,3],[2,4]], king = [0,0]
 * Output: [[0,1],[1,0],[3,3]]
 * Explanation:
 * The queen at [0,1] can attack the king cause they're in the same row.
 * The queen at [1,0] can attack the king cause they're in the same column.
 * The queen at [3,3] can attack the king cause they're in the same diagnal.
 * The queen at [0,4] can't attack the king cause it's blocked by the queen at [0,1].
 * The queen at [4,0] can't attack the king cause it's blocked by the queen at [1,0].
 * The queen at [2,4] can't attack the king cause it's not in the same row/column/diagnal as the king.
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: queens = [[0,0],[1,1],[2,2],[3,4],[3,5],[4,4],[4,5]], king = [3,3]
 * Output: [[2,2],[3,4],[4,4]]
 * Example 3:
 * <p>
 * <p>
 * <p>
 * Input: queens = [[5,6],[7,7],[2,1],[0,7],[1,6],[5,1],[3,7],[0,3],[4,0],[1,2],[6,3],[5,0],[0,4],[2,2],[1,1],[6,4],[5,4],[0,0],[2,6],[4,5],[5,2],[1,4],[7,5],[2,3],[0,5],[4,2],[1,0],[2,7],[0,1],[4,6],[6,1],[0,6],[4,3],[1,7]], king = [3,4]
 * Output: [[2,3],[1,4],[1,6],[3,7],[4,3],[5,4],[4,5]]
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 遍历数组, 选出在直线/斜线上面的queen, 同时标记它在king的哪个方位, 如果有更近的点则替换
 */
public class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        final int LEFT = 0, RIGHT = 1, TOP = 2, BOTTOM = 3, TOP_RIGHT = 4, TOP_LEFT = 5, BOTTOM_LEFT = 6, BOTTOM_RIGHT = 7;
        Map<Integer, int[]> cacheMap = new HashMap<>();
        for (int[] queen : queens) {
            if (queen[0] == king[0]) {
                //TOP
                if (queen[1] > king[1]) {
                    if (!cacheMap.containsKey(TOP)) {
                        cacheMap.put(TOP, queen);
                    } else {
                        if (queen[1] < cacheMap.get(TOP)[1]) {
                            cacheMap.put(TOP, queen);
                        }
                    }
                }
                //BOTTOM
                else {
                    if (!cacheMap.containsKey(BOTTOM)) {
                        cacheMap.put(BOTTOM, queen);
                    } else {
                        if (queen[1] > cacheMap.get(BOTTOM)[1]) {
                            cacheMap.put(BOTTOM, queen);
                        }
                    }
                }
            }
            if (queen[1] == king[1]) {
                //LEFT
                if (queen[0] < king[0]) {
                    if (!cacheMap.containsKey(LEFT)) {
                        cacheMap.put(LEFT, queen);
                    } else {
                        if (queen[0] > cacheMap.get(LEFT)[0]) {
                            cacheMap.put(LEFT, queen);
                        }
                    }
                }
                //RIGHT
                else {
                    if (!cacheMap.containsKey(RIGHT)) {
                        cacheMap.put(RIGHT, queen);
                    } else {
                        if (queen[0] < cacheMap.get(RIGHT)[0]) {
                            cacheMap.put(RIGHT, queen);
                        }
                    }
                }
            }
            if (Math.abs(queen[0] - king[0]) == Math.abs(queen[1] - king[1])) {
                //TOP RIGHT
                if (queen[0] > king[0] && queen[1] > king[1]) {
                    if (!cacheMap.containsKey(TOP_RIGHT)) {
                        cacheMap.put(TOP_RIGHT, queen);
                    } else {
                        if (queen[0] < cacheMap.get(TOP_RIGHT)[0]) {
                            cacheMap.put(TOP_RIGHT, queen);
                        }
                    }
                }
                //TOP LEFT
                if (queen[0] < king[0] && queen[1] > king[1]) {
                    if (!cacheMap.containsKey(TOP_LEFT)) {
                        cacheMap.put(TOP_LEFT, queen);
                    } else {
                        if (queen[0] > cacheMap.get(TOP_LEFT)[0]) {
                            cacheMap.put(TOP_LEFT, queen);
                        }
                    }
                }
                //BOTTOM RIGHT
                if (queen[0] > king[0] && queen[1] < king[1]) {
                    if (!cacheMap.containsKey(BOTTOM_RIGHT)) {
                        cacheMap.put(BOTTOM_RIGHT, queen);
                    } else {
                        if (queen[0] < cacheMap.get(BOTTOM_RIGHT)[0]) {
                            cacheMap.put(BOTTOM_RIGHT, queen);
                        }
                    }
                }
                //BOTTOM LEFT
                if (queen[0] < king[0] && queen[1] < king[1]) {
                    if (!cacheMap.containsKey(BOTTOM_LEFT)) {
                        cacheMap.put(BOTTOM_LEFT, queen);
                    } else {
                        if (queen[0] > cacheMap.get(BOTTOM_LEFT)[0]) {
                            cacheMap.put(BOTTOM_LEFT, queen);
                        }
                    }
                }
            }
        }
        List<List<Integer>> resultList = new ArrayList<>();
        for (int[] queen : cacheMap.values()) {
            List<Integer> queenList = new ArrayList<>();
            queenList.add(queen[0]);
            queenList.add(queen[1]);
            resultList.add(queenList);
        }
        return resultList;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
