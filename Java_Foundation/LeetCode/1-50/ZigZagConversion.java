package stage.one.klaus;

import java.util.ArrayList;
import java.util.List;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Example 1:
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 */
public class ZigZagConversion {

    public static void main(String[] args){
        String str = "PAYPALISHIRING";
        System.out.println(Convert(str, 3));

    }

    public static String Convert(String s, int numRows){
        if(numRows == 1){
            return s;
        }

        List<StringBuilder> builder = new ArrayList<StringBuilder>();
        for(int i = 0; i < numRows; i++){
            builder.add(new StringBuilder());
        }
        boolean flag = false;
        int curRow = 0;

        for(char c : s.toCharArray()){    //char[] toCharArray​() 将此字符串转换为新的字符数组。
            builder.get(curRow).append(c);
            if(curRow == 0 || curRow == numRows - 1){
                flag = !flag;
            }
            curRow += (flag ? 1 : -1);
        }

        StringBuilder goal = new StringBuilder();
        for (StringBuilder temp : builder){
            goal.append(temp);
        }
        return goal.toString();
    }
}
