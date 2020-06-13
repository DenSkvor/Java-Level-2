public class ArraySumCalcWithThrows {

    //все исключения пробрасываются вверх
    public void do4x4ArrSumCalc(String[][]arr) throws MyArraySizeException, MyArrayDataException {

        if(arr.length != 4) throw new MyArraySizeException(
                "MyArraySizeException. Неверный размер массива. Должен быть 4 на 4.");
        for(String[] string : arr) if(string.length != 4) throw new MyArraySizeException(
                "MyArraySizeException. Неверный размер массива. Должен быть 4 на 4.");

            int sum = 0;

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if(!doCheckForNumber(arr[i][j])) {
                        throw new MyArrayDataException(
                                "MyArrayDataException. Неверное преобразование символьной строки в числовой формат."
                                + " Ячейка: " + "[" + i + "]" + "[" + j + "]"
                                + "\nСумма чисел в массиве до момента ошибки: " + sum);
                    }
                    sum += Integer.parseInt(arr[i][j]);
                }
            }
            System.out.println("Сумма чисел в массиве: " + sum);
    }

    private boolean doCheckForNumber(String str){
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) < 48 || str.charAt(i) > 57) return false;
        }
        return true;
    }

}
