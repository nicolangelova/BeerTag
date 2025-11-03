package com.example.beertag.repositories;

import com.example.beertag.exceptions.EntityNotFoundException;
import com.example.beertag.models.Beer;

import java.util.ArrayList;
import java.util.List;

public class BeerRepositoryImpl {

    private List<Beer> beers;

    public BeerRepositoryImpl() {
        beers = new ArrayList<Beer>();

        beers.add(new Beer(1,"Glarus English Ale",4.6));
        beers.add(new Beer(2,"Rhombus Porter", 5));
    }

    public List<Beer> getAll() {
        return beers;
    }

    public Beer getById(int id){
        return beers.stream()
                .filter(beer->beer.getId()==id)
                .findFirst()
                .orElseThrow(()-> new EntityNotFoundException("Beer", id));
    }

    public Beer getByName(String name){
        return beers.stream()
                .filter(beer -> beer.getName().equals(name))
                .findFirst()
                .orElseThrow(()-> new EntityNotFoundException("Beer", "name", name));
    }

    public void  create(Beer beer){
        beers.add(beer);
    }

    public void update(Beer beer){
        Beer beerToUpdate = getById(beer.getId());
        beerToUpdate.setName(beer.getName());
        beerToUpdate.setAbv(beer.getAbv());
    }

    public void delete(int id) {
        Beer beerToDelete = getById(id);
        beers.remove(beerToDelete);
    }















}
