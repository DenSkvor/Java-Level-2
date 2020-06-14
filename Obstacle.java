public interface Obstacle {

    boolean doCheckSuccess(ContestParticipant participant);

    String getClassName();

}
