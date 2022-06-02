public class Main {
    public static void main(String[] args) {
        Filter f = new Filter();
        int[] a = new int[]{1,1,2,3,4,5,5,5};
        int n =f.removeDumplicates(a);
        System.out.println(n);
    }
}
