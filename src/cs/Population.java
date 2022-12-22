package cs;

import java.util.ArrayList;
import java.util.stream.IntStream;

// tạo quần thể các schedule
public class Population {

    private ArrayList<Schedule> schedules;

    public Population(int size, Data data) {  // ==> Bước 1: khởi tạo quần thể số lượng và dữ liệu có sẵn
        schedules = new ArrayList<Schedule>(size);
        // Tạo quần thể scedule
        // Thêm các scedule vào quần thể
        IntStream.range(0, size).forEach(x -> schedules.add(new Schedule(data).initialize()));
    }

    public ArrayList<Schedule> getSchedules() { // lấy ra danh sách quần thể
        return schedules;
    }

    //sắp xếp năng lực
    public Population sortByFitness() {
        schedules.sort((schedules1, schedules2) -> {
            int returnValue = 0;
            if (schedules1.getFitness() > schedules2.getFitness()) returnValue = -1;
            else if (schedules1.getFitness() < schedules2.getFitness()) returnValue = 1;
            return returnValue;
        });
        return this;
    }

}
