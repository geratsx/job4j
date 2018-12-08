package chess;

public class OccupiedWayException extends RuntimeException {
    public OccupiedWayException(String message) {
        super(message);
    }
}
