public class ArraySumCalc {

    public void do4x4ArrSumCalc(String[][]arr){
        try {
            if(arr.length != 4) throw new MyArraySizeException();
            for(int i = 0; i < arr.length; i++) if(arr[i].length != 4) throw new MyArraySizeException();

            int sum = 0;

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    try {
                        if(!doCheckForNumber(arr[i][j])) throw new MyArrayDataException();

                        sum += Integer.parseInt(arr[i][j]);

                    } catch (MyArrayDataException exc) {
                        System.out.println(exc + " Ячейка: " + "[" + i + "]" + "[" + j + "]");
                    }
                }
            }
            System.out.println("Сумма чисел в массиве: " + sum);
        }
        catch (MyArraySizeException exc){
            System.out.println(exc + " Должен быть 4 на 4.");
        }
    }

    private boolean doCheckForNumber(String str){
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) < 48 || str.charAt(i) > 57) return false;
        }
        return true;
    }

}
