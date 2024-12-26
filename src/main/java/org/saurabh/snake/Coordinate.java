package org.saurabh.snake;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Coordinate {
    private int row;
    private int column;

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Coordinate)) return false;
        final Coordinate other = (Coordinate) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getRow() != other.getRow()) return false;
        if (this.getColumn() != other.getColumn()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Coordinate;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getRow();
        result = result * PRIME + this.getColumn();
        return result;
    }

    public String toString() {
        return "Coordinate(row=" + this.getRow() + ", column=" + this.getColumn() + ")";
    }
}
