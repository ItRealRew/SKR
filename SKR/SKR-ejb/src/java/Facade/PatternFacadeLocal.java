/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Pattern;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author INFERUS
 */
@Local
public interface PatternFacadeLocal {

    void create(Pattern pattern);

    void edit(Pattern pattern);

    void remove(Pattern pattern);

    Pattern find(Object id);

    List<Pattern> findAll();

    List<Pattern> findRange(int[] range);

    int count();
    
}
