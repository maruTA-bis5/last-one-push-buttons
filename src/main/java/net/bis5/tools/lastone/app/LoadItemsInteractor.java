package net.bis5.tools.lastone.app;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import net.bis5.tools.lastone.entities.Item;

@Model
class LoadItemsInteractor implements LoadItemsUseCase {

    @Inject
    ItemsStore store;

    @Override
    public List<ManagedItem> handle() {
        return store.findAll().stream().map(this::convert).collect(Collectors.toList());
    }

    private ManagedItem convert(Item item) {
        ManagedItem managed = new ManagedItem();
        managed.setName(item.getName());
        managed.setDescription(item.getDescription());
        return managed;
    }

}