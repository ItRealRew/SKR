/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeansOld;

import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author user
 */
public class AdminsBean implements Serializable{
    
    @EJB
    private DAO.LoginLocal login;
    
}
