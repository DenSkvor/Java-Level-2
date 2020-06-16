public class Main {

    public static void main(String[] args) {

        doSomeParkour();

    }

    public static void doSomeParkour(){

        //участники
        ContestParticipant[] cats = {
                new Cat("Матроскин"), new Cat("Котёнок Гав"), new Cat("Кот Учёный")
        };

        ContestParticipant[] humans = {
                new Human("Илья Муромец"), new Human("Добрыня Никитич"), new Human("Алеша Попович")
        };

        ContestParticipant[] robots = {
                new Robot("Электроник"), new Robot("Громозека"), new Robot("Дровосек")
        };

        ContestParticipant[] participants = {
                new Cat("Матроскин"), new Human("Илья Муромец"), new Robot("Электроник")
        };

        //препятствия
        Obstacle[] obstacleCourseForCats = {
                new Track(90),new Wall(0.5), new Track(100),
                new Wall(1), new Track(110),new Wall(1.5)
        };

        Obstacle[] obstacleCourseForHumans = {
                new Track(900),new Wall(1.5),new Track(1000),
                new Wall(2),new Track(1100),new Wall(2.5)
        };

        Obstacle[] obstacleCourseForRobots = {
                new Track(1900),new Wall(2.5),new Track(2000),
                new Wall(3),new Track(2100),new Wall(3.5)
        };

        Obstacle[] obstacleCourseForMix = {
                new Track(100), new Wall(1),new Track(1000),
                new Wall(2),new Track(2000), new Wall(3)
        };


        //соревнования
        System.out.println("Соревнование котов:\n");
        doContest(cats, obstacleCourseForCats);

        System.out.println("Соревнование людей:\n");
        doContest(humans, obstacleCourseForHumans);

        System.out.println("Соревнование роботов:\n");
        doContest(robots, obstacleCourseForRobots);

        System.out.println("Смешанные соревнования:\n");
        doContest(participants, obstacleCourseForMix);

    }

    public static void doContest(ContestParticipant[] participants, Obstacle[] obstacleCourse){
        for (int i = 0; i < participants.length; i++){
            for(int j = 0; j < obstacleCourse.length; j++) {
                tryOvercomeObstacleByParticipant(obstacleCourse[j], participants[i]);
                if(!obstacleCourse[j].doCheckSuccess(participants[i])) {
                    System.out.println(participants[i].getName() + " сходит с дистанции!");
                    break;
                }
            }
            System.out.println();
        }
    }

    public static void tryOvercomeObstacleByParticipant(Obstacle obstacle, ContestParticipant participant){
        obstacle.tryOvercomeThisObstacleByParticipant(participant);
    }

}
