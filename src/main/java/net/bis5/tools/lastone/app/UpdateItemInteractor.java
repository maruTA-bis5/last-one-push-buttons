package net.bis5.tools.lastone.app;

import java.util.Optional;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

import net.bis5.tools.lastone.entities.Item;

@Model
@Transactional
class UpdateItemInteractor implements UpdateItemUseCase {

    @Inject
    ItemsStore store;

    @Override
    public void updateItem(ManagedItem item) {
        Optional<Item> itemToUpdate = store.findById(item.getId());
        itemToUpdate.ifPresent(i -> applyChanges(item, i));
    }

    private void applyChanges(ManagedItem item, Item itemToUpdate) {
        itemToUpdate.setName(item.getName());
        itemToUpdate.setDescription(item.getDescription());
        store.save(itemToUpdate);
    }
}