public class ArrayCalcThread2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < ArrayCalc.arr2.length; i++){
            ArrayCalc.arr2[i] = (float)(ArrayCalc.arr2[i] * Math.sin(0.2f + (i + ArrayCalc.arr2.length) / 5) *
                    Math.cos(0.2f + (i + ArrayCalc.arr2.length) / 5) * Math.cos(0.4f + (i + ArrayCalc.arr2.length) / 2));
        }
    }
}
