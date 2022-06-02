public class Main {
    public static void main(String[] args) {
        Filter f = new Filter();
        int[] a = new int[]{1,1,0,3,4,0,5,5};
        int[] b =f.moveZeroes(a);
        for (int i = 0; i < b.length; i++){
            System.out.println(b[i]);
        }

    }
}
