package com.masai.controller;

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

import com.masai.exception.LoginException;
import com.masai.exception.SeedException;
import com.masai.model.Seed;
import com.masai.service.SeedService;

	@RestController
	@RequestMapping("/seeds")
	public class SeedServiceController {

	    @Autowired
	    private SeedService seedService;

	    @PostMapping("/{key}")
	    public ResponseEntity<Seed> addSeed(@RequestBody Seed seed, @PathVariable("key") String key) {
	        try {
	            Seed savedSeed = seedService.addSeed(seed, key);
	            return new ResponseEntity<>(savedSeed, HttpStatus.CREATED);
	        } catch (SeedException | LoginException e) {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }
	    }

	    @PutMapping("/{key}")
	    public ResponseEntity<Seed> updateSeed(@RequestBody Seed seed, @PathVariable("key") String key) {
	        try {
	            Seed updatedSeed = seedService.updateSeed(seed, key);
	            return new ResponseEntity<>(updatedSeed, HttpStatus.OK);
	        } catch (SeedException | LoginException e) {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }
	    }

	    @DeleteMapping("/{seedId}/{key}")
	    public ResponseEntity<Seed> deleteSeed(@PathVariable("seedId") Integer seedId, @PathVariable("key") String key) {
	        try {
	            Seed deletedSeed = seedService.deleteSeed(seedId, key);
	            return new ResponseEntity<>(deletedSeed, HttpStatus.OK);
	        } catch (SeedException | LoginException e) {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }
	    }

	    @GetMapping("/{seedId}/{key}")
	    public ResponseEntity<Seed> viewSeed(@PathVariable("seedId") Integer seedId, @PathVariable("key") String key) {
	        try {
	            Seed seed = seedService.viewSeed(seedId, key);
	            return new ResponseEntity<>(seed, HttpStatus.OK);
	        } catch (SeedException | LoginException e) {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }
	    }

	    @GetMapping("/common-name/{commonName}/{key}")
	    public ResponseEntity<Seed> viewSeed(@PathVariable("commonName") String commonName, @PathVariable("key") String key) {
	        try {
	            Seed seed = seedService.viewSeed(commonName, key);
	            return new ResponseEntity<>(seed, HttpStatus.OK);
	        } catch (SeedException | LoginException e) {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }
	    }

	    @GetMapping("/{key}")
	    public ResponseEntity<List<Seed>> viewAllSeeds(@PathVariable("key") String key) {
	        try {
	            List<Seed> seeds = seedService.viewAllSeeds(key);
	            return new ResponseEntity<>(seeds, HttpStatus.OK);
	        } catch (SeedException | LoginException e) {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }
	    }

	    @GetMapping("/type-of-seed/{typeOfSeed}/{key}")
	    public ResponseEntity<List<Seed>> viewAllSeeds(@PathVariable("typeOfSeed") String typeOfSeed, @PathVariable("key") String key) {
	        try {
	            List<Seed> seeds = seedService.viewAllSeeds(typeOfSeed, key);
	            return new ResponseEntity<>(seeds, HttpStatus.OK);
	        } catch (SeedException | LoginException e) {
	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }
	        }

}
