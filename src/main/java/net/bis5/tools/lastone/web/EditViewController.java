package net.bis5.tools.lastone.web;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import net.bis5.tools.lastone.app.ManagedItem;
import net.bis5.tools.lastone.app.UpdateItemUseCase;

@Model
@ViewScoped
public class EditViewController implements Serializable {

    private static final long serialVersionUID = 1L;
    private ManagedItem item;
    private String itemName;
    private String itemDescription;

    @Inject
    UpdateItemUseCase updateUseCase;

    @PostConstruct
    public void initialize() {
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        item = (ManagedItem) flash.get("editItem");
        setItemName(item.getName());
        setItemDescription(item.getDescription());
    }

    public String updateItem() {
        item.setName(getItemName());
        item.setDescription(getItemDescription());
        updateUseCase.updateItem(item);
        return "index?faces-redirect=true";
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}