public class Filter {
    public int removeDumplicates(int[] a){
        int n = 0;
        for (int i = 0; i < a.length; i++){
            if (i == 0 || a[i] == a[i-1]) {
                a[n] = a[i];
                n++;
            }
        }
        return n;
    }
}
