package com.httymd.item;

import com.httymd.HTTYMD;
import com.httymd.Ref;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ItemModArmor extends ItemArmor {
    protected String name;

    public ItemModArmor(ArmorMaterial material, String name, int renderIndex, EntityEquipmentSlot slot) {
        super(material, renderIndex, slot);
        this.name = name;
        setTranslationKey(name);
        setRegistryName(Ref.MOD_ID + ":" + name);
        setCreativeTab(HTTYMD.PROXY.HTTYMD_TAB);
    }

    public void registerItemModel() {
        HTTYMD.PROXY.registerItemRenderer(this, 0, name);
    }
}
