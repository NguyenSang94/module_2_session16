package session16_Kha2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event {
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public Event(String name, LocalDateTime startDate, LocalDateTime endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public String getStatus() {
        LocalDateTime now = LocalDateTime.now();

        if (now.isBefore(startDate)) {
            return "Sắp diễn ra";
        } else if (now.isAfter(endDate)) {
            return "Đã kết thúc";
        } else {
            return "Đang diễn ra";
        }
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        return "Sự kiện: " + name +
                " | Bắt đầu: " + startDate.format(formatter) +
                " | Kết thúc: " + endDate.format(formatter) +
                " | Trạng thái: " + getStatus();
    }
}

