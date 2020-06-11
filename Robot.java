public class Robot implements Motions{

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


    public boolean run(Track obj){
        System.out.print(modelName + " пробует пробежать " + obj.getTrackLength() + "м -> ");
        if(runLimit < obj.getTrackLength()) {
            System.out.println("не удалось");
            return false;
        }
        else {
            System.out.println("удалось");
            return true;
        }
    }

    public boolean jump(Wall obj){
        System.out.print(modelName + " пробует перепрыгнуть " + obj.getWallHeight() + "м -> ");
        if(jumpLimit < obj.getWallHeight()) {
            System.out.println("не удалось");
            return false;
        }
        else {
            System.out.println("удалось");
            return true;
        }
    }
}
