/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Img;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author INFERUS
 */
@Local
public interface ImgFacadeLocal {

    void create(Img img);

    void edit(Img img);

    void remove(Img img);

    Img find(Object id);

    List<Img> findAll();

    List<Img> findRange(int[] range);

    int count();
    
}
