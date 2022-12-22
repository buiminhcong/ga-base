package cs;

import cs.domain.Class;
import java.util.ArrayList;


public class Driver {

    public static final int POPULATION_SIZE = 9; // Size của quần thể khởi tạo 1 thế hệ có 9 quần thể
    public static final double MUTATION_RATE = 0.1; // tỷ lệ đột biến
    public static final double CROSSOVER_RATE = 0.9; // tỷ lệ lai ghép
    // số lượng cá thể có trong quần thể cạnh tranh tournamentPopulation
    public static final int TOURNAMENT_SELECTION_SIZE = 3;
    public static final int NUMBER_OF_ELITE_SCHEDULE = 1; // số cá thể ưu tú
    private Data data; // Dữ liệu đầu vào
    private int scheduleNumb = 0;
    private int classNumb = 1;

    public static void main(String[] args) {


        Driver driver = new Driver();
        driver.data = new Data(); // khởi tạo data
        int generationNumber = 0; // số lần sinh
        driver.printAvailableData();
        System.out.println("> Generation # " + generationNumber);
        System.out.print("  Schedule # |              ");
        System.out.printf("Classes [department, class, room, instructor, meeting-time]");
        System.out.printf("        |      Fitness     |      Conflicts   " );
        System.out.print("---------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------");
        // Khởi tạo thuật toán
        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(driver.data);
        // Khởi tạo quần thể và sort quần thể theo sức mạnh quần thể quá trình đánh giá
        Population population = new Population(Driver.POPULATION_SIZE, driver.data).sortByFitness();
        // lặp các thế hệ
        population.getSchedules().forEach(schedule -> System.out.println("      " + driver.scheduleNumb++ +
                "    | " + schedule + " | " +
                String.format("%.5f", schedule.getFitness()) +
                " |  " + schedule.getNumberOfConflicts()
        ));
        // In ra cá thể tốt nhất của từng quần thể qua các thế hệ
        driver.printScheduleTable(population.getSchedules().get(0), generationNumber);

        driver.classNumb = 1;
        // nếu chưa có cá thể tốt chạy tiếp thuật toán
        while (population.getSchedules().get(0).getFitness() != 1){
            System.out.println(">Generation # " + ++generationNumber);
            System.out.print("  Schedule # |              ");
            System.out.printf("Classes [department, class, room, instructor, meeting-time]");
            System.out.printf("        |      Fitness     |      Conflicts   " );
            System.out.print("---------------------------------------------------------------");
            System.out.println("---------------------------------------------------------------");
            population = geneticAlgorithm.evolve(population).sortByFitness();
            driver.scheduleNumb = 0;
            population.getSchedules().forEach(schedule -> System.out.println("      " + driver.scheduleNumb++ +
                    "    | " + schedule + " | " +
                    String.format("%.5f", schedule.getFitness()) +
                    " |  " + schedule.getNumberOfConflicts()
            ));
            driver.printScheduleTable(population.getSchedules().get(0), generationNumber);
            driver.classNumb = 1;
        }
    }

    private void printScheduleTable(Schedule schedule, int generation){
        ArrayList<Class> classes = schedule.getClasses();
        System.out.print("\n    ");
        System.out.println("Class #  |     Dept     | Course (Numb, max # of students) | Room (Capacity) |  Instructor(ID)   | MeetingTime(ID)");
        System.out.print("      ");
        System.out.print("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");
        classes.forEach(x->{
            int majorIndex = data.getDepartments().indexOf(x.getDept());
            int courseIndex =data.getCourses().indexOf(x.getCourse());
            int roomsIndex = data.getRooms().indexOf(x.getRoom());
            int instructorsIndex = data.getInstructors().indexOf(x.getInstructor());
            int meetingTimeIndex = data.getMeetingTimes().indexOf(x.getMeetingTime());
            System.out.print("      ");
            System.out.print(String.format("  %1$02d ", classNumb)+" | ");
            System.out.print(String.format("%1$4s", data.getDepartments().get(majorIndex).getName() + "  | "));
            System.out.print(String.format("%1$21s", data.getCourses().get(courseIndex).getNumber()+", "+
                    data.getCourses().get(courseIndex).getName()+", "+
                    x.getCourse().getMaxNumbOfStudents()+"("+x.getCourse().getMaxNumbOfStudents())+")           | ");
            System.out.print(String.format("%1$10s", data.getRooms().get(roomsIndex).getNumber() +
                    " ("+x.getRoom().getSeatingCapacity()) +")     | " );
            System.out.print(String.format("%1$15s", data.getInstructors().get(instructorsIndex).getName() +
                    " ("+data.getInstructors().get(instructorsIndex).getId()+")") +"   |  ");
            System.out.println(data.getMeetingTimes().get(meetingTimeIndex).getTime()+
                    " ("+data.getMeetingTimes().get(meetingTimeIndex).getId()+")");
            System.out.println("---");
            classNumb++;
        });
        if(schedule.getFitness() == 1){
            System.out.println("> solution found in "+(generation+1)+" generations");
            System.out.print("----------------------------------------------------");
            System.out.println("----------------------------------------------------");
        }
    }

    // In ra các thông tin có trong data như giáo viên phòng học
    private void printAvailableData() {

        System.out.println("Available Department ==> ");
        data.getDepartments().forEach(x -> System.out.println("name: " + x.getName() + ", course: " + x.getCourses()));
        System.out.println();

        System.out.println("\nAvailable Course ==> ");
        data.getCourses().forEach(x -> System.out.println("course #: " + x.getNumber() + ", name: " + x.getName()
                + ", max # of students: " + x.getMaxNumbOfStudents() + ", instructors: " + x.getInstructors()));
        System.out.println();

        System.out.println("Available Rooms ==> ");
        data.getRooms().forEach(x -> System.out.println("room #: " + x.getNumber() + ", max seating capacity: " + x.getSeatingCapacity()));
        System.out.println();

        System.out.println("Available Instructor ==> ");
        data.getInstructors().forEach(x -> System.out.println("id: " + x.getId() + ", name: " + x.getName()));
        System.out.println();

        System.out.println("Available MeetingTime ==> ");
        data.getMeetingTimes().forEach(x -> System.out.println("id: " + x.getId() + ", MeetingTime: " + x.getTime()));
        System.out.print("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");
    }
}
