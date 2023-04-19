package dk.via.ballpit;

import dk.via.ballpit.accessmanager.ReadOnlyBallPit;

public interface BallPit {
    int getGreenBalls();

    int getRedBalls();

    int getTotal();

    void paintBallGreen();

    void paintBallRed();
}
