package cs;

import cs.domain.Class;
import cs.domain.Department;

import java.util.ArrayList;

public class Schedule {

    private ArrayList<Class> classes;
    private int classNumb = 0;
    private boolean isFitnessChanged = true;
    private double fitness = -1;
    private int numberOfConflicts = 0;
    private Data data;

    public Data getData() {
        return data;
    }

    public Schedule(Data data) {// hàm tạo số lớp schedule
        this.data = data;
        classes = new ArrayList<Class>(data.getNumberOfClass()); // lấy ra số lớp cần tạo trong tkb
    }

    // tạo cá thể schedule ngẫu nhiên
    public Schedule initialize() { // -----1-----
        new ArrayList<Department>(data.getDepartments()).forEach(dept -> { // loop các phòng ban
            dept.getCourses().forEach(course -> { // duyệt các course trong department
                Class newClass = new Class(classNumb++, dept, course); // tạo lớp
                newClass.setMeetingTime(data.getMeetingTimes().get(       // set slot ngẫu nhiên trong list meetting time
                        (int) (data.getMeetingTimes().size() * Math.random())));
                newClass.setRoom(data.getRooms().get( //set room ngẫu nhiên trong list room
                        (int) (data.getRooms().size() * Math.random())));
                newClass.setInstructor(course.getInstructors().get( // set giáo viên ngẫu nhiên trong list giáo viên
                        (int) (course.getInstructors().size() * Math.random())));
                classes.add(newClass); // thêm class mới vào list class
            });
        });
        return this; // trả về schedule
    }

    //lấy ra số xung đột
    public int getNumberOfConflicts() {
        return numberOfConflicts;
    }

    // thể trạng thốt trả về danh sách lớp
    public ArrayList<Class> getClasses() {
        isFitnessChanged = true;
        return classes;
    }


    public double getFitness() {
        if (isFitnessChanged == true) { // nếu trạng thái true thì tiến hành đánh giá
            fitness = calculateFitness();
            isFitnessChanged = false;
        }
        return fitness;
    }

    // tính toán đánh giá thể trạng => b2 đánh giá năng lực độ thích nghi của từng cá thể
    public double calculateFitness() {
        numberOfConflicts = 0; // conflict = 0
        classes.forEach(x -> {
            // sức chứa phòng < số lượng sv trong course => conflict
            if (x.getRoom().getSeatingCapacity() < x.getCourse().getMaxNumbOfStudents()) numberOfConflicts++;
            // lọc
            classes.stream().filter(y -> classes.indexOf(y) >= classes.indexOf(x)).forEach(y -> {
                if (x.getMeetingTime() == y.getMeetingTime() && x.getId() != y.getId()) { // kíp học trùng !ID
                    if (x.getRoom() == y.getRoom()) numberOfConflicts++; //  cùng phòng
                    if (x.getInstructor() == y.getInstructor()) numberOfConflicts++; // cùng giảng viên
                }
            });
        });

        return 1 / (double) (numberOfConflicts + 1); // đưa ra tỉ lệ năng lực bằng 1/(conf + 1)*100%
    }

    @Override
    public String toString() {
        String result = new String();
        for (int x = 0; x < classes.size() - 1; x++) {
            result += classes.get(x) + ", ";
        }
        result += classes.get(classes.size() - 1);
        return result;
    }
}
