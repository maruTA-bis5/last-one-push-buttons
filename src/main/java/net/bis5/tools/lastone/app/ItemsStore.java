package net.bis5.tools.lastone.app;

import org.springframework.data.jpa.repository.JpaRepository;

import net.bis5.tools.lastone.entities.Item;

public interface ItemsStore extends JpaRepository<Item, Long> {
}