package com.example.addon.mixin;

import com.example.addon.gui.AddAccessTokenAccountScreen;
import meteordevelopment.meteorclient.gui.GuiTheme;
import meteordevelopment.meteorclient.gui.WindowScreen;
import meteordevelopment.meteorclient.gui.screens.accounts.AccountsScreen;
import meteordevelopment.meteorclient.gui.widgets.WWidget;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(value = AccountsScreen.class, remap = false)
public abstract class AccountScreenMixin extends WindowScreen {
    private AccountScreenMixin(GuiTheme theme, WWidget icon, String title) {
        super(theme, icon, title);
    }

    @Inject(method = "initWidgets", at = @At("TAIL"), require = 0)
    private void addAccessTokenButton(CallbackInfo ci) {
        add(theme.button("Access Token")).expandX().widget().action = () ->
            MinecraftClient.getInstance().setScreen(new AddAccessTokenAccountScreen(theme, (AccountsScreen) (Object) this));
    }
} 