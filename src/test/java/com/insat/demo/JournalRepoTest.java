package com.insat.demo;
import com.insat.demo.entity.Journal;
import com.insat.demo.entity.Journaliste;
import com.insat.demo.entity.Personality;
import com.insat.demo.repositories.JournalRepository;
import com.insat.demo.repositories.PersonalityRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;



@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class JournalRepoTest {
    @Autowired
    private JournalRepository journalRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveJournalTest() {
        Journaliste journaliste=Journaliste.builder()
                .id_journaliste(5)
                .name("Florence")
                .birthday("18/08/1980")
                .build();
        Journal journal = Journal.builder()
                .name("Figaro")
                .address("France")
                .journaliste(journaliste)
                .build();

        journalRepository.save(journal);

        Assertions.assertThat( journal.getId()).isGreaterThan( 0);
    }
    @Test
    @Order(3)
    @Rollback(value = false)
    public void updateJournalTest(){

        Journal journal = journalRepository.findById(2L).get();

        journal.setName("Emile");

        Journal journalUpdated =  journalRepository.save(journal);

        Assertions.assertThat(journalUpdated.getName()).isEqualTo("Emile");

    }
}
