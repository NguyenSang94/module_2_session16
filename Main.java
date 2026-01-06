package session15_Gioi2;

import java.util.ArrayList;
import java.util.List;

public class Main {
     static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 1500));
        products.add(new Product("Chuột", 50));
        products.add(new Product("Bàn phím", 120));
        ProductProcessor processor = new ProductProcessorImpl();
        if (processor.hasExpensiveProduct(products)) {
            System.out.println("Có sản phẩm đắt tiền >100");
        } else {
            System.out.println("Không có sản phẩm đắt tiền");
        }
        double total = processor.calculateTotalValue(products);
        System.out.println("Tổng giá trị sản phẩm: " + total);
        ProductProcessor.printProductList(products);
    }
}


