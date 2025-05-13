package com.example.demo.controller;

import com.example.demo.Model.JournalEntry;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/Jounral")
public class JournalEntryController {
    private Map<Long, JournalEntry> jounralEntries = new HashMap<>();

    @GetMapping
    public List<JournalEntry> getAll(){
      return new ArrayList<>(jounralEntries.values());
    }

    @PostMapping
    public ResponseEntity<JournalEntry> createJournalEntry(@RequestBody JournalEntry entry){
        jounralEntries.put(entry.getId(), entry);
        return new ResponseEntity<>(entry, HttpStatus.OK);
    }

    @GetMapping("/id/{myId}")
    public JournalEntry getJournalEntry(@PathVariable long myId){
        return jounralEntries.get(myId);
    }

    @PutMapping("/{myId}")
    public boolean updateJournalEntryById(@PathVariable long myId, @RequestBody JournalEntry entry){
        jounralEntries.remove(myId);
        jounralEntries.put(myId, entry);
        return true;
    }

    @DeleteMapping("/id/{id}")
    public boolean deleteJournalEntryById(@PathVariable long id){
        jounralEntries.remove(id);
        return true;
    }
}
