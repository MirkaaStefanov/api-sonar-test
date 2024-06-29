package com.example.spring.boot.API;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
public class LibraryTest {

    @Autowired
    LibraryRepository libraryRepository;

    @Test
    public void givenGenericEntityRepository_whenSaveAndRetreiveEntity_thenOK() {
        Library library = libraryRepository
                .save(new Library("testActor","Targovishte", 28));
        Library foundEntity = libraryRepository.findById(library.getId()).orElse(null);
        assertNotNull(foundEntity);
        assertEquals(library.getName(), foundEntity.getName());
    }
    @Test
    public void testHowManyRows(){
        List<Library> actorEntityList = libraryRepository.findAll();
        assertEquals(4, actorEntityList.size());
    }
}
