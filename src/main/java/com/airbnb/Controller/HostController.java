package com.airbnb.Controller;

import com.airbnb.Exception.HostException;
import com.airbnb.Model.Host;
import com.airbnb.Service.HostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hosts")
public class HostController {

    @Autowired
    private HostService hostService;

    @PostMapping
    public ResponseEntity<Host> createHostHandler(@Valid @RequestBody Host host){
        Host hostResponse=hostService.createHost(host);

        return new ResponseEntity<Host>(hostResponse, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Host>> getHostByIdHandler(@PathVariable Integer id)throws HostException{

        Optional<Host> host=hostService.getHostById(id);

        return new ResponseEntity<>(host,HttpStatus.OK);

    }
    @GetMapping
    public ResponseEntity<List<Host>> getAllHostHandler()throws HostException{

        List<Host> hosts=hostService.getAllHosts();

        return new ResponseEntity<>(hosts,HttpStatus.OK);

   }

   @PutMapping("/{id}")
   public ResponseEntity<Host> updateHostHandler( @PathVariable Integer id,@Valid @RequestBody Host host)throws HostException{

        Host host1=hostService.updateHost(id,host);

        return new ResponseEntity<>(host1,HttpStatus.ACCEPTED);

   }
   @DeleteMapping("/{id}")
   public ResponseEntity<String> deleteHostHandler(@PathVariable Integer id)throws HostException{
        String host=hostService.deleteHost(id);

        return new ResponseEntity<>(host,HttpStatus.ACCEPTED);

   }
}
