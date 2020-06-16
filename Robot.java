public class Robot implements ContestParticipant{

    private String modelName;
    private double runLimit;
    private double jumpLimit;

    public Robot (String modelName){
        this.modelName = modelName;
        runLimit = 1900 + 100 * (int)(Math.random() * 3);
        jumpLimit = 2.5 + 0.5 * (int)(Math.random() * 3);
    }

    public String getName(){
        return modelName;
    }

    public double getRunLimit(){
        return runLimit;
    }

    public double getJumpLimit(){
        return jumpLimit;
    }


    public void run(Track obj){
        System.out.print(modelName + " пробует пробежать " + obj.getTrackLength() + "м -> ");
        if(!obj.doCheckSuccess(this)) {
            System.out.println("не удалось");
        }
        else {
            System.out.println("удалось");
        }
    }

    public void jump(Wall obj){
        System.out.print(modelName + " пробует перепрыгнуть " + obj.getWallHeight() + "м -> ");
        if(!obj.doCheckSuccess(this)) {
            System.out.println("не удалось");
        }
        else {
            System.out.println("удалось");
        }
    }
}
