package com.example.addon;

import com.example.addon.commands.CubicCommand;
import com.mojang.logging.LogUtils;
import meteordevelopment.meteorclient.addons.GithubRepo;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.commands.Commands;
import org.slf4j.Logger;

public class CubicAddon extends MeteorAddon {
    public static final Logger LOG = LogUtils.getLogger();

    @Override
    public void onInitialize() {
        LOG.info("Initializing Cubic Addon");

        // Commands
        Commands.add(new CubicCommand());
    }

    @Override
    public String getPackage() {
        return "com.example.addon";
    }

    @Override
    public GithubRepo getRepo() {
        return new GithubRepo("Cube", "Cube-s-meteor-add-on");
    }
} 