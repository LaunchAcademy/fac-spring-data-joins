package com.launchacademy.launchrpg.repositories;

import com.launchacademy.launchrpg.models.Spell;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface SpellRepository extends CrudRepository<Spell, Integer> {

}
