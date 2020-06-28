public class ArrayCalc {

    static float[] arr1;
    static float[] arr2;

    public void doArrayCalculation(){

        int size = 10000000;
        int h = size / 2;
        float[] arr = new float[size];

        for (int i = 0; i < arr.length; i++) arr[i] = 1;

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        long stopTime = System.currentTimeMillis();

        System.out.println("Время рассчета без разделения массива: " + (stopTime - startTime) + " мс");
        //System.out.println(arr[0] + " " + arr[h-1] + " " + arr[size-1]); //для отладки
    }

    public synchronized void doSplitedArrayCalculation(){

        int size = 10000000;
        float[] arr = new float[size];
        int h = size / 2;

        for (int i = 0; i < arr.length; i++) arr[i] = 1;

        long startTime = System.currentTimeMillis();

        arr1 = new float[h];
        arr2 = new float[h];

        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);

        Thread thread1 = new Thread(new ArrayCalcThread1());
        Thread thread2 = new Thread(new ArrayCalcThread2());

        thread1.start();
        thread2.start();

        for (;;){
            if (!thread1.isAlive() && !thread2.isAlive()){
                System.arraycopy(arr1, 0, arr, 0, h);
                System.arraycopy(arr2, 0, arr, h, h);
                break;
            }
        }

        long stopTime = System.currentTimeMillis();

        System.out.println("Время рассчета с разделением массива на два: " + (stopTime - startTime) + " мс");
        //System.out.println(arr[0] + " " + arr[h-1] + " " + arr[size-1]); //для отладки

    }

}
