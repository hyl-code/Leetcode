package October_2022;

import java.util.List;

/*
    给你一个数组 items, 其中 items[i] = [typei, colori, namei],描述第 i 件物品的类型、颜色以及名称.
    另给你一条由两个字符串 ruleKey 和 ruleValue 表示的检索规则.
    如果第 i 件物品能满足下述条件之一, 则认为该物品与给定的检索规则匹配:
    ruleKey == "type" 且 ruleValue == typei.
    ruleKey == "color" 且 ruleValue == colori.
    ruleKey == "name" 且 ruleValue == namei.
    统计并返回匹配检索规则的物品数量.
 */
public class countMatches_1773 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int res = 0;
        int num = 0;
        if(ruleKey.equals("color")){
            num = 1;
        }else if(ruleKey.equals("name")){
            num = 2;
        }
        for(List<String> item : items){
            if(item.get(num).equals(ruleValue)){
                res++;
            }
        }
        return res;
    }
}
