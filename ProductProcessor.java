package session15_Gioi2;

import java.util.List;
import java.util.function.Predicate;

public interface ProductProcessor {
    double calculateTotalValue(List<Product> products);

    static void printProductList(List<Product> products){
        System.out.println("Danh sách sản phẩm: ");
        for(Product p : products){
            System.out.println(p);
        }
    }
    default boolean hasExpensiveProduct(List<Product> products){
        Predicate<Product> isExpensive = product -> product.getPrice() > 100;
        for (Product p : products){
            if(isExpensive.test(p)){
                return true;
            }
        }
        return false;
    }

}
