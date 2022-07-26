package ducnh.springboot.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
public class WorkingHourDTO extends BaseDTO {

    private LocalTime startMorningTime;

    private LocalTime endMorningTime;

    private LocalTime startAfternoonTime;

    private LocalTime endAfternoonTime;

    private UserDTO user;

    public String toString() {
        return "Morning start time: " + startMorningTime + "		Morning end time: " + endMorningTime
                + "<br>Afternoon start time: " + startAfternoonTime + "		Afternoon end time: " + endAfternoonTime;
    }
}
