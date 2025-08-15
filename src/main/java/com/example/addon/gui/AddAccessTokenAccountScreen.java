package com.example.addon.gui;

import meteordevelopment.meteorclient.gui.GuiTheme;
import meteordevelopment.meteorclient.gui.WindowScreen;
import meteordevelopment.meteorclient.gui.screens.accounts.AccountsScreen;
import meteordevelopment.meteorclient.gui.widgets.containers.WTable;
import net.minecraft.client.MinecraftClient;

public class AddAccessTokenAccountScreen extends WindowScreen {
    private final AccountsScreen parent;

    public AddAccessTokenAccountScreen(GuiTheme theme, AccountsScreen parent) {
        super(theme, null, "Add Access Token Account");
        this.parent = parent;
    }

    @Override
    public void initWidgets() {
        WTable table = add(theme.table()).expandX().widget();

        // Token input
        table.add(theme.label("Access Token:"));
        var tokenInput = theme.textBox("");
        table.add(tokenInput).expandX();
        table.row();

        // Buttons
        table.add(theme.button("Add")).expandX().widget().action = () -> {
            String token = tokenInput.get().trim();
            if (token.isEmpty()) return;
            // TODO: Implement adding account via token
            MinecraftClient.getInstance().setScreen(parent);
        };
        table.add(theme.button("Cancel")).expandX().widget().action = () -> MinecraftClient.getInstance().setScreen(parent);
    }
}