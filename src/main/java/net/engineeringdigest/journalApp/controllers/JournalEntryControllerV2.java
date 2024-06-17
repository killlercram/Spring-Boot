package net.engineeringdigest.journalApp.controllers;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

    @Autowired
    private JournalEntryService journalEntryService;


    @GetMapping
    public List<JournalEntry> getAll(){
        return journalEntryService.getAll();

    }
    @PostMapping
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry MyEntry){
        try {
            MyEntry.setDate(LocalDateTime.now());
            journalEntryService.saveEntry(MyEntry);
            return new ResponseEntity<>(MyEntry, HttpStatus.OK);
        }
        catch(Exception e){

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping("id/{myId}")
    public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable ObjectId myId){
        Optional<JournalEntry> journalEntry= journalEntryService.findById(myId);
        if(journalEntry.isPresent()) {
            return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    //Deleting Particular Entry
    @DeleteMapping("id/{myId}")
    public boolean deleteJournalById(@PathVariable ObjectId myId){
        journalEntryService.deleteById(myId);
        return true;
    }

    //Updating Particular Entry
    @PutMapping("id/{id}")
    public ResponseEntity<?> UpdateJournalById(@PathVariable ObjectId id,@RequestBody JournalEntry newEntry){
       JournalEntry old=journalEntryService.findById(id).orElse(null);
       if(old!=null) {
           old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : old.getTitle());
           old.setContent(newEntry.getContent() != null && !newEntry.equals("") ? newEntry.getContent() : old.getContent());

           journalEntryService.saveEntry(old);
           return new ResponseEntity<>(old,HttpStatus.OK);
       }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }



}
