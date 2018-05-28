package nl.han.toetsapplicatie.core.controllers;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import nl.han.toetsapplicatie.module.model.Vraag;
import nl.han.toetsapplicatie.module.plugin.Plugin;
import nl.han.toetsapplicatie.module.plugin.PluginLoader;


public class VraagEditController {

    public Label lblVraagName;
    public AnchorPane editContrainer;
    Vraag vraag;
    Plugin plugin;

    Runnable onExit;

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
        editContrainer.getChildren().add(plugin.getVraagCreatorView().getView());
    }

    public void btnExitPressed(ActionEvent event) {
        vraag.setData(plugin.getVraagCreatorView().getQuestionData());
        if (onExit != null)
            onExit.run();
    }
}
