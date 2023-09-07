package September_2023;

public class repairCars_2594 {
    public long repairCars(int[] ranks, int cars) {
        long l = 1, r = 1l * ranks[0] * cars * cars;
        while(l < r){
            long m = l + (r - l) / 2;
            if(check(ranks, cars, m)){
                r = m;
            }else{
                l = m + 1;
            }
        }
        return l;
    }

    public boolean check(int[] ranks, int cars, long m){
        long cnt = 0;
        for(int rank : ranks){
            cnt += (long) Math.sqrt(m / rank);
        }
        return cnt >= cars;
    }
}
