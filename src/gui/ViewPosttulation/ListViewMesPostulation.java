/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.ViewPosttulation;



import entities.Postulation;
import javafx.scene.control.ListCell;

/**
 *
 * @author Istabrak
 */
public class ListViewMesPostulation extends ListCell<Postulation> {
    
    
     @Override
     public void updateItem(Postulation e, boolean empty)
    {
        super.updateItem(e,empty);
        if(e != null)
        {
            
            MesPostulationItemController data = new MesPostulationItemController();
            data.setInfo(e);
            setGraphic(data.getHbox());
            setGraphic(data.getBox());
        }
    }
    
}
