package com.example.addon.commands;

import com.example.addon.gui.CubicScreen;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import meteordevelopment.meteorclient.commands.Command;
import meteordevelopment.meteorclient.utils.network.Http;
import net.minecraft.command.CommandSource;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import net.minecraft.client.MinecraftClient;

public class CubicCommand extends Command {
    public CubicCommand() {
        super("cubic", "Opens the Cubic interface or sends a 10-digit alphanumeric code to a URL as a GET request.");
    }

    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) {
        builder.executes(context -> {
            // Open the GUI
            MinecraftClient.getInstance().setScreen(new CubicScreen());
            return 1;
        });

        builder.then(argument("code", StringArgumentType.string())
            .then(argument("url", StringArgumentType.string())
            .executes(context -> {
                String code = StringArgumentType.getString(context, "code");
                String url = StringArgumentType.getString(context, "url");
                sendData(code, url);
                return 1;
            })));
    }

    private void sendData(String code, String url) {
        if (code.isEmpty() || url.isEmpty()) {
            error("Please provide both code and URL.");
            return;
        }

        if (code.length() != 10) {
            error("Code must be exactly 10 characters long.");
            return;
        }

        if (!code.matches("[a-zA-Z0-9]{10}")) {
            error("Code must contain only alphanumeric characters.");
            return;
        }

        try {
            String encodedCode = URLEncoder.encode(code, StandardCharsets.UTF_8.toString());
            String fullUrl = url + (url.contains("?") ? "&" : "?") + "code=" + encodedCode;
            String response = Http.get(fullUrl).sendString();
            info("Data sent successfully! Response: " + response);
        } catch (Exception e) {
            error("Error sending data: " + e.getMessage());
        }
    }
} 