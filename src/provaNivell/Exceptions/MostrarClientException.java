package provaNivell.Exceptions;

public class MostrarClientException extends Exception {


    private String message;

    public MostrarClientException(String message){
        this.message = message;
        getMessage();
    }


    public String getMessage(){
        return message;
    }

}
