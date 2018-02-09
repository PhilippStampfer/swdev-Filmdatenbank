/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.swdev.filme.controller;

import at.swdev.filme.Regisseure;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dev
 */
@Stateless
public class RegisseureFacade extends AbstractFacade<Regisseure> {

    @PersistenceContext(unitName = "FilmdatenbankPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RegisseureFacade() {
        super(Regisseure.class);
    }
    
}
