package com.launchacademy.launchrpg.seeders;

import com.google.inject.internal.util.Lists;
import com.launchacademy.launchrpg.models.Archetype;
import com.launchacademy.launchrpg.models.PlayerCharacter;
import com.launchacademy.launchrpg.models.School;
import com.launchacademy.launchrpg.models.Spell;
import com.launchacademy.launchrpg.repositories.ArchetypeRepository;
import com.launchacademy.launchrpg.repositories.PlayerCharacterRepository;
import com.launchacademy.launchrpg.repositories.SchoolRepository;
import com.launchacademy.launchrpg.repositories.SpellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoSeeder implements CommandLineRunner {

  private PlayerCharacterRepository playerCharacterRepository;
  private ArchetypeRepository archetypeRepository;
  private SpellRepository spellRepository;
  private SchoolRepository schoolRepository;

  @Autowired
  public DemoSeeder(PlayerCharacterRepository playerCharacterRepository,
      ArchetypeRepository archetypeRepository, SpellRepository spellRepository, SchoolRepository schoolRepository) {
    this.playerCharacterRepository = playerCharacterRepository;
    this.archetypeRepository = archetypeRepository;
    this.spellRepository = spellRepository;
    this.schoolRepository = schoolRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    Archetype archetype = new Archetype();
    PlayerCharacter playerCharacter = new PlayerCharacter();
    Spell newSpell = new Spell();
    School newSchool = new School();

    if (Lists.newArrayList(archetypeRepository.findAll()).size() == 0) {
      archetype.setType("Rogue");
      archetype.setHitDice(8);
      archetype.setPrimary_stat("Dex");
      archetypeRepository.save(archetype);
    }

    if (Lists.newArrayList(playerCharacterRepository.findAll()).size() == 0) {
      playerCharacter.setName("Regis");
      playerCharacter.setArchetype(archetype);
      playerCharacter.setRace("Halfling");
      playerCharacter.setBackground("Icewind Dale's Halfling Rogue Extraordinarre");
      playerCharacterRepository.save(playerCharacter);
    }

    if (Lists.newArrayList(schoolRepository.findAll()).size() == 0){
      newSchool.setName("Evocation");
      newSchool.setDescription("All about bringing the damage");
      schoolRepository.save(newSchool);
    }

    if (Lists.newArrayList(spellRepository.findAll()).size() == 0){
      newSpell.setName("Fireball");
      newSpell.setDescription("When you just need to blow something up");
      newSpell.setLevel(3);
      newSpell.setSchool(newSchool);
      spellRepository.save(newSpell);
    }

    }
}
