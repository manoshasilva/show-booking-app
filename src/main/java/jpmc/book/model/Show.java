package jpmc.book.model;

import java.util.Objects;

public class Show {

    private String showNumber;

    private Integer noOfRows;

    private Integer noOfSeatsPerRow;

    private Integer cancellationWindowInMinutes;

    public String getShowNumber() {
        return showNumber;
    }

    public Show showNumber(String showNumber) {
        this.showNumber = showNumber;
        return this;
    }

    public Integer getNoOfRows() {
        return noOfRows;
    }

    public Show noOfRows(Integer noOfRows) {
        this.noOfRows = noOfRows;
        return this;
    }

    public Integer getNoOfSeatsPerRow() {
        return noOfSeatsPerRow;
    }

    public Show noOfSeatsPerRow(Integer noOfSeatsPerRow) {
        this.noOfSeatsPerRow = noOfSeatsPerRow;
        return this;
    }

    public Integer getCancellationWindowInMinutes() {
        return cancellationWindowInMinutes;
    }

    public Show cancellationWindowInMinutes(Integer cancellationWindowInMinutes) {
        this.cancellationWindowInMinutes = cancellationWindowInMinutes;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Show)) return false;
        Show show = (Show) o;
        return Objects.equals(getShowNumber(), show.getShowNumber()) &&
                Objects.equals(getNoOfRows(), show.getNoOfRows()) &&
                Objects.equals(getNoOfSeatsPerRow(), show.getNoOfSeatsPerRow()) &&
                Objects.equals(getCancellationWindowInMinutes(), show.getCancellationWindowInMinutes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getShowNumber(), getNoOfRows(), getNoOfSeatsPerRow(), getCancellationWindowInMinutes());
    }
}
