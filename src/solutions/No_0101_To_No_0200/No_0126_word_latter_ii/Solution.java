package solutions.No_0101_To_No_0200.No_0126_word_latter_ii;

import java.util.*;

/**
 * https://leetcode.com/problems/word-ladder-ii/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
 *
 * Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 * sk == endWord
 * Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest transformation sequences from beginWord to endWord, or an empty list if no such sequence exists. Each sequence should be returned as a list of the words [beginWord, s1, s2, ..., sk].
 *
 *
 *
 * Example 1:
 *
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
 * Explanation: There are 2 shortest transformation sequences:
 * "hit" -> "hot" -> "dot" -> "dog" -> "cog"
 * "hit" -> "hot" -> "lot" -> "log" -> "cog"
 * Example 2:
 *
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * Output: []
 * Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 题解:
 * 给一个开始词, 一个结束词, 开始词每次只能变换一个字母, 且变换过程中的每一个词都必须包含在词表中(包括结束词), 求开始词变换到结束词所有最短路径的变换过程
 * 解题思路:
 * 首先遍历一次做数据处理, 在遍历的过程中1.记录开始词和词表中下一步能走到的词的联系 2.记录词表中单词和下一步能走到的词的联系 3.记录结束词的位置
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findLadders("hit", "cog", Arrays.asList("hot","dot","dog","lot","log")));
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        /*结束词在数组中的索引*/
        int endWordIndex = -1;
        /*记录能转换的词之间的联系的集合*/
        Map<Integer, Set<Integer>> wordRelations = new HashMap<>();
        /*记录要进行下一层遍历的队列*/
        ArrayDeque<PathTreeNode> currentNodeQueue = new ArrayDeque<>();
        /*遍历记录词之间的联系*/
        for(int i = 0 ; i < wordList.size() ; i++){
            String word = wordList.get(i);
            if(canCastTo(beginWord, word)){
                currentNodeQueue.offer(new PathTreeNode(i));
            }
            if(endWordIndex == -1 && word.equals(endWord)){
                endWordIndex = i;
            }
            for(int j = i + 1; j < wordList.size(); j++){
                String targetWord = wordList.get(j);
                if(canCastTo(word, targetWord)){
                    wordRelations.computeIfAbsent(i, k -> new HashSet<>()).add(j);
                    wordRelations.computeIfAbsent(j, k -> new HashSet<>()).add(i);
                }
            }
        }
        /*如果词表中不包含endWord, 直接返回空集合*/
        if(endWordIndex == -1){
            return new ArrayList<>();
        }
        /*广度遍历*/
        /*记录返回结果*/
        List<List<String>> resultList = new ArrayList<>();
        /*记录已经遍历过的word index, 不走回头路!*/
        Set<Integer> handledWordIndexes = new HashSet<>();
        boolean hasFoundShortestPath = false;
        while (!currentNodeQueue.isEmpty()){
            int size = currentNodeQueue.size();
            /*如果找到了最短的路径, 遍历完这层就溜了*/
            if(!hasFoundShortestPath){
                for(int i = 0 ; i < size ; i++){
                    PathTreeNode currentNode = currentNodeQueue.poll();
                    /*如果匹配上了, 加入返回值, 打标志位, 如果没匹配上, 将当前节点的index加入path中, 并将下一层的节点加入queue中, 同时加入已遍历的set中, 避免重复遍历*/
                    if(currentNode.index == endWordIndex){
                        List<String> list = new ArrayList<>();
                        list.add(beginWord);
                        list.addAll(currentNode.getPath(wordList));
                        resultList.add(list);
                        hasFoundShortestPath = true;
                    }else{
                        /*如果前面已经有一个节点匹配上了, 就不用再关注这些匹配不上的节点了, 这里做一个判断进行剪枝优化*/
                        if(!hasFoundShortestPath) {
                            /*如果没匹配上, 将当前节点所有除了已经遍历过之外的关联节点加入queue中, 进行下一层遍历*/
                            handledWordIndexes.add(currentNode.index);
                            for (int index : wordRelations.get(currentNode.index)) {
                                if (!handledWordIndexes.contains(index)) {
                                    currentNodeQueue.offer(new PathTreeNode(index, currentNode));
                                }
                            }
                        }
                    }
                }
            }else{
                break;
            }
        }
        return resultList;
    }

    /**
     * 判断一个词能否通过变换一个字母变成另外一个词(题目已经规定所有词的长度相同, 这里不用判断)
     * @param beginWord
     * @param endWord
     * @return
     */
    private boolean canCastTo(String beginWord, String endWord){
        int castLetterCount = 0;
        for(int i = 0 ; i < beginWord.length() ; i++){
            if(beginWord.charAt(i) != endWord.charAt(i)){
                castLetterCount++;
                if(castLetterCount >= 2){
                    return false;
                }
            }
        }
        return castLetterCount == 1;
    }

    /**
     * 用来记录广度搜索过程中的树节点, 每个节点只需要记录自己的parent即可, 等到遍历到endWord的时候, 就根据当前节点的parent逆序遍历回去, 得到完整的path
     */
    private class PathTreeNode{
        int index;
        PathTreeNode parent;
        PathTreeNode(int index){
            this.index = index;
        }
        PathTreeNode(int index, PathTreeNode parent){
            this.index = index;
            this.parent = parent;
        }

        /**
         * 获取root节点到
         * @param wordList
         * @return
         */
        public List<String> getPath(List<String> wordList) {
            List<String> list = new LinkedList<>();
            PathTreeNode node = this;
            while(node != null){
                list.add(0, wordList.get(node.index));
                node = node.parent;
            }
            return list;
        }
    }
}
