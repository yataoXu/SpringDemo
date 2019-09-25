package com.yatao.demo;


import java.util.ArrayList;

/**
 * 假设有四种面额的钱币，1元、2 元、5 元和 10 元，一共要奖赏某人 10 元，
 * 那可以给他 1 张 10 元，或者 10 张1 元，或者 5 张 1 元外加 1 张 5 元等等。
 * 如果考虑每次要给的金额和先后顺序，那么最终一共有多少种不同的组合方式呢？
 */
public class Lession_5 {

    public static int[] rewards = {1, 2, 5, 10}; // 四种面额的纸币


    public static void main(String[] args) {
        int totalAmt =10;
        Lession_5.get(totalAmt,new ArrayList<>());
    }

    /**
     * @param totalAmt- 总金额，result- 保存当前的解
     * @return void
     * @Description: 使用函数的递归（嵌套）调用，找出所有可能的奖金组合
     */
    public  static void get(int totalAmt, ArrayList<Integer> result) {
        // 当 totalReward < 0 时，证明它不是满足条件的解，不输出
        if (totalAmt < 0){
           return;
        }
        // 当 totalReward = 0 时，证明它是满足条件的解，结束嵌套调用，输出解
        else if (totalAmt == 0){
            System.out.println(result);
        }else{
            for (int i = 0; i < rewards.length;  i++) {
                ArrayList<Integer> newResult = (ArrayList<Integer>) (result.clone());
                newResult.add(rewards[i]);
                // 剩下的金额
                get(totalAmt - rewards[i], newResult);
            }
        }
    }
}
