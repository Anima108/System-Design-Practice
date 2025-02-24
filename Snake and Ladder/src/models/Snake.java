package models;

public class Snake implements Obstacle{
    int start;
    int end;
    @Override
    public int getStart() {
        return start;
    }

    @Override
    public void setStart(int start) {
        this.start = start;

    }

    @Override
    public int getEnd() {
        return end;
    }

    @Override
    public void setEnd(int end){
        if(end>=start){
            throw new IllegalArgumentException("End must be less than start.");
        }
        else{
            this.end = end;
        }
    }

    // Override toString for better representation
    @Override
    public String toString() {
        return "Snake [start=" + start + ", end=" + end + "]";
    }
}
