package com.example.spring.boot.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;
    @Autowired
    private LibraryRepository libraryRepository;

    @PostMapping("/add")
    public ResponseEntity<Library> saveLibrary(@RequestBody Library library) {
        return libraryService.saveLibrary(library);
    }

    @GetMapping("/all")
    public List<Library> getAllLibraries() {
        return libraryService.getAllLibrary();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Library> getLibraryById(@PathVariable Long id) {
        Optional<Library> product = libraryService.getLibraryById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Library> updateLibrary(@PathVariable Long id, @RequestBody Library library) {
        return libraryService.updateLibrary(id, library);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteLibrary(@PathVariable Long id) {
        libraryService.deleteLibrary(id);
        return ResponseEntity.ok("Product deleted successfully!");
    }

}
