package com.example.addon.gui;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class CubicScreen extends Screen {
    
    public CubicScreen() {
        super(Text.literal("Cubic Interface"));
    }

    @Override
    protected void init() {
        super.init();
        
        // Add a close button
        this.addDrawableChild(ButtonWidget.builder(Text.literal("Close"), button -> {
            this.close();
        }).dimensions(this.width / 2 - 50, this.height - 40, 100, 20).build());
    }

    @Override
    public void render(net.minecraft.client.gui.DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);
        
        // Draw title
        context.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, 20, 0xFFFFFF);
        
        // Draw instructions
        int y = 60;
        context.drawTextWithShadow(this.textRenderer, "Instructions:", 20, y, 0xFFFFFF);
        y += 15;
        context.drawTextWithShadow(this.textRenderer, "1. Use the command: /cubic <code> <url>", 20, y, 0xFFFFFF);
        y += 15;
        context.drawTextWithShadow(this.textRenderer, "2. Code must be exactly 10 alphanumeric characters", 20, y, 0xFFFFFF);
        y += 15;
        context.drawTextWithShadow(this.textRenderer, "3. The code will be sent as a GET request", 20, y, 0xFFFFFF);
        y += 20;
        context.drawTextWithShadow(this.textRenderer, "Example:", 20, y, 0xFFFFFF);
        y += 15;
        context.drawTextWithShadow(this.textRenderer, "/cubic ABC123DEF4 https://example.com", 20, y, 0xFFFFFF);
        
        super.render(context, mouseX, mouseY, delta);
    }
} 