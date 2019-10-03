package program;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import program.model.Customer;

import program.service.CustomerRepository;

@SpringBootApplication
public class Application {

    private final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo (CustomerRepository repository){
        return (args) -> {
            repository.save(new Customer(1, "Rick", "Bunte"));
            repository.save(new Customer(2, "Danny", "Hoogwerf"));
            repository.save(new Customer(3, "Owen", "Enkeld"));
            repository.save(new Customer(4, "Els", "Strand"));
            repository.save(new Customer(5, "Bob", "Strand"));

            //Fetch all customers
            log.info("Customers found with findAll()");
            for(Customer customer :repository.findAll()){
                log.info(customer.toString());
            }
            log.info("");

            //Fetch customer by id
            Customer customer = repository.findById(1L);
            log.info("Customer found with findById(1L)");
            log.info(customer.toString());
            log.info("");

            //Fetch customer by last name
            log.info("Customer found with findByLastName('Strand')");
            repository.findByLastName("Strand").forEach(strand -> {
                        log.info(strand.toString());
                    });
            // for (Customer strand : repository.findByLastName("Strand")) {
            // 	log.info(strand.toString());
            // }
            log.info("");

        };
    }

}