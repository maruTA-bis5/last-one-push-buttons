package net.bis5.tools.lastone.app;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

@RequestScoped
class StockEmptyNotifyInteractor implements StockEmptyNotifyUseCase {

    @Inject
    Event<NotifyEvent> eventBus;

    @Override
    public void notify(ManagedItem item) {
        String message = String.format("#### 最後の1個になったときに押すボタンが押されました\r\n- %s\r\n%s", item.getName(), item.getDescription());
        NotifyEvent event = new NotifyEvent(message);
        eventBus.fireAsync(event);
    }

}