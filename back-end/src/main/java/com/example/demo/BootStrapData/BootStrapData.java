package com.example.demo.BootStrapData;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository){
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception{

        if (customerRepository.count() == 1) {
            Customer anthony = new Customer();
            anthony.setFirstName("Anthony");
            anthony.setLastName("Szabo");
            anthony.setAddress("51 Drumlin Rd");
            anthony.setPhone("8604089348");
            anthony.setPostal_code("06092");
            anthony.setDivision(divisionRepository.getReferenceById(6L));
            customerRepository.save(anthony);

            Customer jay = new Customer();
            jay.setFirstName("Jay");
            jay.setLastName("de la Rosa");
            jay.setAddress("11015 St Rd 64");
            jay.setPhone("9419089241");
            jay.setPostal_code("34212");
            jay.setDivision(divisionRepository.getReferenceById((9L)));
            customerRepository.save(jay);

            Customer meg = new Customer();
            meg.setFirstName("Megan");
            meg.setLastName("Sawyer");
            meg.setAddress("442 13th St");
            meg.setPhone("3024069922");
            meg.setPostal_code("19902");
            meg.setDivision(divisionRepository.getReferenceById(7L));
            customerRepository.save(meg);

            Customer sarah = new Customer();
            sarah.setFirstName("Sarah");
            sarah.setLastName("Lawry");
            sarah.setAddress("10th St");
            sarah.setPhone("9172647210");
            sarah.setPostal_code("11221");
            sarah.setDivision(divisionRepository.getReferenceById(31L));
            customerRepository.save(sarah);

            Customer zach = new Customer();
            zach.setFirstName("Zach");
            zach.setLastName("Dunny");
            zach.setAddress("100 Main St");
            zach.setPhone("4134141900");
            zach.setPostal_code("01201");
            zach.setDivision(divisionRepository.getReferenceById(20L));
            customerRepository.save(zach);

        }
    }
}
