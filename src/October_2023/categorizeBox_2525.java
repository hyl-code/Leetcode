package October_2023;

/*
    给你四个整数 length, width, height 和 mass, 分别表示一个箱子的三个维度和质量, 请你返回一个表示箱子类别的字符串.
        如果满足以下条件, 那么箱子是 "Bulky" 的：
            箱子至少有一个维度大于等于 10^4.
            或者箱子的体积大于等于 10^9.
        如果箱子的质量大于等于 100, 那么箱子是 "Heavy" 的.
        如果箱子同时是 "Bulky" 和 "Heavy", 那么返回类别为 "Both" .
        如果箱子既不是 "Bulky", 也不是 "Heavy", 那么返回类别为 "Neither".
        如果箱子是 "Bulky" 但不是 "Heavy", 那么返回类别为 "Bulky".
        如果箱子是 "Heavy" 但不是 "Bulky", 那么返回类别为 "Heavy".
    注意, 箱子的体积等于箱子的长度、宽度和高度的乘积.
 */
public class categorizeBox_2525 {
    public String categorizeBox(int length, int width, int height, int mass) {
        long max = Math.max(length, Math.max(width, height));
        long vol = 1L * length * width * height;
        boolean isBulky = (max >= 1e4 || vol >= 1e9);
        boolean isHeavy = mass >= 100;
        if(isBulky && isHeavy){
            return "Both";
        }else if(isBulky){
            return "Bulky";
        }else if(isHeavy){
            return "Heavy";
        }else{
            return "Neither";
        }
    }
}
