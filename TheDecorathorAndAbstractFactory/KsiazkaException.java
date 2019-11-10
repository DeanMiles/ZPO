public class KsiazkaException extends Exception {

    KsiazkaException(String errorMessage){
        super(errorMessage);
    }
    public String getMessage(){
        return super.getMessage();
    }
}
