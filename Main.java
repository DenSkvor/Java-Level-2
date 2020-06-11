public class Main {

    public static void main(String[] args) {

        doSomeParkour();

    }

    public static void doSomeParkour(){

        //участники
        Cat[] cats = {new Cat("Матроскин"), new Cat("Котёнок Гав"), new Cat("Кот Учёный")};

        Human[] humans = {new Human("Илья Муромец"), new Human("Добрыня Никитич"), new Human("Алеша Попович")};

        Robot[] robots = {new Robot("Электроник"), new Robot("Громозека"), new Robot("Дровосек")};

        //препятствия
        Track[] tracksForCats = {new Track(90), new Track(100), new Track(110)};
        Wall[] wallsForCats = {new Wall(0.5), new Wall(1), new Wall(1.5)};

        Track[] tracksForHumans = {new Track(900), new Track(1000), new Track(1100)};
        Wall[] wallsForHumans = {new Wall(1.5), new Wall(2), new Wall(2.5)};

        Track[] tracksForRobots = {new Track(1900), new Track(2000), new Track(2100)};
        Wall[] wallsForRobots = {new Wall(2.5), new Wall(3), new Wall(3.5)};

        //соревнования
        System.out.println("Соревнование котов:\n");
        doContest(cats, tracksForCats, wallsForCats);

        System.out.println("Соревнование людей:\n");
        doContest(humans, tracksForHumans, wallsForHumans);

        System.out.println("Соревнование роботов:\n");
        doContest(robots, tracksForRobots, wallsForRobots);

    }

    public static void doContest(Cat[] cats, Track[] tracksForCats, Wall[] wallsForCats){
        for (int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++) {
                if (!cats[i].run(tracksForCats[j])) {
                    System.out.println(cats[i].getName() + " сходит с дистанции!");
                    break;
                }
                if (!cats[i].jump(wallsForCats[j])) {
                    System.out.println(cats[i].getName() + " сходит с дистанции!");
                    break;
                }
            }
            System.out.println();
        }
    }

    public static void doContest(Human[] humans, Track[] tracksForHumans, Wall[] wallsForHumans){
        for (int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++) {
                if (!humans[i].run(tracksForHumans[j])) {
                    System.out.println(humans[i].getName() + " сходит с дистанции!");
                    break;
                }
                if (!humans[i].jump(wallsForHumans[j])) {
                    System.out.println(humans[i].getName() + " сходит с дистанции!");
                    break;
                }
            }
            System.out.println();
        }
    }

    public static void doContest(Robot[] robots, Track[] tracksForRobots, Wall[] wallsForRobots){
        for (int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++) {
                if (!robots[i].run(tracksForRobots[j])) {
                    System.out.println(robots[i].getName() + " сходит с дистанции!");
                    break;
                }
                if (!robots[i].jump(wallsForRobots[j])) {
                    System.out.println(robots[i].getName() + " сходит с дистанции!");
                    break;
                }
            }
            System.out.println();
        }
    }
}
