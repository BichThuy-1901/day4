package main;

import configuration.JPAConfig;
import entity.CustomerEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.CustomerRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class MainCustomer {
    static ApplicationContext context = new AnnotationConfigApplicationContext(JPAConfig.class);
    static CustomerRepository customerRepository = context.getBean(CustomerRepository.class);

    public static void main(String[] args) {
//        List<CustomerEntity> customers = List.of(
//                new CustomerEntity("Bich Thuy", LocalDate.of(2000, 1, 19), "Female", "thuy@gmail.com", 1234567890, "Hoi An"),
//                new CustomerEntity("Han Han", LocalDate.of(1992, 5, 20), "Male", "han@gmail.com", 234567891, "Quang Nam"),
//                new CustomerEntity("Ly Na", LocalDate.of(1997, 9, 21), "Male", "na@gmail.com", 345678912, "Da Nang")
//        );
//        addListCustomer(customers);
//        listAllCustomers();
//        findCustomerById(1);
//        findCustomersByName("Bich Thuy");
//        findCustomersByPhoneOrEmail(123456789, "thuy@gmail.com");
        listMenAgedBetween20And30("male");
    }

//    private static void addListCustomer(List<CustomerEntity> customers) {
//        for (CustomerEntity customer : customers) {
//            customerRepository.save(customer);
//            System.out.println("Added customer: " + customer);
//        }
//    }

    //    private static void listAllCustomers() {
//        List<CustomerEntity> customers = customerRepository.findAll();
//        for (CustomerEntity customer : customers) {
//            System.out.println(customer);
//        }
//    }
//
//    private static void findCustomerById(int id) {
//        Optional<CustomerEntity> customerOpt = customerRepository.findById(id);
//        if (customerOpt.isPresent()) {
//            CustomerEntity customer = customerOpt.get();
//            System.out.println(customer);
//        } else {
//            System.out.println("Customer not found with ID: " + id);
//        }
//    }

//
//    private static void findCustomersByName(String name) {
//        List<CustomerEntity> customers = customerRepository.findByName(name);
//        for (CustomerEntity customer : customers) {
//            System.out.println(customer);
//        }
//    }
//
//    private static void findCustomersByPhoneOrEmail(int phone, String email) {
//        List<CustomerEntity> customers = customerRepository.findByPhoneOrEmail(phone, email);
//        for (CustomerEntity customer : customers) {
//            System.out.println(customer);
//        }
//    }
//
    public static void listMenAgedBetween20And30(String sex) {
        List<CustomerEntity> customers = customerRepository.findMenAgedBetween20And30(sex);
        for (CustomerEntity customer : customers) {
            System.out.println(customer);
        }
    }
}

