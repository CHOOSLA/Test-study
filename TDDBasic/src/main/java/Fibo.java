public class Fibo {
    public int fibo(int i) {
//        if(i == 0) return 0;
//        if(i == 1) return 1;
        if(i < 2) return i;
        return fibo(i-1) + fibo(i-2);
    }

    public int fiboIter(int order) {
        if( order < 2) return order;
        int[] tmp = new int[order + 1];
        tmp[0] = 0; tmp[1] = 1;
        for(int i=2; i <= order; i++){
            tmp[i] = tmp[i-1] + tmp[i-2];
        }

        return tmp[order];
    }
}
