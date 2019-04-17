package stage.one.klaus;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 *
 * Example:
 *
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * 解析：https://leetcode.com/problems/unique-binary-search-trees/discuss/31666/DP-Solution-in-6-lines-with-explanation.-F(i-n)-G(i-1)-*-G(n-i)
 *
 * G(n) = F(1, n) + F(2, n) + ... + F(n, n).
 * F(i, n) = G(i-1) * G(n-i)	1 <= i <= n
 */
public class UniqueBinarySearchTrees {

    public int numTrees(int n){
        int[] res = new int[n + 1];   //存储各节点数的  不同二叉搜索树的数量
        res[0] = 1;  //节点数为0时， 二叉搜索树数量为1
        res[1] = 1; //节点数为1时， 二叉搜索树数量为1
        for(int i = 2; i <= n; i++)   //不同的节点数
            for(int j = 1; j <= i; j++){// 每个数做一次根节点
                res[i] = res[i] + res[j - 1] * res[i - j];
            }
        return res[n];
    }
}
