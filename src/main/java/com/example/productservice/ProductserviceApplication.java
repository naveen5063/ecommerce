package com.example.productservice;

import com.example.productservice.inheritancedemo.singletable.Mentor;
import com.example.productservice.inheritancedemo.singletable.MentorRepository;
import com.example.productservice.inheritancedemo.singletable.User;
import com.example.productservice.inheritancedemo.singletable.UserRepository;
import com.example.productservice.models.Category;
import com.example.productservice.models.Price;
import com.example.productservice.models.Product;
import com.example.productservice.repositories.CategoryRepository;
import com.example.productservice.repositories.PriceRepository;
import com.example.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class ProductserviceApplication{
//		implements CommandLineRunner {

//	private MentorRepository mentorRepository;
//
//	private UserRepository userRepository;
//	private final ProductRepository productRepository;
//	private final CategoryRepository categoryRepository;
//	private final PriceRepository priceRepository;
//
//	public ProductserviceApplication(@Qualifier("st_mr") MentorRepository mentorRepository
//	,@Qualifier("st_ur") UserRepository userRepository,
//									 ProductRepository productRepository,
//									 CategoryRepository categoryRepository,
//									 PriceRepository priceRepository){
//		this.mentorRepository = mentorRepository;
//		this.userRepository = userRepository;
//		this.productRepository = productRepository;
//		this.categoryRepository = categoryRepository;
//		this.priceRepository = priceRepository;
//	}

	public static void main(String[] args) {
		SpringApplication.run(ProductserviceApplication.class, args);
	}


//	@Override
//	public void run(String... args) throws Exception {
//		Mentor mentor = new Mentor();
//		mentor.setName("naman");
//		mentor.setEmail("naman@gmail.com");
//		mentor.setAverageRating(4.5);
//		mentorRepository.save(mentor);
//
//		User user = new User();
//		user.setName("preeti");
//		user.setEmail("preeti@gmail.com");
//		userRepository.save(user);

//		Category category = new Category();
//		category.setName("samsung Devices");
//		Category savedCategory = categoryRepository.save(category);
//
//		Price price = new Price("Rupee", 40);
//		Price savedprice = priceRepository.save(price);
//
//		Product product = new Product();
//		product.setTitle("My New samsung");
//		product.setDescription("average phone");
//		product.setCategory(category);
//		product.setPrice(price);
//		productRepository.save(product);

//		Category category1 = categoryRepository.findById(UUID.fromString("0d5f3ab7-3443-4581-8ae7-ae1510c4c526")).get();
//		System.out.println("category name" + category1.getName());
//		System.out.println("printing all categories");
//		for (Product product1 : category1.getProducts()){
//			System.out.println("product title" + product1.getTitle());
//		}
//	}
}
