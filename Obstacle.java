public interface Obstacle {

    boolean doCheckSuccess(ContestParticipant participant);

    void tryOvercomeThisObstacleByParticipant(ContestParticipant participant);

}
