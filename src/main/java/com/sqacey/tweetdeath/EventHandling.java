package com.sqacey.tweetdeath;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import twitter4j.Status;
import twitter4j.Twitter;

@Mod.EventBusSubscriber
public class EventHandling {

    @SubscribeEvent
    public static void pickupItem(EntityItemPickupEvent event) {

        // System.out.println("Item picked up!");

    }

    @SubscribeEvent
    public static void livingDeath(LivingDeathEvent event) {
        DamageSource dmgSource = event.getSource();
        Entity ent = event.getEntity();
        // System.out.println(ent + " was killed by " + dmgSource);

        if (event.getEntity() instanceof ServerPlayerEntity) {
            Twitter twitter = TwitterConfigs.getconfigs();

            ITextComponent entName = ent.getName();

            Status status = null;
            try {
                status = twitter.updateStatus(entName.getUnformattedComponentText() + " was killed by " + dmgSource.damageType + ". dumbass.");
                // System.out.println("Updated status to [" + status.getText() + "]");
            } catch (java.lang.Throwable te) {
                // System.out.println("couldn't connect " + te);
            }
        }
    }

    @SubscribeEvent
    public static void loginServer(PlayerEvent.PlayerLoggedInEvent event) {
        PlayerEntity player = event.getPlayer();
        String name = player.getName().getUnformattedComponentText();

        // System.out.println(name + " has logged into minecraft.");

        Twitter twitter = TwitterConfigs.getconfigs();

        Status status = null;
        try {
            status = twitter.updateStatus(name + " has logged into minecraft.");
            // System.out.println("Updated status to [" + status.getText() + "]");
        } catch (java.lang.Throwable te) {
            // System.out.println("couldn't connect " + te);
        }
    }

    @SubscribeEvent
    public static void chatEvent(ClientChatReceivedEvent event) {
        String chatMsg = event.getMessage().getString();

        // System.out.println("'" + chatMsg + "' was sent");

        Twitter twitter = TwitterConfigs.getconfigs();

        Status status = null;
        try {
            status = twitter.updateStatus(chatMsg);
            // System.out.println("Updated status to [" + status.getText() + "]");
        } catch (java.lang.Throwable te) {
            // System.out.println("couldn't connect " + te);
        }
    }

}

