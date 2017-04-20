package com.lanzdev.controllers.managers.entity;

import com.lanzdev.controllers.managers.Manager;
import com.lanzdev.model.entity.Synonym;

import java.util.List;

public interface SynonymManager extends Manager<Synonym> {

    List<Synonym> getByTermId(Integer id);
}
