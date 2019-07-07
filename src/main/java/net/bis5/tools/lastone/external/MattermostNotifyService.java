package net.bis5.tools.lastone.external;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.ObservesAsync;
import javax.inject.Inject;

import org.wildfly.swarm.spi.runtime.annotations.ConfigurationValue;

import net.bis5.mattermost.client4.ApiResponse;
import net.bis5.mattermost.client4.hook.IncomingWebhookClient;
import net.bis5.mattermost.model.IncomingWebhookRequest;
import net.bis5.tools.lastone.app.NotifyEvent;

@RequestScoped
class MattermostNotifyService {

    @Inject
    @ConfigurationValue("mattermost.webhook")
    private String webhook;

    public void notify(@ObservesAsync NotifyEvent event) {
        IncomingWebhookRequest requestPayload = new IncomingWebhookRequest();
        requestPayload.setText(event.getMessage());

        IncomingWebhookClient client = new IncomingWebhookClient(webhook);
        ApiResponse<Boolean> response = client.postByIncomingWebhook(requestPayload);
        // TODO assert response status
        if (response.hasError()) {
            throw new RuntimeException(response.toString());
        }
    }
}