package com.example.api;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@RestController
@RequestMapping("/api")
public class DemoAPI {

 ConcurrentMap<String,DemoDTO> demoList = new ConcurrentHashMap<>();

 @GetMapping("/")
 public Collection<DemoDTO> getAllContacts(){

  DemoDTO demoDTO = new DemoDTO();
  demoDTO.setId("foo");
  demoDTO.setName("foolish");
  demoDTO.setNumber("1234567890");
  demoList.put("foo",demoDTO);
  return demoList.values();
 }

 @GetMapping("/{name}")
 public DemoDTO getContactById(@PathVariable String name){
  return demoList.get(name);
 }

 @PutMapping("/")
 public DemoDTO addNewContact(@RequestBody DemoDTO demo){
  demoList.put(demo.getId(), demo);
  return demoList.get(demo.getId());
 }
}
