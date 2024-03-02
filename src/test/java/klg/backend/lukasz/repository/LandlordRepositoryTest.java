package klg.backend.lukasz.repository;

import klg.backend.lukasz.model.Landlord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class LandlordRepositoryTest {

    @Autowired
    private LandlordRepository landlordRepository;

    @Test
    public void whenFindingCustomerById_thenCorrect() {
        landlordRepository.save(new Landlord("John Smith"));
        assertThat(landlordRepository.findById(1L)).isInstanceOf(Optional.class);
    }

    @Test
    public void whenFindingAllCustomers_thenCorrect() {
        landlordRepository.save(new Landlord("John Smith"));
        landlordRepository.save(new Landlord("Juile Smith"));
        assertThat(landlordRepository.findAll()).isInstanceOf(List.class);
    }

}
