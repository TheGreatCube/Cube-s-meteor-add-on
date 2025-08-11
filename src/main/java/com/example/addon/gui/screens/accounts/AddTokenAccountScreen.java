package com.example.addon.gui.screens.accounts;

import meteordevelopment.meteorclient.gui.GuiTheme;
import meteordevelopment.meteorclient.gui.screens.accounts.AccountsScreen;
import meteordevelopment.meteorclient.gui.screens.accounts.AddAccountScreen;
import meteordevelopment.meteorclient.gui.widgets.containers.WTable;
import meteordevelopment.meteorclient.gui.widgets.input.WTextBox;
import meteordevelopment.meteorclient.gui.widgets.pressable.WButton;
import meteordevelopment.meteorclient.systems.accounts.Account;
import meteordevelopment.meteorclient.systems.accounts.types.EasyMCAccount;

public class AddTokenAccountScreen extends AddAccountScreen {
    public AddTokenAccountScreen(GuiTheme theme, AccountsScreen parent) {
        super(theme, "Add a Token Account", parent);
    }

    @Override
    public void initWidgets() {
        WTable table = add(theme.table()).widget();

        table.add(theme.label("Token:"));
        WTextBox token = table.add(theme.textBox("")).minWidth(400).expandX().widget();
        token.setFocused(true);

        table.row();

        add = table.add(theme.button("Add")).expandX().widget();
        Runnable addAction = () -> onAddPressed(token);
        add.action = addAction;
        enterAction = addAction;
    }

    private void onAddPressed(WTextBox token) {
        String value = token.get();
        if (value.isEmpty()) return;

        // Use EasyMCAccount as the token-based account implementation available in Meteor
        Account<?> account = new EasyMCAccount(value);
        AccountsScreen.addAccount(this, parent, account);
    }
}