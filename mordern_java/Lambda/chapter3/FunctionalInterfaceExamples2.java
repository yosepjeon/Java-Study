package mordern_java.Lambda.chapter3;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalInterfaceExamples2 {
	public static void main(String[] args) {
		final List<Product> products = Arrays.asList(
				new Product(1L, "A", new BigDecimal("10.00")),
				new Product(2L, "B", new BigDecimal("55.50")),
				new Product(3L, "C", new BigDecimal("17.45")),
				new Product(4L, "D", new BigDecimal("23.00")),
				new Product(5L, "E", new BigDecimal("110.99"))
		);
		
//		BigDecimal twenty = new BigDecimal("20"); // 값이 바뀌기 쉽다.
//		List<Product> result = new ArrayList<>();
//		for(final Product product : products) {
//			if(product.getPrice().compareTo(twenty) >= 0) {
//				result.add(product);
//			}
//		}
		
//		List<Product> result = filter(products,p -> p.getPrice().compareTo(new BigDecimal("20")) >= 0);
//		System.out.println(result);
		
		System.out.println("products >= $20: " + filter(products,p -> p.getPrice().compareTo(new BigDecimal("20")) >= 0));
		System.out.println("products <= $10: " + filter(products,p -> p.getPrice().compareTo(new BigDecimal("10")) <= 0));
		
		final List<Product> expensiveProducts = filter(products, product -> product.getPrice().compareTo(new BigDecimal("50")) > 0);
		
//		List<DiscountedProduct> discountedProducts = new ArrayList<>();
//		for(final Product product : expensiveProducts) {
//			discountedProducts.add(new DiscountedProduct(product.getId(), product.getName(), product.getPrice()));
//		}
		
		
		
//		System.out.println("expensive products: " + expensiveProducts);
//		System.out.println("discounted products: " + discountedProducts);
		
		System.out.println("discounted products: " + map(expensiveProducts,p -> new DiscountedProduct(p.getId(),p.getName(),p.getPrice().multiply(new BigDecimal("0.5")))));
	}
	
	private static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
		List<T> result = new ArrayList<>();
		for(final T t : list) {
			if(predicate.test(t)) {
				result.add(t);
			}
		}
		
		return result;
	}
	
	private static <T,R> List<R> map(List<T> list, Function<T,R> function) {
		List<R> discountedProducts = new ArrayList<>();
		for(final T product : list) {
			discountedProducts.add(function.apply(product));
//			discountedProducts.add(new DiscountedProduct(product.getId(), product.getName(), product.getPrice()));
		}
		
		return discountedProducts;
	}
}

class Product {
	private Long id;
	private String name;
	private BigDecimal price;

	public Product() {

	}

	public Product(final Long id, final String name, final BigDecimal price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return new StringBuilder("product{").append("id=").append(id).append(", name='").append(name).append('\'')
				.append(", price=").append(price).append("}").toString();
	}

}

class DiscountedProduct extends Product {
	public DiscountedProduct(final Long id, final String name, final BigDecimal price) {
		super(id,name,price);
	}
}