package ru.gb.lesson4;

public class Box {
    private int ballCount;

    public Box(int ballCount) {
        this.ballCount = ballCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void addBall(){
        ballCount++;
    }

    public void removeBall() throws BoxIsEmptyException {
        if (ballCount == 0)
            throw new BoxIsEmptyException();
        ballCount--;
    }
}
