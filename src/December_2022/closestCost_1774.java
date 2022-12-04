package December_2022;

/*
    你打算做甜点, 现在需要购买配料. 目前共有 n 种冰激凌基料和 m 种配料可供选购. 而制作甜点需要遵循以下几条规则 :
    必须选择一种冰激凌基料.
    可以添加一种或多种配料, 也可以不添加任何配料.
    每种类型的配料最多两份.
    给你以下三个输入:

    baseCosts, 一个长度为 n 的整数数组, 其中每个 baseCosts[i] 表示第 i 种冰激凌基料的价格.
    toppingCosts, 一个长度为 m 的整数数组, 其中每个 toppingCosts[i] 表示一份第 i 种冰激凌配料的价格.
    target 一个整数, 表示你制作甜点的目标价格.
    你希望自己做的甜点总成本尽可能接近目标价格 target.

    返回最接近 target 的甜点成本。如果有多种方案，返回 成本相对较低 的一种。
 */
public class closestCost_1774 {
    private int best = (int)1e9;
    private int target;

    // dfs + 剪枝
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        this.target = target;
        for(int i = 0; i < baseCosts.length; i++){
            dfs(toppingCosts, 0, baseCosts[i]);
        }
        return best;
    }

    public void dfs(int toppingCosts[], int index, int total){
        int sign = Math.abs(best - target) - Math.abs(total - target);
        if(sign > 0 || (sign == 0 && total < best)){
            best = total;
        }
        if(total >= target || index == toppingCosts.length){
            return;
        }
        for(int k = 0; k < 3; k++){
            dfs(toppingCosts, index + 1, total + toppingCosts[index] * k);
        }
    }
}
