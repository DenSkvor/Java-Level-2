public class MyArraySizeException extends Exception {

    public MyArraySizeException(String message){
        super(message);
    }

    public MyArraySizeException(){
    }

    public String toString(){
        return "MyArraySizeException. Неверный размер массива.";
    }

}
