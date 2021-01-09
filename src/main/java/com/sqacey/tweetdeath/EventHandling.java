package com.sqacey.tweetdeath;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

@Mod.EventBusSubscriber
public class EventHandling {

    @SubscribeEvent
    public static void pickupItem(EntityItemPickupEvent event) {

        System.out.println("Item picked up!");

    }

    @SubscribeEvent
    public static void livingDeath(LivingDeathEvent event) throws TwitterException {
        DamageSource dmgSource = event.getSource();
        Entity ent = event.getEntity();
        System.out.println(ent + " was killed by " + dmgSource);

        if (event.getEntity() instanceof ServerPlayerEntity) {
            Twitter twitter = TwitterConfigs.getconfigs();

            ITextComponent entName = ent.getName();

            Status status = null;
            status = twitter.updateStatus(entName.getUnformattedComponentText() + " was killed by " + dmgSource.damageType + ". dumbass.");
            System.out.println("Updated status to [" + status.getText() + "]");
        }
    }

    @SubscribeEvent
    public static void loginServer(PlayerEvent.PlayerLoggedInEvent event) throws TwitterException {
        PlayerEntity player = event.getPlayer();
        String name = player.getName().getUnformattedComponentText();

        System.out.println(name + " has logged into minecraft.");

        Twitter twitter = TwitterConfigs.getconfigs();

        Status status = null;
        status = twitter.updateStatus(name + " has logged into minecraft.");

        System.out.println("Updated status to [" + status.getText() + "]");
    }

}
