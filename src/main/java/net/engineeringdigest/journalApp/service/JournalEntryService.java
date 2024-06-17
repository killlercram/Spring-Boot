package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {
    @Autowired
    private JournalEntryRepository journalEntryRepository;
//    we are injecting JournalEntryRepository in this class

//    making a method to save the details
    public void saveEntry(JournalEntry journalEntry){
        journalEntryRepository.save((journalEntry));
    }

    //Making method which will get the entries of the database and will return the list
   public List<JournalEntry> getAll(){
        return journalEntryRepository.findAll();
   }

   //Making methods for finding Journal Entry By ID:
    public Optional<JournalEntry> findById(ObjectId id){
        return journalEntryRepository.findById(id);
    }

    //Making methods for deleting by Id:
    public void deleteById(ObjectId id){
        journalEntryRepository.deleteById(id);
    }
}
//controller ---> Service ----> repository