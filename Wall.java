public class Wall implements Obstacle{

    private double wallHeight;

    public Wall(double wallHeight){
        this.wallHeight = wallHeight;
    }

    public double getWallHeight() {
        return wallHeight;
    }

    public boolean doCheckSuccess(ContestParticipant participant){
        return (participant.getJumpLimit() >= wallHeight);
    }

    public void tryOvercomeThisObstacleByParticipant(ContestParticipant participant){
        participant.jump(this);
    }
}
