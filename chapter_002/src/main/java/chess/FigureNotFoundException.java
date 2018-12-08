package chess;

public class FigureNotFoundException extends RuntimeException {
    public FigureNotFoundException(String message) {
        super(message);
    }
}
