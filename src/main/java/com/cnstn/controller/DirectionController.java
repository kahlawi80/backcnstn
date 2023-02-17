package com.cnstn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cnstn.entities.Direction;
import com.cnstn.service.BackServiceDirection;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("dir")
public class DirectionController {
	@Autowired
	BackServiceDirection backservice;
	
	@PostMapping
	public Direction createDir(@RequestBody Direction direction){
        Direction savedDir = backservice.addDirections(direction);
        return savedDir;
    }
	
	@GetMapping("directions")
	 public List<Direction> getAllDir(){
	        List<Direction> directions = backservice.AfficherListDir();
	        return directions;
	    }
	@GetMapping("{id}")
	    public Direction LoadDirectionById(@PathVariable("id") Long id){
	        Direction direction = backservice.LoadDirectionById(id);
	        return direction;
	    }
	@DeleteMapping("{id}")
    public ResponseEntity<String> deleteDirection(@PathVariable("id") Long id){
        backservice.deleteDirection(id);
        return new ResponseEntity<>("direction successfully deleted!", HttpStatus.OK);
    }
	@PutMapping("{id}")
    
    public ResponseEntity<Direction> updateDirection(@PathVariable("id") Long id,
                                           @RequestBody Direction direction){
        direction.setId(id);
        Direction updatedDirection = backservice.updateDirection(direction);
        return new ResponseEntity<>(updatedDirection, HttpStatus.OK);
    }

}
