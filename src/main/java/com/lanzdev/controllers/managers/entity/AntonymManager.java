package com.lanzdev.controllers.managers.entity;

import com.lanzdev.controllers.managers.Manager;
import com.lanzdev.model.entity.Antonym;

import java.util.List;

public interface AntonymManager extends Manager<Antonym> {

    List<Antonym> getByTermId(Integer id);
}
