package klg.backend.lukasz.property;

import klg.backend.lukasz.landlord.LandlordRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

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
