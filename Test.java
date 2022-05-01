package com.github.hephaestus;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

enum ItemRarity {
    COMMON("COMMON", ChatColor.WHITE),
    UNCOMMON("UNCOMMON", ChatColor.GREEN),
    RARE("RARE", ChatColor.DARK_BLUE),
    EPIC("EPIC", ChatColor.DARK_PURPLE),
    LEGENDARY("LEGENDARY", ChatColor.YELLOW);

    String name;
    ChatColor color;

    ItemRarity(String name, ChatColor color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public ChatColor getColor() {
        return color;
    }
}

enum ItemType {
    WEAPON,
    TOOL,
    ARMOR,
    UTILITY;
}

enum ItemAttributes {
    DAMAGE,
    STRENGTH;
    //etc
}

enum ItemAbilityTriggers {
    USER,
    PASSIVE;
}

interface CustomItem {
    ItemType getItemType();
    Material getItem();
    String getName();
    List<String> getLore();
    ItemRarity getItemRarity();
    boolean isCraftable();
    ShapedRecipe getRecipe();
    Map<ItemAttributes, Integer> getAttributes();
    boolean hasAbility();
    ItemAbilityTriggers getAbilityTrigger();
    void handleAbility();
}

class DianaShortbow implements CustomItem {

    @Override
    public ItemType getItemType() {
        return ItemType.WEAPON;
    }

    @Override
    public Material getItem() {
        return Material.BOW;
    }

    @Override
    public String getName() {
        return "Diana's Shortbow";
    }

    @Override
    public List<String> getLore() {
        return Arrays.asList("Rumoured to have belonged to the Goddess Diana,", "this bow has been enfused with the essence of a diety", "and harnesses her spirit to double damage during the Night.");
    }

    @Override
    public ItemRarity getItemRarity() {
        return ItemRarity.LEGENDARY;
    }

    @Override
    public boolean isCraftable() {
        return true;
    }

    @Override
    public ShapedRecipe getRecipe() {
        return new ShapedRecipe(
                new NamespacedKey(Hephaestus.getPlugin(), "unique_plugin_key"),
                new ItemStack(this.getItem())).shape("A", "", "");
    }

    @Override
    public Map<ItemAttributes, Integer> getAttributes() {
        Map<ItemAttributes, Integer> itemAttributes = new HashMap<>();

        itemAttributes.put(ItemAttributes.DAMAGE, 100);
        itemAttributes.put(ItemAttributes.STRENGTH, 150);
        return itemAttributes;
    }

    @Override
    public boolean hasAbility() {
        return true;
    }

    @Override
    public ItemAbilityTriggers getAbilityTrigger() {
        return ItemAbilityTriggers.PASSIVE;
    }

    @Override
    public void handleAbility() {
        //Damage doubling logic as per lore
    }
}
