package chess;

public class ImposibleMoveException extends RuntimeException {
    public ImposibleMoveException(String message) {
        super(message);
    }
}
