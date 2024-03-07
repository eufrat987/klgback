package klg.backend.lukasz.repository;

import klg.backend.lukasz.repository.LandlordRepository;
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
        assertThat(landlordRepository.findById("Bruce Wayne")).isInstanceOf(Optional.class);
        assertThat(landlordRepository.findById("Bruce Wayne").isPresent()).isEqualTo(true);
    }

    @Test
    public void whenFindingAllCustomers_thenCorrect() {
        assertThat(landlordRepository.findAll()).isInstanceOf(List.class);
        assertThat(landlordRepository.findAll().size()).isEqualTo(2);
    }

}
