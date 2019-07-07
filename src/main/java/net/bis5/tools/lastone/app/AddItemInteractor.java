package net.bis5.tools.lastone.app;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

import net.bis5.tools.lastone.entities.Item;

@Model
@Transactional
class AddItemInteractor implements AddItemUseCase {

    @Inject
    ItemsStore store;
    @Override
    public void addItem(ManagedItem item) {
        Item itemToAdd =new Item();
        itemToAdd.setName(item.getName());
        itemToAdd.setDescription(item.getDescription());
        store.save(itemToAdd);
    }

}