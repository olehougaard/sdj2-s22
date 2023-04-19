package dk.via.ballpit.accessmanager;

import dk.via.ballpit.BallPit;

public interface AccessManager {
    void releaseRead();

    ReadOnlyBallPit requestRead();

    void releaseWrite();

    BallPit requestWrite();
}
