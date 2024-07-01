package com.scaler.productservicejune2024.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//this class will be hosting a set of  http API's
@RestController
@RequestMapping("/Hello")
public class SampleController {
    @GetMapping("/sayhello/{name}")
    public String sayHello(@PathVariable("name") String xyz){
        return "Helloeveryone"+ xyz;
    }
    @GetMapping("/bye/{nam}/{times}")
    public String sayBye(@PathVariable("nam")String abc,@PathVariable("times")int times){
      String output= "";
      for(int i=0; i<times; i++){
          output = output + abc +"\n" ;
      }
      return output;
    }
}
