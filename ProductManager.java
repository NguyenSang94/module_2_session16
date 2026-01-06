package session16_Kha1;

import java.util.HashMap;
import java.util.Scanner;

public class ProductManager {
    static HashMap<Integer, Product> productMap = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

     static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    updateProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    showProducts();
                    break;
                case 5:
                    filterProducts();
                    break;
                case 6:
                    totalPrice();
                    break;
                case 0:
                    System.out.println("Thoát chương trình!");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    // ================= MENU =================
    static void showMenu() {
        System.out.println("\n===== QUẢN LÝ SẢN PHẨM =====");
        System.out.println("1. Thêm sản phẩm");
        System.out.println("2. Sửa sản phẩm");
        System.out.println("3. Xóa sản phẩm");
        System.out.println("4. Hiển thị sản phẩm");
        System.out.println("5. Lọc sản phẩm (price > 100)");
        System.out.println("6. Tính tổng giá trị sản phẩm");
        System.out.println("0. Thoát");
        System.out.print("Chọn chức năng: ");
    }

    // ================= CRUD =================
    static void addProduct() {
        System.out.print("Nhập ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        if (productMap.containsKey(id)) {
            System.out.println("ID đã tồn tại!");
            return;
        }

        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();

        System.out.print("Nhập giá: ");
        double price = Double.parseDouble(scanner.nextLine());

        productMap.put(id, new Product(id, name, price));
        System.out.println("Thêm sản phẩm thành công!");
    }

    static void updateProduct() {
        System.out.print("Nhập ID cần sửa: ");
        int id = Integer.parseInt(scanner.nextLine());

        Product product = productMap.get(id);
        if (product == null) {
            System.out.println("Không tìm thấy sản phẩm!");
            return;
        }

        System.out.print("Tên mới: ");
        product.setName(scanner.nextLine());

        System.out.print("Giá mới: ");
        product.setPrice(Double.parseDouble(scanner.nextLine()));

        System.out.println("Cập nhật sản phẩm thành công!");
    }

    static void deleteProduct() {
        System.out.print("Nhập ID cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());

        if (productMap.remove(id) != null) {
            System.out.println("Xóa sản phẩm thành công!");
        } else {
            System.out.println("Không tìm thấy sản phẩm!");
        }
    }

    static void showProducts() {
        if (productMap.isEmpty()) {
            System.out.println("Danh sách sản phẩm rỗng!");
            return;
        }

        productMap.values().forEach(System.out::println);
    }

    static void filterProducts() {
        System.out.println("Sản phẩm có giá > 100:");
        productMap.values().stream()
                .filter(p -> p.getPrice() > 100)
                .forEach(System.out::println);
    }

    static void totalPrice() {
        double total = productMap.values().stream()
                .mapToDouble(Product::getPrice)
                .sum();

        System.out.println("Tổng giá trị sản phẩm: " + total);
    }
}

