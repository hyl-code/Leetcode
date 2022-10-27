package October_2022;

/*
    已知函数 signFunc(x) 将会根据 x 的正负返回特定值:
    如果 x 是正数, 返回 1.
    如果 x 是负数, 返回 -1.
    如果 x 是等于 0, 返回 0.
    给你一个整数数组 nums. 令 product 为数组 nums 中所有元素值的乘积.
    返回 signFunc(product).
 */
public class arraySign_1822 {
    //负数个数为单数: 结果为负数
    //负数个数为双数: 结果为正数
    public int arraySign(int[] nums) {
        boolean flag = true;
        for(int num : nums){
            if(num == 0){
                return 0;
            }
            if(num < 0){
                flag = !flag;
            }
        }
        return flag ? 1 : -1;
    }
}
