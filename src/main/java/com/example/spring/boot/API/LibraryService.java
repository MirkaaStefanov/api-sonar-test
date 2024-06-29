package com.example.spring.boot.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {
    private final LibraryRepository libraryRepository;

    @Autowired
    public LibraryService(LibraryRepository productRepository) {
        this.libraryRepository = productRepository;
    }

    public ResponseEntity<Library> saveLibrary(Library product) {
        return ResponseEntity.ok(libraryRepository.save(product));
    }

    public List<Library> getAllLibrary() {
        return libraryRepository.findAll();
    }

    public Optional<Library> getLibraryById(Long id) {
        return libraryRepository.findById(id);
    }

    public ResponseEntity<Library> updateLibrary(Long id, Library updatedProduct) {
        Optional<Library> existingLibrary = libraryRepository.findById(id);
        if (existingLibrary.isPresent()) {
            Library library = existingLibrary.get();
            library.setName(updatedProduct.getName());
            library.setLocation(updatedProduct.getLocation());
            library.setUsers(updatedProduct.getUsers());
            libraryRepository.save(library);
            return ResponseEntity.ok(library);
        } else {
            throw new RuntimeException("Product not found");
        }
    }

    public void deleteLibrary(Long id) {
        libraryRepository.deleteById(id);
    }

}
