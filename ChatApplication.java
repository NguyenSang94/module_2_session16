package session16_Gioi1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChatApplication {

    static List<Message> messageList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    static DateTimeFormatter dateFormatter =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

     static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    sendMessage();
                    break;
                case 2:
                    showChatHistory();
                    break;
                case 3:
                    filterBySender();
                    break;
                case 4:
                    filterByDate();
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
        System.out.println("\n===== CHAT CONSOLE =====");
        System.out.println("1. Gửi tin nhắn");
        System.out.println("2. Xem lịch sử chat");
        System.out.println("3. Lọc tin nhắn theo người gửi");
        System.out.println("4. Lọc tin nhắn theo ngày");
        System.out.println("0. Thoát");
        System.out.print("Chọn chức năng: ");
    }
    static void sendMessage() {
        System.out.print("Nhập tên người gửi: ");
        String sender = scanner.nextLine();

        System.out.print("Nhập nội dung tin nhắn: ");
        String content = scanner.nextLine();

        Message message =
                new Message(sender, content, LocalDateTime.now());
        messageList.add(message);

        System.out.println("Gửi tin nhắn thành công!");
    }

    static void showChatHistory() {
        if (messageList.isEmpty()) {
            System.out.println("Chưa có tin nhắn nào!");
            return;
        }

        System.out.println("\n===== LỊCH SỬ CHAT =====");
        messageList.forEach(System.out::println);
    }

    static void filterBySender() {
        System.out.print("Nhập tên người gửi cần lọc: ");
        String sender = scanner.nextLine();

        System.out.println("\nTin nhắn của " + sender + ":");

        messageList.stream()
                .filter(m -> m.getSender().equalsIgnoreCase(sender))
                .forEach(System.out::println);
    }

    static void filterByDate() {
        try {
            System.out.print("Nhập ngày (dd/MM/yyyy): ");
            LocalDate inputDate =
                    LocalDate.parse(scanner.nextLine(), dateFormatter);

            System.out.println("\nTin nhắn trong ngày " + inputDate + ":");

            messageList.stream()
                    .filter(m ->
                            m.getTimestamp().toLocalDate().equals(inputDate))
                    .forEach(System.out::println);

        } catch (DateTimeParseException e) {
            System.err.println("Sai định dạng ngày! Định dạng đúng: dd/MM/yyyy");
        }
    }
}

