package klg.backend.lukasz.repository;

import klg.backend.lukasz.repository.PropertyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class PropertyRepositoryTest {

    @Autowired
    private PropertyRepository propertyRepository;

    @Test
    public void whenFindingAll_thenCorrect() {
//        assertThat(landlordRepository.findAll()).isInstanceOf(List.class);
//        assertThat(landlordRepository.findAll().size()).isEqualTo(2);
    }

}
