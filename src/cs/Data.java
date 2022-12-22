package cs;

import cs.domain.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Data {

    private ArrayList<Room> rooms;
    private ArrayList<Instructor> instructors;
    private ArrayList<Course> courses;
    private ArrayList<Department> departments;
    private ArrayList<MeetingTime> meetingTimes;
    private int numberOfClass = 0;

    public Data() {
        initialize();
    }

    //create data
    public Data initialize(){
        // room
        Room room1 = new Room("P101", 25);
        Room room2 = new Room("P102", 45);
        Room room3 = new Room("P103", 35);
        Room room4 = new Room("P201", 60);
        Room room5 = new Room("P202", 20);
        Room room6 = new Room("P203", 20);
        rooms = new ArrayList<Room>(Arrays.asList(room1, room2, room3, room4, room5, room6));

        //meeting
        MeetingTime meetingTime1 = new MeetingTime("t2-k1", "Thu 2 07:00 - 08:50");
        MeetingTime meetingTime2 = new MeetingTime("t2-k2", "Thu 2 09:00 - 10:50");
        MeetingTime meetingTime3 = new MeetingTime("t2-k3", "Thu 2 12:00 - 13:50");
        MeetingTime meetingTime4 = new MeetingTime("t2-k4", "Thu 2 14:00 - 15:50");
        MeetingTime meetingTime5 = new MeetingTime("t2-k5", "Thu 2 16:00 - 17:50");
        MeetingTime meetingTime6 = new MeetingTime("t2-k6", "Thu 2 18:00 - 19:50");

        MeetingTime meetingTime7 = new MeetingTime("t3-k1", "Thu 3 07:00 - 08:50");
        MeetingTime meetingTime8 = new MeetingTime("t3-k2", "Thu 3 09:00 - 10:50");
        MeetingTime meetingTime9 = new MeetingTime("t3-k3", "Thu 3 12:00 - 13:50");
        MeetingTime meetingTime10 = new MeetingTime("t3-k4", "Thu 3 14:00 - 15:50");
        MeetingTime meetingTime11 = new MeetingTime("t3-k5", "Thu 3 16:00 - 17:50");
        MeetingTime meetingTime12 = new MeetingTime("t3-k6", "Thu 3 18:00 - 19:50");

        MeetingTime meetingTime13 = new MeetingTime("t4-k1", "Thu 4 07:00 - 08:50");
        MeetingTime meetingTime14 = new MeetingTime("t4-k2", "Thu 4 09:00 - 10:50");
        MeetingTime meetingTime15 = new MeetingTime("t4-k3", "Thu 4 12:00 - 13:50");
        MeetingTime meetingTime16 = new MeetingTime("t4-k4", "Thu 4 14:00 - 15:50");
        MeetingTime meetingTime17 = new MeetingTime("t4-k5", "Thu 4 16:00 - 17:50");
        MeetingTime meetingTime18 = new MeetingTime("t4-k6", "Thu 4 18:00 - 19:50");

        MeetingTime meetingTime19 = new MeetingTime("t5-k1", "Thu 5 07:00 - 08:50");
        MeetingTime meetingTime20 = new MeetingTime("t5-k2", "Thu 5 09:00 - 10:50");
        MeetingTime meetingTime21 = new MeetingTime("t5-k3", "Thu 5 12:00 - 13:50");
        MeetingTime meetingTime22 = new MeetingTime("t5-k4", "Thu 5 14:00 - 15:50");
        MeetingTime meetingTime23 = new MeetingTime("t5-k5", "Thu 5 16:00 - 17:50");
        MeetingTime meetingTime24 = new MeetingTime("t5-k6", "Thu 5 18:00 - 19:50");

        MeetingTime meetingTime25 = new MeetingTime("t6-k1", "Thu 6 07:00 - 08:50");
        MeetingTime meetingTime26 = new MeetingTime("t6-k2", "Thu 6 09:00 - 10:50");
        MeetingTime meetingTime27 = new MeetingTime("t6-k3", "Thu 6 12:00 - 13:50");
        MeetingTime meetingTime28 = new MeetingTime("t6-k4", "Thu 6 14:00 - 15:50");
        MeetingTime meetingTime29 = new MeetingTime("t6-k5", "Thu 6 16:00 - 17:50");
        MeetingTime meetingTime30 = new MeetingTime("t6-k6", "Thu 6 18:00 - 19:50");


        meetingTimes = new ArrayList<MeetingTime>
                (Arrays.asList(meetingTime1, meetingTime2, meetingTime3, meetingTime4,
                        meetingTime5, meetingTime6, meetingTime7, meetingTime8,
                        meetingTime9, meetingTime10, meetingTime11, meetingTime12,
                        meetingTime13, meetingTime14, meetingTime15, meetingTime16,
                        meetingTime17, meetingTime18, meetingTime19, meetingTime20,
                        meetingTime21, meetingTime22, meetingTime23, meetingTime24,
                        meetingTime25, meetingTime26, meetingTime27, meetingTime28,
                        meetingTime29, meetingTime30));
        // Teacher
        Instructor instructor1 = new Instructor("T1", "Nguyen Trong Khanh");
        Instructor instructor2 = new Instructor("T2", "Nguyen Manh Son");
        Instructor instructor3 = new Instructor("T3", "Nguyen Van Hoan");
        Instructor instructor4 = new Instructor("T4", "T.T.V.Anh");
        Instructor instructor5 = new Instructor("T5", "Tran Dinh Que");
        Instructor instructor6 = new Instructor("T6", "Nguyen Manh Hung");
        Instructor instructor7 = new Instructor("T7", "Dang Ngoc Hung");
        Instructor instructor8 = new Instructor("T8", "Bui Minh Cong");
        Instructor instructor9 = new Instructor("T9", "Bui Minh Chien");
        Instructor instructor10 = new Instructor("T10", "Bui Tieng Anh");
        Instructor instructor11 = new Instructor("T11", "Ngo Thi Ly");
        Instructor instructor12 = new Instructor("T12", "Nguyen Ngoc Phuong");
        Instructor instructor13 = new Instructor("T13", "Do Xuan Cho");
        Instructor instructor14 = new Instructor("T14", "Trinh Van Quyet");
        Instructor instructor15 = new Instructor("T15", "Ngo Thi Mai");
        instructors = new ArrayList<Instructor>(Arrays.asList(instructor1, instructor2,
                instructor3, instructor4, instructor5, instructor6, instructor7, instructor8,
                instructor9, instructor10, instructor11, instructor12, instructor13, instructor14, instructor15));

        // Course môn học
        Course course1 = new Course("C1", "HDV",
                25,  new ArrayList<Instructor>(Arrays.asList(instructor1, instructor7)));
        Course course2 = new Course("C2", "LTM",
                35,  new ArrayList<Instructor>(Arrays.asList(instructor1, instructor6, instructor7)));
        Course course3 = new Course("C3", "LTW",
                25,  new ArrayList<Instructor>(Arrays.asList(instructor3, instructor2)));
        Course course4 = new Course("C4", "ANDROID",
                30,  new ArrayList<Instructor>(Arrays.asList(instructor4, instructor8, instructor9)));
        Course course5 = new Course("C5", "IOS",
                35,  new ArrayList<Instructor>(Arrays.asList(instructor4, instructor9)));
        Course course6 = new Course("C6", "Dai so",
                45,  new ArrayList<Instructor>(Arrays.asList(instructor12, instructor14)));
        Course course7 = new Course("C7", "Giai tich 1",
                45,  new ArrayList<Instructor>(Arrays.asList(instructor12, instructor14, instructor15)));
        Course course8 = new Course("C8", "Giai tich 2",
                50,  new ArrayList<Instructor>(Arrays.asList(instructor12, instructor14, instructor15)));
        Course course9 = new Course("C9", "Tieng Anh 1",
                60,  new ArrayList<Instructor>(Arrays.asList(instructor10)));
        Course course10 = new Course("C10", "Triet 1",
                45,  new ArrayList<Instructor>(Arrays.asList(instructor11, instructor13)));
        courses = new ArrayList<Course>(Arrays.asList(course1, course2, course3, course4,
                course5, course6, course7, course8, course9, course10));
        // Khoa
        Department dept1 = new Department("Mon co so", new ArrayList<Course>(Arrays.asList(course6, course7
                            ,course8, course9, course10)));
        Department dept2 = new Department("CNTT", new ArrayList<Course>(Arrays.asList(course4, course5,
                             course1, course3, course3)));
        Department dept3 = new Department("ATTT", new ArrayList<Course>(Arrays.asList(course2)));

        departments = new ArrayList<Department>(Arrays.asList(dept1, dept2, dept3));
        // số lớp bằng size departments.getCourse
        departments.forEach(x -> numberOfClass+=x.getCourses().size());

        return this;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public ArrayList<Instructor> getInstructors() {
        return instructors;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public ArrayList<MeetingTime> getMeetingTimes() {
        return meetingTimes;
    }

    public int getNumberOfClass() {
        return numberOfClass;
    }


}
