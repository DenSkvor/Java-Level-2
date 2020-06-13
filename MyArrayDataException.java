public class MyArrayDataException extends Exception {

    public MyArrayDataException(String message){
        super(message);
    }

    public MyArrayDataException(){
    }

    public String toString(){
        return "MyArrayDataException. Неверное преобразование символьной строки в числовой формат.";
    }

}
