public class Track implements Obstacle {

    private double trackLength;

    public Track(double trackLength){
        this.trackLength = trackLength;
    }

    public double getTrackLength() {
        return trackLength;
    }

    public boolean doCheckSuccess(ContestParticipant participant){
        return (participant.getRunLimit() >= trackLength);
    }

    public String getClassName(){
        return "Track";
    }
}

