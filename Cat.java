public class Cat implements Motions {

    private String name;
    private double runLimit;
    private double jumpLimit;

    public Cat (String name){
        this.name = name;
        runLimit = 90 + 10 * (int)(Math.random() * 3);
        jumpLimit = 0.5 + 0.5 * (int)(Math.random() * 3);
    }

    public String getName(){
        return name;
    }

    public double getRunLimit(){
        return runLimit;
    }

    public double getJumpLimit(){
        return jumpLimit;
    }


    public boolean run(Track obj){
        System.out.print(name + " пробует пробежать " + obj.getTrackLength() + "м -> ");
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
        System.out.print(name + " пробует перепрыгнуть " + obj.getWallHeight() + "м -> ");
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
