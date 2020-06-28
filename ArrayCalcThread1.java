public class ArrayCalcThread1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < ArrayCalc.arr1.length; i++){
            ArrayCalc.arr1[i] = (float)(ArrayCalc.arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}
