/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui ;



import entities.Postulation;
import javafx.scene.control.ListCell;

/**
 *
 * @author Istabrak
 */
public class ListViewPostulation extends ListCell<Postulation> {
    
    
     @Override
     public void updateItem(Postulation e, boolean empty)
    {
        super.updateItem(e,empty);
        if(e != null)
        {
            
            PostulationItemController data = new PostulationItemController();
            data.setInfo(e);
            setGraphic(data.getHbox());
            setGraphic(data.getBox());
        }
    }
    
}
