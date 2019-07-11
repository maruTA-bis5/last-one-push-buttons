package net.bis5.tools.lastone.web;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Inject;

import net.bis5.tools.lastone.app.LoadItemsUseCase;
import net.bis5.tools.lastone.app.ManagedItem;
import net.bis5.tools.lastone.app.StockEmptyNotifyUseCase;

@Model
@ViewScoped
public class IndexViewController implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<ManagedItem> items;
    @Inject LoadItemsUseCase loadItemsUseCase;
    @Inject StockEmptyNotifyUseCase stockEmptyNotifyUseCase;

    @PostConstruct
    public void initialize() {
        items = loadItemsUseCase.handle();
    }
    public List<ManagedItem> getItems() {
        return items;
    }

    public void setItems(List<ManagedItem> items) {
        this.items = items;
    }

    public void notifyStockEmpty(ManagedItem item) {
        stockEmptyNotifyUseCase.notify(item);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ボタンが押されたので通知メッセージを送信しました"));
    }

    public String moveToEditView(ManagedItem item) {
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        flash.put("editItem", item);
        return "edit?faces-redirect=true";
    }
}