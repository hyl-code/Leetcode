package November_2023;

/*
    给你一个整数 money, 表示你总共有的钱数（单位为美元）和另一个整数 children, 表示你要将钱分配给多少个儿童.
    你需要按照如下规则分配：
        所有的钱都必须被分配.
        每个儿童至少获得 1 美元.
        没有人获得 4 美元.
    请你按照上述规则分配金钱, 并返回最多有多少个儿童获得恰好 8 美元. 如果没有任何分配方案, 返回 -1.
 */
public class distMoney_2591 {
    // 贪心
    public int distMoney(int money, int children) {
        if(money < children){
            return -1;
        }
        money -= children;
        int res = Math.min(money / 7, children);
        money -= res * 7;
        children -= res;
        if((children == 0 && money > 0) || (children == 1 && money == 3)){
            res--;
        }
        return res;
    }
}
