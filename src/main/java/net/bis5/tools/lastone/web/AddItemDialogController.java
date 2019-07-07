package net.bis5.tools.lastone.web;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import net.bis5.tools.lastone.app.AddItemUseCase;
import net.bis5.tools.lastone.app.ManagedItem;

@Model
public class AddItemDialogController {
    private String itemName;
    private String itemDescription;

    @Inject
    AddItemUseCase useCase;

    public String addItem() {
        ManagedItem item = new ManagedItem();
        item.setName(itemName);
        item.setDescription(itemDescription);
        useCase.addItem(item);

        return "index?faces-redirect=true";
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }
}