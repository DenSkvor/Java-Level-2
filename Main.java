public class Main {

    public static void main(String[] args) {

        doSomeExceptionExample();

    }

    public static void doSomeExceptionExample(){

        String[][] stringArr1 = {
                {"10","10","10","1A"},
                {"10","10","1B","10"},
                {"10","1C","10","10"},
                {"1D","10","10","10"}
        };

        String[][] stringArr2 = {
                {"10","10","10","1A"},
                {"10","10","1B","10"},
                {"10","1C","10","10"},
                {"1D","10","10","10","10"},
        };

        ArraySumCalc arraySumCalc = new ArraySumCalc();

        System.out.println("Массив 1:");
        arraySumCalc.do4x4ArrSumCalc(stringArr1);

        System.out.println("\nМассив 2:");
        arraySumCalc.do4x4ArrSumCalc(stringArr2);


        System.out.println("\nМассив 2 (проброс искл. вверх):");
        try {
            new ArraySumCalcWithThrows().do4x4ArrSumCalc(stringArr2);
        }
        catch (MyArraySizeException exc){
            System.out.println(exc + " Должен быть 4 на 4.");
        }

    }

}
