package com.example.specification_4;

import static com.example.specification_4.specification.CoffeeSpecification.*;
import static com.example.specification_4.entity.Coffee.CoffeeType;

import java.util.Arrays;

import com.example.specification_4.repositories.CoffeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class Specification4Application {

    public static void main(String[] args) {
        SpringApplication.run(Specification4Application.class, args);
    }

    private final CoffeeRepository coffeeRepository;
    @Bean
    CommandLineRunner init() {
        return args -> {
            // Lấy ra user nằm trong tập ID đã cho và có type là HOT
            // hoặc lấy ra user có ID = 5
            Specification specification = Specification.where(hasIdIn(Arrays.asList(1L, 2L, 3L, 4L)))
                    .and(hasType(CoffeeType.HOT))
                    .or(hasId(5L));
            // Truyền Specification vào hàm findAll()
            coffeeRepository.findAll(specification).forEach(System.out::println);
        };
    }

}
