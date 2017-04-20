package com.lanzdev.controllers.managers.entity;

import com.lanzdev.controllers.managers.Manager;
import com.lanzdev.model.entity.Definition;

import java.util.List;

public interface DefinitionManager extends Manager<Definition> {

    List<Definition> getByTermId(Integer id);
}
