package nl.han.toetsapplicatie.core.controllers;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import nl.han.toetsapplicatie.core.data.VraagOpslaanDAO;
import nl.han.toetsapplicatie.module.model.Vraag;
import nl.han.toetsapplicatie.module.plugin.Plugin;
import nl.han.toetsapplicatie.module.plugin.PluginLoader;


public class VraagOpstelController {

    public Label lblVraagName;
    public AnchorPane opstelContainer;
    Vraag vraag;
    Plugin plugin;
    VraagOpslaanDAO vraagOpslaan;

    Runnable onExit;

    public void setVraagOpslaan(VraagOpslaanDAO vraagOpslaan){
        this.vraagOpslaan = vraagOpslaan;
    }

    public void setOnExit(Runnable onExit) {
        this.onExit = onExit;
    }

    public void setVraag(Vraag vraag) {
        this.vraag = vraag;
        lblVraagName.setText(vraag.getName());
        try {
            plugin = PluginLoader.getPlugin(vraag);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        opstelContainer.getChildren().add(plugin.getVraagCreatorView().getView());
    }

    public void btnAnnuleerPressed(ActionEvent event) {
        if (onExit != null)
            onExit.run();

    }

    public void btnOpslaanPressed(ActionEvent event){
      String vraag = plugin.getVraagCreatorView().getQuestionData();
      vraagOpslaan.slaOp(vraag);
      if(onExit != null)
          onExit.run();


    }
}
