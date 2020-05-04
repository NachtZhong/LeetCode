package solutions.No_0601_To_No_0700.No_0676_implement_magic_dictionary;

import java.util.*;

/**
 * https://leetcode.com/problems/implement-magic-dictionary/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Implement a magic directory with buildDict, and search methods.
 *
 * For the method buildDict, you'll be given a list of non-repetitive words to build a dictionary.
 *
 * For the method search, you'll be given a word, and judge whether if you modify exactly one character into another character in this word, the modified word is in the dictionary you just built.
 *
 * Example 1:
 * Input: buildDict(["hello", "leetcode"]), Output: Null
 * Input: search("hello"), Output: False
 * Input: search("hhllo"), Output: True
 * Input: search("hell"), Output: False
 * Input: search("leetcoded"), Output: False
 * Note:
 * You may assume that all the inputs are consist of lowercase letters a-z.
 * For contest purpose, the test data is rather small by now. You could think about highly efficient algorithm after the contest.
 * Please remember to RESET your class variables declared in class MagicDictionary, as static/class variables are persisted across multiple test cases. Please see here for more details.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 遍历比较即可
 */
class MagicDictionary {

    private List<String> dictList ;

    /** Initialize your data structure here. */
    public MagicDictionary() {
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        dictList = new ArrayList<>();
        for(String word : dict){
            dictList.add(word);
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        for(String dictWord : dictList){
            if(dictWord.length() == word.length()) {
                int diffCount = 0;
                for (int i = 0; i < dictWord.length(); i++) {
                    if (word.charAt(i) != dictWord.charAt(i)) {
                        diffCount++;
                        if (diffCount > 1) {
                            break;
                        }
                    }
                }
                if (diffCount == 1) {
                    return true;
                }
            }
        }
        return false;
    }

}
