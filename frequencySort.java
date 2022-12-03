/*
Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.

Return the sorted string. If there are multiple answers, return any of them. 

Example 1:

Input: s = "tree"
Output: "eert" or "eetr"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'.

Example 2:

Input: s = "cccaaa"
Output: "aaaccc"
Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
Note that "cacaca" is incorrect, as the same characters must be together.

Example 3:

Input: s = "Aabb"
Output: "bbAa"
Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.

Constraints:
    1 <= s.length <= 5 * 105
    s consists of uppercase and lowercase English letters and digits.

*/
import java.util.*;

public class frequencySort{

    static String solution(String s){
         Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++)
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);

        // r (Map.Entry<String,String> entry : gfg.entrySet()) 
        List<Character> [] arr = new List[s.length() +1];

        for(Character key : map.keySet()){
            int freq = map.get(key);
            if(arr[freq] == null)
                arr[freq] = new ArrayList<>();
            arr[freq].add(key);
        }

        StringBuilder str = new StringBuilder();
        for(int i=arr.length-1; i>=0; i--){
            if(arr[i] != null){
                for(Character c : arr[i])
                    for(int cnt = 0; cnt<i; cnt++)
                        str.append(c);
            }
        }
        return str.toString();
    }

    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String res = solution(s);
        System.out.println(res);
    }
}
