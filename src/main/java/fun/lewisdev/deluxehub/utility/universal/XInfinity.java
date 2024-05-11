package fun.lewisdev.deluxehub.utility.universal;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.bukkit.*;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class XInfinity implements Keyed, Translatable {

    public static final org.bukkit.enchantments.Enchantment INFINITY = getEnchantment("infinity");

    public XInfinity() {
    }

    @NotNull
    private static org.bukkit.enchantments.Enchantment getEnchantment(@NotNull String key) {
        NamespacedKey namespacedKey = NamespacedKey.minecraft(key);
        org.bukkit.enchantments.Enchantment enchantment = Registry.ENCHANTMENT.get(namespacedKey);
        Preconditions.checkNotNull(enchantment, "No Enchantment found for %s. This is a bug.", namespacedKey);
        return enchantment;
    }

    @NotNull
    public abstract String getName();

    public abstract int getMaxLevel();

    public abstract int getStartLevel();

    @NotNull
    public abstract EnchantmentTarget getItemTarget();

    public abstract boolean isTreasure();

    public abstract boolean isCursed();

    public abstract boolean conflictsWith(@NotNull org.bukkit.enchantments.Enchantment var1);

    public abstract boolean canEnchantItem(@NotNull ItemStack var1);

    @Contract("null -> null")
    @Nullable
    public static org.bukkit.enchantments.Enchantment getByKey(@Nullable NamespacedKey key) {
        return key == null ? null : Registry.ENCHANTMENT.get(key);
    }

    @Contract("null -> null")
    @Nullable
    public static org.bukkit.enchantments.Enchantment getByName(@Nullable String name) {
        return name == null ? null : getByKey(NamespacedKey.fromString(name.toLowerCase()));
    }

    @NotNull
    public static org.bukkit.enchantments.Enchantment[] values() {
        return Lists.newArrayList(Registry.ENCHANTMENT).toArray(new org.bukkit.enchantments.Enchantment[0]);
    }
}
