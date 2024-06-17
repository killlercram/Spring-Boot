//package net.engineeringdigest.journalApp.controllers;
//
//import net.engineeringdigest.journalApp.entity.JournalEntry;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.*;
//
//@RestController
//@RequestMapping("/_journal")
//public class JournalEntryController {
//
//    private  Map<Long, JournalEntry> JEntries=new HashMap<>();
//
//    @GetMapping
//    public List<JournalEntry> getAll(){
//        return new ArrayList<>(JEntries.values());
//
//    }
//    @PostMapping
//    public boolean createEntry(@RequestBody JournalEntry MyEntry){
//        JEntries.put(MyEntry.getId(),MyEntry);
//        return true;
//    }
//    @GetMapping("id/{myId}")
//    public JournalEntry getJournalEntryById(@PathVariable Long myId){
//        return JEntries.get(myId);
//    }
//    //Deleting Particular Entry
//    @DeleteMapping("id/{myId}")
//    public JournalEntry deleteJournalById(@PathVariable Long myId){
//        return JEntries.remove(myId);
//    }
//    //Updating Particular Entry
//    @PutMapping("id/{Id}")
//    public JournalEntry UpdateJournalById(@PathVariable Long Id,@RequestBody JournalEntry MyEntry){
//        return JEntries.put(Id,MyEntry);
//    }
//
//
//
//}
