package com.example.addon.mixin;

import com.example.addon.gui.screens.accounts.AddTokenAccountScreen;
import meteordevelopment.meteorclient.MeteorClient;
import meteordevelopment.meteorclient.gui.GuiTheme;
import meteordevelopment.meteorclient.gui.GuiThemes;
import meteordevelopment.meteorclient.gui.screens.accounts.AccountsScreen;
import meteordevelopment.meteorclient.gui.widgets.WWidget;
import meteordevelopment.meteorclient.gui.widgets.containers.WHorizontalList;
import meteordevelopment.meteorclient.gui.widgets.pressable.WButton;
import meteordevelopment.meteorclient.gui.utils.Cell;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = AccountsScreen.class, remap = false)
public abstract class AccountScreenMixin {
    @Shadow
    public abstract <W extends WWidget> Cell<W> add(W widget);

    @Inject(method = "initWidgets", at = @At("TAIL"))
    private void cubic$addTokenButton(CallbackInfo ci) {
        GuiTheme theme = GuiThemes.get();

        WHorizontalList row = theme.horizontalList();
        this.add(row).expandX();

        WButton tokenButton = theme.button("Token Account");
        tokenButton.action = () -> MeteorClient.mc.setScreen(new AddTokenAccountScreen(theme, (AccountsScreen) (Object) this));
        row.add(tokenButton);
    }
} 