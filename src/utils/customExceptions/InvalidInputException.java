package utils.customExceptions;

import utils.Constants;

public class InvalidInputException extends RuntimeException{
    public InvalidInputException(){
        super(Constants.INVALI_INPUT_MESSAGE);
    }
}
