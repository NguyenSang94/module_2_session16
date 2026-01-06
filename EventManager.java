package session16_Kha2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EventManager {

    static List<Event> eventList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

     static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addEvent();
                    break;
                case 2:
                    showEvents();
                    break;
                case 0:
                    System.out.println("Thoát chương trình!");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
    static void showMenu() {
        System.out.println("\n===== QUẢN LÝ SỰ KIỆN =====");
        System.out.println("1. Thêm sự kiện");
        System.out.println("2. Hiển thị danh sách sự kiện");
        System.out.println("0. Thoát");
        System.out.print("Chọn chức năng: ");
    }
    static void addEvent() {
        try {
            System.out.print("Nhập tên sự kiện: ");
            String name = scanner.nextLine();

            System.out.print("Nhập thời gian bắt đầu: ");
            LocalDateTime start =
                    LocalDateTime.parse(scanner.nextLine(), formatter);

            System.out.print("Nhập thời gian kết thúc: ");
            LocalDateTime end =
                    LocalDateTime.parse(scanner.nextLine(), formatter);

            if (end.isBefore(start)) {
                System.out.println("Thời gian kết thúc phải sau thời gian bắt đầu!");
                return;
            }

            eventList.add(new Event(name, start, end));
            System.out.println("Thêm sự kiện thành công!");

        } catch (DateTimeParseException e) {
            System.out.println("Sai định dạng ngày giờ!");
        }
    }

    static void showEvents() {
        if (eventList.isEmpty()) {
            System.out.println("Danh sách sự kiện trống!");
            return;
        }

        System.out.println("\n===== DANH SÁCH SỰ KIỆN =====");
        for (Event event : eventList) {
            System.out.println(event);
        }
    }
}

